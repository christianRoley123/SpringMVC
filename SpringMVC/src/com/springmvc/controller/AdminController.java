package com.springmvc.controller;

import java.util.List;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvc.model.Admin;
import com.springmvc.service.AdminService;

@Controller
public class AdminController  {
	
	@Autowired
	private AdminService admin_Service;
	
	@RequestMapping(value = "admin/guardar" , method= RequestMethod.POST)
	public String guardar(@ModelAttribute("clave_admin") Admin admin, Model modelo, RedirectAttributes redirectAttributes ,
							@RequestParam("param_estado") String estado) {
		
		admin.setFechaCreacion(new Timestamp(new Date().getTime()));
		if(admin_Service.save(admin)) {
			redirectAttributes.addFlashAttribute("resultado", "Registro realizado con exito");
			
		}else{
			redirectAttributes.addFlashAttribute("resultado", "Error, verificar inputs");
			
		}
		return  "redirect:/admin";
		
	}
	
	@RequestMapping("/admin/{id}/update")
	public String showUpdate(Model modelo, @PathVariable("codigo") int codigo) {
		Admin adminObj = admin_Service.findById(codigo);
		modelo.addAttribute("adminUpdate", adminObj);
		return "admin";
	}
	
	
	
	
	@RequestMapping("/admin")
	public String showAdmin(Model model, @ModelAttribute("resultado_flash") String objFlash) {
		//springform  noss pide Forzozamente una instancia del POJO(MODELO.class) por ello enviamos la instancia OBJ_ADMIN;
		Admin obj_admin = new Admin();
		model.addAttribute("clave_admin" , obj_admin);
		//
		model.addAttribute("objFlash", objFlash);
		
		//listar administradores
		List<Admin> listObj =  admin_Service.findAll();
		//Vector<Admin> vector = (Vector<Admin>) listObj;
		model.addAttribute("administradores",listObj);
		return "admin";
	}
	
	
//	 @ModelAttribute va a leer un atributo del MODELO con CLAVE
//	Admin => De que tipo es
	@RequestMapping(value = "/admin/save" , method = RequestMethod.POST)
	public String encargarseDeAdmin(@ModelAttribute("clave_admin") Admin modelAttribute , Model modelo, RedirectAttributes redirectAttributes,
									@RequestParam("param_estado") String estado) {
		Logger logger = Logger.getLogger("AdminController.class");
		logger.info("VALOR DEL MODELATTRIBUTE");
//			Admin instancia = new Admin();
		//modelo.addAttribute("adminForm", modelAttribute);
		System.out.println("Valores del ModelAtributte: " + modelAttribute );
		System.out.println("Request param: " + estado);
			//RedirectAttribute -> interfaz de spring ,  flash atribute es un metodo persiste en varias peticiones si se dirije a otro CONTROLADOR
		redirectAttributes.addFlashAttribute("resultado_flash", "Acaba de realizar los cambios con exito" );
		//return "index";
		//ya no devolvera una direccion o vista logica, sino una redireccion
		return "redirect:/admin";
		}
	

}
