package iteracion2.Alohandes.negocio;

/**
 * Interfaz para los métodos get de HABITACION.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 */
public interface VOHabitacion 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El id de la habitacion
	 */
	public long getId();

	/**
	 * @return El id de la Empresa
	 */
	public long getEmpresa();

	/**
	 * @return El numero de la habitacion
	 */
	public int getNumHabitacion();
	
	/**
	 * @return El tipo de habitacion
	 */
	public String getTipo();
	
	/**
	 * @return La ubicaión de la habitación
	 */
	public String getUbicacion();
	
	/**
	 * @return La capacidad de la habitación
	 */
	public int getCapacidad();
	
	/**
	 * @return Si la habitación es o no compartida
	 */
	public boolean getCompartida();
	
	/**
	 * @return El tamanio de la habitacion
	 */
	public int getTamanio();
	
	/**
	 * @return El precio de la habitacion
	 */
	public int getPrecio();

	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();

}
