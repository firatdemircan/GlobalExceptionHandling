package com.exceptionha.repostorys;

import com.exceptionha.models.Personel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonelRepostory extends JpaRepository<Personel,Integer> {


}
