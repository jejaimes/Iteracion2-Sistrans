package iteracion2.Alohandes.negocio;

/**
 * Interfaz para los métodos get de Servicio.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 */
public interface VOServicio 
{
	/*****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * @return El nombre del servicio
	 */
	public String getNombre();

	/**
	 * @return La descripción del servicio
	 */
	public String getDescripion();
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();
}