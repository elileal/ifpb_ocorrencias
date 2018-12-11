package daojpa;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Cidade;

public class DAOCidade  extends DAO<Cidade>{

	public Cidade readByNome (String nome){	
		try{
			Query q = manager.createQuery("select p from Cidade p where p.nome= '" + nome +"'");
			return (Cidade) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public  List<Cidade> consultarCidadeSemLocal() {
		Query q = manager.createQuery(
				"select c from Cidade c where c.local is null");
		return q.getResultList();
	}

	public Long consultarTotalCidades() {
		Query q = manager.createQuery(
				"select count(c) from Cidade c");
		return (Long) q.getSingleResult();
	}
	
}



