package es.salutiscentro.gestion.service;

import es.salutiscentro.gestion.model.Terapeuta;

public interface TerapeutaSvc {
	
	/**
	 * Listar todos los elementos
	 * @return lista completa de elementos
	 * @throws SvcException
	 */
	public Iterable<Terapeuta> listar() throws SvcException;

	public Terapeuta buscar(int id) throws SvcException;

	public void guardar(Terapeuta terapeuta) throws SvcException;

	public void modificar(Terapeuta terapeuta) throws SvcException;

	public void eliminar(Terapeuta tera) throws SvcException;

}
