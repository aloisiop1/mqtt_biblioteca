package br.com.etecmam.bibloteca.dmp.json;

import com.google.gson.annotations.SerializedName;

import br.com.etecmam.bibloteca.dmp.Aluno;
import br.com.etecmam.bibloteca.mqttserver.IEnviavel;

public class AlunoJSON implements IEnviavel {	
	
	@SerializedName("id")
	private long id;
	
	@SerializedName("rm")
	private int rm; 
	
	@SerializedName("nome")
	private String nome;
	
	@SerializedName("data-validade")
	private String dataValidade;

	
	
	public AlunoJSON() {
		
	}
	
	public AlunoJSON(Aluno aluno) {
		id = aluno.getId();
		rm = aluno.getRm();
		nome = aluno.getNome();
		dataValidade = aluno.getDataValidade();		
	}
	
	public AlunoJSON(int id, int rm, String nome, String dataValidade) {
		this.id = id;
		this.rm = rm;
		this.nome = nome;
		this.dataValidade = dataValidade;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	
	
	

}
