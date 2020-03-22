package iteracion2.Alohandes.negocio;

import java.sql.Timestamp;

/**
 * Clase para modelar el concepto TiempoOcupacion de AlohAndes
 *
 */
public class TiempoOcupacion implements VOTiempoOcupacion
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO del TiempoOcupacion
	 */
	private long id;
	
	/**
	 * La fecha de llegada del TiempoOcupacion
	 */
	private Timestamp fechaLlegada;
	
	/**
	 * La fecha de salida del TiempoOcupacion
	 */
	private Timestamp fechaSalida;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public TiempoOcupacion() 
	{
		this.id = 0;
		this.fechaLlegada = new Timestamp (0);
		this.fechaSalida = new Timestamp (0);
	}

	/**
	 * Constructor con valores
	 * @param id - El id del TiempoOcupacion
	 * @param fechaLlegada - La fecha de llegada del TiempoOcupacion
	 * @param fechaSalida - La fecha de salida del TiempoOcupacion
	 */
	public TiempoOcupacion(long id, Timestamp fechaLlegada, Timestamp fechaSalida) 
	{
		this.id = id;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
	}

	/**
	 * @return El id del TiempoOcupacion
	 */
	public long getId() 
	{
		return id;
	}

	/**
	 * @param id - El nuevo id del TiempoOcupacion 
	 */
	public void setId(long id) 
	{
		this.id = id;
	}
	
	/**
	 * @return La fechaLlegada del TiempoOcupacion
	 */
	public Timestamp getFechaLlegada()
	{
		return this.fechaLlegada;
	}
	
	/**
	 * @param fechaLlegada - La nueva fechaLlegada del TiempoOcupacion
	 */
	public void setFechaLlegada(Timestamp fechaLlegada) 
	{
		this.fechaLlegada = fechaLlegada;
	}


	/**
	 * @return La fechaSalida del TiempoOcupacion
	 */
	public Timestamp getFechaSalida()
	{
		return this.fechaSalida;
	}
	
	/**
	 * @param fechaSalida - La nueva fechaSalida del TiempoOcupacion
	 */
	public void setFechaSalida(Timestamp fechaSalida) 
	{
		this.fechaSalida = fechaSalida;
	}

	/**
	 * @return Una cadena con la información básica del TiempoOcupacion
	 */
	@Override
	public String toString() 
	{
		return "TiempoOcupacion [id=" + id + ", fechaLlegada=" + fechaLlegada + ", fechaSalida=" + fechaSalida + "]";
	}
}