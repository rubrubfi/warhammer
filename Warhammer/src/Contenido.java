
public class Contenido {

	String raza;

	public Contenido(String raza) {
		super();
		this.raza = raza;
	}

	public Contenido() {

		this.raza = "";
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = descripciones(raza);

	}

	public String descripciones(String raza) {

		String descripcion = "";

		String enanos, elfos, humanos, halfling;

		enanos = "<html>Los enanos son una raza de guerreros y artesanos de corta estatura pero corpulentos y resistentes."
				+ " La mayor�a viven bajo las monta�as en poderosas fortalezas, con minas que excavan hasta lo m�s profundo de la tierra. "
				+ "Se les reconoce f�cilmente por sus cuerpos robustos, largos cabellos y espesas barbas. "
				+ "Suelen ser gru�ones e irritables, y su capacidad de guardar rencor es legendaria. "
				+ "No obstante, los enanos son un pueblo valiente e inquebrantablemente leal a sus amigos y aliados."
				+ " Luchan por proteger los vestigios de sus reinos monta�eses de orcos, goblins y dem�s criaturas inmundas. "
				+ "Los enanos mantienen fuertes vinculos con los humanos del Imperio y muchos forman parte de la sociedad imperial.</html>";
		
		
		elfos = "<html>Los elfos son una raza �gil y gr�cil, f�cilmente reconocibles por sus puntiagudas orejas y sus rasgos afilados. "
				+ "Tienen una historia gloriosa aunque tr�gica, y son famosos por su arquer�a, sus conocimientos y su magia. "
				+ "Los elfos poseen un entendimiento innato de las v�as y corrientes de la naturaleza, en especial de los bosques y mares. "
				+ "Desprecian a aquellos que destruyen la pureza de la naturaleza, ya sean orgullosos humanos, avariciosos enanos o malvados orcos."
				+ "Aunque pueden parecer distantes, se han sacrificado m�s por el bien del mundo de lo que cualquier otra raza pueda creer.</html>";
		
		
		humanos = "<html>Los humanos son la raza m�s habitual del Viejo Mundo, y los fundadores del Imperio. "
				+ "Aunque no son tan resistentes como los enanos ni tan sabios como los elfos, los humanos son una raza animada y din�mica que ha conseguido mucho en muy poco tiempo."
				+ " Son tremendamente adaptables, lo cual es tanto una gran ventaja como una grave debilidad. "
				+ "Mientras que muchos humanos heroicos han combatido contra la marea de oscuridad, es innegable que tambi�n han engrosado las filas del Caos.</html>";
		
		
		halfling = "<html>Los halflings son una raza peque�a pero habilidosa que parecen ni�os humanos para los no avezados. "
				+ "El hecho de que no les crezca barba refuerza esta impresi�n. Aunque suelen ser panzudos "
				+ "(pues comen el doble de veces que cualquier otra raza), son capaces de moverse con gran sigilo. "
				+ "Esto, combinado con su notoria habilidad con la honda, convierte a los halflings en oponentes sorprendentemente recalcitrantes. "
				+ "Sin embargo, son en general un pueblo pac�fico, y se contentan con cultivar la tierra, comer y fumar hierba en pipa."
				+ "Est�n orgullosos de sus familias y todos los halflings son capaces de enumerar su linaje familiar diez generaciones atr�s (o incluso m�s).</html>";

		switch (raza) {

			case "Enano/a":
				descripcion = enanos;
				break;
	
			case "Elfo/a":
				descripcion = elfos;
				break;
	
			case "Humano/a":
				descripcion = humanos;
				break;
	
			case "Halfling":
				descripcion = halfling;
				break;
	
			default:
				descripcion = humanos;
				break;
		}

		return descripcion;

	}
	
