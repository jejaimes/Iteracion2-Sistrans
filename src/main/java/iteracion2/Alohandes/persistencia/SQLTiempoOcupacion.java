package iteracion2.Alohandes.persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.Cliente;
import iteracion2.Alohandes.negocio.TiempoOcupacion;

public class SQLTiempoOcupacion
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
	public SQLTiempoOcupacion (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para crear un tiempo de estadia de la base de datos de Alohandes.
	 * @param pm - El manejador de persistencia
	 * @param id - El id del alojamiento
	 * @return EL número de tuplas eliminadas
	 */
	public long crearTiempoOcupacion (PersistenceManager pm, Timestamp fechaLlegada, Timestamp fechaSalida, long id )
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaTiempoOcupacion() + "(fecha_llegada, fecha_salida, id) values (?, ?, ?)");
        q.setParameters(fechaLlegada, fechaSalida,id);
        return (long) q.executeUnique();
	}
	
	
	public List<TiempoOcupacion> darTiempos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTiempoOcupacion());
		
		List<Object[]> aux = (List<Object[]>) q.executeList();
		List<TiempoOcupacion> lista =  new ArrayList<>();
		for (Object[] datos : aux)
		{
				Timestamp fecha1 = Timestamp.valueOf(datos[0].toString());
				Timestamp fecha2 = Timestamp.valueOf(datos[1].toString());
				long id = ((BigDecimal)datos[2]).longValue();
				lista.add( new TiempoOcupacion(id, fecha1, fecha2));
		}
		return lista;
	}
	
}
