package Dominio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class Archivo {

	private String RUTA;
	
	public boolean Existe() {
		
		File archivo= new File(RUTA);
		if(archivo.exists())
			return true;
		return false;
	}
	
	public boolean CrearArchivo() {
		FileWriter escritura;
		try {
			escritura= new FileWriter(RUTA,true);
			escritura.write("");
			escritura.close();
			return true;
		}
		
		catch(IOException e){
			
			e.printStackTrace();
			
		}
		return false;
	}
	
	public TreeSet<Persona> Leer() {
		FileReader entrada;
		TreeSet<Persona>lista= new TreeSet<Persona>();
		Persona personita= new Persona();
		String limite="[-]";
		String [] listaPersona;
		try {
			entrada= new FileReader(RUTA);
			BufferedReader buffer= new BufferedReader(entrada);
			String linea= "";
			while(linea!=null)
			{
				
				listaPersona=buffer.readLine().split(limite);
				personita.setNombre(listaPersona[0]);
				personita.setApellido(listaPersona[1]);
				personita.setDNI(Integer.parseInt(listaPersona[2]));
				lista.add(personita);
				
				
			}
			buffer.close();
			entrada.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return lista;
	}
	
	public boolean Escribir(String linea) {
		FileWriter escritura;
		try {
			escritura= new FileWriter(RUTA,true);
			BufferedWriter bufferW= new BufferedWriter(escritura);
			bufferW.write(linea);
			bufferW.close();
			escritura.close();
			return true;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getRUTA() {
		return RUTA;
	}

	public void setRUTA(String rUTA) {
		RUTA = rUTA;
	}

}
