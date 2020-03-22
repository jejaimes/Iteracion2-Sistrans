package iteracion2.Alohandes.negocio;

/**
 * Interfaz para los métodos get de HOSTAL.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 */
public interface VOHostal
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El idEmpresa
	 */
	public long getIdEmpresa();

	/**
	 * @return El horario de atención del Hostal
	 */
	public String getHorarioDeAtencion();
	
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