package com.example.demo.Service;


import com.example.demo.Entity.EtkinlikSalonSeansEntity;
import com.example.demo.Repository.EtkinlikSalonSeansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupScheduler {
    private final EtkinlikService etkinlikService;
    private final SeansService seansService;
    private final EtkinlikSalonSeansRepository essRepo;

    @Autowired
    public StartupScheduler(EtkinlikService es, SeansService se, EtkinlikSalonSeansRepository essRepo) {
        this.etkinlikService = es;
        this.seansService = se;
        this.essRepo = essRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void scheduleAllEvents() {
        etkinlikService.findAllIds()
                .forEach(etkinlikService::scheduleTarihiGecti);

        for (EtkinlikSalonSeansEntity ess : essRepo.findAll()) {
            // ess.getSeans() ve ess.getEtkinlik().getEtkinlikSuresi()
            seansService.scheduleSessionExpired(
                    ess.getSeans(),
                    ess.getEtkinlik().getEtkinlikSuresi()
            );
        }

    }
}