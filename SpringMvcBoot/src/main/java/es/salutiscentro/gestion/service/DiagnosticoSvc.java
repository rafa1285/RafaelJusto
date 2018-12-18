package es.salutiscentro.gestion.service;

import es.salutiscentro.gestion.model.Diagnostico;

public interface DiagnosticoSvc {
	
	/**
	 * Listar todos los elementos
	 * @return lista completa de elementos
	 * @throws SvcException
	 */
	public Iterable<Diagnostico> listar() throws SvcException;

	public Diagnostico buscar(int id) throws SvcException;

}
