package com.exceptionha.controller;

import com.exceptionha.models.Personel;
import com.exceptionha.services.PersonelService;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/personel")
public class PersonelController {

    public PersonelService personelService;

    public PersonelController(PersonelService personelService) {
        this.personelService = personelService;
    }

    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@Valid @RequestBody  Personel personel){
        Map<String,Personel> hm = new HashMap<String,Personel>();
        Personel p = personelService.addPersonels(personel);
        hm.put("status",p);

        return new ResponseEntity<>(hm,HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Object> list(){
        Map<String, List<Personel>> hm = new HashMap<>();

        List<Personel> personels = personelService.getPersonels();

        hm.put("status",personels);
        return new ResponseEntity<>(hm,HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id){
        Map<String, Object> hm = new HashMap<>();

        Personel personel = personelService.getPersonel(id);
            hm.put("status", personel);
            return new ResponseEntity<>(hm, HttpStatus.OK);
    }


}
