package com.bank.credit.controller;

import com.bank.credit.model.AppSessionData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
public class PrincipalController extends AbstractController{

	@Autowired
	Environment environment;

	@RequestMapping(value="/main.htm", method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//String datos = environment.getProperty("app.datos");
		ModelAndView view = new ModelAndView("Main");

		view.addObject("razonSocial", "eCredits SAC");
		view.addObject("usuario", "Harry Potter");
		view.addObject("numeroMensajes", 14);
		view.addObject("empresa", "eCredit");

		AppSessionData app = new AppSessionData();
		app.setEmpresa("eCredit");
		app.setUsuario("Harry Potter");
		app.setRazonSocial("eCredits SAC");
		app.setNumeroMensajes(14);

		// subir datos a session
		request.getSession().setAttribute("datosEnSession", app);

		return view;
	}


	@RequestMapping(value="/getAttributesToSession.htm", method = RequestMethod.GET)
	@ResponseBody
	public String getAttributesToSession(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		//HttpSession session = request.getSession(false);
		ObjectMapper mapper = new ObjectMapper();
		HashMap<Object, String> jsonObject = new HashMap<>();
		String jsonData;
		try {
			jsonObject.put("success","true");
			jsonObject.put("responseText", "responseText");
			jsonObject.put("descriptionAgency", "Ayacucho");
			jsonObject.put("username", "Yeny");
			jsonObject.put("descriptionRole", "Prestamista");
			jsonObject.put("responseText", "responseText");
			jsonObject.put("fullName", "Yeny Canales.");
			jsonObject.put("category", "COLABORADOR.");
			jsonObject.put("pending", "0");
			jsonObject.put("process", "1");
		} catch (Exception e){
			e.getMessage();
			jsonObject.put("mensaje", e.getMessage());
		} finally {
			jsonData = mapper.writeValueAsString(jsonObject);
		}
		return jsonData;
	}

}