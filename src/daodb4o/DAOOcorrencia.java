package daodb4o;

import java.util.List;

import com.db4o.query.Query;

import modelo.Ocorrencia;

public class DAOOcorrencia extends DAO<Ocorrencia> {
	
	public Ocorrencia readById (String id){	
		Query q = manager.query();
		q.constrain(Ocorrencia.class);
		q.descend("id").constrain(id);
		List<Ocorrencia> resultados = q.execute();
		if (resultados.size()>0)
			return (Ocorrencia) resultados.get(0);
		else
			return null;
	}
	

	public int consultarTotalOcorrencias() {
		Query q = manager.query();
		q.constrain(Ocorrencia.class);
		int total = q.execute().size(); 
		return total;
	}	
}