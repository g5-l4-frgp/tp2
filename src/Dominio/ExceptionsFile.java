package Dominio;

@SuppressWarnings("serial")
public class ExceptionsFile extends Exception{
	public ExceptionsFile(String errorMessage) {
		super (errorMessage);
		System.out.println(errorMessage);
	}

}
