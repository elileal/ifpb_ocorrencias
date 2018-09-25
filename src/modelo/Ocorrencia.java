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
}
