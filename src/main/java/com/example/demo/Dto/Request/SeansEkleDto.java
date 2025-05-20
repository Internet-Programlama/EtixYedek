// src/main/java/com/example/demo/Dto/Request/SeansEkleDto.java
package com.example.demo.Dto.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SeansEkleDto {
    // Sadece başlangıç zamanı var
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone="Europe/Istanbul")
    private Timestamp tarih;

    public SeansEkleDto() {}

    public SeansEkleDto(Timestamp tarih) {
        this.tarih = tarih;
    }

    public Timestamp getTarih() {
        return tarih;
    }
    public void setTarih(Timestamp tarih) {
        this.tarih = tarih;
    }
}
