/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package iteracion2.Alohandes.negocio;

/**
 * Interfaz para los métodos get de CLIENTE.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 */
public interface VOCliente 
{
	
	/**
	 * @return El nombre del cliente
	 */
	public String getNombre();
	
	
	/**
	 * @return El tipo_persona del cliente
	 */
	public String getTipoPersona();
	

	/**
	 * @return El tipoDocumento del cliente
	 */
	public String getTipoDocumento();
	
	
	/**
	 * @return El num_documento del cliente
	 */
	public long getNumDocumento();
	
	
	/**
	 * @return Una cadena con la información básica de la bebida
	 */
	@Override
	public String toString();

}
