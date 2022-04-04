package com.example.staj_backend_spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@Service
public class BaglantiServisImpl implements BaglantiServis{

    @Autowired
    BaglantiDAO baglantiDAO;

    @Autowired
    SorgulamaDAO servisDAO;

    @Override
    public Baglanti servisBaglantiKaydet(Long servisId, Baglanti baglanti) {
        Date tanitimZamani = new Date();
        baglanti.setTanitimZamani(tanitimZamani);
        baglanti.setGuncellemeZamani(tanitimZamani);
        baglanti.setServisId(servisId);
        return baglantiDAO.saveAndFlush(baglanti);
    }

    @Override
    public List<Baglanti> servisBaglantilariGetir(Long servisId) {
        return baglantiDAO.findAllByServisId(servisId);
    }

    @Override
    public Baglanti servisBaglantiGetir(long id) {
        return baglantiDAO.findById(id).orElseThrow(
                () -> new EntityNotFoundException("kayit bulunamadi")
        );
    }

    @Override
    public Baglanti servisBaglantiGuncelle(long id, Baglanti yeniBaglanti) {
        Baglanti eskiBaglanti = baglantiDAO.findById(id).orElseThrow(
                () -> new EntityNotFoundException("kayit bulunamadi")
        );

        Date guncellemeZamani = new Date();
        eskiBaglanti.setTanitimZamani(guncellemeZamani);

        eskiBaglanti.setKurumId(yeniBaglanti.getKurumId());

        if(yeniBaglanti.getServisAdresi() != null)
            eskiBaglanti.setServisAdresi(yeniBaglanti.getServisAdresi());

        eskiBaglanti.setMaxDenemeSayisi(yeniBaglanti.getMaxDenemeSayisi());
        eskiBaglanti.setZamanAsimiSuresi(yeniBaglanti.getZamanAsimiSuresi());
        eskiBaglanti.setDurumId(yeniBaglanti.getDurumId());

        baglantiDAO.saveAndFlush(eskiBaglanti);
        return eskiBaglanti;
    }
}
