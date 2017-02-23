package com.talkingaboutjava.application.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name = "UF")
public class Uf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 232359273804681340L;

	private String id;
	private String nome;
	private Long version;

	/**
	 * Construtor padrão
	 */
	public Uf() {
		this(null, null);
	}

	/**
	 * Construtor
	 * 
	 * @param id
	 *            {@link String}
	 * @param nome
	 *            {@link String}
	 */
	public Uf(String id, String nome) {
		setId(id);
		setNome(nome);
	}

	@Id
	@Column(name = "UF", columnDefinition = "char(2)")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "NOME")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Version
	@Column(name = "VERSION")
	public Long getVersion() {
		return version;
	}

	public void setVersion(final Long version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uf other = (Uf) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
