package daojpa;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Local;
import modelo.Ocorrencia;

public class DAOOcorrencia extends DAO<Ocorrencia> {
	
	public Ocorrencia readById (String id){
		try{
			Query q = manager.createQuery("select o from Ocorrencia o where o.id='" + id +"'");
			return (Ocorrencia) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}
	
	public Local readByNome (String nome){	
		try{
			Query q = manager.createQuery("select l from Local l where l.medidor='" + nome +"'");
			return (Local) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}
	

	public Long consultarTotalOcorrencias() {
		Query q = manager.createQuery(
				"select count(o) from Ocorrencia o");
		return (Long) q.getSingleResult();
	}
	
}