/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package iteracion2.Alohandes.negocio;

/**
 * Clase para modelar el concepto CLIENTE del negocio de ALOHANDES
 *
 * @author Germán Bravo
 */
public class Cliente implements VOCliente
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El nombre del cliente
	 */
	private String nombre;
	
	/**
	 * El TIPOPERSONA del cliente
	 */
	private String tipoPersona;
	
	/**
	 * El tipo de documento del cliente
	 */
	private String tipoDocumento;
	
	/**
	 * El numero de documento del cliente
	 */
	private long numDocumento;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Cliente() 
	{
		this.nombre = "";
		this.tipoPersona = "";
		this.tipoDocumento = "";
		this.numDocumento = 0;
	}


	public Cliente(String nombre, String tipoPer, String tipoDoc, long documento) 
	{
		this.nombre = nombre;
		this.tipoPersona = tipoPer;
		this.tipoDocumento = tipoDoc;
		this.numDocumento = documento;
	}

	/**
	 * @return El nombre del cliente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre - el nuevo nombre del cliente
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return El tipo de persona del cliente
	 */
	public String getTipoPersona() {
		return tipoPersona;
	}

	/**
	 * @param tipoPersona - El nuevo tipo de persona del cliente
	 */
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	/**
	 * @return El tipo de documento del cliente
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento - El nuevo tipo de documento del cliente
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return El numero de documento del cliente
	 */
	public long getNumDocumento() {
		return numDocumento;
	}

	/**
	 * @param numDocumento - El nuevo numero de documento del cliente
	 */
	public void setNumDocumento(long numDocumento) {
		this.numDocumento = numDocumento;
	}


	/**
	 * @return Una cadena con la información básica del cliente
	 */
	@Override
	public String toString() 
	{
		return "Cliente [nombre=" + nombre + ", tipoPersona=" + tipoPersona + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numDocumento + "]";
	}

}
