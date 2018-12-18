package es.salutiscentro.gestion.service;

import es.salutiscentro.gestion.model.Especialidad;

public interface EspecialidadSvc {
	
	/**
	 * Listar todos los elementos
	 * @return lista completa de elementos
	 * @throws SvcException
	 */
	public Iterable<Especialidad> listar() throws SvcException;
	

}
