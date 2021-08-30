package com.example.staj_backend_spring;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BaglantiServis {
    public Baglanti servisBaglantiKaydet(Long servisId, Baglanti baglanti);
    public List<Baglanti> servisBaglantilariGetir(Long servisId);
    public Baglanti servisBaglantiGetir(long id);
    public Baglanti servisBaglantiGuncelle(long id, Baglanti yeniBaglanti);
}
