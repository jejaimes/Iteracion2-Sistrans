package iteracion2.Alohandes.negocio;

/**
 * Clase para modelar el concepto ReservaHabitacion de AlohAndes
 *
 */
public class ReservaHabitacion implements VOReservaHabitacion
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El id de la reserva
	 */
	private long idReserva;

	/**
	 * El id de la habitación
	 */
	private long idHabitacion;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ReservaHabitacion() 
	{
		this.idReserva = 0;
		this.idHabitacion = 0;
	}

	/**
	 * Constructor con valores
	 * @param idReserva - El id de la reserva
	 * @param idHabitacion - El id de la habitación
	 */
	public ReservaHabitacion(long idReserva, long idHabitacion) 
	{
		this.idReserva = idReserva;
		this.idHabitacion = idHabitacion;
	}

	/**
	 * @return El id de la reserva
	 */
	public long getIdReserva()
	{
		return idReserva;
	}

	/**
	 * @param idReserva - El id de la reserva. Debe ser una reserva existente.
	 */
	public void setIdReserva(long idReserva) 
	{
		this.idReserva = idReserva;
	}

	/**
	 * @return El id de la habitación
	 */
	public long getIdHabitacion()
	{
		return idHabitacion;
	}

	/**
	 * @param idHabitacion - El id de la habitación. Debe ser una habitación existente.
	 */
	public void setIdHabitacion(long idHabitacion) 
	{
		this.idHabitacion = idHabitacion;
	}
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "ReservaHabitacion [idReserva=" + idReserva + ", idHabitacion=" + idHabitacion + "]";
	}
}
