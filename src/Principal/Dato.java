package Principal;

public class Dato {
	String nombre, locale, dependencia, dependencia_aux_1, dependencia_aux_2;

	public Dato(String nombre, String locale, String dependencia, String dependencia_aux_1, String dependencia_aux_2) {
		super();
		this.nombre = nombre;
		this.locale = locale;
		this.dependencia = dependencia;
		this.dependencia_aux_1 = dependencia_aux_1;
		this.dependencia_aux_2 = dependencia_aux_2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getDependencia() {
		return dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	public String getDependencia_aux_1() {
		return dependencia_aux_1;
	}

	public void setDependencia_aux_1(String dependencia_aux_1) {
		this.dependencia_aux_1 = dependencia_aux_1;
	}

	public String getDependencia_aux_2() {
		return dependencia_aux_2;
	}

	public void setDependencia_aux_2(String dependencia_aux_2) {
		this.dependencia_aux_2 = dependencia_aux_2;
	}

}
