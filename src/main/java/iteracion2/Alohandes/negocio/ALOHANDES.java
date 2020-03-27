

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
	public Reserva adicionarReserva (Timestamp fechaLlegada, Timestamp fechaSalida, long idCliente, String tipoDocCliente, long idAlojamiento, int costo)
	{
        log.info ("Adicionando nueva reserva con los datos especificados" );
        Reserva reserva = pp.adicionarReserva(fechaLlegada, fechaSalida, idCliente, tipoDocCliente, idAlojamiento, costo);	
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
	
	/*****************************************************************
	 * 			Métodos para manejar los ALOJAMIENTOS 
	 *****************************************************************/
	
	/**
	 * Adiciona de manera persistente un alojamiento
	 * Adiciona entradas al log de la aplicación
	 * @return El objeto Alojamiento adicionado. null si ocurre alguna Excepción
	 */
	public Alojamiento adicionarAlojamiento (String direccion, long docProv, String tipoDoc)
	{
        log.info ("Adicionando nueva alojamiento con los datos especificados" );
        System.out.println("antes de crear en alohandes");
        Alojamiento alo = pp.adicionarAlojamiento(direccion, docProv, tipoDoc);
        System.out.println("ya deberia estar creado en alohandes");
        log.info ("Adicionando alojamiento: " + alo);
        return alo;
	}
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
	
	
	public List<AlojamientosPopulares> alojamientosPopulares ()
	{
		log.info ("Consultando Alojamientos populares");
        List<AlojamientosPopulares> tiposBebida = pp.alojamientosPopulares();	
        log.info ("Consultando los alojamientos populares: " + tiposBebida.size() );
        return tiposBebida;
	}
	
	public List<Hostal> darHostalesPorServicio (String serv)
	{
		log.info ("Consultando Hostales por servicio");
        List<Hostal> tiposBebida = pp.darHostalesPorServicio(serv);	
        log.info ("Consultando los hostales por servicio: " + tiposBebida.size() );
        return tiposBebida;
	}
	
	public List<Hostal> darHostales ( )
	{
		log.info ("Consultando Hostales ");
        List<Hostal> tiposBebida = pp.darHostales();
        log.info ("Consultando los hostales : " + tiposBebida.size() );
        return tiposBebida;
	}
	
	
	public List<Hotel> darHotelesPorServicio (String serv)
	{
		log.info ("Consultando Hoteles por servicio");
        List<Hotel> tiposBebida = pp.darHotelesPorServicio(serv);	
        log.info ("Consultando los hostales por servicio: " + tiposBebida.size() );
        return tiposBebida;
	}
	
	public List<Hotel> darHoteles ( )
	{
		log.info ("Consultando Hoteles ");
        List<Hotel> tiposBebida = pp.darHoteles();
        log.info ("Consultando los hostales : " + tiposBebida.size() );
        return tiposBebida;
	}
	
	
	public List<Reserva> darReservas ()
	{
		log.info ("Consultando Reservas");
        List<Reserva> tiposBebida = pp.darReservas();	
        log.info ("Consultando las reservas: " + tiposBebida.size()  + " existentes");
        return tiposBebida;
	}
	
	public List<TiempoOcupacion> darTiempos ()
	{
		log.info ("Consultando tiempos de ocupacion");
        List<TiempoOcupacion> tiposBebida = pp.darTiempos();	
        log.info ("Consultando los tiempos: " + tiposBebida.size()  + " existentes");
        return tiposBebida;
	}
	
	public List<Alojamiento> darAlojamientos()
	{
		log.info ("Consultando Alojamientos");
        List<Alojamiento> tiposBebida = pp.darAlojamientos();
        log.info ("Consultando los alojamientos: " + tiposBebida.size() );
        return tiposBebida;
	}
	
	public List<InmueblePersona> darInmueblesPorServicio (String serv)
	{
		log.info ("Consultando Inmuebles por servicio");
        List<InmueblePersona> tiposBebida = pp.darInmueblesPorServicio(serv);
        log.info ("Consultando los Inmuebles por servicio: " + tiposBebida.size() );
        return tiposBebida;
	}
	
	public List<InmueblePersona> darInmueblesPersona ( )
	{
		log.info ("Consultando Inmuebles ");
        List<InmueblePersona> tiposBebida = pp.darInmuebles();
        log.info ("Consultando los Inmuebles : " + tiposBebida.size() );
        return tiposBebida;
	}
	
	public List<Cliente> darClientes()
	{
		log.info ("Consultando Clientes");
        List<Cliente> tiposBebida = pp.darClientes();
        log.info ("Consultando los clientes: " + tiposBebida.size() );
        return tiposBebida;
	}
	public List<GananciaProveedor> gananciaProveedores()
	{
		log.info ("Consultando ganancias");
        List<GananciaProveedor> tiposBebida = pp.gananciaProveedores();
//        System.out.println("Andadndoooooooooooo");
//        System.err.println(tiposBebida.size());
        log.info ("Consultando el numero de proveedores: " + tiposBebida.size() );
        return tiposBebida;
	}
	
	
	public Alojamiento darAlojamientoId(long id)
	{
		log.info ("Consultando Alojamientos");
        Alojamiento tiposBebida = pp.darAlojamientoId(id);
        log.info ("Consultando los alojamientos: " + tiposBebida );
        return tiposBebida;
	}
	
	public long crearHostal(long id_empresa, String horario, String idSuperI, String idCamara)
	{
		log.info ("Creando hostal");
        long numCreados = pp.crearHostal(id_empresa, horario, idSuperI, idCamara);
        log.info ("Hostales creados: " + numCreados );
        return numCreados;
	}
	
	public long [] limpiarAlohandes ()
	{
        log.info ("Limpiando la BD de Parranderos");
        long [] borrrados = pp.limpiarAlohandes();	
        log.info ("Limpiando la BD de Parranderos: Listo!");
        return borrrados;
	}
	
	
}
