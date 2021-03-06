package iteracion2.Alohandes.negocio;

/**
 * Interfaz para los métodos get de HOTEL.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 */
public interface VOHotel
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El idEmpresa
	 */
	public long getIdEmpresa();
	
	/**
	 * @return El id de la superintendencia
	 */
	public String getIdSuperintendencia();
	
	/**
	 * @return El id de la camara
	 */
	public String getIdCamara();
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();
	
}