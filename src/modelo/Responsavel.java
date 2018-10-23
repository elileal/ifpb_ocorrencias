package modelo;

import dao.IDInterface;

public class Responsavel implements IDInterface{
	
	private Integer id;
	private String nome;
	private String telefone;
	private String endereco;
	private Local local;
	
	public Responsavel(String nome, String telefone) {
		super();
		setNome(nome);
		setTelefone(telefone);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		String texto = "Responsavel [id=" + id 
				+ ", nome=" + nome 
				+ ", telefone=" + telefone 
				+ ", endereco=" + endereco
				+ ", local=";
		if(local != null)
			texto += local.getMedidor();
		else
			texto += " vazio";
		
		return texto;
	}
	
	
	
	
}
