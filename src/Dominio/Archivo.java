package Dominio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
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
		TreeSet<Persona>listaTreeSet= new TreeSet<Persona>();
		String [] listaPersona;
		try {
			BufferedReader buffer= new BufferedReader(new InputStreamReader(new FileInputStream(RUTA), "utf-8"));
			String linea= null;
			while((linea = buffer.readLine())!= null)
			{
				Persona personita = new Persona();
				listaPersona = linea.split("-");
				try{
					if(!personita.validarDni(listaPersona[2]))
						throw new ExceptionsFile("El DNI ingresado no tiene el formato correcto");
					personita.setNombre(listaPersona[0]);
					personita.setApellido(listaPersona[1]);
					personita.setDNI(Integer.parseInt(listaPersona[2]));
					listaTreeSet.add(personita);
				}
				catch(ExceptionsFile e) {
					e.getMessage();
				}
			}	
			buffer.close();
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return listaTreeSet;
	}
	public boolean Escribir(TreeSet<Persona> lista) {
		try {
			BufferedWriter bufferW= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(RUTA), "UTF8"));
			for(Persona e:lista) {
				bufferW.write(e.getNombre() + " " + e.getApellido());
				bufferW.newLine();
			}
			bufferW.close();
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
