package src.br.edu.ifpb.atividadejsf2.dao;

import java.sql.*;

public class GeneralDAO {
	
	static String user = "root";
	static String password = "senha";
	static String url = "jdbc:mysql://localhost:3306/atividadeJsf2";
	static Connection connection;
	static ResultSet rs;

	public GeneralDAO() {
		
	}
	public void abrirConexao(){
	
		try {

			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Nao foi possivel encontrar o Driver apropriado");
		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel conectar ao SGBD");
			sqle.printStackTrace(System.err);
		}
	}
	public void alteraBanco(String sql){
		try{
			Statement st = this.connection.createStatement();
			st.executeUpdate(sql);
			st.close();
		
		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel realizar inser��o");
			sqle.printStackTrace(System.err);
		}
	}	
	public ResultSet consultaBanco(String sql){
		
		try{
			Statement st = this.connection.createStatement();
			rs = st.executeQuery(sql);
		
		} catch (SQLException sqle) {
			System.out.println("N�o foi poss�vel fazer a consulta");
			sqle.printStackTrace(System.err);
		}
		
		return rs;
	}
	
	public void fecharConexao(){
		
		try {
			this.connection.close();
		} catch (SQLException e) {
			System.out.println("N�o foi poss�vel fechar conex�o");
			e.printStackTrace();
		} catch (NullPointerException npe){
			System.out.println("N�o foi poss�vel realizar inser��o");
			npe.printStackTrace(System.err);
		}
	}		
}