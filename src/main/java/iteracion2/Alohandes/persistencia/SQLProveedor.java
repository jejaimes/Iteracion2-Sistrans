package iteracion2.Alohandes.persistencia;


import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.Alojamiento;
import iteracion2.Alohandes.negocio.AlojamientosPopulares;
import iteracion2.Alohandes.negocio.Proveedor;
import iteracion2.Alohandes.negocio.Reserva;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocnumDoca en el paquete de persistencia
 * 
 */
class SQLProveedor
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaAlohandes.SQL;

	/* ****************************************************************
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
	public SQLProveedor (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para crear un Proveedor de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param nombre - nombre del proveedor
	 * @param tipoDoc - tipo de documento del proveedor
	 * @param numDoc - número de documento del proveedor
	 * @param ganancias - ganancias del proveedor
	 * @return El número de tuplas creadas
	 */
	public long crearProveedor (PersistenceManager pm, String nombre, String tipoDoc, long numDoc, int ganancias)
	{
		try{
			Query q = pm.newQuery(SQL, "INSERT INTO "+pp.darTablaProveedor()+" (NOMBRE, TIPO_DOCUMENTO, NUM_DOCUMENTO, GANANCIAS) VALUES ('"+nombre+"','"+tipoDoc+"',"+numDoc+","+ganancias+")" );
			return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar una tupla de Proveedor de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param numDoc - número de documento del proveedor
	 * @param tipo - tipo de documento del proveedor
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarProveedor (PersistenceManager pm, String tipoDoc, long numDoc)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaProveedor () + " WHERE WHERE tipo_documento = ? AND num_documento = ?");
        q.setParameters(tipoDoc,numDoc);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para buscar una tupla de Proveedor de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param numDoc - número de documento del proveedor
	 * @param tipoDoc - tipo de documento del proveedor
	 * @return El número de tuplas eliminadas
	 */
	public long buscarProveedor (PersistenceManager pm, String tipoDoc, long numDoc)
	{
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProveedor () + " WHERE tipo_documento = ? AND num_documento = ?");
        q.setParameters(tipoDoc,numDoc);
        return (long) q.executeUnique();
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todas los Proveedores
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos AlojamientoServicio
	 */
	public List<Proveedor> darProveedors (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaProveedor() );
		q.setResultClass(Proveedor.class);
		return (List<Proveedor>) q.executeList();
	}
}