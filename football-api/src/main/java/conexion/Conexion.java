package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	private static String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/soccer";
	private static String USUARIO = "root";
	private static String CLAVE = "";

	static {
		try {
			Class.forName(CONTROLADOR);
			JOptionPane.showMessageDialog(null, "Driver conectado");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Driver no conectado");

		}
	}
		
		Connection con = null;
	public Connection getConnection() {
			try {
				con=DriverManager.getConnection(URL,USUARIO,CLAVE);
				JOptionPane.showMessageDialog(null, "Conexion a MYSQL correcta");
			}
			catch (SQLException e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error de conexion");
			}
			
			return con;
		}
	
	public Connection close() {
		try {
			con.close();
			JOptionPane.showMessageDialog(null, "Conexion cerrada");
		}
		catch (SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR Conexion");
		}
		
		return con;
	}
	
	public static void main(String[] args) {
		Conexion db=new Conexion();
		db.getConnection();
	}
}
