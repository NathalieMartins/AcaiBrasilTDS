package controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import MODEL.MoUsuario;
import repositório.UsuarioRepository;
import serviço.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioService UsuarioService;
	
	@GetMapping("/")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("pessoas", UsuarioService.findAll());
		
		return mv;
	}
	
	@RequestMapping("/new")
	public String add(Model model) {
		
		MoUsuario usuario = new MoUsuario();
		model.addAttribute("usuario", usuario);
		
		return "adicionar";
	}
	

	@PostMapping("/save")
	public String save(@ModelAttribute("usuario") MoUsuario pessoa) {
            MoUsuario usuario = null;
				
		UsuarioService.persist(usuario);
		
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		UsuarioService.delete(id);
		
		return "redirect:/";
	}
 
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    MoUsuario usuario = UsuarioService.findOne(id);      
	     
	    model.addAttribute("usuario", usuario);
	    return "editar";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, MoUsuario usuario, 
	  BindingResult result, Model model) {	         
	    UsuarioService.persist(usuario);
	    model.addAttribute("usuarios", UsuarioService.findAll());
	    return "index";
	}	     
	
}
