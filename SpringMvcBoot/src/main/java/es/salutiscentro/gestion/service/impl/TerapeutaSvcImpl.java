package es.salutiscentro.gestion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import es.salutiscentro.gestion.model.Terapeuta;
import es.salutiscentro.gestion.model.dao.TerapeutaDao;
import es.salutiscentro.gestion.service.SvcException;
import es.salutiscentro.gestion.service.TerapeutaSvc;

@Service
@Transactional
public class TerapeutaSvcImpl implements TerapeutaSvc {

	@Autowired
	private TerapeutaDao dao;

	@Override
	public Iterable<Terapeuta> listar() throws SvcException {
		Iterable<Terapeuta> tera = null;
		try {
			tera = dao.findAll();
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return tera;
	}

	@Override
	public Terapeuta buscar(int id) throws SvcException {
		Terapeuta tera = null;
		try {
			tera = dao.findById(id);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		return tera;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void guardar(Terapeuta terapeuta) throws SvcException {
		try {
			dao.save(terapeuta);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}		
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void modificar(Terapeuta terapeuta) throws SvcException {
		try {
			dao.update(terapeuta);
		} catch (Exception ex) {
			throw new SvcException(ex);
		}
		
	}

	@Override
	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void eliminar(Terapeuta tera) throws SvcException {
		try{
			tera = buscar(tera.getId_empleado());
			dao.delete(tera);
		}catch (Exception ex){
			throw new SvcException(ex);
		}	
		
	}

}
