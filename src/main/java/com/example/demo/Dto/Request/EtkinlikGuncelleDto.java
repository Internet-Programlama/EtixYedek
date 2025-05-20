// src/main/java/com/example/demo/Dto/Request/EtkinlikGuncelleDto.java
package com.example.demo.Dto.Request;

import com.example.demo.Entity.EtkinlikTurEntity;
import com.example.demo.Entity.SalonEntity;
import com.example.demo.Entity.SehirEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EtkinlikGuncelleDto {
    private Long etkinlikId;
    private List<SeansDuzenleDto> seansDuzenleDtoList;
    private List<SeansEkleDto>   seansEkleDtoList;
    private EtkinlikTurEntity etkinlikTur;
    private SalonEntity salon;
    private SehirEntity sehir;
    private String etkinlikAdi;
    private String kapakFotografi;
    private String etkinlikAciklamasi;
    private int yasSiniri;
    private int etkinlikSuresi;
    private float biletFiyati;

    public EtkinlikGuncelleDto() {}

    public EtkinlikGuncelleDto(Long etkinlikID, SalonEntity salon, List<SeansDuzenleDto> seansDuzenleDtoList, EtkinlikTurEntity etkinlikTur, SehirEntity sehir, String etkinlikAdi, String kapakFotografi, String etkinlikAciklamasi, int yasSiniri, int etkinlikSuresi, float biletFiyati) {
        this.etkinlikId = etkinlikID;
        this.salon = salon;
        this.seansDuzenleDtoList = seansDuzenleDtoList;
        this.etkinlikTur = etkinlikTur;
        this.sehir = sehir;
        this.etkinlikAdi = etkinlikAdi;
        this.kapakFotografi = kapakFotografi;
        this.etkinlikAciklamasi = etkinlikAciklamasi;
        this.yasSiniri = yasSiniri;
        this.etkinlikSuresi = etkinlikSuresi;
        this.biletFiyati = biletFiyati;
    }

    public Long getEtkinlikId() {
        return etkinlikId;
    }
    public void setEtkinlikId(Long etkinlikId) {
        this.etkinlikId = etkinlikId;
    }

    public List<SeansDuzenleDto> getSeansDuzenleDtoList() {
        return seansDuzenleDtoList;
    }
    public void setSeansDuzenleDtoList(List<SeansDuzenleDto> seansDuzenleDtoList) {
        this.seansDuzenleDtoList = seansDuzenleDtoList;
    }

    public List<SeansEkleDto> getSeansEkleDtoList() {
        return seansEkleDtoList;
    }
    public void setSeansEkleDtoList(List<SeansEkleDto> seansEkleDtoList) {
        this.seansEkleDtoList = seansEkleDtoList;
    }

    public EtkinlikTurEntity getEtkinlikTur() {
        return etkinlikTur;
    }
    public void setEtkinlikTur(EtkinlikTurEntity etkinlikTur) {
        this.etkinlikTur = etkinlikTur;
    }

    public SalonEntity getSalon() {
        return salon;
    }
    public void setSalon(SalonEntity salon) {
        this.salon = salon;
    }

    public SehirEntity getSehir() {
        return sehir;
    }
    public void setSehir(SehirEntity sehir) {
        this.sehir = sehir;
    }

    public String getEtkinlikAdi() {
        return etkinlikAdi;
    }
    public void setEtkinlikAdi(String etkinlikAdi) {
        this.etkinlikAdi = etkinlikAdi;
    }

    public String getKapakFotografi() {
        return kapakFotografi;
    }
    public void setKapakFotografi(String kapakFotografi) {
        this.kapakFotografi = kapakFotografi;
    }

    public String getEtkinlikAciklamasi() {
        return etkinlikAciklamasi;
    }
    public void setEtkinlikAciklamasi(String etkinlikAciklamasi) {
        this.etkinlikAciklamasi = etkinlikAciklamasi;
    }

    public int getYasSiniri() {
        return yasSiniri;
    }
    public void setYasSiniri(int yasSiniri) {
        this.yasSiniri = yasSiniri;
    }

    public int getEtkinlikSuresi() {
        return etkinlikSuresi;
    }
    public void setEtkinlikSuresi(int etkinlikSuresi) {
        this.etkinlikSuresi = etkinlikSuresi;
    }

    public float getBiletFiyati() {
        return biletFiyati;
    }
    public void setBiletFiyati(float biletFiyati) {
        this.biletFiyati = biletFiyati;
    }
}
