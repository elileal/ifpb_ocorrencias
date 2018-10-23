package modelo;

import java.util.ArrayList;
import java.util.List;

import dao.IDInterface;

public class Cidade implements IDInterface{
	
	private Integer id;
	private String nome;
	private List<Local> locais = new ArrayList<Local>();
	
	public Cidade(String nome) {
		super();
		setNome(nome);
	}
	
	public void adcionarLocal(Local l) {
		locais.add(l);
		l.setCidade(this);
	}
	
	public void removerLocal(Local l) {
		locais.remove(l);
		l.setCidade(null);
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

	@Override
	public String toString() {
		String texto = "Cidade [id=" + id
				+ ", nome=" + nome
				+ ", locais=";
				if(locais.isEmpty())
					texto += " vazio";
				else
					for (Local local : locais) 
						texto += " " + local.getId();
				return texto + "]";
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
}
