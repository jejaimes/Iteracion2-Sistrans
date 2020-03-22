package iteracion2.Alohandes.negocio;

/**
 * Interfaz para los métodos get de INMUEBLETIEMPOOCUPADA.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 */
public interface VOInmuebleTiempoOcupada
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El idInmueble
	 */
	public long getIdInmueble();

	/**
	 * @return El idTiempo
	 */
	public long getIdTiempo();
	
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();
	
}