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
 * * Clase para modelar la relación HABITACIONSERVICIO del negocio de ALOHANDES
 *
 * @author Germán Bravo
 */
public class HabitacionServicio implements VOHabitacionServicio
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El nombre del servicio
	 */
	private String nombreServicio;

	/**
	 * El id de la habitacion
	 */
	private long idHabitacion;
	
	/**
	 * El costo del servicio
	 */
	private int costo;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defectp
	 */
	public HabitacionServicio() {
		this.nombreServicio = "";
		this.idHabitacion = 0;
		this.costo = 0;
	}



	/**
	 * Construcor con valores
	 * @param nombreServicio
	 * @param idHabitacion
	 * @param costo
	 */
	public HabitacionServicio(String nombreServicio, long idHabitacion, int costo) {
		this.nombreServicio = nombreServicio;
		this.idHabitacion = idHabitacion;
		this.costo = costo;
	}

	


	/**
	 * @return El nombre del servicio
	 */
	public String getNombreServicio() {
		return nombreServicio;
	}



	/**
	 * @param El nuevo nombre del servicio
	 */
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}



	/**
	 * @return El id de la habitacion
	 */
	public long getIdHabitacion() {
		return idHabitacion;
	}



	/**
	 * @param El nuevo id de la habitacion
	 */
	public void setIdHabitacion(long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}



	/**
	 * @return El costo del servicio
	 */
	public int getCosto() {
		return costo;
	}



	/**
	 * @param El nuevo costo del servicio
	 */
	public void setCosto(int costo) {
		this.costo = costo;
	}



	/**
	 * @return Una cadena de caracteres con la información del tipo de bebida
	 */
	@Override
	public String toString() 
	{
		return "HabitacionServicio [nombreServicio=" + nombreServicio + ", idHabitacion=" + idHabitacion + ", costo=" + costo +"]";
	}

}
