package fachada;
import java.util.ArrayList;
import java.util.List;

//import dao.DAO;
//import dao.DAOCidade;
//import dao.DAOLocal;
//import dao.DAOOcorrencia;
//import dao.DAOResponsavel;
//import dao.DAOSite;
//import dao.DAOTecnico;

import daojpa.*;

import modelo.Cidade;
import modelo.Local;
import modelo.Ocorrencia;
import modelo.Responsavel;
import modelo.Site;
import modelo.Tecnico;

public class Fachada {
	private static DAOCidade daocidade = new DAOCidade();
	private static DAOLocal daolocal = new DAOLocal();
	private static DAOOcorrencia daoocorrencia = new DAOOcorrencia();
	private static DAOResponsavel daoresponsavel = new DAOResponsavel();
	private static DAOSite daosite = new DAOSite();
	private static DAOTecnico daotecnico = new DAOTecnico();

	public static void inicializar(){
		DAO.open();
	}

	public static void finalizar(){
		DAO.close();
	}
	
	//---CIDADES

	public static Cidade cadastrarCidade(String nome) 
			throws  Exception{
		DAO.begin();			
		Cidade c = daocidade.readByNome(nome);
		if(c != null) {
			DAO.rollback();
			throw new Exception("cidade ja cadastrada:" + nome);
		}

		c = new Cidade(nome);
		daocidade.create(c);		
		DAO.commit();
		return c;
	}
	
	
	public static Cidade apagarCidade(String nome) throws  Exception{
		DAO.begin();			
		Cidade c = daocidade.readByNome(nome);
		if(c == null) {
			DAO.rollback();
			throw new Exception("Cidade nao cadastrada:" + nome);
		}
		
		List<Local> locais = c.getLocais();
		
		if(locais != null){
			
			for (Local l : locais) {
				l.setCidade(null);
				daolocal.update(l);				
			}
		}
		daocidade.delete(c);
		DAO.commit();
		return c;
	}
	
	public static String listarCidades() {
		List<Cidade> aux = daocidade.readAll();
		String texto = "\nListagem de cidades: ";
		if (aux.isEmpty())
			texto += "Não tem cidade cadastrada";
		else {	
			for(Cidade c: aux) {
				texto += "\n" + c.getNome(); 
			}
		}
		return texto;		
	}
	public static Long totalCidades() {
		return daocidade.consultarTotalCidades();
	}
	
	public static List<Cidade> cidadeSemLocal(){
		return daocidade.consultarCidadeSemLocal();
	}
	
	
	//---LOCAIS
	
	public static Local cadastrarLocal(String cidade, String medidor) throws  Exception{
		DAO.begin();
		Cidade c = daocidade.readByNome(cidade);
		if(c == null) {
			DAO.rollback();
			throw new Exception("cidade Não cadastrada:" + cidade);
		}
		
		Local l = new Local(c, medidor);
		c.adcionarLocal(l);
		daolocal.create(l);		
		DAO.commit();
		return l;
	}
	
	public static Local apagarLocal(String medidor) throws  Exception{
		DAO.begin();			
		Local l = daolocal.readByNome(medidor);
		if(l == null) {
			DAO.rollback();
			throw new Exception("Local com o medidor "+medidor+" nao cadastrado");
		}
		
		List<Responsavel> responsaveis = new ArrayList<Responsavel>();
		responsaveis = l.getResponsaveis();
		if(responsaveis != null){
			for (Responsavel r : responsaveis) {
				r.setLocal(null);
				daoresponsavel.update(r);				
			}
		}
		
		if(l.getSite() != null){
			Site s = l.getSite();
			s.removerLocal(l);
			daosite.update(s);			
		}
		
		if(l.getCidade() != null) {
			Cidade c = l.getCidade();
			c.removerLocal(l);
			daocidade.update(c);
		}
		
		daolocal.delete(l);
		DAO.commit();
		return l;
	}

