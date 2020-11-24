import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;

public class Consultas {

	static Connection conexion = Conectar.conexion;

	// ---------------------REGISTRO: COMPROBAMOS SI EL USUARIO EXISTE
	// -------------------------

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

	// ------------ REGISTRO : ASIGNAMOS UN ID AL USUARIO Y LO REGISTRAMOS EN LA
	// BASE DE DATOS ---------------------------

	public static void asignaIDusuario(String usuario, String mail, String contraseña) {

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

	// ----------------- COMPROBAMOS SI EL LOGIN ES CORRECTO
	// -------------------------------------------------

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

	// ---------------- OBTENEMOS TODA LA INFORMACIÓN DEL USUARIO
	// ---------------------------

	public static ObjetoUsuario defineUsuario(int id) {

		int idusuario = 0;
		String nombre = null, contraseña = null, correo = null;

		ObjetoUsuario usuario = null;

		String sentenciaGetId = "SELECT * FROM usuario  WHERE id = ?";

		PreparedStatement sentencia = null;
		ResultSet resultado = null;

		try {
			sentencia = conexion.prepareStatement(sentenciaGetId);
			sentencia.setInt(1, id);
			resultado = sentencia.executeQuery();

			while (resultado.next()) {
				idusuario = resultado.getInt(1);
				nombre = resultado.getString(2);
				correo = resultado.getString(3);
				contraseña = resultado.getString(4);
			}

			usuario = new ObjetoUsuario(nombre, correo, contraseña, idusuario);

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
		return usuario;

	};

	// ---------------- OBTENEMOS LA ID DEL USUARIO
	// ---------------------------------

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
		String encriptada = DigestUtils.md5Hex(pass);
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

	// ESTE MÉTODO PERMITE CREAR UN NUEVO PERSONAJE

	public static void nuevoPersonaje(int idusuario, String nombre, String raza, String clase, String genero,int edad) {

		String sentenciaGetId = "SELECT id_personaje FROM personaje  ORDER BY id_personaje DESC LIMIT 1";

		String sentencianueva = "INSERT INTO personaje VALUES (?,?,?,?,?,?,?)";

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

			int idpersonaje = id + 1;
			sentencia = conexion.prepareStatement(sentencianueva);

			sentencia.setInt(1, idpersonaje);
			sentencia.setString(2, nombre);
			sentencia.setString(3, raza);
			sentencia.setString(4, clase);
			sentencia.setInt(5, edad);
			sentencia.setString(6, genero);
			sentencia.setInt(7, idusuario);

			sentencia.execute();
			sentencia.close();

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
	
	
	public static ArrayList<ObjetoPersonaje> damePersonajes(int id){
		
		ArrayList<ObjetoPersonaje> personajes = new ArrayList<ObjetoPersonaje>();
		
		ObjetoPersonaje personaje = new ObjetoPersonaje(0, 0, 0, null, null, null, null);
		
		int idpersonaje, idusuario, edad;
		String nombre, raza, clase, genero;
		
		String sentenciaGet = "SELECT * FROM personaje WHERE idusuario = ? ORDER BY id_personaje DESC";
		
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		try {
			sentencia = conexion.prepareStatement(sentenciaGet);
			sentencia.setInt(1, id);
			resultado = sentencia.executeQuery();

			while (resultado.next()) {
				idpersonaje = resultado.getInt(1);
				nombre = resultado.getString(2);
				raza = resultado.getString(3);
				clase = resultado.getString(4);
				edad = resultado.getInt(5);
				genero = resultado.getString(6);
				idusuario = resultado.getInt(7);
							
				personaje = new ObjetoPersonaje(idpersonaje, idusuario, edad, nombre, raza, clase, genero);
				
				personajes.add(personaje);
				
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

		return personajes;
		
	}

}
