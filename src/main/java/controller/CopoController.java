/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import MODEL.MoCopo;
import MODEL.MoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import serviço.CopoService;
import serviço.UsuarioService;

/**
 *
 * @author a1628682
 */

    




@Controller
public class CopoController {

	@Autowired
	CopoService CopoService;
	
	@GetMapping("/")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("copos", CopoService.findAll());
		
		return mv;
	}
	
	@RequestMapping("/new")
	public String add(Model model) {
		
		MoCopo copo = new MoCopo();
		model.addAttribute("copo", copo);
		
		return "adicionar";
	}
	

	@PostMapping("/save")
	public String save(@ModelAttribute("copo") MoCopo copos) {
            
            MoCopo copo = null;
				
		CopoService.persist(copo);
		
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		CopoService.delete(id);
		
		return "redirect:/";
	}
 
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    MoCopo copo = CopoService.findOne(id);      
	     
	    model.addAttribute("copo", copo);
	    return "editar";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, MoCopo copo, 
	  BindingResult result, Model model) {	         
	    CopoService.persist(copo);
	    model.addAttribute("copos", CopoService.findAll());
	    return "index";
	}	     
	
}

