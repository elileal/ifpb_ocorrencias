package modelo;

import java.util.ArrayList;
import java.util.List;

public class Site {
	private String alias;
	private String ip_nvr;
	private String ip_cameras;
	private String ip_central;
	private String ip_swicth;
	private String lat;
	private String log;
	private Integer id;
	private Float altura;
	private Integer canais;
	private Local local;
	private List<Ocorrencia> ocorrencias = new ArrayList<Ocorrencia>();
	
}
