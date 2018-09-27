package modelo;

import java.util.ArrayList;
import java.util.List;

public class Cidade {
	
	private String id;
	private String nome;
	private List<Local> locais = new ArrayList<Local>();
	
	public Cidade(String id, String nome, List<Local> locais) {
		super();
		this.id = id;
		this.nome = nome;
		this.locais = locais;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Local> getLocais() {
		return locais;
	}

	public void setLocais(List<Local> locais) {
		this.locais = locais;
	}
	
	
	
	
}
