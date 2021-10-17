package com.todo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.todo.dao.CardDao;
import com.todo.model.Card;

@Controller
public class MainController {
	
	@Autowired
	private CardDao cardDao;
	
	@RequestMapping("/")
	public String home(HttpServletRequest request)
	{
		request.setAttribute("cards", cardDao.getAllCards());
		return "home";
	}
	
	@RequestMapping(value="/createCard",method = RequestMethod.POST)
	public RedirectView handleCreation(@ModelAttribute Card card, HttpServletRequest request)
	{
		cardDao.createOrUpdateCard(card);
		return new RedirectView(request.getContextPath()+"/");
	}
	
	@RequestMapping("/deleteCard/{cardId}")	
	public RedirectView handleProduct(@PathVariable("cardId") int cardId, HttpServletRequest request)
	{
		cardDao.removeCard(cardId);
		return new RedirectView(request.getContextPath()+"/");
	}
}
