package daojpa;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Site;

public class DAOSite  extends DAO<Site>{

	public Site readByAlias (String nome){	
		try{
			Query q = manager.createQuery("select s from Site s where s.alias= '" + nome +"'");
			return (Site) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}
	

	public Long consultarTotalSites() {
		Query q = manager.createQuery(
				"select count(s) from Site s");
		return (Long) q.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Site> consultarSitesSemOcorrencias(){
		Query q = manager.createQuery(
				"select s from Site s where s.ocorrencias IS EMPTY");
        return (List<Site>) q.getResultList();
	}
	
}

