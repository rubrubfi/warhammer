
public class ObjetoUsuario {
	
	String nombre, correo , contraseña;
	int id;
	
	public ObjetoUsuario(String nombre, String correo, String contraseña, int id) {
		
		this.nombre = nombre;
		this.correo = correo;
		this.contraseña = contraseña;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

}
