package com.example.staj_backend_spring;

import java.util.List;

public interface BaglantiDAO extends BaseDAO<Baglanti>{

    List<Baglanti> findAllByServisId(Long servisId);

}
