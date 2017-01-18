package com.bank.credit.dao.impl;

import com.bank.credit.model.jpa.Persona;
import com.bank.credit.dao.AbstractRepository;
import com.bank.credit.dao.PersonaDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("personaDao")
public class PersonaDaoImpl extends AbstractRepository implements PersonaDao {

    public List<Persona> findAllPersonas(){
        return null;
    }
}
