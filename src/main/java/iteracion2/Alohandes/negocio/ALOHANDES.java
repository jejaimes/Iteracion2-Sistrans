

package iteracion2.Alohandes.negocio;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import iteracion2.Alohandes.persistencia.PersistenciaAlohandes;

/**
 * Clase principal del negocio
 * Satisface todos los requerimientos funcionales del negocio
 *
 */
public class ALOHANDES 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(ALOHANDES.class.getName());
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaAlohandes pp;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public ALOHANDES ()
	{
		pp = PersistenciaAlohandes.getInstance();
	}
	
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public ALOHANDES (JsonObject tableConfig)
	{
		pp = PersistenciaAlohandes.getInstance (tableConfig);
	}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar las RESERVAS 
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente una reserva
	 * Adiciona entradas al log de la aplicación
	 * @return El objeto Reserva adicionado. null si ocurre alguna Excepción
	 */
	public Reserva adicionarReserva (Timestamp fechaLlegada, Timestamp fechaSalida, long idCliente, String tipoDocCliente, long idAlojamiento)
	{
        log.info ("Adicionando nueva reserva con los datos especificados" );
        Reserva reserva = pp.adicionarReserva(fechaLlegada, fechaSalida, idCliente, tipoDocCliente, idAlojamiento);	
        log.info ("Adicionando reserva: " + reserva);
        return reserva;
	}
	
	/**
	 * Elimina una reserva por su id
	 * Adiciona entradas al log de la aplicación
	 * @param id - El id de la reserva a eliminar
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarReserva (long id)
	{
		log.info ("Eliminando reserva por id: " + id);
        long resp = pp.eliminarReservaPorId (id);		
        log.info ("Eliminando reserva por id: " + resp + " tuplas eliminadas");
        return resp;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar los ALOJAMIENTOS 
	 *****************************************************************/
	/**
	 * Elimina un alojamiento por su id
	 * Adiciona entradas al log de la aplicación
	 * @param id - El id del alojamiento a eliminar
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarAlojamiento (long id)
	{
		log.info ("Eliminando reserva por id: " + id);
        long resp = pp.eliminarAlojamientoPorId (id);		
        log.info ("Eliminando reserva por id: " + resp + " tuplas eliminadas");
        return resp;
	}
	
	
	
}
