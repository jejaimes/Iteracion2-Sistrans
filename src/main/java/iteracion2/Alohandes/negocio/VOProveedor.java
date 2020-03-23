package iteracion2.Alohandes.negocio;

/**
 * Interfaz para los métodos get de Proveedor.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 */
public interface VOProveedor
{
	/*****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	
	/**
	 * @return El nombre del proveedor
	 */
	public String getNombre();
	
	/**
	 * @return Tipo de documento del proveedor
	 */
	public String getTipoDocumento();
	
	/**
	 * @return Número de documento del proveedor
	 */
	public long getNumDocumento();
	
	/**
	 * @return Las ganancias del proveedor
	 */
	public long getGanancias();
	
	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos del proveedor
	 */
	public String toString();
}
