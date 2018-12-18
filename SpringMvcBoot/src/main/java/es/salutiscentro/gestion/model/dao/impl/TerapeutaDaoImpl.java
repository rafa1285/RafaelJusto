package es.salutiscentro.gestion.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import es.salutiscentro.gestion.model.Terapeuta;
import es.salutiscentro.gestion.model.dao.DaoException;
import es.salutiscentro.gestion.model.dao.TerapeutaDao;

@Repository
public class TerapeutaDaoImpl implements TerapeutaDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Iterable<Terapeuta> findAll() throws DaoException {
		List<Terapeuta> tera = null;
		try {
			String hql = "FROM Terapeuta";
			tera = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return tera;
	}

	@Override
	public Terapeuta findById(int id) throws DaoException {
		Terapeuta tera = null;
		try {
			tera = (Terapeuta) sessionFactory.getCurrentSession().get(Terapeuta.class, id);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return tera;
	}

	@Override
	public void save(Terapeuta terapeuta) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(terapeuta);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		
	}

	@Override
	public void update(Terapeuta terapeuta) throws DaoException {
		try {
			sessionFactory.getCurrentSession().update(terapeuta);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		
	}

	@Override
	public void delete(Terapeuta tera) throws DaoException {
		try{
			sessionFactory.getCurrentSession().delete(tera);		
		}catch (Exception ex){
			throw new DaoException(ex);
		}
		
	}

}
