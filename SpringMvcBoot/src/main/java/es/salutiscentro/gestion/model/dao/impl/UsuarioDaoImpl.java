package es.salutiscentro.gestion.model.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.salutiscentro.gestion.model.Usuario;
import es.salutiscentro.gestion.model.dao.DaoException;
import es.salutiscentro.gestion.model.dao.UsuarioDao;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Usuario findByUsernameAndPassword(String username, String password) throws DaoException {
		Usuario user = null;
		try {
			String hql = "FROM Usuario u WHERE u.username=:username AND u.password=:password";
			user = (Usuario) sessionFactory.getCurrentSession().createQuery(hql).setParameter("username", username).setParameter("password", password).uniqueResult();
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return user;

	}

	@Override
	public void save(Usuario item) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(item);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		
	}

}
