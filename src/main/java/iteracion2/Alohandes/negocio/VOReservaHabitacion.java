package iteracion2.Alohandes.negocio;

/**
 * Interfaz para los métodos get de ReservaHabitacion.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 */
public interface VOReservaHabitacion
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El id de la reserva
	 */
	public long getIdReserva();

	/**
	 * @return El id de la habitación
	 */
	public long getIdHabitacion();
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();
}
