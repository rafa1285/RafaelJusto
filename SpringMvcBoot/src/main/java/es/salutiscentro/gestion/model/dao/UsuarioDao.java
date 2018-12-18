package es.salutiscentro.gestion.model.dao;


import es.salutiscentro.gestion.model.Usuario;



public interface UsuarioDao{

	/**
	 * Buscar por usuario y clave
	 * @param usuario
	 * @param clave
	 * @return
	 * @throws DaoException 
	 */
	public Usuario findByUsernameAndPassword(String username, String password) throws DaoException;

	public void save(Usuario item) throws DaoException;
}
