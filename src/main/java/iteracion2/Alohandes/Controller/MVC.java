package iteracion2.Alohandes.Controller;

import java.io.FileNotFoundException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;


public class MVC {
	
	private Controller controller;
	
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, FileNotFoundException 
	{
		Controller controler = new Controller();
		controler.run();
	}
}
