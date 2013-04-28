package com.common.tool;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Jpa {
	public static void main(String args[]) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory(null);
		EntityManager em = factory.createEntityManager();
		// EntityManager em =
		// factory.createEntityManager(PersistenceContextType.EXTENDED.HashMap<K,
		// V>);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em
				.createQuery("select e from Employee e where e.division.name = 'Research' AND e.avgHours > 40");
		List results = query.getResultList();
		for (Object res : results) {
			//Users emp = (Users) res;
			// 这里给值
		}
		tx.commit();
		em.close();
		factory.close();
	}
}
