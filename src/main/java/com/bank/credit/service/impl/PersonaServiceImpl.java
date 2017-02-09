package com.bank.credit.service.impl;

import com.bank.credit.model.bean.PersonaBean;
import com.bank.credit.service.PersonaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("personaService")
public class PersonaServiceImpl implements PersonaService {

    public boolean savePersona(PersonaBean personaBean){
        boolean result = false;
        // convertir el BEAN a POJO
        //result = personaDao.save(personaPojo);
        result = true;
        return result;
    }

    public boolean updatePersona(PersonaBean personaBean){
        boolean result = false;
        // convertir el BEAN a POJO
        //result = personaDao.save(personaPojo);
        result = true;
        return result;
    }

    public boolean deletePersona(String numeroDni){
        boolean result = false;
        // convertir el BEAN a POJO
        //result = personaDao.save(personaPojo);
        result = true;
        return result;
    }

    public List<PersonaBean> listPersonActive(boolean active){

        PersonaBean persona1 = new PersonaBean();
        persona1.setNumeroDni("12457896");
        persona1.setNombre("Roy");
        persona1.setApePaterno("Calle");
        persona1.setApeMaterno("Sulca");
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
        if(active){
            persona1.setIndel("0");
        } else {
            persona1.setIndel("1");
        }

        PersonaBean persona2 = new PersonaBean();
        persona2.setNumeroDni("987654321");
        persona2.setNombre("Yeny");
        persona2.setApePaterno("Canales");
        persona2.setApeMaterno("P.");
        persona2.setNumeroRuc("91254879611");
        persona2.setRazonSocial("CrediUnion.Sac");
        persona2.setDireccion("Lima 368");
        persona2.setSexo("Femenino");
        persona2.setFechaNacimiento("12/12/1995");
        persona2.setEmail("yeny@gmail.com");
        persona2.setTelefonoFijo("01 125 8956");
        persona2.setTelefonoMovil("01 996 666945");
        persona2.setEstadoCivil("Soltera");
        persona2.setDepartamento("Ayacucho");
        persona2.setDistrito("Huanta");
        persona2.setProvincia("Huanta");
        if(active){
            persona2.setIndel("0");
        } else {
            persona2.setIndel("1");
        }

        PersonaBean persona3 = new PersonaBean();
        persona3.setNumeroDni("36524578");
        persona3.setNombre("Carol");
        persona3.setApePaterno("C.");
        persona3.setApeMaterno("P.");
        persona3.setNumeroRuc("91254879611");
        persona3.setRazonSocial("CrediUnion.Sac");
        persona3.setDireccion("Lima 368");
        persona3.setSexo("Femenino");
        persona3.setFechaNacimiento("12/12/1995");
        persona3.setEmail("yeny@gmail.com");
        persona3.setTelefonoFijo("01 125 8956");
        persona3.setTelefonoMovil("01 996 666945");
        persona3.setEstadoCivil("Soltera");
        persona3.setDepartamento("Ayacucho");
        persona3.setDistrito("Ayacucho");
        persona3.setProvincia("Ayacucho");
        if(active){
            persona3.setIndel("0");
        } else {
            persona3.setIndel("1");
        }

        PersonaBean persona4 = new PersonaBean();
        persona4.setNumeroDni("98784565");
        persona4.setNombre("Lucia");
        persona4.setApePaterno("C.");
        persona4.setApeMaterno("P.");
        persona4.setNumeroRuc("91254879611");
        persona4.setRazonSocial("CrediUnion.Sac");
        persona4.setDireccion("Lima 368");
        persona4.setSexo("Femenino");
        persona4.setFechaNacimiento("12/12/1995");
        persona4.setEmail("yeny@gmail.com");
        persona4.setTelefonoFijo("01 125 8956");
        persona4.setTelefonoMovil("01 996 666945");
        persona4.setEstadoCivil("Soltera");
        persona4.setDepartamento("Ayacucho");
        persona4.setDistrito("Ayacucho");
        persona4.setProvincia("Ayacucho");
        if(active){
            persona4.setIndel("0");
        } else {
            persona4.setIndel("1");
        }

        PersonaBean persona5 = new PersonaBean();
        persona5.setNumeroDni("33665522");
        persona5.setNombre("Marco");
        persona5.setApePaterno("C.");
        persona5.setApeMaterno("P.");
        persona5.setNumeroRuc("91254879611");
        persona5.setRazonSocial("CrediUnion.Sac");
        persona5.setDireccion("Lima 368");
        persona5.setSexo("Femenino");
        persona5.setFechaNacimiento("12/12/1995");
        persona5.setEmail("yeny@gmail.com");
        persona5.setTelefonoFijo("01 125 8956");
        persona5.setTelefonoMovil("01 996 666945");
        persona5.setEstadoCivil("Soltera");
        persona5.setDepartamento("Ayacucho");
        persona5.setDistrito("Ayacucho");
        persona5.setProvincia("Ayacucho");
        if(active){
            persona5.setIndel("0");
        } else {
            persona5.setIndel("1");
        }

        PersonaBean persona6 = new PersonaBean();
        persona6.setNumeroDni("88554411");
        persona6.setNombre("Carlos");
        persona6.setApePaterno("C.");
        persona6.setApeMaterno("P.");
        persona6.setNumeroRuc("91254879611");
        persona6.setRazonSocial("CrediUnion.Sac");
        persona6.setDireccion("Lima 368");
        persona6.setSexo("Femenino");
        persona6.setFechaNacimiento("12/12/1995");
        persona6.setEmail("yeny@gmail.com");
        persona6.setTelefonoFijo("01 125 8956");
        persona6.setTelefonoMovil("01 996 666945");
        persona6.setEstadoCivil("Soltera");
        persona6.setDepartamento("Ayacucho");
        persona6.setDistrito("Ayacucho");
        persona6.setProvincia("Ayacucho");
        if(active){
            persona6.setIndel("0");
        } else {
            persona6.setIndel("1");
        }

        PersonaBean persona7 = new PersonaBean();
        persona7.setNumeroDni("99551144");
        persona7.setNombre("Aziana");
        persona7.setApePaterno("C.");
        persona7.setApeMaterno("P.");
        persona7.setNumeroRuc("91254879611");
        persona7.setRazonSocial("CrediUnion.Sac");
        persona7.setDireccion("Lima 368");
        persona7.setSexo("Femenino");
        persona7.setFechaNacimiento("12/12/1995");
        persona7.setEmail("yeny@gmail.com");
        persona7.setTelefonoFijo("01 125 8956");
        persona7.setTelefonoMovil("01 996 666945");
        persona7.setEstadoCivil("Soltera");
        persona7.setDepartamento("Ayacucho");
        persona7.setDistrito("Ayacucho");
        persona7.setProvincia("Ayacucho");
        if(active){
            persona7.setIndel("0");
        } else {
            persona7.setIndel("1");
        }

        List<PersonaBean> listPersons = new ArrayList<>();
        listPersons.add(persona1);
        listPersons.add(persona2);
        listPersons.add(persona3);
        listPersons.add(persona4);
        listPersons.add(persona5);
        listPersons.add(persona6);
        listPersons.add(persona7);

        return listPersons;
    }
}
