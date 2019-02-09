package daodb4o;


import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Tecnico;

public class DAOTecnico  extends DAO<Tecnico>{

	public Tecnico readByName (String nome){	
		Query q = manager.query();
		q.constrain(Tecnico.class);
		q.descend("nome").constrain(nome);
		List<Tecnico> resultados = q.execute();
		if (resultados.size()>0)
			return (Tecnico) resultados.get(0);
		else
			return null;
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
