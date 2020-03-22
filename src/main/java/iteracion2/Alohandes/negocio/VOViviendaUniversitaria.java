package iteracion2.Alohandes.negocio;
/**
 * Interfaz para los métodos get de VIVIENDA_UNIVERSITARIA.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 */
public interface VOViviendaUniversitaria {


	/**
	 * @return El id del bebedor
	 */
	public long getId();

	/**
	 * @return Una cadena de caracteres con la información básica de la VIVIENDA_UNIVERSITARIA
	 */
	@Override
	public String toString();

}
