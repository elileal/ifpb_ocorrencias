package daojpa;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Cidade;
import modelo.Local;

public class DAOCidade  extends DAO<Cidade>{

	public Cidade readByNome (String nome){	
		try{
			Query q = manager.createQuery("select p from Cidade p where p.nome= '" + nome +"'");
			return (Cidade) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}
	
	
	public  List<Cidade> consultarCidadeSemLocal() {
		Query q = manager.query();
		q.constrain(Cidade.class);
		q.constrain(new Filtro3());
		List<Cidade> result = q.execute();
		return result; 
	}

	public int consultarTotalCidades() {
		Query q = manager.query();
		q.constrain(Cidade.class);
		int total = q.execute().size(); 
		return total;
	}
	
}

@SuppressWarnings("serial")
class Filtro3 implements Evaluation{
	public void evaluate(Candidate candidate) {
		Cidade c = (Cidade) candidate.getObject();
		candidate.include(c.getLocais().size() == 0);
	}
}


