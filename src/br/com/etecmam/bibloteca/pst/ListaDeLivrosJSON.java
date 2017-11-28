package br.com.etecmam.bibloteca.pst;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import br.com.etecmam.bibloteca.dmp.json.LivroJSON;
import br.com.etecmam.bibloteca.mqttserver.IEnviavel;

public class ListaDeLivrosJSON implements IEnviavel {
	
	@SerializedName("livros")
	List<LivroJSON> livros;

	
	public ListaDeLivrosJSON( List<LivroJSON> livros ) {
		this.livros = livros;	
	}
	
	
	public List<LivroJSON> getLivros() {
		return livros;
	}

	public void setLivros(List<LivroJSON> livros) {
		this.livros = livros;
	}

}
