package com.example.staj_backend_spring;

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
public class SorgulamaController {

    @Autowired
    SorgulamaServis sorgulamaServis;

    @RequestMapping(value = "/servis-kayit", method = RequestMethod.POST)
    public ResponseEntity<Servis> servisKayit(@RequestBody Servis servis) {
        return new ResponseEntity<>(
           sorgulamaServis.servisKayit(servis),
           HttpStatus.OK
        );
    }

    @RequestMapping(value = "/kayitlar-getir", method = RequestMethod.GET)
    public ResponseEntity<List<Servis>> kayitlarGetir() {
        return new ResponseEntity<>(
                sorgulamaServis.kayitlarGetir(),
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "/kayit-getir/{id}", method = RequestMethod.GET)
    public ResponseEntity<Servis> kayitGetir(@PathVariable("id") long id) {
        return new ResponseEntity<>(
                sorgulamaServis.kayitGetir(id),
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "/kayit-guncelle/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Servis> kayitGuncelle(@PathVariable("id") long id, @RequestBody Servis yeniServis) {
        return new ResponseEntity<>(
                sorgulamaServis.kayitGuncelle(id, yeniServis),
                HttpStatus.OK
        );
    }

}
