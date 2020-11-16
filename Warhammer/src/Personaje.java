
public class Personaje {
	
	String nombre, sexo , raza, profesion , edad;

	public Personaje(String nombre, String sexo, String raza, String profesion, String edad) {
		
		this.nombre = nombre;
		this.sexo = sexo;
		this.raza = raza;
		this.profesion = profesion;
		this.edad = edad;
	}
	
	public Personaje() {
		
		this.nombre = "";
		this.sexo = "";
		this.raza = "";
		this.profesion = "";
		this.edad = "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

}
