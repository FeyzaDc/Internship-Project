package com.example.staj_backend_spring;

import java.util.List;

public interface SorgulamaServis {

    public Servis servisKayit(Servis servis);
    public List<Servis> kayitlarGetir();
    public Servis kayitGetir(long id);
    public Servis kayitGuncelle(long id, Servis yeniServis);



}
