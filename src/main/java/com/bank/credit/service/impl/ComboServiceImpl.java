package com.bank.credit.service.impl;

import com.bank.credit.model.Sexo;
import com.bank.credit.service.ComboService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("comboService")
public class ComboServiceImpl implements ComboService {

    public List<Sexo> getSexo(){
        Sexo sexo1 = new Sexo();
        sexo1.setId("00");
        sexo1.setDescripcionCorta("Masculino");
        sexo1.setDescripcionLarga("Masculino");
        sexo1.setIndel("0");

        Sexo sexo2 = new Sexo();
        sexo2.setId("01");
        sexo2.setDescripcionCorta("Femenino");
        sexo2.setDescripcionLarga("Femenino");
        sexo2.setIndel("0");

        List<Sexo> listSex = new ArrayList<>();
        listSex.add(sexo1);
        listSex.add(sexo2);
        return listSex;
    }

}