	public static String [] profesiones(String raza) {
		
		String [] profesiones = null;
		
		switch (raza) {
		
		case "Humano/a":
			
			profesiones = new String[54];		
			
			profesiones[0] = "Alborotador";
			profesiones[1] = "Aprendiz de Hechicero";
			profesiones[2] = "Alguacil";
			profesiones[3] = "Barbero cirujano";
			profesiones[4] = "Batelero";
			profesiones[5] = "Guardaespaldas";
			profesiones[6] = "Osamentero";
			profesiones[7] = "Cazarrecompensas";
			profesiones[8] = "Burgu�s";
			profesiones[9] = "Miembro de s�quito";
			profesiones[10] = "Carbonero";
			profesiones[11] = "Cochero";
			profesiones[12] = "Artista";
			profesiones[13] = "Espadach�n estaliano";
			profesiones[14] = "Barquero";
			profesiones[15] = "Pescador";
			profesiones[16] = "Ladr�n de tumbas";
			profesiones[17] = "Hechicero vulgar";
			profesiones[18] = "Cazador";
			profesiones[19] = "Iniciado";
			profesiones[20] = "Carcelero";
			profesiones[21] = "Kossar kislevita";
			profesiones[22] = "Guardia marina";
			profesiones[23] = "Mercenario";
			profesiones[24] = "Mensajero";
			profesiones[25] = "Miliciano";
			profesiones[26] = "Minero";
			profesiones[27] = "Noble";
			profesiones[28] = "Bers�rker n�rdico";
			profesiones[29] = "Forajido";
			profesiones[30] = "Escolta";
			profesiones[31] = "Campesino";
			profesiones[32] = "Gladiador";
			profesiones[33] = "Sicario";
			profesiones[34] = "Cazarratas";
			profesiones[35] = "Patrulla de caminos";
			profesiones[36] = "Brib�n";
			profesiones[37] = "Escriba";
			profesiones[38] = "Marinero";
			profesiones[39] = "Sirviente";
			profesiones[40] = "Contrabandista";
			profesiones[41] = "Soldado";
			profesiones[42] = "Escudero";
			profesiones[43] = "Estudiante";
			profesiones[44] = "Ladr�n";
			profesiones[45] = "Mat�n";
			profesiones[46] = "Peajero";
			profesiones[47] = "Saqueador de tumbas";
			profesiones[48] = "Menestral";
			profesiones[49] = "Vagabundo";
			profesiones[50] = "Ayudante de c�mara";
			profesiones[51] = "Vigilante";
			profesiones[52] = "Le�ador";
			profesiones[53] = "Fan�tico";				
			
						
			break;
			
		case "Enano/a":
			
			profesiones = new String[30];		

			profesiones[0] = "Alborotador";
			profesiones[1] = "Guardaespaldas";
			profesiones[2] = "Burgu�s";
			profesiones[3] = "Cochero";
			profesiones[4] = "Artista";
			profesiones[5] = "Cazador";
			profesiones[6] = "Carcelero";
			profesiones[7] = "Guardia Marina";
			profesiones[8] = "Mercenario";
			profesiones[9] = "Miliciano";
			profesiones[10] = "Minero";
			profesiones[11] = "Noble";
			profesiones[12] = "Forajido";
			profesiones[13] = "Gladiador";
			profesiones[14] = "Sicario";
			profesiones[15] = "Cazarratas";
			profesiones[16] = "Portador de Runas";
			profesiones[17] = "Escriba";
			profesiones[18] = "Marinero";
			profesiones[19] = "Sirviente";
			profesiones[20] = "Rompescudos";
			profesiones[21] = "Contrabandista";
			profesiones[22] = "Soldado";
			profesiones[23] = "Estudiante";
			profesiones[24] = "Ladr�n";
			profesiones[25] = "Peajero";
			profesiones[26] = "Saqueador de tumbas";
			profesiones[27] = "Menestral";
			profesiones[28] = "Matatrolls";
			profesiones[29] = "Vigilante";
			
			break;
		
		case "Elfo/a":
			
			profesiones = new String[16];		
			
			profesiones[0] = "Aprendiz de Hechicero";
			profesiones[1] = "Artista";
			profesiones[2] = "Embajador";
			profesiones[3] = "Cazador";
			profesiones[4] = "Guerrero de camarilla";
			profesiones[5] = "Mercenario";
			profesiones[6] = "Mensajero";
			profesiones[7] = "Forajido";
			profesiones[8] = "Escolta";
			profesiones[9] = "Brib�n";
			profesiones[10] = "Escriba";
			profesiones[11] = "Marinero";
			profesiones[12] = "Estudiante";
			profesiones[13] = "Ladr�n";
			profesiones[14] = "Menestral";
			profesiones[15] = "Vagabundo";
			
			break;
			
		case "Halfling":
			
			profesiones = new String[31];		
			
			profesiones[0] = "Alborotador";
			profesiones[1] = "Barbero cirujano";
			profesiones[2] = "Osamentero";
			profesiones[3] = "Cazarrecompensas";
			profesiones[4] = "Burgu�s";
			profesiones[5] = "Miembro de s�quito";
			profesiones[6] = "Carbonero";
			profesiones[7] = "Artista";
			profesiones[8] = "Barquero";
			profesiones[9] = "Patrulla fronteriza";
			profesiones[10] = "Pescador";
			profesiones[11] = "Ladr�n de tumbas";
			profesiones[12] = "Cazador";
			profesiones[13] = "Mercenario";
			profesiones[14] = "Mensajero";
			profesiones[15] = "Miliciano";
			profesiones[16] = "Forajido";
			profesiones[17] = "Campesino";
			profesiones[18] = "Cazarratas";
			profesiones[19] = "Brib�n";
			profesiones[20] = "Sirviente";
			profesiones[21] = "Contrabandista";
			profesiones[22] = "Soldado";
			profesiones[23] = "Estudiante";
			profesiones[24] = "Ladr�n";
			profesiones[25] = "Peajero";
			profesiones[26] = "Saqueador de tumbas";
			profesiones[27] = "Menestral";
			profesiones[28] = "Vagabundo";
			profesiones[29] = "Ayuda de c�mara";
			profesiones[30] = "Vigilante";
			
			
			break;
			
		default:
			
			break;
		}
		
		return profesiones;

		
		
	}

}
