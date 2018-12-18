package es.salutiscentro.gestion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.salutiscentro.gestion.model.Usuario;
import es.salutiscentro.gestion.model.dao.UsuarioDao;
import es.salutiscentro.gestion.service.SvcException;
import es.salutiscentro.gestion.service.UsuarioSvc;



@Service
@Transactional
public class UsuarioSvcImpl implements UsuarioSvc{
	
	private static final String URI_INICIO = "inicio";
	private static final String URI_USUARIO = "usuario";
	private static final String URI_CARRITO = "carrito";
	private static final String URI_DISCOS = "disco/listar";
	
	@Autowired
	private UsuarioDao dao;	

	@Override
	public Usuario identificar(Usuario usuario) throws SvcException {
		Usuario res = null;
		
		try{
			res = dao.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword());
		}catch (Exception ex){
			throw new SvcException(ex);
		}
		
		return res;
	}

	@Override
	public boolean comprobar(Usuario usuario, String uri) throws SvcException {
		switch (usuario.getTipo().getId_tipo()){
		case 1:
			return true;
		case 2:
			// url a las cuales tiene acceso
//			return (uri.contains(URI_INICIO) || 
//					uri.contains(URI_USUARIO) || 
//					uri.contains(URI_DISCOS) ||
//					uri.contains(URI_CARRITO));
		default:
			return false;
		}
	}
	
	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)	
	@Override
	public void guardar(Usuario item) throws SvcException {
		try{
			dao.save(item);
		}catch (Exception ex){
			throw new SvcException(ex);
		}
	}

}
