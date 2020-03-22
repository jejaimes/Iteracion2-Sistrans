package iteracion2.Alohandes.negocio;

/**
 * Clase para modelar el concepto Servicio de AlohAndes
 *
 */
public class Servicio implements VOServicio
{
	/*****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El nombre del servicio
	 */
	private String nombre;

	/**
	 * La descripción del servicio
	 */
	private String descripcion;

	/*****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Servicio() 
	{
		this.nombre = "";
		this.descripcion = "";
	}

	/**
	 * Constructor con valores
	 * @param nombre - El nombre del servicio
	 * @param descripcion - La descripción del servicio
	 */
	public Servicio(String nombre, String descripcion) 
	{
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	/**
	 * @return El nombre del servicio
	 */
	public String getNombre()
	{
		return nombre;
	}

	/**
	 * @param nombre - El nuevo nombre del servicio
	 */
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	/**
	 * @return La descripción del servicio
	 */
	public String getDescripion()
	{
		return descripcion;
	}

	/**
	 * @param descripcion - La nueva descripción del servicio
	 */
	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "Servicio [nombre=" + nombre + ", descripción=" + descripcion + "]";
	}
}