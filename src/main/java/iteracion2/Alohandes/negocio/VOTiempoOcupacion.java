package iteracion2.Alohandes.negocio;

import java.sql.Timestamp;

/**
 * Interfaz para los métodos get de TiempoOcupacion.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 */
public interface VOTiempoOcupacion
{
	/**
	 * @return El id del TiempoOcupacion
	 */
	public long getId();

	/**
	 * @return La fechaLlegada del TiempoOcupacion
	 */
	public Timestamp getFechaLlegada();

	/**
	 * @return La fechaSalida del TiempoOcupacion
	 */
	public Timestamp getFechaSalida();
	
	/**
	 * @return Una cadena con la información básica de la bebida
	 */
	@Override
	public String toString();
}