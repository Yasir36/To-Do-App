package com.todo.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.todo.dao.CardDao;
import com.todo.model.Card;

@Component
public class CardDaoImpl implements CardDao {
	
	@Autowired
	public HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Card> getAllCards() {
		 return this.hibernateTemplate.loadAll(Card.class);
	}

	@Override
	public Card getCard(int id) {
		return this.hibernateTemplate.load(Card.class, id);
	}

	@Override
	@Transactional
	public void createOrUpdateCard(Card card) {
		this.hibernateTemplate.saveOrUpdate(card);
	}

	@Override
	@Transactional
	public void removeCard(int id) {
		this.hibernateTemplate.delete(this.getCard(id));
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public String toString() {
		return "CardDaoImpl [hibernateTemplate=" + hibernateTemplate + "]";
	}
	
}
