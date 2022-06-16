package pe.edu.upc.demo.controllers;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.demo.entities.DetalleGaleria;
import pe.edu.upc.demo.serviceinterface.IDetalleGaleriaService;
import pe.edu.upc.demo.serviceinterface.IGaleriaService;
import pe.edu.upc.demo.serviceinterface.IJuegoService;
import pe.edu.upc.demo.serviceinterface.IUserService;


@Controller
@RequestMapping("/detallegalerias")
public class DetalleGaleriaController {
	
	@Autowired
	private IDetalleGaleriaService dgService;
	@Autowired
	private IGaleriaService gService;
	@Autowired
	private IUserService uService;
	@Autowired
	private IJuegoService jService;
	
	@GetMapping("/nuevo")
	public String newDetalleGaleria(Model model) {
		model.addAttribute("dg", new DetalleGaleria());
		model.addAttribute("listaGalerias", gService.list());
		model.addAttribute("listaUsuarios", uService.listar());
		model.addAttribute("listaJuegos", jService.list());
		return "detallegaleria/detallegaleria";
	}
	
	@PostMapping("/guardar")
	public String registrarDetalleGaleria(@Valid DetalleGaleria objDg, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			return "detallegaleria/detallegaleria";
		} else {
			dgService.insert(objDg);
			model.addAttribute("mensaje", "Se guardó correctamente");
			return "redirect:/detallegalerias/listar";
		}
	}
	
	@GetMapping("/listar")
	public String listarDetalleGalerias(Model model) {
		try {
			model.addAttribute("dr", new DetalleGaleria());
			model.addAttribute("listadetallegaleria", dgService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/detallegaleria/listaDetalleGaleria";
	}
}
