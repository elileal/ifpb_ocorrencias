package daojpa;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;

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
	
	
	public  List<Tecnico> consultarTecnicoSemOcorrencias() {
		Query q = manager.query();
		q.constrain(Tecnico.class);
		q.constrain(new Filtro2());
		List<Tecnico> result = q.execute();
		return result;
	}

	public int consultarTotalTecnicos() {
		Query q = manager.query();
		q.constrain(Tecnico.class);
		int total = q.execute().size(); 
		return total;
	}
}

@SuppressWarnings("serial")
class Filtro2 implements Evaluation {
	public void evaluate(Candidate candidate) {
		Tecnico t =(Tecnico) candidate.getObject();
		candidate.include(t.getOcorrencia().size() == 0);
	}
}
