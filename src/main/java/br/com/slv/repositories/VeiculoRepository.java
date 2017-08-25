package br.com.slv.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.slv.models.Veiculo;

public class VeiculoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entity;

	public void save(Veiculo veiculo) {
		if (veiculo.getId() == null) {
			entity.persist(veiculo);
		} else {
			entity.merge(veiculo);
		}
	}

	public void remove(Veiculo veiculo) {
		entity.remove(veiculo);
	}

	public Veiculo find(Long id) {
		return entity.find(Veiculo.class, id);
	}

	public Veiculo find(String placa) {
		TypedQuery<Veiculo> query = entity.createQuery("select v from Veiculo v where v.placa = :pPlaca",
				Veiculo.class);
		query.setParameter("pPlaca", placa);

		return query.getSingleResult();
	}

	public List<Veiculo> findAll() {
		TypedQuery<Veiculo> query = entity.createQuery("select v from Veiculo v", Veiculo.class);
		return query.getResultList();
	}

}
