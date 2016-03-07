package src.br.edu.ifpb.atividadejsf2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import src.br.edu.ifpb.atividadejsf2.entidade.Usuario;

public class UsuarioDAO {
	
	public List<Usuario> getUsuarios() throws ClassNotFoundException {

		List<Usuario> listaUsu = new ArrayList<Usuario>();

		String sql = "select* from usuario;";
		try {	
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = preparador.executeQuery(sql);
			preparador.execute();
			preparador.close();

			while (rs.next()) {
				Usuario usu = new Usuario();
				usu.setNome(rs.getString("nome"));
				usu.setNascimento(rs.getString("nascimento"));
				usu.setMatricula(rs.getString("matricula"));

				listaUsu.add(usu);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return listaUsu;

	}

	public void cadatrar(Usuario usu) throws ClassNotFoundException {

		String sql = "INSERT INTO usuario values(?,?,?);";
		System.out.println(sql);
		try {
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql);
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getNascimento());
			preparador.setString(3, usu.getMatricula());

			preparador.execute();
			preparador.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void removerUsuario(String matricula) throws ClassNotFoundException {

		String sql = "DELETE FROM usuario WHERE matricula='" + matricula + "';";
		System.out.println(sql);
		try {
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql);

			preparador.execute();
			preparador.close();
		} catch (SQLException e) {

		}
	}

	public List<Usuario> getUsuarios(String nome) throws ClassNotFoundException {

		List<Usuario> listaUsu = new ArrayList<Usuario>();

		String sql = "select* from usuario WHERE nome like'%" + nome + "%';";
		try {
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = preparador.executeQuery(sql);
			preparador.execute();
			preparador.close();

			while (rs.next()) {
				Usuario usu = new Usuario();
				usu.setNome(rs.getString("nome"));
				usu.setNascimento(rs.getString("data_nascimento"));
				usu.setMatricula(rs.getString("matricula"));

				listaUsu.add(usu);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return listaUsu;
	}
}