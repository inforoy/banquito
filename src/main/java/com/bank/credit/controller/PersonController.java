package com.bank.credit.controller;

import com.bank.credit.model.Person;
import com.bank.credit.model.GeneralResponse;
import com.google.gson.Gson;
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

    @RequestMapping(value="/getPersons.htm", method = RequestMethod.GET)
    @ResponseBody
    public String getListPersons(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new Gson();
        GeneralResponse generalResponse = new GeneralResponse();
        String jsonData = null;
        try {
            Person person1 = new Person();
            person1.setName("Roy");
            person1.setEmail("roy@gmail.com");
            person1.setPhone("3232563");

            Person person2 = new Person();
            person2.setName("Azi");
            person2.setEmail("azi@gmail.com");
            person2.setPhone("9656845");

            List<Person> list = new ArrayList<>();
            list.add(person1);
            list.add(person2);

            generalResponse.setSuccess(true);
            generalResponse.setMessage("");
            generalResponse.setTotalCount(new Long(list.size()));
            generalResponse.setData(list);

            jsonData = gson.toJson(generalResponse);

        } catch (Exception e){
            generalResponse.setSuccess(false);
            generalResponse.setMessage(e.getMessage());
            generalResponse.setTotalCount(0L);
            generalResponse.setData(null);
        } finally {

        }

        return jsonData;
    }

    @RequestMapping(value="/updatePersons.htm", method = RequestMethod.GET)
    @ResponseBody
    public String updateListPersons(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new Gson();

        return "";
    }

}
