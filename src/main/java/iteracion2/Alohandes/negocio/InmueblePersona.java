package iteracion2.Alohandes.negocio;

import java.sql.Timestamp;

/**
 * Clase para modelar la instancia HOSTAL del negocio de ALOHANDES
 * 
 */
public class InmueblePersona extends Alojamiento implements VOInmueblePersona
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El tipo de propietario del inmueble
	 */
	private String tipoPropietario;
	
	/**
	 * El numero de habitaciones del inmueble
	 */
	private int numHabitaciones;
	
	/**
	 * si el inmueble está o no amoblado
	 */
	private boolean amoblado;
	
	/**
	 * El tipo de inmueble
	 */
	private String tipoInmueble;
	

	
	/**
	 * El id del alojamiento del inmueble
	 */
	private long idAlojamiento;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public InmueblePersona() 
	{
		this.tipoPropietario = "";
		this.numHabitaciones = 0;
		this.amoblado = false;
		this.tipoInmueble = "";
		this.idAlojamiento = 0;
	}

	/**
	 * Constructor con valores
	 * @param tipoPropietario
	 * @param numHabitaciones
	 * @param amoblado
	 * @param tipoInmueble
	 * @param precio
	 * @param idAlojamiento
	 */
	public InmueblePersona(String tipoPropietario, int numHabitaciones, boolean amoblado, String tipoInmueble,
			 long idAlojamiento) {
		this.tipoPropietario = tipoPropietario;
		this.numHabitaciones = numHabitaciones;
		this.amoblado = amoblado;
		this.tipoInmueble = tipoInmueble;
		this.idAlojamiento = idAlojamiento;
	}


	/**
	 * @return El tipo de propietario del inmueble
	 */
	public String getTipoPropietario() {
		return tipoPropietario;
	}

	/**
	 * @param El nuevo tipo de propietario del inmueble
	 */
	public void setTipoPropietario(String tipoPropietario) {
		this.tipoPropietario = tipoPropietario;
	}

	/**
	 * @return El numero de habitaciones del inmueble
	 */
	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	/**
	 * @param El nuevo numero de habitaciones del inmueble
	 */
	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	/**
	 * @return si el inmueble está o no amoblado
	 */
	public boolean getAmoblado() {
		return amoblado;
	}

	/**
	 * @param si el inmueble está o no amoblado
	 */
	public void setAmoblado(boolean amoblado) {
		this.amoblado = amoblado;
	}

	/**
	 * @return El tipo de inmueble
	 */
	public String getTipoInmueble() {
		return tipoInmueble;
	}

	/**
	 * @param El nuevo tipo de inmueble
	 */
	public void setTipoInmueble(String tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}

	/**
	 * @return El id del alojamiento del inmueble
	 */
	public long getIdAlojamiento() {
		return idAlojamiento;
	}

	/**
	 * @param El nuevo id del alojamiento del inmueble
	 */
	public void setIdAlojamiento(long idAlojamiento) {
		this.idAlojamiento = idAlojamiento;
	}

	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "InmueblePersona [tipoPropietario=" + tipoPropietario + ", numeroHabitaciones=" + numHabitaciones + ", amoblado=" + amoblado + ", tipoInmueble=" + tipoInmueble+", idAlojamiento=" + idAlojamiento+ "]";
	}
}