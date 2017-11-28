package br.com.etecmam.bibloteca.dmp;

import java.util.List;

import br.com.etecmam.bibloteca.dmp.json.AlunoJSON;
import br.com.etecmam.bibloteca.dmp.json.GenerosJSON;
import br.com.etecmam.bibloteca.dmp.json.LivroJSON;
import br.com.etecmam.bibloteca.pst.AlunoPST;
import br.com.etecmam.bibloteca.pst.LivroPST;

public class TestePST {

	public static void main(String[] args) {

		LivroPST livroPST = new LivroPST();

		List<Livro> info = livroPST.getlivrosPorCategoria("Informática");

		for (Livro livro : info) {
			System.out.println( new LivroJSON(livro).toJson() );
		}
				
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		List<String> listaDeGeneros = livroPST.getListaDeGeneros();
		
		GenerosJSON generosJSON = new GenerosJSON(listaDeGeneros);
		
		System.out.println(generosJSON.toJson());
		
		
		System.out.println("-- CODIGO -------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		Livro livro = livroPST.getlivrosPorCodigo(12345678924L);		
		System.out.println( new LivroJSON(livro).toJson());
		
		System.out.println("-- TOMBO -------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		livro = livroPST.getlivrosPorTombo("591");		
		System.out.println( new LivroJSON(livro).toJson());
		
		System.out.println("-- ALUNO -------------------------------------------------------------------------------------------------------------------------------------------------------------");
				
		Aluno aln = new AlunoPST().getAlunoPorRM(14288);
		System.out.println( new AlunoJSON(aln).toJson() );
				
	}

}
