package br.com.etecmam.bibloteca.dmp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="emprestimodevolucao")
public class EmprestimoDevolucao {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	
	@Column(name = "dataemprestimo")
	private String dataEmprestimo;
	
	@Column(name = "dataentrega")
	private String dataEntrega;

	@Column(name = "datadevolucao")
	private String dataDevolucao;

	@JoinColumn(name = "codlivro")
	private Livro livro;
	
	@JoinColumn(name = "codaluno")
	private Aluno aluno;

	public EmprestimoDevolucao() {
	}
	
	public EmprestimoDevolucao(String dataEmprestimo, String dataEntrega, String dataDevolucao, Livro livro,
			Aluno aluno) {
		super();
		this.dataEmprestimo = dataEmprestimo;
		this.dataEntrega = dataEntrega;
		this.dataDevolucao = dataDevolucao;
		this.livro = livro;
		this.aluno = aluno;
	}




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "EmprestimoDevolucao [id=" + id + ", dataEmprestimo=" + dataEmprestimo + ", dataEntrega=" + dataEntrega
				+ ", dataDevolucao=" + dataDevolucao + ", livro=" + livro + ", aluno=" + aluno + "]";
	}
	
	
	
}
