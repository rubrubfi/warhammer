
public class ObjetoUsuario {
	
	String nombre, correo , contrase�a;
	int id;
	
	public ObjetoUsuario(String nombre, String correo, String contrase�a, int id) {
		
		this.nombre = nombre;
		this.correo = correo;
		this.contrase�a = contrase�a;
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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

}
