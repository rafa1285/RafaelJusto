package es.salutiscentro.gestion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import es.salutiscentro.gestion.model.Especialidad;
import es.salutiscentro.gestion.model.dao.EspecialidadDao;
import es.salutiscentro.gestion.service.EspecialidadSvc;
import es.salutiscentro.gestion.service.SvcException;

@Service
@Transactional
public class EspecialidadSvcImpl implements EspecialidadSvc {

	@Autowired
	private EspecialidadDao dao;

	@Override
	public Iterable<Especialidad> listar() throws SvcException {
		Iterable<Especialidad> esp = null;

		try {
			esp = dao.findAll();
		} catch (Exception ex) {
			throw new SvcException(ex);
		}

		return esp;
	}

}
