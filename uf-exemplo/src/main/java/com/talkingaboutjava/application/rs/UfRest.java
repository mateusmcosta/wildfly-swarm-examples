package com.talkingaboutjava.application.rs;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.inject.Inject;

import com.talkingaboutjava.application.persistence.entity.Uf;
import com.talkingaboutjava.application.service.UfService;

@Path("uf/")
public class UfRest {

	@Inject
	private UfService ufService;

	@GET
	@Path("buscaTodos")
	@Produces("application/json")
	public List<Uf> buscaTodos() {
		List<Uf> ufs = ufService.buscaTodos();

		return ufs;
	}
	
	
	@GET
	@Path("teste")
	@Produces("text/plain")
	public String teste() {
		List<Uf> ufs = ufService.buscaTodos();
		return "teste "+ufs == null ? "0" : ufs.size()+"";
	}
}
