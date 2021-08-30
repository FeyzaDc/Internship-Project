package com.example.staj_backend_spring;

import org.hibernate.mapping.Bag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BaglantiController {

    @Autowired
    BaglantiServis baglantiServis;

    @RequestMapping(value = "/servis-baglanti-kaydet/{id}", method = RequestMethod.POST)
    public ResponseEntity<Baglanti> servisBaglantiKaydet(@PathVariable("id") long servisId, @RequestBody Baglanti baglanti) {
        return new ResponseEntity<>(
                baglantiServis.servisBaglantiKaydet(servisId, baglanti),
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "/servis-baglantilari-getir/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Baglanti>> servisBaglantilariGetir(@PathVariable("id") long servisId) {
        return new ResponseEntity<>(
                baglantiServis.servisBaglantilariGetir(servisId),
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "/servis-baglanti-getir/{id}", method = RequestMethod.GET)
    public ResponseEntity<Baglanti> servisBaglantiGetir(@PathVariable("id") long id) {
        return new ResponseEntity<>(
                baglantiServis.servisBaglantiGetir(id),
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "/servis-baglanti-guncelle/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Baglanti> servisBaglantiGuncelle(@PathVariable("id") long id, @RequestBody Baglanti yeniBaglanti) {
        return new ResponseEntity<>(
                baglantiServis.servisBaglantiGuncelle(id, yeniBaglanti),
                HttpStatus.OK
        );
    }

}









