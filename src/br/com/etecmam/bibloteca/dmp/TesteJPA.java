package br.com.etecmam.bibloteca.dmp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.etecmam.bibloteca.pst.JPAUtil;

public class TesteJPA {
	
	
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		TypedQuery<Aluno> query = em.createQuery("SELECT A FROM Aluno A", Aluno.class);
		
		List<Aluno> list = query.getResultList();
		
		for (Aluno a : list) {			
			System.out.println(a);			
		}
		
//		Aluno a = new Aluno();
//				
//		a.setNome("ALOISIO PINTO");
//		a.setDataCadastro("2017-11-24");
//		a.setDataValidade("2018-11-24");
//		a.setEmail("aloisiop1@gmail.com");
//		a.setCurso("INFO");
//		a.setModulo("3º");
//		a.setRm(123456);
//		a.setTelefone("(14) 3406 1000");
//		
//		em.getTransaction().begin();
//		em.persist(a);
//		em.getTransaction().commit();
	}

}
