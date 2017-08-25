package br.com.slv.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.slv.models.Locacao;

public class LocacaoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entity;

	public void save(Locacao locacao) {
		if (locacao.getId() == null) {
			entity.persist(locacao);
		} else {
			entity.merge(locacao);
		}
	}

	public void remove(Locacao locacao) {
		entity.remove(locacao);
	}

	public Locacao find(Long id) {
		return entity.find(Locacao.class, id);
	}

	public List<Locacao> findAll() {
		TypedQuery<Locacao> query = entity.createQuery("select a from Locacao a", Locacao.class);
		return query.getResultList();
	}

}
