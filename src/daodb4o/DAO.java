package daodb4o;

import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Query;

import modelo.Cidade;
import modelo.Local;
import modelo.Ocorrencia;
import modelo.Responsavel;
import modelo.Site;
import modelo.Tecnico;

public abstract class DAO<T> implements DAOInterface<T> {
	protected static ObjectContainer manager;
	
	public static void open() {
		if (manager==null) {
			abrirBancoLocal();
		}
	}
	
	public static void abrirBancoLocal() {
		new File("banco.db4o").delete();  //apagar o banco
		
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		config.common().messageLevel(1);
		
		config.common().objectClass(Cidade.class).cascadeOnDelete(false);
		config.common().objectClass(Cidade.class).cascadeOnUpdate(true);
		config.common().objectClass(Cidade.class).cascadeOnActivate(true);
		config.common().objectClass(Local.class).cascadeOnDelete(false);
		config.common().objectClass(Local.class).cascadeOnUpdate(true);
		config.common().objectClass(Local.class).cascadeOnActivate(true);
		config.common().objectClass(Ocorrencia.class).cascadeOnDelete(false);
		config.common().objectClass(Ocorrencia.class).cascadeOnUpdate(true);
		config.common().objectClass(Ocorrencia.class).cascadeOnActivate(true);
		config.common().objectClass(Responsavel.class).cascadeOnDelete(false);
		config.common().objectClass(Responsavel.class).cascadeOnUpdate(true);
		config.common().objectClass(Responsavel.class).cascadeOnActivate(true);
		config.common().objectClass(Site.class).cascadeOnDelete(false);
		config.common().objectClass(Site.class).cascadeOnUpdate(true);
		config.common().objectClass(Site.class).cascadeOnActivate(true);
		config.common().objectClass(Tecnico.class).cascadeOnDelete(false);
		config.common().objectClass(Tecnico.class).cascadeOnUpdate(true);
		config.common().objectClass(Tecnico.class).cascadeOnActivate(true);
		
		config.common().objectClass(Ocorrencia.class).objectField("data").indexed(true);
		config.common().objectClass(Site.class).objectField("alias").indexed(true);
		
		manager = Db4oEmbedded.openFile(config, "banco.db4o");
		IDControl.registrarManager(manager);
	}
	
	public static void abrirBancoServidor() {
		//implementar depois
	}
	
	public static void close() {
		if(manager!=null) {
			manager.close();
			manager=null;
		}
	}
	
	//----------CRUD-----------------------

		public void create(T obj){
			manager.store( obj );
		}
		
		@SuppressWarnings("unchecked")
		public T read(int id){
			Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
			Query q = manager.query();
			q.constrain(type);
			q.descend("id").constrain(id);
			List<T> resultados = q.execute();
			if (resultados.size()>0)
				return (T) resultados.get(0);
			else
				return null;
		}

		public T update(T obj){
			manager.store(obj);
			return obj;
		}

		public void delete(T obj) {
			manager.delete(obj);
		}

		public void refresh(T obj){
			manager.ext().refresh(obj, Integer.MAX_VALUE);
		}

		@SuppressWarnings("unchecked")
		public List<T> readAll(){
			Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
			Query q = manager.query();
			q.constrain(type);
			return (List<T>) q.execute();
		}
		
		//--------transa��o---------------
		public static void begin(){	}		// tem que ser vazio
		public static void commit(){
			manager.commit();
		}
		public static void rollback(){
			manager.rollback();
		}
}