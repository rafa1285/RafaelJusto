package es.salutiscentro.gestion.model.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.salutiscentro.gestion.model.Cita;
import es.salutiscentro.gestion.model.Paciente;
import es.salutiscentro.gestion.model.dao.CitaDao;
import es.salutiscentro.gestion.model.dao.DaoException;

@Repository
public class CitaDaoImpl implements CitaDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Iterable<Cita> findAll() throws DaoException {
		List<Cita> cita = null;
		try {
			String hql = "FROM Cita";
			cita = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return cita;
	}

	@Override
	public void save(Cita cita) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(cita);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		
	}

	@Override
	public void update(Cita cita) throws DaoException {
		try {
			sessionFactory.getCurrentSession().update(cita);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		
	}

	@Override
	public Cita findById(int id) throws DaoException {
		Cita cita = null;
		try {
			cita = (Cita) sessionFactory.getCurrentSession().get(Cita.class, id);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return cita;
	}

}
