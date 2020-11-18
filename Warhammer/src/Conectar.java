import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
	
static Connection conexion = null;
	
	public static void Conectar() {
		
		try {
			  Class.forName("org.postgresql.Driver").newInstance();
			  conexion = DriverManager.getConnection(
			    "jdbc:postgresql://localhost:5432/warhammer",
			    "postgres", "ruben");
			} catch (ClassNotFoundException cnfe) {
			  cnfe.printStackTrace();
			} catch (SQLException sqle) {
			  sqle.printStackTrace();
			} catch (InstantiationException ie) {
			  ie.printStackTrace();
			} catch (IllegalAccessException iae) {
			  iae.printStackTrace();
			}
		
		System.out.println("Conexion establecida");

		
	}

}
