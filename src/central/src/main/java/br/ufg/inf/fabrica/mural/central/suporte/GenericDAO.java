package br.ufg.inf.fabrica.mural.central.suporte;



public interface GenericDAO<T extends GenericEntity> {
	
	public boolean incluir(T entity);
	
	public boolean alterar(T entity);
	
	public boolean remover(T entity);
	
	public T buscar(T entity);

}
