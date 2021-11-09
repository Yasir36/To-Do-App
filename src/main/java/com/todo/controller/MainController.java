package com.todo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.todo.service.CardService;
import com.todo.model.Card;

@Controller
public class MainController {
	
	@Autowired
	private CardService cardService;
	
	@RequestMapping("/")
	public String home(HttpServletRequest request)
	{
		request.setAttribute("cards", cardService.getAll());
		return "home";
	}
	
	@RequestMapping(value="/createOrUpdateCard",method = RequestMethod.POST)
	public RedirectView handleCreation(@ModelAttribute Card card, HttpServletRequest request)
	{
		cardService.createOrUpdate(card);
		return new RedirectView(request.getContextPath()+"/");
	}
	
	@RequestMapping("/deleteCard/{cardId}")	
	public RedirectView handleDeletion(@PathVariable("cardId") int cardId, HttpServletRequest request)
	{
		cardService.remove(cardId);
		return new RedirectView(request.getContextPath()+"/");
	}
}
