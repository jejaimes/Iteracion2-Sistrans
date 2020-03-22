package iteracion2.Alohandes.negocio;

/**
 * Clase para modelar el concepto MenajeViviendaU de AlohAndes
 *
 */
public class MenajeViviendaU implements VOMenajeViviendaU
{
	/*****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El id de la vivienda universitaria
	 */
	private long idViviendaU;

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
	public MenajeViviendaU() 
	{
		this.idViviendaU = 0;
		this.menaje = "";
		this.cantidad = 0;
	}

	/**
	 * Constructor con valores
	 * @param idViviendaU - El id de la vivienda universitaria
	 * @param menaje - El nombre del menaje
	 * @param cantidad - La cantidad del menaje
	 */
	public MenajeViviendaU(long idViviendaU, String menaje, int cantidad) 
	{
		this.idViviendaU = idViviendaU;
		this.menaje = menaje;
		this.cantidad = cantidad;
	}

	/**
	 * @return El id de la vivienda universitaria
	 */
	public long getIdViviendaU() {
		return idViviendaU;
	}

	/**
	 * @param idViviendaU El nuevo id de la vivienda universitaria
	 */
	public void setIdViviendaU(long idViviendaU) {
		this.idViviendaU = idViviendaU;
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
		return "MenajeViviendaU [idViviendaU=" + idViviendaU + ", menaje=" + menaje + ", cantidad=" + cantidad + "]";
	}
		
}
