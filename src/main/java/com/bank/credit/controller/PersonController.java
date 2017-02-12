package com.bank.credit.controller;

import com.bank.credit.model.GeneralResponse;
import com.bank.credit.model.bean.*;
import com.bank.credit.service.PersonaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class PersonController extends AbstractController {

    @Autowired
    private PersonaService personaService;

    public static final String OPERATION_SUCCESS = "La operaci&oacute;n se ha realizado con &Eacute;xito.";
    public static final String OPERATION_ERROR   = "Ha ocurrido un error inesperado.";

    @RequestMapping(value="/getListPersons.htm", method = RequestMethod.GET)
    @ResponseBody
    public String getListPersons(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new Gson();
        GeneralResponse generalResponse = new GeneralResponse();
        String jsonData;
        try {

            List<PersonaBean> list = personaService.listPersonActive(false);
            long count = list.size();
            generalResponse.setSuccess(true);
            generalResponse.setMessage("");
            generalResponse.setTotalCount(count);
            generalResponse.setData(list);

        } catch (Exception e){
            generalResponse.setSuccess(false);
            generalResponse.setMessage(e.getMessage());
            generalResponse.setTotalCount(0L);
            generalResponse.setData(null);
        } finally {
            jsonData = gson.toJson(generalResponse);
        }

        return jsonData;
    }

    @RequestMapping(value="/listPersonActive.htm", method = RequestMethod.GET)
    @ResponseBody
    public String listPersonActive(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new Gson();
        GeneralResponse generalResponse = new GeneralResponse();
        String jsonData;
        try {

            List<PersonaBean> list = personaService.listPersonActive(true);
            long count = list.size();
            generalResponse.setSuccess(true);
            generalResponse.setMessage("");
            generalResponse.setTotalCount(count);
            generalResponse.setData(list);

        } catch (Exception e){
            generalResponse.setSuccess(false);
            generalResponse.setMessage(e.getMessage());
            generalResponse.setTotalCount(0L);
            generalResponse.setData(null);
        } finally {
            jsonData = gson.toJson(generalResponse);
        }

        return jsonData;
    }

    @RequestMapping(value="/savePersona.htm", method = RequestMethod.POST)
    @ResponseBody
    public String savePersona(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new Gson();
        GeneralResponse generalResponse = new GeneralResponse();
        String data;
        String jsonData = request.getParameter("jsonData");
        ObjectMapper mapper = new ObjectMapper();
        try {
            PersonaBean personaBean = mapper.readValue(jsonData, PersonaBean.class);
            boolean result = personaService.savePersona(personaBean);
            generalResponse.setSuccess(true);
            generalResponse.setMessage(OPERATION_SUCCESS);
            generalResponse.setTotalCount(0L);
            generalResponse.setData(result);
        } catch (Exception e){
            generalResponse.setSuccess(false);
            generalResponse.setMessage(e.getMessage() == null ? OPERATION_ERROR : e.getMessage());
            generalResponse.setTotalCount(0L);
            generalResponse.setData(null);
        } finally {
            data = gson.toJson(generalResponse);
        }
        return data;
    }

    @RequestMapping(value="/updatePersona.htm", method = RequestMethod.POST)
    @ResponseBody
    public String updatePersona(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new Gson();
        GeneralResponse generalResponse = new GeneralResponse();
        String data;
        String jsonData = request.getParameter("jsonData");
        ObjectMapper mapper = new ObjectMapper();
        try {
            PersonaBean personaBean = mapper.readValue(jsonData, PersonaBean.class);
            boolean result = personaService.updatePersona(personaBean);
            generalResponse.setSuccess(true);
            generalResponse.setMessage(OPERATION_SUCCESS);
            generalResponse.setTotalCount(0L);
            generalResponse.setData(result);

        } catch (Exception e){
            generalResponse.setSuccess(false);
            generalResponse.setMessage(e.getMessage() == null ? OPERATION_ERROR : e.getMessage());
            generalResponse.setTotalCount(0L);
            generalResponse.setData(null);
        } finally {
            data = gson.toJson(generalResponse);
        }

        return data;
    }

    @RequestMapping(value="/deletePersona.htm", method = RequestMethod.POST)
    @ResponseBody
    public String deletePersona(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String numeroDni = request.getParameter("jsonData");
        Gson gson = new Gson();
        GeneralResponse generalResponse = new GeneralResponse();
        String jsonData;
        try {
            boolean result = personaService.deletePersona(numeroDni);
            generalResponse.setSuccess(true);
            generalResponse.setMessage(OPERATION_SUCCESS);
            generalResponse.setTotalCount(0L);
            generalResponse.setData(result);
        } catch (Exception e){
            generalResponse.setSuccess(false);
            generalResponse.setMessage(e.getMessage() == null ? OPERATION_ERROR : e.getMessage());
            generalResponse.setTotalCount(0L);
            generalResponse.setData(null);
        } finally {
            jsonData = gson.toJson(generalResponse);
        }
        return jsonData;
    }

    @RequestMapping(value="/loadGridPersonsDefault.htm", method = RequestMethod.GET)
    @ResponseBody
    public String loadGridPersonsDefault(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new Gson();
        GeneralResponse generalResponse = new GeneralResponse();
        String jsonData;
        try {

            List<PersonaBean> list = personaService.listPersonActive(true);
            long count = list.size();
            generalResponse.setSuccess(true);
            generalResponse.setMessage("");
            generalResponse.setTotalCount(count);
            generalResponse.setData(list);

        } catch (Exception e){
            generalResponse.setSuccess(false);
            generalResponse.setMessage(e.getMessage());
            generalResponse.setTotalCount(0L);
            generalResponse.setData(null);
        } finally {
            jsonData = gson.toJson(generalResponse);
        }

        return jsonData;
    }

    @RequestMapping(value="/getSexo.htm", method = RequestMethod.GET)
    @ResponseBody
    public String getSexo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new Gson();
        GeneralResponse generalResponse = new GeneralResponse();
        String jsonData;
        try {

            SexoBean sexoM = new SexoBean();
            sexoM.setId("M");
            sexoM.setDescription("Masculino");

            SexoBean sexoF = new SexoBean();
            sexoF.setId("F");
            sexoF.setDescription("Femenino");

            List<SexoBean> list = new ArrayList<>();
            list.add(sexoM);
            list.add(sexoF);

            long count = list.size();
            generalResponse.setSuccess(true);
            generalResponse.setMessage("");
            generalResponse.setTotalCount(count);
            generalResponse.setData(list);

        } catch (Exception e){
            generalResponse.setSuccess(false);
            generalResponse.setMessage(e.getMessage());
            generalResponse.setTotalCount(0L);
            generalResponse.setData(null);
        } finally {
            jsonData = gson.toJson(generalResponse);
        }
        return jsonData;
    }

    @RequestMapping(value="/getDepartamento.htm", method = RequestMethod.GET)
    @ResponseBody
    public String getDepartamento(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new Gson();
        GeneralResponse generalResponse = new GeneralResponse();
        String jsonData;
        try {

            DepartamentoBean departamento = new DepartamentoBean();
            departamento.setId("");
            departamento.setDescription("- Seleccione -");

            DepartamentoBean departamentoAyac = new DepartamentoBean();
            departamentoAyac.setId("01");
            departamentoAyac.setDescription("Ayacucho");

            List<DepartamentoBean> list = new ArrayList<>();
            list.add(departamento);
            list.add(departamentoAyac);

            long count = list.size();
            generalResponse.setSuccess(true);
            generalResponse.setMessage("");
            generalResponse.setTotalCount(count);
            generalResponse.setData(list);

        } catch (Exception e){
            generalResponse.setSuccess(false);
            generalResponse.setMessage(e.getMessage());
            generalResponse.setTotalCount(0L);
            generalResponse.setData(null);
        } finally {
            jsonData = gson.toJson(generalResponse);
        }
        return jsonData;
    }

    @RequestMapping(value="/getProvincia.htm", method = RequestMethod.GET)
    @ResponseBody
    public String getProvincia(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new Gson();
        GeneralResponse generalResponse = new GeneralResponse();
        String jsonData;
        try {

            ProvinciaBean provincia = new ProvinciaBean();
            provincia.setId("");
            provincia.setDescription("- Seleccione -");

            ProvinciaBean provinciaAyac = new ProvinciaBean();
            provinciaAyac.setId("01");
            provinciaAyac.setDescription("Ayacucho");

            List<ProvinciaBean> list = new ArrayList<>();
            list.add(provincia);
            list.add(provinciaAyac);

            long count = list.size();
            generalResponse.setSuccess(true);
            generalResponse.setMessage("");
            generalResponse.setTotalCount(count);
            generalResponse.setData(list);

        } catch (Exception e){
            generalResponse.setSuccess(false);
            generalResponse.setMessage(e.getMessage());
            generalResponse.setTotalCount(0L);
            generalResponse.setData(null);
        } finally {
            jsonData = gson.toJson(generalResponse);
        }
        return jsonData;
    }

    @RequestMapping(value="/getDistrito.htm", method = RequestMethod.GET)
    @ResponseBody
    public String getDistrito(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new Gson();
        GeneralResponse generalResponse = new GeneralResponse();
        String jsonData;
        try {

            DistritoBean distrito = new DistritoBean();
            distrito.setId("");
            distrito.setDescription("- Seleccione -");

            DistritoBean distritoAyac = new DistritoBean();
            distritoAyac.setId("01");
            distritoAyac.setDescription("Ayacucho");

            List<DistritoBean> list = new ArrayList<>();
            list.add(distrito);
            list.add(distritoAyac);

            long count = list.size();
            generalResponse.setSuccess(true);
            generalResponse.setMessage("");
            generalResponse.setTotalCount(count);
            generalResponse.setData(list);

        } catch (Exception e){
            generalResponse.setSuccess(false);
            generalResponse.setMessage(e.getMessage());
            generalResponse.setTotalCount(0L);
            generalResponse.setData(null);
        } finally {
            jsonData = gson.toJson(generalResponse);
        }
        return jsonData;
    }


    @RequestMapping(value="/getEstadoCivil.htm", method = RequestMethod.GET)
    @ResponseBody
    public String getEstadoCivil(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new Gson();
        GeneralResponse generalResponse = new GeneralResponse();
        String jsonData;
        try {
            EstadoCivilBean estadoCivil = new EstadoCivilBean();
            estadoCivil.setId("");
            estadoCivil.setDescription("- Seleccione -");

            EstadoCivilBean estadoCivilBean = new EstadoCivilBean();
            estadoCivilBean.setId("01");
            estadoCivilBean.setDescription("Soltero");

            List<EstadoCivilBean> list = new ArrayList<>();
            list.add(estadoCivil);
            list.add(estadoCivilBean);

            long count = list.size();
            generalResponse.setSuccess(true);
            generalResponse.setMessage("");
            generalResponse.setTotalCount(count);
            generalResponse.setData(list);

        } catch (Exception e){
            generalResponse.setSuccess(false);
            generalResponse.setMessage(e.getMessage());
            generalResponse.setTotalCount(0L);
            generalResponse.setData(null);
        } finally {
            jsonData = gson.toJson(generalResponse);
        }
        return jsonData;
    }

}
