package com.bank.credit.controller;

import com.bank.credit.model.Persona;
import com.bank.credit.model.GeneralResponse;
import com.bank.credit.service.PersonaService;
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

    @RequestMapping(value="/getListPersons.htm", method = RequestMethod.GET)
    @ResponseBody
    public String getListPersons(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new Gson();
        GeneralResponse generalResponse = new GeneralResponse();
        String jsonData = null;
        try {
            boolean userActive = false;
            List<Persona> list = personaService.listPersonActive(userActive);

            generalResponse.setSuccess(true);
            generalResponse.setMessage("");
            generalResponse.setTotalCount(new Long(list.size()));
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
        String jsonData = null;
        try {
            boolean userActive = true;
            List<Persona> list = personaService.listPersonActive(userActive);

            generalResponse.setSuccess(true);
            generalResponse.setMessage("");
            generalResponse.setTotalCount(new Long(list.size()));
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

    @RequestMapping(value="/updatePersons.htm", method = RequestMethod.GET)
    @ResponseBody
    public String updateListPersons(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new Gson();

        return "";
    }

    @RequestMapping(value="/loadGridPersonsDefault.htm", method = RequestMethod.GET)
    @ResponseBody
    public String loadGridPersonsDefault(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new Gson();
        GeneralResponse generalResponse = new GeneralResponse();
        String jsonData = null;
        try {
            boolean userActive = true;
            List<Persona> list = personaService.listPersonActive(userActive);

            generalResponse.setSuccess(true);
            generalResponse.setMessage("");
            generalResponse.setTotalCount(new Long(list.size()));
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
