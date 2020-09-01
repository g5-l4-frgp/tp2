package Dominio;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Principal {

@SuppressWarnings("null")
public static void main(String[] args) {

Collator comparador = Collator.getInstance();
comparador.setStrength(Collator.PRIMARY);
Archivo archivo= new Archivo();
TreeSet<Persona>lista=new TreeSet<Persona>();
archivo.setRUTA("PersonasEmpresa.txt");
ArrayList<Persona> listarray= new ArrayList();
System.out.println(" ARCHIVO PERSONASEMPRESA : ");

//Guardo la lista treeSet sin duplicados
lista=archivo.Leer();

//Convierto la lista treeset a ArrayList
for(Persona e:lista)
{
listarray.add(e);
}
//Ordeno alfabeticamente
Collections.sort(listarray,(x, y) -> comparador.compare(x.getNombre(), y.getNombre()));
for(Persona e:listarray)
{
System.out.println(e.getNombre()+" "+e.getDNI());
}
}
}
