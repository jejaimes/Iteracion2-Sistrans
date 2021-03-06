package iteracion2.Alohandes.persistencia;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import iteracion2.Alohandes.negocio.GananciaProveedor;
import iteracion2.Alohandes.negocio.Alojamiento;
import iteracion2.Alohandes.negocio.AlojamientosPopulares;
import iteracion2.Alohandes.negocio.Cliente;
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
	 * @return EL número de tuplas creadas
	 */
	public long crearReserva (PersistenceManager pm, String estado, String fecha, long id, long idCliente, String tipoDoc, long alojamiento, long tiempo, int costo)
	{
		try{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReserva () + "(estado, fecha, id, cliente_num_doc, cliente_tipo_doc, alojamiento, id_tiempo, precio) values"
				+ " ('" + estado +"', '"+ fecha +"',"+ id  + ", " + idCliente+ ", '" + tipoDoc + "', " + alojamiento + ", " + tiempo + ", " + costo + ")" );
		return (long) q.execute();
	} 
	catch (Exception e) {
		e.printStackTrace();
		return -1;
	}
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

	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar las reservas asociadas a un alojamiento dado
	 * @param pm - El manejador de persistencia
	 * @param idAlojamiento - Id del alojamiento
	 * @return Una lista de objetos Reserva
	 */
	public List<Reserva> verificarReserva (PersistenceManager pm, long idAlojamiento)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva () + " WHERE alojamiento = " + idAlojamiento);
		List<Object[]> aux = (List<Object[]>) q.executeList();
		List<Reserva> lista =  new ArrayList<>();
		for (Object[] datos : aux)
		{
			String estado = datos[0].toString();
			Timestamp fecha = Timestamp.valueOf(datos[1].toString());
			long idReserva = ((BigDecimal)datos[2]).longValue();
			long numDoc = ((BigDecimal)datos[3]).longValue();
			String tipoDoc = datos[4].toString();
			long idTiempo = ((BigDecimal)datos[5]).longValue();
			int costo =((BigDecimal)datos[6]).intValue();
			lista.add( new Reserva(estado, fecha, idReserva,numDoc,tipoDoc, idAlojamiento, idTiempo, costo));
		}
		return lista;
	}

	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar los 20 alojamientos más populares
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos AlojamientosPopulares
	 */
	public List<AlojamientosPopulares> alojamientosPopulares (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT ID, DIRECCION, CANTIDAD FROM (SELECT COUNT(*) AS CANTIDAD, ALOJAMIENTO AS ID_1 FROM "
				+ pp.darTablaReserva () + " GROUP BY ALOJAMIENTO)"
				+ " JOIN " + pp.darTablaAlojamiento() + " ON ID_1 = ID WHERE ROWNUM <= 20 ORDER BY CANTIDAD DESC" );
		q.setResultClass(AlojamientosPopulares.class);
		return (List<AlojamientosPopulares>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar todas las reservas
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Reserva
	 */
	public List<Reserva> darReservas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva ());
		List<Object[]> aux = (List<Object[]>) q.executeList();
		List<Reserva> lista =  new ArrayList<>();
		for (Object[] datos : aux)
		{
			String estado = datos[0].toString();
			Timestamp fecha = Timestamp.valueOf(datos[1].toString());
			long idReserva = ((BigDecimal)datos[2]).longValue();
			long numDoc = ((BigDecimal)datos[3]).longValue();
			String tipoDoc = datos[4].toString();
			long idAlojamiento = ((BigDecimal)datos[5]).longValue();
			long idTiempo = ((BigDecimal)datos[6]).longValue();
			int costo =((BigDecimal)datos[7]).intValue();
			lista.add( new Reserva(estado, fecha, idReserva,numDoc,tipoDoc, idAlojamiento, idTiempo, costo));
		}
		return lista;
	}

	/**
	 * Crea y ejecuta la sentencia SQL para seleccionar las ganancias de cada proveedor durante el año actual y el año anterior
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos GananciaProveedor
	 */
	public List<GananciaProveedor> gananciaProveedores (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT PROVEEDOR_TIPO_DOC,PROVEEDOR_NUM_DOC, SUM(RESERVA.PRECIO)" +
									" FROM RESERVA" +
									" INNER JOIN ALOJAMIENTO" +
									" ON RESERVA.ALOJAMIENTO = ALOJAMIENTO.ID" +
									" WHERE FECHA <= sysdate AND FECHA > TRUNC(sysdate,'yyyy')" +
									" GROUP BY PROVEEDOR_TIPO_DOC,PROVEEDOR_NUM_DOC");
		
		List<Object[]> aux = (List<Object[]>) q.executeList();
//		System.out.println(aux.size());
		List<GananciaProveedor> lista =  new ArrayList<>();
		for (Object[] datos : aux)
		{
				String proveedorTipoDoc = datos[0].toString();
				long proveedorNumDoc = ((BigDecimal)datos[1]).longValue();
				long ganancia = ((BigDecimal)datos[2]).longValue();
				lista.add( new GananciaProveedor(proveedorTipoDoc, proveedorNumDoc, ganancia));
		}
		return lista;
	}

}