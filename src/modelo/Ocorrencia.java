package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

public class Ocorrencia {
	private Integer id;
	private String descricao;
	private Data data;
	private String solucao;
	private Site site;
	private List<Tecnico> tecnicos = new ArrayList<Tecnico>();
	
	public Ocorrencia(Integer id, String descricao, Data data, Site site, List<Tecnico> tecnicos) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.site = site;
		this.tecnicos = tecnicos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}

	public List<Tecnico> getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(List<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}

	public String getDescricao() {
		return descricao;
	}

	public Data getData() {
		return data;
	}

	public Site getSite() {
		return site;
	}
	
	
}
