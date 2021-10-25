package br.com.slv.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.slv.models.Telefone;

public class TelefoneRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entity;

	public void save(Telefone telefone) {
		if (telefone.getId() == null) {
			entity.persist(telefone);
		} else {
			entity.merge(telefone);
		}
	}

	public void remove(Telefone telefone) {
		entity.remove(telefone);
	}

	public Telefone find(Long id) {
		return entity.find(Telefone.class, id);
	}
	
	public List<Telefone> findAll() {
		TypedQuery<Telefone> query = entity.createQuery("select t from Telefone t", Telefone.class);
		return query.getResultList();
	}

}
