package br.com.etecmam.bibloteca.pst;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.etecmam.bibloteca.dmp.Aluno;

public class AlunoPST {
	
	public Aluno getAlunoPorRM(int rm) {
		
		Aluno aluno = null;
		
		EntityManager em = JPAUtil.getEntityManager();		
		
		try {
			
			TypedQuery<Aluno> query = em.createQuery("SELECT A FROM Aluno A WHERE A.rm = :id", Aluno.class);
			
			query.setParameter("id", rm);
			
			aluno = query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	    		
		return aluno;
		
		
		
	}

}
