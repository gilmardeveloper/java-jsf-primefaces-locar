package br.com.slv.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.slv.models.Pessoa;

public class PessoaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entity;

	public void save(Pessoa pessoa) {
		if (pessoa.getId() == null) {
			entity.persist(pessoa);
		} else {
			entity.merge(pessoa);
		}
	}

	public void remove(Pessoa pessoa) {
		entity.remove(pessoa);
	}

	public Pessoa find(Long id) {
		return entity.find(Pessoa.class, id);
	}

	public Pessoa find(String cpf) {
		TypedQuery<Pessoa> query = entity.createQuery("select p from Pessoa p where p.cpf = :pCpf", Pessoa.class);
		query.setParameter("pCpf", cpf);

		return query.getSingleResult();
	}

	public List<Pessoa> findAll() {
		TypedQuery<Pessoa> query = entity.createQuery("select distinct p from Pessoa p join fetch p.telefones", Pessoa.class);
		return query.getResultList();
	}

}
