package com.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("resultado") //Si desea poner mas variables de session -> ({"v1","v2"})
public class IndexController {
	
	//COMO DECIR QUE ESTE METODO VA A TENER UNA EPTICION HTTP
	//DE FORMA DINAMICA ESTAMOS CONCATENANDO EL CONTEXTPATH http://localhost:8081/SpringMVC
	@RequestMapping("/")
	public String mostrarIndex(Model model) { //Model es una interfaz para colocar aributos que son validos para un controlador
		model.addAttribute("resultado_model", "Resultado desde session");
		model.addAttribute("resultado","Resultado de anotacion session");
		
		
		return "index";
	}
	
	//DE FORMA DINAMICA ESTAMOS CONCATENANDO EL CONTEXTPATH http://localhost:8081/SpringMVC
	@RequestMapping("about")
	public String mostrarAcercaDe(HttpSession httpsession, SessionStatus sessionStatus) {
		httpsession.setAttribute("resultado_sesion", "resultado de la session"); //OTRA FORMA DE PERSISTIR SERIA CON LA ETIQUETA @SESSIONATTRIBUTES
		sessionStatus.setComplete(); //limpia todos los atributos de la session
		return "about";
	}
//	
//	@RequestMapping("admin")
//	public String mostrarAdmin(Model model) {
//		model.addAttribute("mensaje", "Enviando mensaje");//PARA QUE EL MENSAJE SE PUEDA PERSISTIR EN CUALQUIER CONTROLADOR DE ESTA CLASE TENEMOS QUE HACER UNA SESSION 
//		return "admin";
//	}
}
