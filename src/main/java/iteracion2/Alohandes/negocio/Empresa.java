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
 * Clase para modelar la relación GUSTAN del negocio de los Parranderos:
 * Cada objeto de esta clase representa el hecho que un bebedor gusta de una bebida y viceversa.
 * Se modela mediante los identificadores del bebedor y de la bebida respectivamente.
 * Debe existir un bebedor con el identificador dado
 * Debe existir una bebida con el identificador dado 
 * 
 * @author Germán Bravo
 */
public class Empresa extends Alojamiento implements VOEmpresa
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del alojamiento
	 */
	private long idAlojamiento;

	/**
	 * El identificador de la bebida que gusta al bebedor
	 */
	private String nombre;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Empresa() 
	{
		this.idAlojamiento = 0;
		this.nombre = "";
	}

	/**
	 * Constructor con valores
	 * 
	 */
	public Empresa(long id, String nombre) 
	{
		this.idAlojamiento = id;
		this.nombre = nombre;
	}

	/**
	 * @return El id del alojamiento
	 */
	public long getIdAlojamiento() {
		return idAlojamiento;
	}

	/**
	 * @param idAlojamiento - El nuevo idAlojamiento. Debe existir un alojamiento con dicho identificador

	public void setIdAlojamiento(long idAlojamiento) {
		this.idAlojamiento = idAlojamiento;
	}
	
	/**
	 * @return El nombre de la empresa
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre - El nuevo nombre de la empresa
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
		return "Empresa [idAlojamiento=" + idAlojamiento + ", nombre=" + nombre + "]";
	}
	
}