	public static String listarLocais() {
		List<Local> aux = daolocal.readAll();
		String texto = "\nListagem de locais: ";
		if (aux.isEmpty())
			texto += "Não tem local cadastrado";
		else {	
			for(Local l: aux) {
				texto += "\n" + l.getMedidor(); 
			}
		}
		return texto;		
	}
	
	public static List<Local> locaisDaCidade(String nome){
		Cidade c = daocidade.readByNome(nome);
		return daolocal.consultarLocaisDaCidade(c);
	}
	//---SITES
	
	public static Site cadastrarSite(String alias, String lat, String log, Float altura, String local) throws  Exception{
		DAO.begin();
		Site s = daosite.readByAlias(alias);
		if(s != null) {
			DAO.rollback();
			throw new Exception("site ja cadastrado:" + alias);
		}
		Local l = daolocal.readByNome(local);
		
		if(l == null) {
			DAO.rollback();
			throw new Exception("local não cadastrado:" + local);
		}
		
		s = new Site(alias, lat, log, altura);
		s.adicionarLocal(l);
		daosite.create(s);		
		DAO.commit();
		return s;
	}
	
	public static Site apagarSite(String alias) throws  Exception{
		DAO.begin();			
		Site s = daosite.readByAlias(alias);
		if(s == null) {
			DAO.rollback();
			throw new Exception("Site nao cadastrado:"+alias);
		}
		
		
		if(s.getOcorrencias() != null){
			for (Ocorrencia o : s.getOcorrencias()) {
				o.setSite(null);
				apagarOcorrencia(o.getId());
			}
		}
		
		if(s.getLocal() != null)
			s.removerLocal(s.getLocal());
		
		daosite.delete(s);
		DAO.commit();
		return s;
	}

	public static String listarSite() {
		List<Site> aux = daosite.readAll();
		String texto = "\nListagem de Sites: ";
		if (aux.isEmpty())
			texto += "Não tem Site cadastrado";
		else {	
			for(Site s: aux) {
				texto += "\n" + s.getAlias(); 
			}
		}
		return texto;		
	}
	
	public static Long totalSites() {
		return daocidade.consultarTotalCidades();
	}
	
	public static List<Site> siteSemOcorrencia(){
		List<Site> s = daosite.consultarSitesSemOcorrencias();
		return s;
	}
	
	public static double mediaDeOcorrencias (String nome) {
		double countOcorrencias = totalOcorrencias();
		Site s = daosite.readByAlias(nome);
		int qtdPSite = s.getOcorrencias().size();
		return (qtdPSite/countOcorrencias)*100;
	}
	
	//---OCORRENCIAS
	
	public static Ocorrencia cadastrarOcorrencia(String descricao, String alias, String tecnico) throws  Exception{
		DAO.begin();
		Site s = daosite.readByAlias(alias);
		if(s == null) {
			DAO.rollback();
			throw new Exception("site Não cadastrado:" + alias);
		}
		Tecnico t = daotecnico.readByName(tecnico);
		if(t == null) {
			DAO.rollback();
			throw new Exception("tecnico Não cadastrado:" +tecnico);
		}
		
		Ocorrencia o = new Ocorrencia(descricao, s);
		o.adicionarTecnicos(t);
		t.adicionarOcorrencias(o);
		s.adicionarOcorrencia(o);
		daoocorrencia.create(o);		
		DAO.commit();
		return o;
	}
	
	public static Ocorrencia apagarOcorrencia(int id) throws  Exception{
		DAO.begin();			
		Ocorrencia o = daoocorrencia.read(id);
		if(o == null) {
			DAO.rollback();
			throw new Exception("Ocorrencia nao cadastrado:"+id);
		}
		
		if(o.getTecnicos() != null){
			for (Tecnico t : o.getTecnicos()) {
				t.removerOcorrencia(o);
				daotecnico.update(t);				
			}
		}
		
		if(o.getSite() != null){
			Site s = o.getSite();
			s.removerOcorrencia(o);
			daosite.update(s);			
		}
		
		daoocorrencia.delete(o);
		DAO.commit();
		return o;
	}

