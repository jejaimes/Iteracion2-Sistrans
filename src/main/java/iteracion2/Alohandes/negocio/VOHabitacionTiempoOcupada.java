
package iteracion2.Alohandes.negocio;

import java.sql.Timestamp;

/**
 * Interfaz para los métodos get de HABITACIONTIEMPOOCUPADA.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Germán Bravo
 */
public interface VOHabitacionTiempoOcupada 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El id de la habitacion
	 */
	public long getIdHabitacion();

	/**
	 * @return El id del tiempo de ocupación
	 */
	public long getIdTiempoOcupacion();


	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();

}
