package src.br.edu.ifpb.atividadejsf2.dao;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

class ConnectionFactory {
	
	private static Connection connection = null;
	private static boolean open = false;

	static String usuario = "root";
	static String senha = "";
	static String url = "jdbc:mysql://localhost:3306/atividadeJsf2";

	
	private ConnectionFactory() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = (Connection) DriverManager.getConnection(url, usuario, senha);
	}

	public static boolean openConnection() throws ClassNotFoundException, SQLException {
		if (!open) {
			new ConnectionFactory();
			setOpen(true);
			return true;
		}
		return false;
	}

	public static Connection getConnection() {
		if (open)
			return connection;
		return null;
	}

	public static boolean closeConnection() {
		try {
			connection.close();
			setOpen(false);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static boolean isOpen() {
		return open;
	}

	private static void setOpen(boolean aberto) {
		open = aberto;
	}
}