	public static String listarOcorrencia() {
		List<Ocorrencia> aux = daoocorrencia.readAll();
		String texto = "\nListagem de Ocorrencias: ";
		if (aux.isEmpty())
			texto += "Não tem Ocorrencia cadastrado";
		else {	
			for(Ocorrencia o: aux) {
				texto += "\n" + o.getDescricao(); 
			}
		}
		return texto;		
	}
	
	public static Long totalOcorrencias() {
		return daoocorrencia.consultarTotalOcorrencias();
	}
	
	//---RESPONSÃ�VEIS
	
	public static Responsavel cadastrarResponsavel(String nome, String telefone, String medidor) throws  Exception{
		DAO.begin();
		Responsavel r = daoresponsavel.readByName(nome);
		if(r != null) {
			throw new Exception("Responsavel ja cadastrado:" + nome);
		}
		
		Local l = daolocal.readByNome(medidor);
		if(l == null)
			throw new Exception("Local Não cadastrado");
		
		r = new Responsavel(nome, telefone);
		r.setLocal(l);
		l.adcionarResponsavel(r);
		daoresponsavel.update(r);
		daoresponsavel.create(r);		
		DAO.commit();
		return r;
	}
	
	public static Responsavel apagarResponsavel(String nome) throws  Exception{
		DAO.begin();			
		Responsavel r = daoresponsavel.readByName(nome);
		if(r == null)throw new Exception("Responsavel nao cadastrado:"+nome);
		
		Local l = r.getLocal(); 
		if(l != null) {
			l.removerResponsavel(r);
			daolocal.update(l);		
		}
		
		daoresponsavel.delete(r);
		DAO.commit();
		return r;
	}

	public static String listarResponsavel() {
		List<Responsavel> aux = daoresponsavel.readAll();
		String texto = "\nListagem de Responsaveis: ";
		if (aux.isEmpty())
			texto += "Não tem Responsavel cadastrado";
		else {	
			for(Responsavel r: aux) {
				texto += "\n" + r.getNome(); 
			}
		}
		return texto;		
	}
	
	//---TÃ‰CNICO
	
		public static Tecnico cadastrarTecnico(String nome, String matricula, String especialidade) throws  Exception{
			DAO.begin();
			Tecnico t = daotecnico.readByName(nome);
			if(t != null) {
				throw new Exception("Tecnico ja cadastrado:" + nome);
			}
			
			t = new Tecnico(nome, matricula, especialidade);
			daotecnico.create(t);		
			DAO.commit();
			return t;
		}
		
		public static Tecnico apagarTecnico(String nome) throws  Exception{
			DAO.begin();			
			Tecnico t = daotecnico.readByName(nome);
			if(t == null)throw new Exception("Tecnico nao cadastrado:"+nome);
			
			if(t.getOcorrencia() != null) {
				for (Ocorrencia o : t.getOcorrencia()) {
					o.removerTecnicos(t);
					daoocorrencia.update(o);
				}
			}
			
			daotecnico.delete(t);
			DAO.commit();
			return t;
		}

		public static String listarTecnico() {
			List<Tecnico> aux = daotecnico.readAll();
			String texto = "\nListagem de Tecnicos: ";
			if (aux.isEmpty())
				texto += "Não tem Tecnico cadastrado";
			else {	
				for(Tecnico t: aux) {
					texto += "\n" + t.getNome(); 
				}
			}
			return texto;		
		}
		
		public static Long totalTecnicos() {
			return daotecnico.consultarTotalTecnicos();
		}
		public static List<Tecnico> tecnicosSemOcorrencias(){
			return daotecnico.consultarTecnicoSemOcorrencias();
		}
}
 