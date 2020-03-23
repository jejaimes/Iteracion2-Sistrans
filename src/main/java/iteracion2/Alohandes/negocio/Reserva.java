package iteracion2.Alohandes.negocio;

import java.sql.Timestamp;

/**
 * Clase para modelar el concepto Reserva de AlohAndes
 *
 */
public class Reserva implements VOReserva
{
	/*****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El estado de la Reserva
	 */
	private String estado;

	/**
	 * La fecha de la Reserva
	 */
	private Timestamp fecha;
	
	/**
	 * El id de la Reserva
	 */
	private long id;
	
	/**
	 * El número de documento del cliente de la Reserva
	 */
	private long clienteNumDoc;
	
	/**
	 * El tipo de documento del cliente de la Reserva
	 */
	private String clienteTipoDoc;
	
	/**
	 * El id del alojamiento de la Reserva
	 */
	private long alojamiento;
	
	/**
	 * El id del TiempoOcupacion de la Reserva
	 */
	private long idTiempo;
	
	private int costo;

	/*****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Reserva() 
	{
		this.estado = "";
		this.fecha = new Timestamp(0);
		this.id = 0;
		this.clienteNumDoc = 0;
		this.clienteTipoDoc = "";
		this.alojamiento = 0;
		this.idTiempo = 0;
		this.costo = 0;
	}


	/**
	 * Constructor con valores
	 * @param estado - El estado de la Reserva
	 * @param fecha - La fecha de la Reserva
	 * @param id - El id de la Reserva
	 * @param clienteNumDoc - El número de documento del cliente de la Reserva
	 * @param clienteTipoDoc - El tipo de documento del cliente de la Reserva
	 * @param alojamiento - El id del alojamiento de la Reserva
	 * @param idTiempo - El id del TiempoOcupacion de la Reserva
	 */
	public Reserva(String estado, Timestamp fecha, long id, long clienteNumDoc, String clienteTipoDoc, long alojamiento, long idTiempo, int costo) 
	{
		this.estado = estado;
		this.fecha = fecha;
		this.id = id;
		this.clienteNumDoc = clienteNumDoc;
		this.clienteTipoDoc = clienteTipoDoc;
		this.alojamiento = alojamiento;
		this.idTiempo = idTiempo;
		this.costo = costo;
	}

	/**
	 * @return El estado de la Reserva
	 */
	public String getEstado()
	{
		return estado;
	}
	
	/**
	 * @param estado - El nuevo estado de la Reserva
	 */
	public void setEstado(String estado) 
	{
		this.estado = estado;
	}

	/**
	 * @return La fecha de la Reserva
	 */
	public Timestamp getFecha()
	{
		return fecha;
	}
	
	/**
	 * @param fecha - La nueva fecha de la Reserva
	 */
	public void setFecha(Timestamp fecha) 
	{
		this.fecha = fecha;
	}
	
	/**
	 * @return El id de la Reserva
	 */
	public long getId()
	{
		return id;
	}
	
	/**
	 * @param id - El nuevo id de la Reserva
	 */
	public void setId(long id) 
	{
		this.id = id;
	}
	
	/**
	 * @return El número de documento del cliente de la Reserva
	 */
	public long getClienteNumDoc()
	{
		return clienteNumDoc;
	}
	
	/**
	 * @param clienteNumDoc - El nuevo número de documento del cliente de la Reserva
	 */
	public void setClienteNumDoc(long clienteNumDoc) 
	{
		this.clienteNumDoc = clienteNumDoc;
	}
	
	/**
	 * @return El tipo de documento del cliente de la Reserva
	 */
	public String getClienteTipoDoc()
	{
		return clienteTipoDoc;
	}
	
	/**
	 * @param clienteTipoDoc - El nuevo tipo de documento del cliente de la Reserva
	 */
	public void setClienteTipoDoc(String clienteTipoDoc) 
	{
		this.clienteTipoDoc = clienteTipoDoc;
	}
	
	/**
	 * @return El id del alojamiento de la Reserva
	 */
	public long getAlojamiento()
	{
		return alojamiento;
	}
	
	/**
	 * @param alojamiento - El nuevo id del alojamiento de la Reserva
	 */
	public void setAlojamiento(long alojamiento) 
	{
		this.alojamiento = alojamiento;
	}
	
	/**
	 * @return El id del TiempoOcupacion de la Reserva
	 */
	public long getIdTiempo()
	{
		return idTiempo;
	}
	
	/**
	 * @param idTiempo - El nuevo id del TiempoOcupacion de la Reserva
	 */
	public void setIdTiempo(long idTiempo) 
	{
		this.idTiempo = idTiempo;
	}
	
	public int getCosto()
	{
		return costo;
	}
	
	/**
	 * @param idTiempo - El nuevo id del TiempoOcupacion de la Reserva
	 */
	public void setCosto(int Costo) 
	{
		this.costo = Costo;
	}
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString()
	{
		return "Reserva [estado=" + estado + ", fecha=" + fecha + ", id=" + id + ", clienteNumDoc=" + clienteNumDoc + ", clienteTipoDoc=" + clienteTipoDoc + ", alojamiento=" + alojamiento + ", idTiempo=" + idTiempo + ", costo=" + costo+ "]";
	}
	
}
