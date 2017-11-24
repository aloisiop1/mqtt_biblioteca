package br.com.etecmam.bibloteca.dmp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.etecmam.bibloteca.pst.JPAUtil;

public class TesteJPA {
	
	
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		Aluno aluno = em.find(Aluno.class, 1L);
		Livro livro = em.find(Livro.class, 12345678924L);
		
		livro.setStatus("E");
		
		EmprestimoDevolucao emprestimoDevolucao = new EmprestimoDevolucao("2017-11-24", "2017-12-08", "", livro, aluno);
		em.getTransaction().begin();
		em.persist(emprestimoDevolucao);
		em.getTransaction().commit();

		
		TypedQuery<Aluno> query = em.createQuery("SELECT A FROM Aluno A", Aluno.class);
		
		List<Aluno> list = query.getResultList();
		
		for (Aluno a : list) {			
			System.out.println(a);
		}
		
		System.out.println("--------------------------------------------------------------------------------------------");
		
		TypedQuery<Livro> query2 = em.createQuery("SELECT L FROM Livro L", Livro.class);		
		
		List<Livro> livros = query2.getResultList();
		
		for (Livro l : livros) {			
			System.out.println(l);			
		}
		
		
		System.out.println("--------------------------------------------------------------------------------------------");
		
		TypedQuery<EmprestimoDevolucao> queryEmprest = em.createQuery("SELECT L FROM EmprestimoDevolucao L", EmprestimoDevolucao.class);		
		
		List<EmprestimoDevolucao> emprestimos = queryEmprest.getResultList();
		
		for (EmprestimoDevolucao e : emprestimos) {
			System.out.println(e);
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
