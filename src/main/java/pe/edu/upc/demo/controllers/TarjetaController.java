package pe.edu.upc.demo.controllers;

import javax.validation.Valid;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.demo.entities.Tarjeta;
import pe.edu.upc.demo.serviceinterface.ITarjetaService;
import pe.edu.upc.demo.serviceinterface.IUserService;

@Controller
@RequestMapping("/tarjetas")
public class TarjetaController {
	@Autowired
	private ITarjetaService tService;
	@Autowired
	private IUserService uService;

	@GetMapping("/nuevo")
	public String newTrajeta(Model model) {
		model.addAttribute("t", new Tarjeta());
		model.addAttribute("listaUsuario", uService.listar());
		model.addAttribute("listaTarjetas", tService.list());
		return "tarjeta/frmRegistro";
	}

	@PostMapping("/guardar")
	public String saveTarjeta(@Valid Tarjeta objTar, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			return "tarjeta/frmRegistro"; // carpeta
		} else {
			tService.insert(objTar);
			model.addAttribute("mensaje", "Se guardó correctamente");
			return "redirect:/tarjetas/listar";// @RequestMapping
		}
	}

	@GetMapping("/listar")
	public String listTarjetas(Model model) {
		try {
			model.addAttribute("t", new Tarjeta());
			model.addAttribute("listaTarjetas", tService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/tarjeta/frmLista"; // carpeta
	}
}
