package com.exceptionha.services;

import com.exceptionha.models.Personel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonelService {

    Personel getPersonel(int id);

    List<Personel> getPersonels();

    Personel addPersonels(Personel personel);




}
