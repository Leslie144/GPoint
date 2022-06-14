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

import pe.edu.upc.demo.entities.Notificacion;
import pe.edu.upc.demo.serviceinterface.INotificacionService;

@Controller
@RequestMapping("/notificaciones")
public class NotificacionController {
	@Autowired
	private INotificacionService nService;
	
	
	// REGISTRA UNA NUEVA CALIFICACION Y DIRECCIONA UN FORM DE REGISTRO
	@GetMapping("/nuevo")
	public String newNotificacion(Model model) {
		model.addAttribute("not", new Notificacion());
		return "transaccion/frmTransaccion";
	}
	
	
	// GUARDA EL REGISTRO DE CALIFICACION Y DIRECCIONA A UN FORM DE GUARDADO
	@PostMapping ("/guardar")
	public String saveNotificacion(@Valid Notificacion n, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "notificacion/frmNotificacion";
		} else {
			nService.insert(n);
			model.addAttribute("mensaje", "Se registró correctamente!!");
			return "redirect:/notificaciones/nuevo";
		}
	}

	
	// MUESTRA LAS PERSONAS REGISTRADAS EN UNA LISTA
	@GetMapping ("/listar")
	public String listTransaccion(Model model) {
		try {
			model.addAttribute("listaNotificaciones", nService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "notificacion/frmLista";
	}

	
	@RequestMapping ("/eliminar")
	public String deleteTransaccion(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				nService.delete(id); // elimina
				model.put("listaNotificaciones", nService.list()); // vuelve a listar actualizado
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "notificacion/frmLista";
	}

	
	// ACTUALIZAR UN REGISTRO DE LA LISTA
	@RequestMapping ("/irmodificar/{id}")
	public String goUpdate(@PathVariable int id, Model model) {

		Optional<Notificacion> objNot = nService.listId(id); // Lista los atributos de un registro
		model.addAttribute("not", objNot.get());// Trae los atributos del registro
		return "notificacion/frmActualiza";
	}

	
	@PostMapping ("/modificar")
	public String updateNotificacion(Notificacion not) {
		nService.update(not);
		return "redirect:/notificaciones/listar";
	}
}