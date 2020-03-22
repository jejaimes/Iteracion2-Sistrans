package iteracion2.Alohandes.negocio;

/**
 * Interfaz para los métodos get de EMPRESA.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 */
public interface VOEmpresa 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El IDALOJAMIENTO
	 */
	public long getIdAlojamiento();

	/**
	 * @return El nombre de la empresa
	 */
	public String getNombre();
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();
	
}
