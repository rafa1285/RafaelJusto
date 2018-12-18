package es.salutiscentro.gestion.model.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.salutiscentro.gestion.model.Diagnostico;
import es.salutiscentro.gestion.model.Paciente;
import es.salutiscentro.gestion.model.dao.DaoException;
import es.salutiscentro.gestion.model.dao.DiagnosticoDao;

@Repository
public class DiagnosticoDaoImpl implements DiagnosticoDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Iterable<Diagnostico> findAll() throws DaoException {
		List<Diagnostico> diag = null;
		try {
			String hql = "FROM Cita";
			diag = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return diag;
	}

	@Override
	public Diagnostico findById(int id) throws DaoException {
		Diagnostico diagnostico = null;
		try {
			diagnostico = (Diagnostico) sessionFactory.getCurrentSession().get(Diagnostico.class, id);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return diagnostico;
	}

}
