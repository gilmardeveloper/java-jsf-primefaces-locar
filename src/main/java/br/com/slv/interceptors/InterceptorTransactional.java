package br.com.slv.interceptors;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import br.com.slv.annotations.Transactional;

@Interceptor
@Transactional
public class InterceptorTransactional implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entity;

	@AroundInvoke
	public Object contextInterceptor(InvocationContext context) throws Exception {

		entity.getTransaction().begin();
		Object object = context.proceed();
		entity.getTransaction().commit();

		return object;

	}

}
