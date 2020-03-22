package iteracion2.Alohandes.negocio;

/**
 * Clase para modelar el concepto ViviendaUniversitaria del negocio de ALOHANDES
 */
public class ViviendaUniversitaria extends Empresa implements VOViviendaUniversitaria
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de ViviendaUniversitaria
	 */
	private long id;

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    /**
     * Constructor por defecto
     */
	public ViviendaUniversitaria() 
    {
    	this.id = 0;
	}

	/**
	 * Constructor con valores
	 * @param id - El id de ViviendaUniversitaria
	 */
    public ViviendaUniversitaria(long id) 
    {
    	this.id = id;
	}

    /**
	 * @return El id de ViviendaUniversitaria
	 */
	public long getId() 
	{
		return id;
	}
	
	/**
	 * @param id - El nuevo id de ViviendaUniversitaria
	 */
	public void setId(long id) 
	{
		this.id = id;
	}

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos de ViviendaUniversitaria
	 */
	public String toString() 
	{
		return "ViviendaUniversitaria [id=" + id + "]";
	}
	

}
