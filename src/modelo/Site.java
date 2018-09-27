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
	
	public Site(String alias, String lat, String log, Integer id, Float altura, Local local) {
		super();
		this.alias = alias;
		this.lat = lat;
		this.log = log;
		this.id = id;
		this.altura = altura;
		this.local = local;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getIp_nvr() {
		return ip_nvr;
	}

	public void setIp_nvr(String ip_nvr) {
		this.ip_nvr = ip_nvr;
	}

	public String getIp_cameras() {
		return ip_cameras;
	}

	public void setIp_cameras(String ip_cameras) {
		this.ip_cameras = ip_cameras;
	}

	public String getIp_central() {
		return ip_central;
	}

	public void setIp_central(String ip_central) {
		this.ip_central = ip_central;
	}

	public String getIp_swicth() {
		return ip_swicth;
	}

	public void setIp_swicth(String ip_swicth) {
		this.ip_swicth = ip_swicth;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public Integer getCanais() {
		return canais;
	}

	public void setCanais(Integer canais) {
		this.canais = canais;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public Integer getId() {
		return id;
	}
	
	
	
}
