

package iteracion2.Alohandes.negocio;

/**
 * Clase para modelar el concepto ALOJAMIENTO del negocio de ALOHANDES
 */
public class Alojamiento implements VOAlojamiento
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
	}

	/**
	 * Constructor con valores
	 * @param id - El id del alojamiento
	 * @param nombre - La direccion del alojamiento
	 */
    public Alojamiento(long id, String dir) 
    {
    	this.id = id;
		this.direccion = dir;
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
	
	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos del alojamiento
	 */
	public String toString() 
	{
		return "Bar [id=" + id + ", direccion=" + direccion+ "]";
	}
	

}
