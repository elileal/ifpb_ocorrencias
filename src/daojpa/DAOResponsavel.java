package daojpa;

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
	
		
	public Responsavel consultarResponsavelSemLocal(){
		try {
			Query q = manager.createQuery("select r from Responsavel r where r.local=null");
			return (Responsavel) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}

	public int consultarTotalResponsavels() {
		try {
			Query q = manager.createQuery("select count(r) from Responsavel r");
			return (int) q.getSingleResult();
		} catch (NoResultException e) {
			return 0;
		}
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
