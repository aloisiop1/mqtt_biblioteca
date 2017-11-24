package br.com.etecmam.bibloteca.pst;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.etecmam.bibloteca.dmp.Livro;

public class LivroPST {
	
	private List<Livro> lista;

	public List<Livro> getlivrosPorCategoria(String genero) {
		
		EntityManager em = JPAUtil.getEntityManager();		
		
		lista = new ArrayList<>();
		
		try {
			
			TypedQuery<Livro> query = em.createQuery("SELECT L FROM Livro L WHERE L.genero = :gen", Livro.class);
			
			query.setParameter("gen", genero);
			lista  = query.getResultList();			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	    		
		return lista;
		
	}

}
