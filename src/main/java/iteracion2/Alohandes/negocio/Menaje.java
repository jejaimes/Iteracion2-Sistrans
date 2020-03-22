
package iteracion2.Alohandes.negocio;

import java.sql.Timestamp;

/**
 * Clase para modelar la instancia MENAJE del negocio de ALOHANDES
 * 
 */
public class Menaje implements VOMenaje
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El nombre del maneje
	 */
	private String nombre;

	

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Menaje() 
	{
		this.nombre = "";
	}

	/**
	 * Constructor con valores
	 * @param idInmueble
	 * @param idTiempo
	 */
	public Menaje(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return El idInmueble
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param El nuevo idInmueble
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "Menaje [Nombre=" + nombre + "]";
	}
}