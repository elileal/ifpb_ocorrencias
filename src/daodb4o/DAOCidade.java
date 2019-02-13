package daodb4o;


import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Cidade;

public class DAOCidade  extends DAO<Cidade>{

	public Cidade readByNome (String nome){	
		Query q = manager.query();
		q.constrain(Cidade.class);
		q.descend("nome").constrain(nome);
		List<Cidade> resultados = q.execute();
		if (resultados.size()>0)
			return (Cidade) resultados.get(0);
		else
			return null;
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


