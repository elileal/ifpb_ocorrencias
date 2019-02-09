package daojpa;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Site;
import modelo.Tecnico;

public class DAOTecnico  extends DAO<Tecnico>{

	public Tecnico readByName (String nome){	
		try{
			Query q = manager.createQuery("select t from Tecnico t where t.nome='" + nome +"'");
			return (Tecnico) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Tecnico> consultarTecnicoSemOcorrencias(){
		Query q = manager.createQuery(
                "select t from Tecnico t where t.ocorrencias IS EMPTY");
        return (List<Tecnico>) q.getResultList();
	}
	

	public Long consultarTotalTecnicos() {
		Query q = manager.createQuery(
				"select count(t) from Tecnico t");
		return (Long) q.getSingleResult();
	}
}