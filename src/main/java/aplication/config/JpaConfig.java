package aplication.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaConfig {

	private static EntityManagerFactory emf;
	private static EntityManager em;

	public static EntityManager iniciarConexao() {
		if (em == null) {
			emf = Persistence.createEntityManagerFactory("BancoDados");
			em = emf.createEntityManager();
		}
		return em;
	}

	public static void fecharConexão() {
		if (em != null) {
			em.close();
			emf.close();
		}
	}

}
