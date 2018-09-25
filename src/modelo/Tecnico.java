package modelo;

import java.util.ArrayList;
import java.util.List;

public class Tecnico {
	private Integer id;
	private String nome;
	private String matricula;
	private String especialidade;
	private List<Ocorrencia> Ocorrencia = new ArrayList<Ocorrencia>();
	
	
	public Tecnico(String nome, String matricula, String especialidade, List<modelo.Ocorrencia> ocorrencia) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.especialidade = especialidade;
		Ocorrencia = ocorrencia;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public List<Ocorrencia> getOcorrencia() {
		return Ocorrencia;
	}
	public void setOcorrencia(List<Ocorrencia> ocorrencia) {
		Ocorrencia = ocorrencia;
	}
	
	
}
