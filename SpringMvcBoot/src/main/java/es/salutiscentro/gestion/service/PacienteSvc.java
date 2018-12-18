package es.salutiscentro.gestion.service;

import es.salutiscentro.gestion.model.Paciente;

public interface PacienteSvc {
	
	/**
	 * Guardar un elemento
	 * @param producto elemento a guardar
	 * @throws SvcException
	 */
	public void guardar(Paciente paciente) throws SvcException;

	public void modificar(Paciente paciente) throws SvcException;
	
	/**
	 * Listar todos los elementos
	 * @return lista completa de elementos
	 * @throws SvcException
	 */
	public Iterable<Paciente> listar() throws SvcException;
	
	/**
	 * Filtrar por id
	 * @param id clave a buscar
	 * @return producto encontrado, null si no lo encuentra
	 * @throws SvcException
	 */
	public Paciente buscar(int id) throws SvcException;

	public void eliminar(Paciente paci) throws SvcException;

}
