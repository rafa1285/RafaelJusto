package es.salutiscentro.gestion.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.salutiscentro.gestion.model.Paciente;
import es.salutiscentro.gestion.model.dao.DaoException;
import es.salutiscentro.gestion.model.dao.PacienteDao;

@Repository
public class PacienteDaoImpl implements PacienteDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Paciente paciente) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(paciente);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

	}

	@Override
	public void update(Paciente paciente) throws DaoException {
		try {
			sessionFactory.getCurrentSession().update(paciente);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

	}

	@Override
	public Iterable<Paciente> findByNombre(String nombre) throws DaoException {
		List<Paciente> paci = null;
		try {
			String hql = "FROM Paciente p WHERE p.nombre LIKE :nombre";
			paci = sessionFactory.getCurrentSession().createQuery(hql).setParameter("nombre", "%" + nombre + "%")
					.list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return paci;
	}

	@Override
	public Paciente findById(int id) throws DaoException {
		Paciente paci = null;
		try {
			paci = (Paciente) sessionFactory.getCurrentSession().get(Paciente.class, id);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return paci;
	}

	@Override
	public void delete(Paciente paci) throws DaoException {
		try{
			sessionFactory.getCurrentSession().delete(paci);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}

}
