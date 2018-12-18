package es.salutiscentro.gestion.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import es.salutiscentro.gestion.model.Usuario;
import es.salutiscentro.gestion.service.UsuarioSvc;


public class LoginInterceptor extends HandlerInterceptorAdapter{
	
//	public static final String ATT_USER = "sessionUser";
//	private static final String INDEX = "index.jsp"; 
//	private static final String LOGIN = "/login";
//
//	@Override
//	public boolean preHandle(HttpServletRequest request,
//			HttpServletResponse response, Object handler) throws Exception {
//		String uri = request.getRequestURI();
//		Usuario usuario = (Usuario) request.getSession().getAttribute(ATT_USER);
//        
//        if(usuario == null){
//        	if (!uri.endsWith(INDEX) && !uri.endsWith(LOGIN)){
//        		response.sendRedirect(INDEX);
//        		return false;
//        	}
//        }
//        
//        return true;
//	}
	
	public static final String ATT_USER = "sessionUser";
	private static final String INDEX = "/index.jsp"; 
	private static final String INICIO = "/login";
	private static final String REGISTRO = "/registrar";
	private static final String LOGIN = "/login/";
	
	@Autowired
	private UsuarioSvc usuarioSvc;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		Usuario usuario = (Usuario) request.getSession().getAttribute(ATT_USER);
        
        if(usuario == null){
	        	if (!uri.endsWith(INICIO) && !uri.endsWith(LOGIN) && !uri.endsWith(REGISTRO)){
	        		//Redirigir al inicio en caso de acceso prohibido
	        		response.sendRedirect(request.getContextPath() + INDEX);
	        		return false;
	        	}
        }else{
	        	//Comprobar autorización
	        	boolean res = usuarioSvc.comprobar(usuario, uri);
	        	if (!res){
	        		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        		response.sendRedirect(request.getContextPath() + INDEX);
	        	}
	        	return res;
	    }
        
        return true;
	}

}
