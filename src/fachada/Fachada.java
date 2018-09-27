package fachada;

import java.util.List;

import dao.DAO;
import dao.DAOCidade;
import modelo.Cidade;
import modelo.Local;

public class Fachada {
	private static DAOCidade daocidade = new DAOCidade();
	
	public static void inicializar() {
		DAO.open();
	}
	
	public static void finalizar() {
		DAO.close();
	}
	
	public static Cidade cadastrarCidade(String id, String nome, List<Local> local) throws Exception{
		DAO.begin();
		Cidade c = daocidade.readByNome(nome);
		if(c!=null)
			throw new Exception("Cidade já cadastrada:"+nome);
		c = new Cidade(id, nome, local);
		daocidade.create(c);
		DAO.commit();
		return c;
	}
}
