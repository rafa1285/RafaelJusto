package es.salutiscentro.gestion.service;

import es.salutiscentro.gestion.model.Usuario;

public interface UsuarioSvc {

	/**
	 * Identificar un usuario
	 * @param usuario
	 * @return usuario si lo encuentra, null en caso contrario
	 * @throws SvcException
	 */
	public Usuario identificar(Usuario usuario) throws SvcException; 
	
	/**
	 * Comprobar si un usuario dispone de permisos de acceso
	 * @param usuario usuario a comprobar
	 * @param uri recurso a comprobar
	 * @return true si dispone de permiso
	 * @throws SvcException
	 */
	public boolean comprobar(Usuario usuario, String uri) throws SvcException;

	public void guardar(Usuario item) throws SvcException; 
}
