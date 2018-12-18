package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Cidade;
import modelo.Local;

public class DAOLocal extends DAO<Local>{
	
	public Local readByNome (String nome){	
		try{
			Query q = manager.createQuery("select l from Local l where l.medidor='" + nome +"'");
			return (Local) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}
	
	public Local readById (Integer Id){	
		Query q = manager.query();
		q.constrain(Local.class);
		q.descend("Id").constrain(Id);
		List<Local> resultados = q.execute();
		if (resultados.size()>0)
			return (Local) resultados.get(0);
		else
			return null;
	}
	
	public List<Local> consultarLocaisDaCidade(Cidade c){
		Query q = manager.query();
		q.constrain(Local.class);
		q.descend("cidade").descend("nome").constrain(c.getNome());
		List<Local> result = q.execute(); 
		return result;	
	}

	
	
//	public List<Local> consultarLocalsDoLocal(int id){
//		Query q = manager.query();
//		q.constrain(Local.class);
//		q.descend("prateleira").descend("id").constrain(id);
//		List<Local> result = q.execute(); 
//		return result;	
//	}
//
//	public List<Local> consultarVizinhos(String nome){
//		Query q = manager.query();
//		q.constrain(Local.class);
//		q.descend("prateleira").descend("Locals").descend("nome").constrain(nome);
//		q.descend("nome").constrain(nome).not(); // excluir o proprio nome do resultado
//		List<Local> result = q.execute(); 
//		return result;	
//	}
}
