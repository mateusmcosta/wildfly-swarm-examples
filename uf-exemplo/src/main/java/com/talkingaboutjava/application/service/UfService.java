package com.talkingaboutjava.application.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.talkingaboutjava.application.persistence.dao.UfDAO;
import com.talkingaboutjava.application.persistence.entity.Uf;


@Stateless
public class UfService {
	
	@Inject
	private UfDAO ufDAO;
	
	public List<Uf> buscaTodos() {
		return ufDAO.buscaTodos();
	}
}
