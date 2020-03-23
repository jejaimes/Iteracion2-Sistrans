package iteracion2.Alohandes.persistencia;


import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.Alojamiento;
import iteracion2.Alohandes.negocio.AlojamientosPopulares;
import iteracion2.Alohandes.negocio.Reserva;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 */
class SQLReserva
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
	public SQLReserva (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para eliminar ALOJAMIENTO de la base de datos de Alohandes, por su id
	 * @param pm - El manejador de persistencia
	 * @param id - El id del alojamiento
	 * @return EL número de tuplas eliminadas
	 */
	public long crearReserva (PersistenceManager pm, String estado, Timestamp fecha, long id, long idCliente, String tipoDoc, long alojamiento, long tiempo )
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReserva () + "(estado, fecha, id, cliente_num_doc, cliente_tipo_doc, alojamiento, id_tiempo) values (?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(estado, fecha,id,idCliente, tipoDoc,alojamiento,tiempo);
        return (long) q.executeUnique();
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar ALOJAMIENTO de la base de datos de Alohandes, por su id
	 * @param pm - El manejador de persistencia
	 * @param id - El id del alojamiento
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarReservaPorId (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();
	}
	
	
	public List<Reserva> verificarReserva (PersistenceManager pm, long idAlojamiento)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva () + " WHERE alojamiento = ?");
		q.setResultClass(Reserva.class);
		q.setParameters(idAlojamiento);
		return (List<Reserva>) q.executeList();
	}
	
	public List<AlojamientosPopulares> alojamientosPopulares (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT ID, DIRECCION, CANTIDAD FROM (SELECT COUNT(*) AS CANTIDAD, ALOJAMIENTO AS ID_1 FROM "
				+ pp.darTablaReserva () + " GROUP BY ALOJAMIENTO)"
						+ " JOIN " + pp.darTablaAlojamiento() + " ON ID_1 = ID WHERE ROWNUM <= 20");
		q.setResultClass(AlojamientosPopulares.class);
		return (List<AlojamientosPopulares>) q.executeList();
	}

}