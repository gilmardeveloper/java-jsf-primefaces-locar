package br.com.slv.factorys;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityFactory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("siadb");
		return emf.createEntityManager();
	}

	public void destroyEntityManager(@Disposes EntityManager entity) {
		if (entity.isOpen()) {
			entity.close();
		}
	}

}
