/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import MODEL.MoItem;
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
import serviço.ItemService;

/**
 *
 * @author a1628682
 */
@Controller
public class ItemController {

	@Autowired
	ItemService ItemService;
	
	@GetMapping("/")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("itens", ItemService.findAll());
		
		return mv;
	}
	
	@RequestMapping("/new")
	public String add(Model model) {
		
		MoItem item = new MoItem();
		model.addAttribute("item", item);
		
		return "adicionar";
	}
	

	@PostMapping("/save")
	public String save(@ModelAttribute("item") MoItem itens) {
            
            MoItem item = null;
				
		ItemService.persist(item);
		
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		ItemService.delete(id);
		
		return "redirect:/";
	}
 
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    MoItem item = ItemService.findOne(id);      
	     
	    model.addAttribute("item", item);
	    return "editar";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, MoItem item, 
	  BindingResult result, Model model) {	         
	    ItemService.persist(item);
	    model.addAttribute("itens", ItemService.findAll());
	    return "index";
	}	     
	
}