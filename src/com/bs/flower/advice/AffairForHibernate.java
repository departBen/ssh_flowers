package com.bs.flower.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * 事务管理增强
 * @author ben
 *
 */
public class AffairForHibernate implements MethodInterceptor {
	
	private SessionFactory sessionFactory;	
	
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		
		Session session = null;
		Transaction ts = null;
		Object obj = null;
		try {
			session = sessionFactory.getCurrentSession();
			ts = session.beginTransaction();
			obj = arg0.proceed();
			ts.commit();
			
		} catch (HibernateException e) {
			ts.rollback();
			throw e;
		}
		
		return obj;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
		
}
