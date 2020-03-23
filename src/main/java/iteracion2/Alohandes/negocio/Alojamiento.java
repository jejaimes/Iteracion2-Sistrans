

package iteracion2.Alohandes.negocio;

/**
 * Clase para modelar el concepto ALOJAMIENTO del negocio de ALOHANDES
 */
public class Alojamiento implements VOAlojamiento
{
	/*****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de los alojamientos
	 */
	private long id;
	
	/**
	 * La direccion del alojamiento
	 */
	private String direccion;
	
	/**
	 * El número de documento del proveedor del alojamiento
	 */
	private long proveedorNumDoc;
	
	/**
	 * El tipo de documento del proveedor del alojamiento
	 */
	private String proveedorTipoDoc;


	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    /**
     * Constructor por defecto
     */
	public Alojamiento() 
    {
    	this.id = 0;
		this.direccion = "";
		this.proveedorTipoDoc = "";
		this.proveedorNumDoc = 0;
	}

	/**
	 * Constructor con valores
	 * @param id - El id del alojamiento
	 * @param dir - La direccion del alojamiento
	 * @param proveedorTipoDoc - El número de documento del proveedor del alojamiento
	 * @param proveedorNumDoc - El tipo de documento del proveedor del alojamiento
	 */
    public Alojamiento(long id, String dir, String proveedorTipoDoc, long proveedorNumDoc) 
    {
    	this.id = id;
		this.direccion = dir;
		this.proveedorTipoDoc = proveedorTipoDoc;
		this.proveedorNumDoc = proveedorNumDoc;
	}

    /**
	 * @return El id del alojamiento
	 */
	public long getId() 
	{
		return id;
	}
	
	/**
	 * @param id - El nuevo id del alojamiento
	 */
	public void setId(long id) 
	{
		this.id = id;
	}
	
	/**
	 * @return la direccion del alojamiento
	 */
	public String getDireccion() 
	{
		return direccion;
	}
	
	/**
	 * @param nombre El nuevo nombre del bar
	 */
	public void setDireccion(String nombre) 
	{
		this.direccion = nombre;
	}
	
	/**
	 * @return El proveedorNumDoc del proveedor del alojamiento
	 */
	public long getProveedorNumDoc()
	{
		return proveedorNumDoc;
	}

	/**
	 * @param proveedorNumDoc - El nuevo proveedorNumDoc del proveedor del alojamiento
	 */
	public void setProveedorNumDoc(long proveedorNumDoc)
	{
		this.proveedorNumDoc = proveedorNumDoc;
	}

	/**
	 * @return El proveedorTipoDoc del proveedor del alojamiento
	 */
	public String getProveedorTipoDoc()
	{
		return proveedorTipoDoc;
	}

	/**
	 * @param proveedorTipoDoc - El nuevo proveedorTipoDoc del proveedor del alojamiento
	 */
	public void setProveedorTipoDoc(String proveedorTipoDoc)
	{
		this.proveedorTipoDoc = proveedorTipoDoc;
	}

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos del alojamiento
	 */
	public String toString() 
	{
		return "Alojamiento [id=" + id + ", direccion=" + direccion + ", proveedorTipoDoc=" + proveedorTipoDoc + ", proveedorNumDoc=" + proveedorNumDoc + "]";
	}
	

}
