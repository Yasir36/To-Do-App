package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.dao.CardDao;
import com.todo.model.Card;

@Service
public class CardService implements AbstractService<Card>{
	
	@Autowired
	private CardDao cardDao;
	
	public CardDao getCardDao() {
		return cardDao;
	}

	public void setCardDao(CardDao cardDao) {
		this.cardDao = cardDao;
	}

	@Override
	public List<Card> getAll()
	{
		return cardDao.getAllCards();
	}
	
	@Override
	public Card get(int id)
	{
		return cardDao.getCard(id);
	}
	
	@Override
	public void createOrUpdate(Card card)
	{
		cardDao.createOrUpdateCard(card);
	}
	
	@Override
	public void remove(int id)
	{
		cardDao.removeCard(id);
	}
}
