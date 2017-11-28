package br.com.etecmam.bibloteca.pst;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.etecmam.bibloteca.dmp.Livro;

public class LivroPST {
	
	private List<Livro> lista;
	
	
	public Livro getlivrosPorTombo(String tombo) {
		
		EntityManager em = JPAUtil.getEntityManager();		
		
		Livro livro = null;
		
		try {
			
			TypedQuery<Livro> query = em.createQuery("SELECT L FROM Livro L WHERE L.tombo = :tombo", Livro.class);
			
			query.setParameter("tombo", tombo);
			livro = query.getSingleResult();
						
		} catch (Exception e) {
			e.printStackTrace();
		}
			    		
		return livro;
		
	}
	
	
	public Livro getlivrosPorCodigo(long id) {
		
		EntityManager em = JPAUtil.getEntityManager();		
		
		Livro livro = null;
		
		try {			
			livro = em.find( Livro.class, id );
						
		} catch (Exception e) {
			e.printStackTrace();
		}
			    		
		return livro;
	
	}

	
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
	
	
	public List<String> getListaDeGeneros() {
		
		EntityManager em = JPAUtil.getEntityManager();		
		
		List<String> generos = null;
		
		lista = new ArrayList<>();
		
		try {
			
			 TypedQuery<String> query = em.createQuery("SELECT DISTINCT(L.genero) FROM Livro L", String.class);
						
			generos  = query.getResultList();			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			    		
		return generos;
		
	}
	
	
}
