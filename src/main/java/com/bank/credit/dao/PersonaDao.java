package com.bank.credit.dao;

import com.bank.credit.model.jpa.Persona;

import java.util.List;

public interface PersonaDao {

    List<Persona> findAllPersonas();
}
