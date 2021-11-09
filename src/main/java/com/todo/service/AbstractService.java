package com.todo.service;

import java.util.List;

import com.todo.model.Card;

public interface AbstractService<T> {
	public List<T> getAll();
	public Card get(int id);
	public void createOrUpdate(T t);	
	public void remove(int id);
}
