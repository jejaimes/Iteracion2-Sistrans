package iteracion2.Alohandes.persistencia;


import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.Alojamiento;
import iteracion2.Alohandes.negocio.Reserva;
import java.math.BigDecimal;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 */
class SQLAlojamiento 
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
	public SQLAlojamiento (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar ALOJAMIENTO de la base de datos de Alohandes, por su id
	 * @param pm - El manejador de persistencia
	 * @param id - El id del alojamiento
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarAlojamientoPorId (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAlojamiento () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para crear ALOJAMIENTO de la base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @param id - id del alojamiento
	 * @param direccion - direccion del alojamiento
	 * @param docProv - número de documento del proveedor del alojamiento
	 * @param tipoDoc - tipo de documento del proveedor del alojamiento
	 * @return El número de tuplas creadas
	 */
	public long crearAlojamiento (PersistenceManager pm, long id, String direccion, long docProv, String tipoDoc)
	{
		try{
			System.out.println("vamos en el sql");
//		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaAlojamiento() + " (direccion,proveedor_num_doc,proveedor_tipo_doc) values"
//				+ " ('" + direccion +"',"+ docProv + ",'" + tipoDoc + "')");
		Query q = pm.newQuery(SQL, "INSERT INTO ALOJAMIENTO (ID,DIRECCION, PROVEEDOR_TIPO_DOC, PROVEEDOR_NUM_DOC) VALUES (1,'cll 132c #44-44','CE',1111611111)");
        return (long) q.execute();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS ALOJAMIENTOS de la 
	 * base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos ALOJAMIENTO
	 */
	public List<Alojamiento> darAlojamientos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAlojamiento ());
		
		List<Object[]> aux = (List<Object[]>) q.executeList();
		List<Alojamiento> lista =  new ArrayList<>();
		for (Object[] datos : aux)
		{
				long id = ((BigDecimal)datos[0]).longValue();
				String direccion = datos[1].toString();
				String tipoDoc = datos[2].toString();
				long idPersona = ((BigDecimal)datos[3]).longValue();
				lista.add( new Alojamiento(id, direccion, tipoDoc, idPersona));
		}
		return lista;
	}
	
	public Alojamiento darAlojamientoId (PersistenceManager pm, long id)
	{
		long i = 1;
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAlojamiento () + " WHERE id = " + id);
		Object o = q.executeUnique();
		if (o == null) return null;
		else{
			Object[] datos = (Object[]) o;
			String direccion = datos[1].toString();
			String tipoDoc = datos[2].toString();
			long idPersona = ((BigDecimal)datos[3]).longValue();
			return new Alojamiento(id, direccion, tipoDoc, idPersona);
		}
	}

	
}
