package com.bank.credit.service.impl;

import com.bank.credit.model.Persona;
import com.bank.credit.service.PersonaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("personaService")
public class PersonaServiceImpl implements PersonaService {

    public List<Persona> listPersonActive(boolean active){

        Persona persona1 = new Persona();
        persona1.setNumeroDni("12457896");
        persona1.setNombre("Roy");
        persona1.setApePaterno("Calle");
        persona1.setApePaterno("Sulca");
        persona1.setNumeroRuc("11124578969");
        persona1.setRazonSocial("Inforoy.Sac");
        persona1.setDireccion("Lima 368");
        persona1.setSexo("Masculino");
        persona1.setFechaNacimiento("12/12/1990");
        persona1.setEmail("roy@gmail.com");
        persona1.setTelefonoFijo("01 365 8956");
        persona1.setTelefonoMovil("01 996 568945");
        persona1.setEstadoCivil("Soltero");
        persona1.setDepartamento("Ayacucho");
        persona1.setDistrito("Ayacucho");
        persona1.setProvincia("Huamanga");
        if(active == true){
            persona1.setIndel("0");
        } else {
            persona1.setIndel("1");
        }

        List<Persona> listPersons = new ArrayList<>();
        listPersons.add(persona1);

        return listPersons;
    }
}
