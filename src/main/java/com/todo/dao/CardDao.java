package com.todo.dao;

import java.util.List;

import com.todo.model.Card;


public interface CardDao {
	public List<Card> getAllCards();
	public Card getCard(int id);
	public void createOrUpdateCard(Card card);
	public void removeCard(int id);
}
