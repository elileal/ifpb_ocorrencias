package daojpa;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;

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
	
	public List<Site> consultarSitesSemOcorrencias(){
		Query q = manager.query();
		q.constrain(Site.class);
		q.constrain(new Filtro());
		List<Site> result = q.execute();
		return result;
	}
	
}

@SuppressWarnings("serial")
class Filtro implements Evaluation {
	public void evaluate(Candidate candidate) {
		Site s = (Site) candidate.getObject();
		candidate.include(s.getOcorrencias().size() == 0);
	}
}

