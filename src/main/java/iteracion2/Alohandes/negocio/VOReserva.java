package iteracion2.Alohandes.negocio;

import java.sql.Timestamp;

/**
 * Interfaz para los métodos get de Reserva.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 */
public interface VOReserva
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El estado de la Reserva
	 */
	public String getEstado();

	/**
	 * @return La fecha de la Reserva
	 */
	public Timestamp getFecha();
	
	/**
	 * @return El id de la Reserva
	 */
	public long getId();
	
	/**
	 * @return El número de documento del cliente de la Reserva
	 */
	public long getClienteNumDoc();
	
	/**
	 * @return El tipo de documento del cliente de la Reserva
	 */
	public String getClienteTipoDoc();
	
	/**
	 * @return El id del alojamiento de la Reserva
	 */
	public long getAlojamiento();
	
	/**
	 * @return El id del TiempoOcupacion de la Reserva
	 */
	public long getIdTiempo();
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();
}
