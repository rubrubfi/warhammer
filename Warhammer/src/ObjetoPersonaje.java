

public class ObjetoPersonaje {
	
	int idpersonaje, idusuario, edad;
	String nombre, raza, clase , genero;
	
	public ObjetoPersonaje(int idpersonaje, int idusuario, int edad, String nombre, String raza, String clase,String genero) {
		super();
		this.idpersonaje = idpersonaje;
		this.idusuario = idusuario;
		this.edad = edad;
		this.nombre = nombre;
		this.raza = raza;
		this.clase = clase;
		this.genero = genero;
	}

	public int getIdpersonaje() {
		return idpersonaje;
	}

	public void setIdpersonaje(int idpersonaje) {
		this.idpersonaje = idpersonaje;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	

}
