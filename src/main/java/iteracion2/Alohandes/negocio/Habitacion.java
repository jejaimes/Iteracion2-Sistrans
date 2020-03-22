

package iteracion2.Alohandes.negocio;

/**
 * Clase para modelar la clase HABITACION del negocio de ALOHANDES:
 * 
 */
public class Habitacion implements VOHabitacion
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El id de la habitacion
	 */
	private long id;

	/**
	 * El id de la Empresa
	 */
	private long empresa;

	/**
	 * El numero de la habitacion
	 */
	private int numHabitacion;
	
	/**
	 * El tipo de habitacion
	 */
	private String tipo;
	
	/**
	 * La ubicaión de la habitación
	 */
	private String ubicacion;
	
	/**
	 * La capacidad de la habitación
	 */
	private int capacidad;
	
	/**
	 * Si la habitación es o no compartida
	 */
	private boolean compartida;
	
	/**
	 * El tamanio de la habitacion
	 */
	private int tamanio;
	
	/**
	 * El precio de la habitacion
	 */
	private int precio;

	
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Habitacion () 
	{
		this.id = 0;
		this.empresa = 0;
		this.numHabitacion = 0;
		this.tipo = "";
		this.ubicacion = "";
		this.capacidad = 0;
		this.compartida = false;
		this.tamanio = 0;
		this.precio = 0;
	}
	
	
	
	/**
	 * Constructor con valores
	 * @param id
	 * @param empresa
	 * @param numHabitacion
	 * @param tipo
	 * @param ubicacion
	 * @param capacidad
	 * @param compartida
	 * @param tamanio
	 * @param precio
	 */
	public Habitacion(long id, long empresa, int numHabitacion, String tipo, String ubicacion, int capacidad,
			boolean compartida, int tamanio, int precio) {
		this.id = id;
		this.empresa = empresa;
		this.numHabitacion = numHabitacion;
		this.tipo = tipo;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
		this.compartida = compartida;
		this.tamanio = tamanio;
		this.precio = precio;
	}

	

	/**
	 * @return El id de la habitacion
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param el nuevo id
	 */
	public void setId(long id) {
		this.id = id;
	}



	/**
	 * @return El id de la Empresa
	 */
	public long getEmpresa() {
		return empresa;
	}



	/**
	 * @param 
	 */
	public void setEmpresa(long empresa) {
		this.empresa = empresa;
	}



	/**
	 * @return El numero de la habitacion
	 */
	public int getNumHabitacion() {
		return numHabitacion;
	}



	/**
	 * @param numHabitacion the numHabitacion to set
	 */
	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}



	/**
	 * @return El tipo de habitacion
	 */
	public String getTipo() {
		return tipo;
	}



	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	/**
	 * @return La ubicaión de la habitación
	 */
	public String getUbicacion() {
		return ubicacion;
	}



	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}



	/**
	 * @return La capacidad de la habitación
	 */
	public int getCapacidad() {
		return capacidad;
	}



	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}



	/**
	 * @return Si la habitación es o no compartida
	 */
	public boolean getCompartida() {
		return compartida;
	}



	/**
	 * @param compartida the compartida to set
	 */
	public void setCompartida(boolean compartida) {
		this.compartida = compartida;
	}



	/**
	 * @return El tamaño de la habitacion
	 */
	public int getTamanio() {
		return tamanio;
	}



	/**
	 * @param tamanio the tamanio to set
	 */
	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}



	/**
	 * @return El precio de la habitacion
	 */
	public int getPrecio() {
		return precio;
	}



	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "Habitacion [id=" + id + ", empresaId=" + empresa + ", numeroHabitacion=" + numHabitacion +", tipoHabitacion=" + tipo +", ubicacion=" + ubicacion+", capacidad=" + capacidad + ", compartida=" + compartida +", tamanio=" + tamanio +", precio=" + precio + "]";
	}
}
