package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import daodb4o.IDInterface;

@Entity
public class Tecnico implements IDInterface{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String matricula;
	private String especialidade;
	@ManyToMany(cascade= {
			CascadeType.PERSIST, 
//			CascadeType.REMOVE,
			CascadeType.MERGE, 
			CascadeType.REFRESH})
	private List<Ocorrencia> ocorrencias = new ArrayList<>();
	
	
	public Tecnico(String nome, String matricula, String especialidade) {
		super();
		setNome(nome);
		setMatricula(matricula);
		setEspecialidade(especialidade);
	
	}
	
	public Tecnico() {}
	
	public void adicionarOcorrencias(Ocorrencia o) {
		ocorrencias.add(o);
	}
	
	public void removerOcorrencia(Ocorrencia o) {
		ocorrencias.remove(o);
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
		return ocorrencias;
	}
	public void setOcorrencia(List<Ocorrencia> ocorrencia) {
		this.ocorrencias = ocorrencia;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String texto = "Tecnico [id=" + id
				+ ", nome=" + nome
				+ ", matricula=" + matricula
				+ ", especialidade=" + especialidade
				+ ", ocorrencias="; 
		if (ocorrencias.isEmpty())
			texto += " vazio";
		else
			for (Ocorrencia ocorrencia : ocorrencias) 
				texto += " " + ocorrencia.getId() + ", ";
			
		return texto + "]";
	}
}
