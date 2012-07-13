package cn.jhc.interceptor;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import cn.jhc.annotations.Transactional;
import cn.jhc.manager.Manager;

@Transactional
@Interceptor
public class TransactionalInterceptor implements Serializable {

	private static final long serialVersionUID = -4005485633217198958L;

	private static final Logger logger 
			= Logger.getLogger(TransactionalInterceptor.class.getName());

	@AroundInvoke
	public Object manageTransaction(InvocationContext ctx) throws Exception {
		Manager manager = (Manager) ctx.getTarget();
		EntityManager em = manager.getEntityManager();
		Object obj = null;
		try {
			em.getTransaction().begin();
			obj = ctx.proceed();
			em.getTransaction().commit();
		} catch (RuntimeException ex) {
			try {
				em.getTransaction().rollback();
			} catch (RuntimeException rex) {
				logger.severe("Could not rollback transaction. " + rex);
			}
			throw ex;
		}
		return obj;
	}
}
