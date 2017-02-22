package com.talkingaboutjava.application.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.talkingaboutjava.application.persistence.entity.Uf;

public class UfDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Uf> buscaTodos() {
		return entityManager.createQuery("select e from Uf e order by e.id desc", Uf.class).getResultList();
	}

	public void create(String sigla, String nome) {
		entityManager.persist(new Uf(sigla, nome));
	}
}
