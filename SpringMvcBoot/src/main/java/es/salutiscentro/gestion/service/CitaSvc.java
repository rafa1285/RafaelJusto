package es.salutiscentro.gestion.service;


import es.salutiscentro.gestion.model.Cita;

public interface CitaSvc {
	
	/**
	 * Listar todos los elementos
	 * @return lista completa de elementos
	 * @throws SvcException
	 */
	public Iterable<Cita> listar() throws SvcException;
	
	public void guardar(Cita cita) throws SvcException;

	public void modificar(Cita cita) throws SvcException;

	public Cita buscar(int id) throws SvcException;

}
