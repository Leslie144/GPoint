package pe.edu.upc.demo.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import pe.edu.upc.demo.entities.Rol;
import pe.edu.upc.demo.serviceinterface.IRolService;

@Controller
@RequestMapping("/roles")
public class RolController {
	@Autowired
	private IRolService rService;
	
	@GetMapping("/nuevo")
	public String newRol(Model model) {
		model.addAttribute("r",new Rol());
		return "rol/frmRegistro";
	}
	
	@PostMapping("/guardar")
	public String saveRol(@Valid Rol r, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "rol/frmRegistro";
		} else {
			rService.insert(r);
			model.addAttribute("mensaje","Se registró correctamente");
			return "redirect:/roles/nuevo";
		}
				
	}
	
	@GetMapping("/listar")
	public String listRol(Model model) {
		try {
			model.addAttribute("listaRoles", rService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/rol/frmLista";
	}
	
	@RequestMapping("/eliminar")
	public String deleteRol(Map<String,Object> model, @RequestParam(value="id")Integer id) {
		try {
			if(id != null && id>0) {
				rService.delete(id);
				model.put("listaRoles", rService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "rol/frmLista";
	}
	
	@RequestMapping("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {
		
		Optional<Rol>objR= rService.listId(id);
		model.addAttribute("rols", objR.get());
		return "rol/frmActualiza";
	}
	
	@PostMapping("/modificar")
	public String updateRol(Rol ro) {
		rService.update(ro);
		return "redirect:/roles/listar";
	}
}
