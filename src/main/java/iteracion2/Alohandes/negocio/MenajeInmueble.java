package iteracion2.Alohandes.negocio;

/**
 * Clase para modelar el concepto MenajeInmueble de AlohAndes
 *
 */
public class MenajeInmueble implements VOMenajeInmueble
{
	/*****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El id del inmueble
	 */
	private long idInmueble;

	/**
	 * El nombre del menaje
	 */
	private String menaje;
	
	/**
	 * La cantidad del menaje
	 */
	private int cantidad;

	/*****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public MenajeInmueble() 
	{
		this.idInmueble = 0;
		this.menaje = "";
		this.cantidad = 0;
	}

	/**
	 * Constructor con valores
	 * @param idInmueble - El id del inmueble
	 * @param menaje - El nombre del menaje
	 * @param cantidad - La cantidad del menaje
	 */
	public MenajeInmueble(long idInmueble, String menaje, int cantidad) 
	{
		this.idInmueble = idInmueble;
		this.menaje = menaje;
		this.cantidad = cantidad;
	}

	/**
	 * @return El id del inmueble
	 */
	public long getIdInmueble() {
		return idInmueble;
	}

	/**
	 * @param idInmueble El nuevo id del inmueble
	 */
	public void setIdInmueble(long idInmueble) {
		this.idInmueble = idInmueble;
	}

	/**
	 * @return El nombre del menaje
	 */
	public String getMenaje() {
		return menaje;
	}

	/**
	 * @param menaje El nuevo nombre del menaje
	 */
	public void setMenaje(String menaje) {
		this.menaje = menaje;
	}

	/**
	 * @return La cantidad del menaje
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad La nueva cantidad del menaje
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString()
	{
		return "MenajeInmueble [idInmueble=" + idInmueble + ", menaje=" + menaje + ", cantidad=" + cantidad + "]";
	}
}
