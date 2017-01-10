package com.bank.credit.controller;

import com.bank.credit.model.GeneralResponse;
import com.bank.credit.model.Sexo;
import com.bank.credit.service.ComboService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/")
public class ComboController extends AbstractController{

    @Autowired
    private ComboService comboService;

    @RequestMapping(value="/getSexo.htm", method = RequestMethod.GET)
    @ResponseBody
    public String getSexo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Gson gson = new Gson();
        GeneralResponse generalResponse = new GeneralResponse();
        String jsonData = null;
        try {

            List<Sexo> list = comboService.getSexo();

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
