package com.example.staj_backend_spring;

import lombok.Data;
import org.hibernate.mapping.Bag;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "servis")
@Data
public class Servis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "servis_adi")
    private String servisAdi;

    @Column(name = "servis_arayuz_adi")
    private String servisArayuzAdi;

    @Column(name = "log_seviyesi")
    private Integer logSeviyesi;

    @Column(name = "sunucu_mu")
    private Integer sunucuMu;

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

    @Column(name = "loglanacak_istek_metin")
    private String loglanacakIstekMetin;

    @Column(name = "loglanacak_cevap_metin")
    private String loglanacakCevapMetin;


}
