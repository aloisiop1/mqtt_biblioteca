package br.com.etecmam.bibloteca.dmp;

import java.util.List;

import br.com.etecmam.bibloteca.pst.LivroPST;

public class TestePST {

	public static void main(String[] args) {

		LivroPST livroPST = new LivroPST();

		List<Livro> info = livroPST.getlivrosPorCategoria("Informática");

		for (Livro livro : info) {
			System.out.println(livro);
		}
		
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		List<Livro> enf = livroPST.getlivrosPorCategoria("Enfermagem");

		for (Livro livro : enf) {
			System.out.println(livro);
		}

	}

}
