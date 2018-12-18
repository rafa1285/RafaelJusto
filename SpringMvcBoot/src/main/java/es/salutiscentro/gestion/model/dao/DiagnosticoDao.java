package es.salutiscentro.gestion.model.dao;

import es.salutiscentro.gestion.model.Diagnostico;

public interface DiagnosticoDao {

	public Iterable<Diagnostico> findAll() throws DaoException;

	public Diagnostico findById(int id) throws DaoException;

}
