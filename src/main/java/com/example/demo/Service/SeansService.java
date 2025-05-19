package com.example.demo.Service;

import com.example.demo.Entity.SeansEntity;
import com.example.demo.Repository.SeansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

@Service
public class SeansService {
    private final SeansRepository seansRepo;
    private final TaskScheduler scheduler;
    private final Map<Long, ScheduledFuture<?>> futures = new ConcurrentHashMap<>();

    @Autowired
    public SeansService(SeansRepository seansRepo,
                        @Qualifier("taskScheduler") TaskScheduler scheduler) {
        this.seansRepo = seansRepo;
        this.scheduler = scheduler;
    }

    /**
     * Bir seans için "bitiş zamanı"na göre tarihiGectiMi==true yapacak task schedule eder.
     * @param seans seans entity
     * @param etkinlikSuresi etkinliğin toplam süresi (dakika)
     */
    public void scheduleSessionExpired(SeansEntity seans, int etkinlikSuresi) {
        Instant runAt = seans.getTarih().toInstant()
                .plus(Duration.ofMinutes(etkinlikSuresi));

        // Önceki varsa iptal
        ScheduledFuture<?> prev = futures.remove(seans.getSeansID());
        if (prev != null) prev.cancel(false);

        // Eğer bitiş zamanı geçmişse hemen set et
        Date now = new Date();
        Date runDate = Date.from(runAt);
        if (runDate.before(now)) {
            expire(seans.getSeansID());
            return;
        }

        // Yeni task
        ScheduledFuture<?> future = scheduler.schedule(
                () -> expire(seans.getSeansID()),
                runDate
        );
        futures.put(seans.getSeansID(), future);
    }

    @Transactional
    protected void expire(Long seansId) {
        seansRepo.findById(seansId).ifPresent(s -> {
            if (!s.isTarihiGectiMi()) {
                s.setTarihiGectiMi(true);
                seansRepo.save(s);
                System.out.printf("Seans %d tarihiGectiMi=true olarak güncellendi%n", seansId);
            }
        });
    }
}
