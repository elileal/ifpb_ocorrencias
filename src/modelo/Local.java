package modelo;

import java.util.ArrayList;
import java.util.List;

public class Local {
	private Integer id;
	private Cidade cidade;
	private String medidor;
	private List<Responsavel> responsaveis = new ArrayList<Responsavel>();
	//VER SE É POSSÍVEL INCLUIR DADOS DO CONTRATO
	private String contrato;
	private List<Site> sites = new ArrayList<Site>();
	
	public Local(Integer id, Cidade cidade, String medidor, List<Responsavel> responsaveis,
			List<Site> sites) {
		super();
		this.id = id;
		this.cidade = cidade;
		this.medidor = medidor;
		this.responsaveis = responsaveis;
		this.sites = sites;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
	
	

}
