
package iteracion2.Alohandes.negocio;

import java.sql.Timestamp;

/**
 * Clase para modelar la relación VISITAN del negocio de los Parranderos:
 * Cada objeto de esta clase representa el hecho que un bebedor visitó un bar y viceversa.
 * Se modela mediante los identificadores del bebedor y del bar respectivamente
 * Debe existir un bebedor con el identificador dado
 * Debe existir un bar con el identificador dado 
 * Adicionalmente contiene la fecha y el horario (DIURNO, NOCTURNO, TODOS) en el cual el bebedor visitó el bar
 * 
 * @author Germán Bravo
 */
public class HabitacionTiempoOcupada implements VOHabitacionTiempoOcupada
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El id de la habitacion
	 */
	private long idHabitacion;

	/**
	 * El id del tiempo de ocupación
	 */
	private long idTiempoOcupacion;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public HabitacionTiempoOcupada() 
	{
		this.idHabitacion = 0;
		this.idTiempoOcupacion = 0;
	}

	

	/**
	 * Constructor con valores
	 * @param idHabitacion
	 * @param idTiempoOcupacion
	 */
	public HabitacionTiempoOcupada(long idHabitacion, long idTiempoOcupacion) {
		this.idHabitacion = idHabitacion;
		this.idTiempoOcupacion = idTiempoOcupacion;
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
	 * @return El id del tiempo de ocupación
	 */
	public long getIdTiempoOcupacion() {
		return idTiempoOcupacion;
	}



	/**
	 * @param El nuevo id del tiempo de ocupación
	 */
	public void setIdTiempoOcupacion(long idTiempoOcupacion) {
		this.idTiempoOcupacion = idTiempoOcupacion;
	}



	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "HabitacionTiempoOcupada [idHabitacion=" + idHabitacion + ", idTiempoOcupacion=" + idTiempoOcupacion + "]";
	}
}
