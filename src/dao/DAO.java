package dao;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

import modelo.Ocorrencia;

public abstract class DAO<T> implements DAOInterface<T> {
	protected static ObjectContainer manager;
	
	public static void open() {
		if (manager==null) {
			abrirBancoLocal();
		}
	}
	
	public static void abrirBancoLocal() {
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		config.common().messageLevel(0);
		config.common().objectClass(Ocorrencia.class).cascadeOnDelete(false);
		config.common().objectClass(Ocorrencia.class).cascadeOnUpdate(true);
		config.common().objectClass(Ocorrencia.class).cascadeOnActivate(true);
	}
	
	public static void abrirBancoServidor() {
		
	}

}
