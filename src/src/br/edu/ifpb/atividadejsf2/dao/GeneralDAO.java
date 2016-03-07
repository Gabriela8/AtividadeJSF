package src.br.edu.ifpb.atividadejsf2.dao;

import src.br.edu.ifpb.atividadejsf2.entidade.Usuario;

public class GeneralDAO {
		
	public static void main(String[] args) throws ClassNotFoundException {

		Usuario usu = new Usuario();
		@SuppressWarnings("unused")
		UsuarioDAO usuDao = new UsuarioDAO();
		
		 	System.out.println(usu.getMatricula()+" "+usu.getNascimento());
		      
		
		 	
	}

}