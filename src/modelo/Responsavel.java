package modelo;

public class Responsavel {
	
	private String id;
	private String nome;
	private String telefone;
	private String endereco;
	private Local local;
	public Responsavel(String id, String nome, String telefone, Local local) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.local = local;
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
	public String getId() {
		return id;
	}
	
	
}
