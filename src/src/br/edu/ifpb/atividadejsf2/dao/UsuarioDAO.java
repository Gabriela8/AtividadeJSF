package src.br.edu.ifpb.atividadejsf2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import src.br.edu.ifpb.atividadejsf2.entidade.Usuario;

public class UsuarioDAO {

	GeneralDAO usuariojsf = new GeneralDAO();
	public ResultSet rs;

	public UsuarioDAO() {
	}

	public ArrayList<Usuario> consultaUser() {
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		usuariojsf.abrirConexao();
		System.out.print("Consulta SQL");

		String sql = "SELECT * FROM usuario";

		try {
			Statement st = GeneralDAO.connection.createStatement();
			rs = st.executeQuery(sql);
			
			Usuario usuario = new Usuario();
			
			while(rs.next()) {
				usuario.setNome(rs.getString("nome"));
				usuario.setMatricula(rs.getString("matricula"));
				usuario.setNascimento(rs.getString("nascimento"));				
				usuarios.add(usuario);
				System.out.println(" Sucesso");
			}
			st.close();

		}
		catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
			sqle.printStackTrace(System.err);
		}
		catch (NullPointerException npe){
			System.out.println("Nao foi possivel realizar inserção");
			npe.printStackTrace(System.err);
		}

		usuariojsf.fecharConexao();

		return usuarios;
	}

}