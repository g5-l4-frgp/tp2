package Dominio;

public class Persona {
	
	private String Nombre;
	private String Apellido;
	private int DNI;
	
	public Persona() {
		Nombre = "Sin Nombre";
		Apellido = "Sin Apellido";
		DNI = 11111111;
	}
	
	public Persona(String Nombre, String Apellido, int DNI)
	{
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.DNI = DNI;
	}	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}

	@Override
	public String toString() {
		return "La Persona se llama " + Nombre + ", Apellido=" + Apellido + ", con DNI=" + DNI;
	}
	
}