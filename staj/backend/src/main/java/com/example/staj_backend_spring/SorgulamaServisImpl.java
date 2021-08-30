package com.example.staj_backend_spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@Service
public class SorgulamaServisImpl implements SorgulamaServis{

    @Autowired
    SorgulamaDAO sorgulamaDAO;

    @Override
    public Servis servisKayit(Servis servis) {
        Date tanitimZamani = new Date();
        servis.setTanitimZamani(tanitimZamani);
        servis.setGuncellemeZamani(tanitimZamani);
        return sorgulamaDAO.saveAndFlush(servis);
    }

    @Override
    public List<Servis> kayitlarGetir() {
        return sorgulamaDAO.findAll();
       /*
       * update için
       * Servis parametreden gelecek
       * servis.setUpdateTime();
       *
       * sorgulamaDao.saveAndFlush(servis);
       * */
    }

    @Override
    public Servis kayitGetir(long id) {
        return sorgulamaDAO.findById(id).orElseThrow(
                () -> new EntityNotFoundException("kayit bulunamadi")
        );
    }

    @Override
    public Servis kayitGuncelle(long id, Servis yeniServis) {

        Servis eskiServis = sorgulamaDAO.findById(id).orElseThrow(
                () -> new EntityNotFoundException("kayit bulunamadi")
        );

        Date guncellemeZamani = new Date();
        eskiServis.setTanitimZamani(guncellemeZamani);

        eskiServis.setServisAdi(yeniServis.getServisAdi());

        if(yeniServis.getServisArayuzAdi() != null)
            eskiServis.setServisArayuzAdi(yeniServis.getServisArayuzAdi());

        eskiServis.setSunucuMu(yeniServis.getSunucuMu());
        eskiServis.setLogSeviyesi(yeniServis.getLogSeviyesi());
        eskiServis.setDurumId(yeniServis.getDurumId());

        sorgulamaDAO.saveAndFlush(eskiServis);
        return eskiServis;
    }
}
