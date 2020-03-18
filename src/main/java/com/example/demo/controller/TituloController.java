package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.StatusTitulo;
import com.example.demo.model.Titulo;
import com.example.demo.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	@Autowired
	private Titulos titulos;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("todosStatusTitulo", StatusTitulo.values());
		return mv;
	}
	//Salvar no banco de dados
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		
		titulos.save(titulo);
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("mensagem", "Salvo com sucesso");
		mv.addObject("todosStatusTitulo", StatusTitulo.values());
		return mv;
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}
}
