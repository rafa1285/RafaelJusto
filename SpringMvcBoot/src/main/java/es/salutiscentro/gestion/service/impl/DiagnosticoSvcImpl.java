package es.salutiscentro.gestion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.salutiscentro.gestion.model.Diagnostico;
import es.salutiscentro.gestion.model.Paciente;
import es.salutiscentro.gestion.model.dao.DiagnosticoDao;
import es.salutiscentro.gestion.service.DiagnosticoSvc;
import es.salutiscentro.gestion.service.SvcException;

@Service
@Transactional
public class DiagnosticoSvcImpl implements DiagnosticoSvc {
	
	@Autowired
	private DiagnosticoDao dao;

	@Override
	public Iterable<Diagnostico> listar() throws SvcException {
		Iterable<Diagnostico> diag = null;
		try {
			diag = dao.findAll();
		}catch (Exception ex) {
			throw new SvcException(ex);
		}
		return diag;
	}

	@Override
	public Diagnostico buscar(int id) throws SvcException {
		Diagnostico diagnostico = null;
		try {
			diagnostico = dao.findById(id);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return diagnostico;
	}

}
