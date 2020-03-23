package iteracion2.Alohandes.negocio;

/**
* Clase para modelar el concepto PROVEEDOR del negocio de ALOHANDES
*/
public class Proveedor implements VOProveedor
{
	/*****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El nombre del proveedor
	 */
	private String nombre;
	
	/**
	 * Tipo de documento del proveedor
	 */
	private String tipoDocumento;

	/**
	 * Número de documento del proveedor
	 */
	private long numDocumento;
	
	/**
	 * Ganancias del proveedor
	 */
	private long ganancias;

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    /**
     * Constructor por defecto
     */
	public Proveedor()
	{
		this.nombre = "";
		this.tipoDocumento = "";
		this.numDocumento = 0;
		this.ganancias = 0;
	}

	/**
	 * Constructor con valores
	 * @param nombre - El nombre del proveedor
	 * @param tipoDocumento - Tipo de documento del proveedor
	 * @param numDocumento - Número de documento del proveedor
	 * @param ganancias - Ganancias del proveedor
	 */
    public Proveedor(String nombre, String tipoDocumento, long numDocumento, long ganancias)
    {
		this.nombre = nombre;
		this.tipoDocumento = tipoDocumento;
		this.numDocumento = numDocumento;
		this.ganancias = ganancias;
	}

	/**
	 * @return El nombre del proveedor
	 */
	public String getNombre()
	{
		return nombre;
	}

	/**
	 * @param nombre - El nuevo nombre del proveedor
	 */
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	/**
	 * @return Tipo de documento del proveedor
	 */
	public String getTipoDocumento()
	{
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento - El nuevo tipoDocumento del proveedor
	 */
	public void setTipoDocumento(String tipoDocumento)
	{
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return Número de documento del proveedor
	 */
	public long getNumDocumento()
	{
		return numDocumento;
	}

	/**
	 * @param numDocumento - El nuevo numDocumento del proveedor
	 */
	public void setNumDocumento(long numDocumento)
	{
		this.numDocumento = numDocumento;
	}

	/**
	 * @return Las ganancias del proveedor
	 */
	public long getGanancias()
	{
		return ganancias;
	}

	/**
	 * @param ganancias - Las nuevas ganancias del proveedor
	 */
	public void setGanancias(long ganancias)
	{
		this.ganancias = ganancias;
	}
    
	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos del proveedor
	 */
	public String toString()
	{
		return "Proveedor [nombre=" + nombre + ", tipoDocumento=" + tipoDocumento + ", numDocumento=" + numDocumento + ", ganancias=" + ganancias + "]";
	}
}
