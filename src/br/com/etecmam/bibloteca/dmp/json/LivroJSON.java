package br.com.etecmam.bibloteca.dmp.json;

import com.google.gson.annotations.SerializedName;

import br.com.etecmam.bibloteca.dmp.Livro;
import br.com.etecmam.bibloteca.mqttserver.IEnviavel;

public class LivroJSON implements IEnviavel {
	
	@SerializedName("id")
	private long id;

	@SerializedName("tombo")
	private String tombo;
	
	@SerializedName( "titulo")
	private String titulo;
	
	@SerializedName( "editora")
	private String editora;
	
	@SerializedName( "autor")
	private String autor;
	
	@SerializedName( "ano")
	private int ano;
	
	@SerializedName( "status")
	private String status;

	public LivroJSON() {
		
	}
	
	public LivroJSON(Livro livro) {
		
		id = livro.getId();
		tombo  = livro.getTombo();
		titulo = livro.getTitulo();
		editora = livro.getEditora();
		autor = livro.getAutor();
		ano = livro.getAno();
		status = livro.getStatus();	
	}
	
	public LivroJSON(long id, String tombo, String titulo, String editora, String autor, int ano, String status) {
		this.id = id;
		this.tombo = tombo;
		this.titulo = titulo;
		this.editora = editora;
		this.autor = autor;
		this.ano = ano;
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTombo() {
		return tombo;
	}
	public void setTombo(String tombo) {
		this.tombo = tombo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
	
}
