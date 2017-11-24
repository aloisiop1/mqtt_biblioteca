package br.com.etecmam.bibloteca.pst;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory( "BIBLIOTECA_UNIT" );

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static void fecharEntityManagerFactory() {

		if (emf.isOpen()) {
			System.out.println("FECHANDO EMF...");
			emf.close();

		}

	}

	
}