package com.exceptionha.services.serviceimpl;

import com.exceptionha.models.Personel;
import com.exceptionha.repostorys.PersonelRepostory;
import com.exceptionha.services.PersonelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonelServiceImpl implements PersonelService {


    PersonelRepostory personelRepostory;

    public PersonelServiceImpl(PersonelRepostory personelRepostory) {
        this.personelRepostory = personelRepostory;
    }

    @Override
    public Personel getPersonel(int id) {
        return personelRepostory.getOne(id);
    }

    @Override
    public List<Personel> getPersonels() {
        return personelRepostory.findAll();
    }

    @Override
    public Personel addPersonels(Personel personel) {
        return personelRepostory.save(personel);
    }
}
