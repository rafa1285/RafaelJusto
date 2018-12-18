package es.salutiscentro.gestion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import es.salutiscentro.gestion.model.Cita;
import es.salutiscentro.gestion.model.Paciente;
import es.salutiscentro.gestion.model.dao.CitaDao;
import es.salutiscentro.gestion.service.CitaSvc;
import es.salutiscentro.gestion.service.SvcException;

@Service
@Transactional
public class CitaSvcImpl implements CitaSvc {
	
	@Autowired
	private CitaDao dao;

	@Override
	public Iterable<Cita> listar() throws SvcException {
		Iterable<Cita> cita = null;
		try {
			cita = dao.findAll();
		} catch (Exception ex) {
			throw new SvcException(ex);
		}

		return cita;	}


	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Cita cita) throws SvcException {
		try {
			dao.save(cita);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Cita cita) throws SvcException {
		try {
			dao.update(cita);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		
	}


	@Override
	public Cita buscar(int id) throws SvcException {
		Cita cita = null;
		try {
			cita = dao.findById(id);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return cita;
	}

}
