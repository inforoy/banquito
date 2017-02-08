package com.bank.credit.controller;

import com.bank.credit.model.GeneralResponse;
import com.bank.credit.model.bean.PersonaBean;
import com.bank.credit.service.PersonaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/")
public class PersonController extends AbstractController {

    @Autowired
    private PersonaService personaService;

    public static final String OPERATION_SUCCESS = "La operacion se ha realizado con Exito.";
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

}
