package com.example.staj_backend_spring;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "servis_baglanti")
@Data
public class Baglanti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "servis_id")
    private Long servisId;

    @Column(name = "kurum_id")
    private Long kurumId;

    @Column(name = "max_deneme_sayisi")
    private Integer maxDenemeSayisi;

    @Column(name = "sonraki_gonderim_suresi")
    private Long sonrakiGonderimSuresi;

    @Column(name = "zaman_asimi_suresi")
    private Long zamanAsimiSuresi;

    @Column(name = "servis_adresi")
    private String servisAdresi;

    @Column(name = "servis_protokol_id")
    private Long servisProtokolId;

    @Column(name = "kullanici_kodu")
    private String kullaniciKodu;

    @Column(name = "sifre")
    private String sifre;

    @Column(name = "durum_id")
    private Long durumId;

    @Column(name = "tanitim_zamani")
    private Date tanitimZamani;

    @Column(name = "tanitan_kullanici_id")
    private Long tanitanKullaniciId;

    @Column(name = "guncelleme_zamani")
    private Date guncellemeZamani;

    @Column(name = "guncelleyen_kullanici_id")
    private Long guncelleyenKullaniciId;



}
