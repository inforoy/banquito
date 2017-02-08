package com.bank.credit.service;

import com.bank.credit.model.bean.PersonaBean;

import java.util.List;

public interface PersonaService {

    /**
     * Metodo para Guardar un Persona
     * @param personaBean
     * @return boolean
     */
    boolean savePersona(PersonaBean personaBean);

    /**
     * Metodo para Guardar un Persona
     * @param personaBean
     * @return boolean
     */
    boolean updatePersona(PersonaBean personaBean);

    /**
     * Metodo para Eliminar una Persona
     * @param personaBean
     * @return boolean
     */
    boolean deletePersona(String numeroDni);

    /**
     * Listado de Personas activas
     * @param active
     * @return List<PersonaBean>
     */
    List<PersonaBean> listPersonActive(boolean active);
}
