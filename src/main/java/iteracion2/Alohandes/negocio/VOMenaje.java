package iteracion2.Alohandes.negocio;

/**
 * Interfaz para los métodos get de MENAJE.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 */
public interface VOMenaje
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El nombre del menaje
	 */
	public String getNombre();

	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();
	
}