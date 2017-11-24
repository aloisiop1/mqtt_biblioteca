package br.com.etecmam.bibloteca.dmp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "codaluno")
	private long id;
	private int rm;	
	private String nome;
	private String curso;
	
	private String modulo;
	private String telefone;
	
	@Column(name = "datacadastro")
	private String dataCadastro;
	
	@Column(name = "datavalidade")
	private String dataValidade;
		
	private String email;
	
	
	
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
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Aluno() {
	}
	public Aluno(long id, int rm, String nome, String curso, String modulo, String telefone, String dataCadastro,
			String dataValidade, String email) {
		this.id = id;
		this.rm = rm;
		this.nome = nome;
		this.curso = curso;
		this.modulo = modulo;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
		this.dataValidade = dataValidade;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", rm=" + rm + ", nome=" + nome + ", curso=" + curso + ", modulo=" + modulo
				+ ", telefone=" + telefone + ", dataCadastro=" + dataCadastro + ", dataValidade=" + dataValidade
				+ ", email=" + email + "]";
	}
	
	
	

}
