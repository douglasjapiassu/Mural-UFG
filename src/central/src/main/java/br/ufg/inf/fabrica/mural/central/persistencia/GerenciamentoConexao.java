package br.ufg.inf.fabrica.mural.central.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufg.inf.fabrica.mural.central.dominio.Posicao;
import br.ufg.inf.fabrica.mural.central.suporte.GenericEntity;

public class GerenciamentoConexao {

	private static final String PERSISTENCE_UNIT_NAME = "br.ufg.inf.fabrica.muralufg_central_jar_1.0-SNAPSHOTPU";
	private static EntityManagerFactory factory;
	private static EntityManager em;
	
	public static EntityManager getEntityManager() {
		return em;
	}

	public static void startConnection() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
        em.getTransaction().begin();
    }
 
    public static void closeConnection() {
        em.getTransaction().commit();
        factory.close();
    }
    
    public static void persist(Object object){
    	startConnection();
    	em.persist(object);
    	closeConnection();
    }
    
    public static void merge(Object object){
    	startConnection();
    	em.merge(object);
    	em.flush();
    	closeConnection();
    }
    
    public static void remove(Object object){
    	startConnection();
    	em.remove(object);
    	em.flush();
    	closeConnection();
    }
	
}
