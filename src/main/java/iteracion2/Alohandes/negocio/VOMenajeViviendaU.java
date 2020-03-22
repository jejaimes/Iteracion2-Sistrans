package iteracion2.Alohandes.negocio;

/**
 * Interfaz para los métodos get de MenajeViviendaU.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 */
public interface VOMenajeViviendaU
{
	/*****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * @return El id de la vivienda universitaria
	 */
	public long getIdViviendaU();

	/**
	 * @return El nombre del menaje
	 */
	public String getMenaje();
	
	/**
	 * @return La cantidad del menaje
	 */
	public int getCantidad();
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();
}
