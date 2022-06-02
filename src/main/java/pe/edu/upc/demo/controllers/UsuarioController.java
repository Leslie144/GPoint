package pe.edu.upc.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.serviceinterface.IRolService;
import pe.edu.upc.demo.serviceinterface.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IRolService rService;

	@Autowired
	private IUsuarioService uService;

	@GetMapping("/nuevo")
	public String newUsuario(Model model) {

		model.addAttribute("usuario", new Usuario());
		model.addAttribute("listaRoles", rService.list());
		return "usuario/frmRegistro";
	}

	@PostMapping("/guardar")
	public String saveUsuario(@Valid Usuario usuario, BindingResult binRes) {
		try {
			if (binRes.hasErrors()) {
				System.out.println(binRes.getFieldError());
				return "usuario/frmRegistro";
			} else {
				uService.insert(usuario);
				return "redirect:/usuarios/nuevo";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "usuario/frmRegistro";
		}
	}

	@GetMapping("/listar")
	public String listUsuario(Model model) {
		try {
			model.addAttribute("listaUsuarios", uService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "usuario/frmLista";
	}

}
