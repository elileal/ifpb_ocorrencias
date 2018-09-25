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

}
