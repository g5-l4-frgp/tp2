package Dominio;

import java.util.TreeSet;

public class Principal {

	public static void main(String[] args) {

		TreeSet<Persona>lista=new TreeSet<Persona>();
		Archivo archivo= new Archivo();
		archivo.setRUTA("PersonasEmpresa.txt");

		System.out.println(" ARCHIVO PERSONASEMPRESA : ");
		
			lista=archivo.Leer();

			for(Persona e:lista)
			{
				System.out.println(e.getNombre());
			}
			
		

		/*Persona archivo2= new Persona();
		archivo2.setRuta("Resultado.txt");

		if(!archivo2.existe())
		{
		archivo2.creararchivonuevo();
		}

		//comprobar que funcione el Validador de dni

		Persona a1= new Persona();
		a1.setDni(12345678);
		try
		{
		   Persona.validarDNI(a1.getDni());
		   
		}
		catch(ExcepcionDNI e)
		{
		e.printStackTrace();
		} */
	}

}
