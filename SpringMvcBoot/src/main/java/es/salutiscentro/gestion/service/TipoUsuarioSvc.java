package es.salutiscentro.gestion.service;

import es.salutiscentro.gestion.model.TipoUsuario;

public interface TipoUsuarioSvc {
	
	/**
	 * Listar todos los elementos
	 * @return lista completa de elementos
	 * @throws SvcException
	 */
	public Iterable<TipoUsuario> listar() throws SvcException;

}
