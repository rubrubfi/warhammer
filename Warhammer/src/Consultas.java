import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

public class Consultas {

	static Connection conexion = Conectar.conexion;

	// ---------------------REGISTRO: COMPROBAMOS SI EL USUARIO EXISTE -------------------------

	public static boolean compruebaUsuario(String nombre) {
		boolean existe = false;

		String sentenciamail = "SELECT nombre FROM usuario WHERE nombre = ?";
		PreparedStatement sentencia = null;
		ResultSet resultado = null;

		try {
			sentencia = conexion.prepareStatement(sentenciamail);
			sentencia.setString(1, nombre);
			resultado = sentencia.executeQuery();

			while (resultado.next()) {
				existe = true;
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("error");
		} finally {
			if (sentencia != null)
				try {
					sentencia.close();
					resultado.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
		}
		return existe;

	}

	// ------------ REGISTRO : ASIGNAMOS UN ID AL USUARIO Y LO REGISTRAMOS EN LA BASE DE DATOS ---------------------------

	public static void asignaID(String usuario, String mail, String contraseña) {

		String sentenciaGetId = "SELECT id FROM usuario  ORDER BY id DESC LIMIT 1";
		String sentenciaSql = "INSERT INTO usuario (id, nombre, correo, contraseña) VALUES (?, ?, ?, ?)";
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		int id = 0;

		try {
			sentencia = conexion.prepareStatement(sentenciaGetId);
			resultado = sentencia.executeQuery();

			while (resultado.next()) {
				id = resultado.getInt(1);

			}
			sentencia.close();

			sentencia = conexion.prepareStatement(sentenciaSql);
			sentencia.setInt(1, id + 1);
			sentencia.setString(2, usuario);
			sentencia.setString(3, mail);
			sentencia.setString(4, contraseña);
			sentencia.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if (sentencia != null)
				try {
					sentencia.close();
					resultado.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
		}

	}

	// ----------------- COMPROBAMOS SI EL LOGIN ES CORRECTO -------------------------------------------------

	public static boolean compruebaLogin(String nombre, String pass) {
		boolean esCorrecto = false;

		String sentenciaSQL = "SELECT nombre FROM usuario WHERE nombre = ? AND contraseña = ?";
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		try {
			sentencia = conexion.prepareStatement(sentenciaSQL);
			sentencia.setString(1, nombre);
			sentencia.setString(2, pass);
			resultado = sentencia.executeQuery();

			if (resultado.next()) {
				esCorrecto = true;
			} else {
				esCorrecto = false;
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if (sentencia != null)
				try {
					sentencia.close();
					resultado.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
		}
		return esCorrecto;

	}

	// ---------------- OBTENEMOS LA ID DEL USUARIO ---------------------------------

	public static int obtieneid(String nombre) {

		int id = 0;

		String sentenciaGetId = "SELECT id FROM usuario  WHERE nombre = ?";

		PreparedStatement sentencia = null;
		ResultSet resultado = null;

		try {
			sentencia = conexion.prepareStatement(sentenciaGetId);
			sentencia.setString(1, nombre);
			resultado = sentencia.executeQuery();

			while (resultado.next()) {
				id = resultado.getInt(1);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("error");
		} finally {
			if (sentencia != null)
				try {
					sentencia.close();
					resultado.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
		}

		return id;

	}
	
	/// ESTE MÉTODO PERMITE AL USUARIO CAMBIAR SU CONTRASEÑA

		public static void cambiapass(String dni, String pass) {

			String sentenciaPass = "UPDATE profesor SET contraseña = ? WHERE dni = ?";
			String encriptada =  DigestUtils.md5Hex(pass);
			PreparedStatement sentencia = null;
			

			try {
				sentencia = conexion.prepareStatement(sentenciaPass);
				sentencia.setString(1, encriptada);
				sentencia.setString(2, dni);

				sentencia.executeUpdate();

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				System.out.println("error");
			} finally {
				if (sentencia != null)
					try {
						sentencia.close();
						
					} catch (SQLException sqle) {
						sqle.printStackTrace();
					}
			}

		}


}
