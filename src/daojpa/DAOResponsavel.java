package daojpa;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Responsavel;

public class DAOResponsavel  extends DAO<Responsavel>{

	public Responsavel readByName (String nome){	
		try{
			Query q = manager.createQuery("select r from Responsavel r where r.nome='" + nome +"'");
			return (Responsavel) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}
	
	
	public  List<Responsavel> consultarResponsavelSemLocal() {
		Query q = manager.query();
		q.constrain(Responsavel.class);
		q.descend("locais").constrain(null);
		return q.execute(); 
	}

	public int consultarTotalResponsavels() {
		Query q = manager.query();
		q.constrain(Responsavel.class);
		int total = q.execute().size(); 
		return total;
	}
	
	

//	public List<Responsavel> consultarResponsavelsDoLocal(int id){
//		Query q = manager.query();
//		q.constrain(Responsavel.class);
//		q.descend("prateleira").descend("id").constrain(id);
//		List<Responsavel> result = q.execute(); 
//		return result;	
//	}
//
//	public List<Responsavel> consultarVizinhos(String nome){
//		Query q = manager.query();
//		q.constrain(Responsavel.class);
//		q.descend("prateleira").descend("Responsavels").descend("nome").constrain(nome);
//		q.descend("nome").constrain(nome).not(); // excluir o proprio nome do resultado
//		List<Responsavel> result = q.execute(); 
//		return result;	
//	}

}
