
package iteracion2.Alohandes.negocio;

import java.sql.Timestamp;

/**
 * Clase para modelar la relacion INMUEBLETIEMPOOCUPADA del negocio de ALOHANDES
 * 
 */
public class InmuebleTiempoOcupada implements VOInmuebleTiempoOcupada
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El idInmueble
	 */
	private long idInmueble;

	/**
	 * El idTiempo
	 */
	private long idTiempo;
	

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public InmuebleTiempoOcupada() 
	{
		this.idInmueble = 0;
		this.idTiempo = 0;
	}

	/**
	 * Constructor con valores
	 * @param idInmueble
	 * @param idTiempo
	 */
	public InmuebleTiempoOcupada(long idInmueble, long idTiempo) {
		this.idInmueble = idInmueble;
		this.idTiempo = idTiempo;
	}


	/**
	 * @return El idInmueble
	 */
	public long getIdInmueble() {
		return idInmueble;
	}

	/**
	 * @param El nuevo idInmueble
	 */
	public void setIdInmueble(long idInmueble) {
		this.idInmueble = idInmueble;
	}

	/**
	 * @return El idTiempo
	 */
	public long getIdTiempo() {
		return idTiempo;
	}

	/**
	 * @param El nuevo idTiempo
	 */
	public void setIdTiempo(long idTiempo) {
		this.idTiempo = idTiempo;
	}

	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "InmuebleTiempoOcupada [idInmueble=" + idInmueble + ", idTiempo=" + idTiempo + "]";
	}
}