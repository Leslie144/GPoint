package pe.edu.upc.demo.controllers;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.demo.entities.DetalleResena;
import pe.edu.upc.demo.entities.Juego;

import pe.edu.upc.demo.serviceinterface.ICalificacionService;
import pe.edu.upc.demo.serviceinterface.ICategoriaService;
import pe.edu.upc.demo.serviceinterface.IClasificacionService;
import pe.edu.upc.demo.serviceinterface.IJuegoService;
import pe.edu.upc.demo.serviceinterface.IPopularidadService;

@Controller
@RequestMapping("/juegos")
public class JuegoController {
	
	@Autowired
	private IJuegoService jService;
	@Autowired
	private ICategoriaService cService;
	@Autowired
	private IClasificacionService claService;
	@Autowired
	private ICalificacionService caService;
	@Autowired
	private IPopularidadService poService;
	
	@GetMapping("/nuevo")
	public String newJuego(Model model) {
		model.addAttribute("j", new Juego());
		model.addAttribute("listaCategorias", cService.list());
		model.addAttribute("listaClasificaciones", claService.list());
		model.addAttribute("listaCalificaciones", caService.list());
		model.addAttribute("listaPopularidades", poService.list());
		return "juego/juego";
	}
	
	@PostMapping("/guardar")
	public String registrarJuego(@Valid @ModelAttribute("j") Juego j, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			System.out.println(binRes.getFieldError(null));
			return "juego/juego";
		} else {
			jService.insert(j);
			model.addAttribute("mensaje", "Se guardó correctamente");
			return "redirect:/juegos/listar";
		}
	}
	
	
	@GetMapping("/listar")
	public String listarJuegos(Model model) {
		try {	
			model.addAttribute("j", new Juego());
			model.addAttribute("listaJuegos", jService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/juego/listaJuego";
	}
}
