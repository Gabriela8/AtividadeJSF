package src.br.edu.ifpb.atividadejsf2.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import src.br.edu.ifpb.atividadejsf2.dao.UsuarioDAO;
import src.br.edu.ifpb.atividadejsf2.entidade.Usuario;

@SessionScoped
@ManagedBean

public class UsuarioBean {
	
	private Usuario usuario;
	private UsuarioDAO usuarioDao;
	private List<Usuario> usuarios;
	
	public UsuarioBean() {
	
		this.usuario = new Usuario();
		this.usuarioDao = new UsuarioDAO();
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}
	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public String listarUsuarios(){
		
		try {
		
			usuarios = usuarioDao.getUsuarios();
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return "exibeUsuario.xhtml";
	}
}