package iteracion2.Alohandes.negocio;

/**
 * Interfaz para los métodos get de Alojamiento.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 */
public interface VOAlojamiento 
{
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
     /**
	 * @return El id del alojamiento
	 */
	public long getId();
	
	/**
	 * @return la direccion del alojamiento
	 */
	public String getDireccion();
	
	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos del alojamiento
	 */
	public String toString();

}
