package dao;


import java.util.List;

import com.db4o.ObjectSet;
import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Site;

public class DAOSite  extends DAO<Site>{

	public Site readByAlias (String alias){	
		Query q = manager.query();
		q.constrain(Site.class);
		q.descend("alias").constrain(alias);
		List<Site> resultados = q.execute();
		if (resultados.size()>0)
			return (Site) resultados.get(0);
		else
			return null;
	}
	
	public int consultarTotalSites() {
		Query q = manager.query();
		q.constrain(Site.class);
		int total = q.execute().size(); 
		return total;
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

