package iteracion2.Alohandes.negocio;

/**
 * Clase para modelar el concepto AlojamientosPopulares del negocio de ALOHANDES
 */
public class AlojamientosPopulares
{
	/* ****************************************************************
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
	 * La direccion del alojamiento
	 */
	private int cantidad;

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    /**
     * Constructor por defecto
     */
	public AlojamientosPopulares() 
    {
    	this.id = 0;
		this.direccion = "";
		this.cantidad = 0;
	}

	/**
	 * Constructor con valores
	 * @param id - El id del alojamiento
	 * @param nombre - La direccion del alojamiento
	 */
    public AlojamientosPopulares(long id, String dir, int cantidad) 
    {
    	this.id = id;
		this.direccion = dir;
		this.cantidad = cantidad;
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
	 * @return la direccion del alojamiento
	 */
	public int getCantidad() 
	{
		return cantidad;
	}
	
	/**
	 * @param nombre El nuevo nombre del bar
	 */
	public void setCantidad(int cantidad) 
	{
		this.cantidad = cantidad;
	}

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos del alojamiento
	 */
	public String toString() 
	{
		return "Alojamientos mas populares [id=" + id + ", direccion=" + direccion + ", cantidad=" + cantidad +"]";
	}

}


