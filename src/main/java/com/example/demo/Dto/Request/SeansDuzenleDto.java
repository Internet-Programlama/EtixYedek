// src/main/java/com/example/demo/Dto/Request/SeansDuzenleDto.java
package com.example.demo.Dto.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SeansDuzenleDto {
    private Long seansId;

    // Front'tan ISO string gelecek, Timestamp'e çeviriyoruz
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone="Europe/Istanbul")
    private Timestamp tarih;

    public SeansDuzenleDto() {}

    public SeansDuzenleDto(Long seansId, Timestamp tarih) {
        this.seansId = seansId;
        this.tarih   = tarih;
    }

    public Long getSeansId() {
        return seansId;
    }
    public void setSeansId(Long seansId) {
        this.seansId = seansId;
    }

    public Timestamp getTarih() {
        return tarih;
    }
    public void setTarih(Timestamp tarih) {
        this.tarih = tarih;
    }
}
