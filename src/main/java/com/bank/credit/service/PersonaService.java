package com.bank.credit.service;

import com.bank.credit.model.Persona;

import java.util.List;

public interface PersonaService {

    /**
     * Listado de Personas activas
     * @param persona
     * @return
     */
    List<Persona> listPersonActive(boolean active);
}
