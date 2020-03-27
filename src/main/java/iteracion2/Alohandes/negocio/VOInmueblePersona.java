package iteracion2.Alohandes.negocio;

/**
 * Interfaz para los métodos get de InmueblePersona.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 */
public interface VOInmueblePersona
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El tipo de propietario del inmueble
	 */
	public String getTipoPropietario();
	
	/**
	 * @return El numero de habitaciones del inmueble
	 */
	public int getNumHabitaciones();
	
	/**
	 * @return si el inmueble está o no amoblado
	 */
	public boolean getAmoblado();
	
	/**
	 * @return El tipo de inmueble
	 */
	public String getTipoInmueble();
	
	
	/**
	 * @return El id del alojamiento del inmueble
	 */
	public long getIdAlojamiento();
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();
	
}