package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import daodb4o.IDInterface;

@Entity
public class Local implements IDInterface{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Cidade cidade;
	private String medidor;
	@OneToMany(mappedBy="local", cascade=CascadeType.ALL)
	private List<Responsavel> responsaveis = new ArrayList<>();
	@OneToOne
	private Site site;
	
	
	public Local(Cidade cidade, String medidor) {
		super();
		setCidade(cidade);
		setMedidor(medidor);
	}
	
	public Local() {}
	
	public void adcionarResponsavel(Responsavel r) {
		responsaveis.add(r);
		r.setLocal(this);
	}
	
	public void removerResponsavel(Responsavel r) {
		responsaveis.remove(r);
		r.setLocal(null);
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getMedidor() {
		return medidor;
	}

	public void setMedidor(String medidor) {
		this.medidor = medidor;
	}

	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}

//	public String getContrato() {
//		return contrato;
//	}
//
//	public void setContrato(String contrato) {
//		this.contrato = contrato;
//	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	@Override
	public String toString() {
		String texto = "Local [id=" + id
				+ ", cidade=";
		if(cidade != null)
			texto += cidade.getNome();
		else
			texto += " vazio";
				
		texto += ", medidor=" + medidor
				+ ", site=";
		if(site != null)
			texto += site.getAlias();
		else
			texto += "vazio";
			
		texto += ", responsaveis=";
		if (responsaveis.isEmpty())
			texto += " vazio";
		else
			for (Responsavel responsavel : responsaveis) 
				texto += " " + responsavel.getNome(); 
		
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
