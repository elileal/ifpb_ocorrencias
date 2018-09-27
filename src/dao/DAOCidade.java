package dao;

import com.db4o.query.Query;

import modelo.Cidade;

public class DAOCidade extends DAO<Cidade> {

	public Cidade readByNome (String nome) {
		Query q = manager.query();
		q.constrain(Cidade.class);
		q.descend("nome").constrain(nome);
		Cidade c = (Cidade) q.execute();
		return c;
	}
	

}
