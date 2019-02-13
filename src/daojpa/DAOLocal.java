package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Cidade;
import modelo.Local;

public class DAOLocal extends DAO<Local>{
	
	public Local readByNome (String nome){	
		try{
			Query q = manager.createQuery("select l from Local l where l.medidor='" + nome +"'");
			return (Local) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public  List<Local> consultarLocaisDaCidade(Cidade c) {
//		System.out.println(c.getNome());
		Query q = manager.createQuery(
				"select l.medidor from Cidade c JOIN c.locais l where l.cidade.nome='"+c.getNome()+"'");
		return (List<Local>) q.getResultList();
	}
	
	
}
