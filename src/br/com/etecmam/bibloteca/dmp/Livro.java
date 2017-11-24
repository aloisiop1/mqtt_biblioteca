package br.com.etecmam.bibloteca.dmp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="livros")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )	
	
	@Column(name = "codlivro")
	private long id;
		
	@Column(name = "tombo", unique = true, nullable = false)
	private String tombo;
	
	@Column(name = "status_livro")
	private String status;
	
	private String titulo;
	private String autor;
	
	@Column(name = "anopublicacao")	
	private int ano;
	
	private String genero;
	private String editora;
	
	
	public Livro() {
		
	}
	
	public Livro(long id, String tombo, String titulo, String autor, int ano, String genero, String editora) {
		super();
		this.id = id;
		this.tombo = tombo;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.genero = genero;
		this.editora = editora;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", tombo=" + tombo + ", titulo=" + titulo + ", autor=" + autor + ", ano=" + ano
				+ ", genero=" + genero + ", editora=" + editora + "]";
	}
	
}
