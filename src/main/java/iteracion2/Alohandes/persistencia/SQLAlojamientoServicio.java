package iteracion2.Alohandes.persistencia;
/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto AlojamientoServicio de Alohandes
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 */
public class SQLAlojamientoServicio
{
	/*****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaAlohandes.SQL;

	/*****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaAlohandes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLAlojamientoServicio (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}

}
