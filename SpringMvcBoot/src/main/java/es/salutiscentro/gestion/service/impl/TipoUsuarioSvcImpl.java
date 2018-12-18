package es.salutiscentro.gestion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import es.salutiscentro.gestion.model.TipoUsuario;
import es.salutiscentro.gestion.model.dao.TipoUsuarioDao;
import es.salutiscentro.gestion.service.SvcException;
import es.salutiscentro.gestion.service.TipoUsuarioSvc;

@Service
@Transactional
public class TipoUsuarioSvcImpl implements TipoUsuarioSvc {

	@Autowired
	private TipoUsuarioDao dao;

	@Override
	public Iterable<TipoUsuario> listar() throws SvcException {
		Iterable<TipoUsuario> tipoUser = null;

		try {
			tipoUser = dao.findAll();
		} catch (Exception ex) {
			throw new SvcException(ex);
		}

		return tipoUser;
	}

}
