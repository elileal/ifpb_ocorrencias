package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import daodb4o.IDInterface;

@Entity
public class Site implements IDInterface{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String alias;
	private String ip_nvr;
	private String ip_cameras;
	private String ip_central;
	private String ip_swicth;
	private String lat;
	private String log;
	private Float altura;
	private Integer canais;
	@OneToOne
	private Local local;
	@OneToMany(mappedBy="site")
	private List<Ocorrencia> ocorrencias = new ArrayList<>();
	
	public Site(String alias, String lat, String log, Float altura) {
		super();
		setAlias(alias);
		setLat(lat);
		setLog(log);
		setAltura(altura);
	}
	public Site() {}
	
	public void adicionarLocal(Local l) {
		setLocal(l);
		l.setSite(this);
	}
	
	public void removerLocal(Local l) {
		setLocal(null);
		l.setSite(null);
	}
	
	public void adicionarOcorrencia(Ocorrencia o) {
		ocorrencias.add(o);
		o.setSite(this);
	}
	
	public void removerOcorrencia(Ocorrencia o) {
		ocorrencias.remove(o);
		o.setSite(null);
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

	@Override
	public String toString() {
		String texto =  "Site [id=" + id 
				+ ", alias=" + alias 
				+ ", ip_nvr=" + ip_nvr 
				+ ", ip_cameras=" + ip_cameras
				+ ", ip_central=" + ip_central 
				+ ", ip_swicth=" + ip_swicth 
				+ ", lat=" + lat 
				+ ", log=" + log
				+ ", altura=" + altura 
				+ ", canais=" + canais 
				+ ", local=";
		if(local != null)
			texto += local.getMedidor();
		else
			texto = " vazio";
		
		texto += ", ocorrencias=";
				if (ocorrencias.isEmpty()) {
					texto += " vazio";
				}
				else
					for (Ocorrencia ocorrencia : ocorrencias) 
						texto += " " + ocorrencia.getId();
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
