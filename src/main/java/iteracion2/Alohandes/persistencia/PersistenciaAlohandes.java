package iteracion2.Alohandes.persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import iteracion2.Alohandes.negocio.Alojamiento;
import iteracion2.Alohandes.negocio.AlojamientoServicio;
import iteracion2.Alohandes.negocio.AlojamientosPopulares;
import iteracion2.Alohandes.negocio.Cliente;
import iteracion2.Alohandes.negocio.Empresa;
import iteracion2.Alohandes.negocio.GananciaProveedor;
import iteracion2.Alohandes.negocio.Habitacion;
import iteracion2.Alohandes.negocio.HabitacionServicio;
import iteracion2.Alohandes.negocio.HabitacionTiempoOcupada;
import iteracion2.Alohandes.negocio.Reserva;
import iteracion2.Alohandes.negocio.TiempoOcupacion;

/**
 * Clase para el manejador de persistencia del proyecto alohandes
 * 
 */
public class PersistenciaAlohandes 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(PersistenciaAlohandes.class.getName());
	
	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Atributo privado que es el único objeto de la clase - Patrón SINGLETON
	 */
	private static PersistenciaAlohandes instance;
	
	/**
	 * Fábrica de Manejadores de persistencia, para el manejo correcto de las transacciones
	 */
	private PersistenceManagerFactory pmf;
	
	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su orden:
	 * Secuenciador, alojamiento, alojamientoServicio, cliente, empresa, habitacion, habitacionServicio, habitacionTiempoOcupada, 
	 * hostal, hotel, inmueblePersona, inmuebleTiempoOcupada, menaje, menajeInmueble, menajeviviendaU, reserva, reservaHabitacion,
	 * servicio, tiempoOcupacion, ViviendaUniversitaria.
	 */
	private List <String> tablas;
	
	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaAlohandes
	 */
	private SQLUtil sqlUtil;
	
	/**
	 * Atributo para el acceso a la tabla ALOJAMIENTO de la base de datos
	 */
	private SQLAlojamiento sqlAlojamiento;
	
	/**
	 * Atributo para el acceso a la tabla ALOJAMIENTOSERVICIO de la base de datos
	 */
	private SQLAlojamientoServicio sqlAlojamientoServicio;
	
	/**
	 * Atributo para el acceso a la tabla CLIENTE de la base de datos
	 */
	private SQLCliente sqlCliente;
	
	/**
	 * Atributo para el acceso a la tabla EMPRESA de la base de datos
	 */
	private SQLEmpresa sqlEmpresa;
	
	/**
	 * Atributo para el acceso a la tabla HABITACION de la base de datos
	 */
	private SQLHabitacion sqlHabitacion;
	
	/**
	 * Atributo para el acceso a la tabla HABITACIONSERVICIO de la base de datos
	 */
	private SQLHabitacionServicio sqlHabitacionServicio;
	
	/**
	 * Atributo para el acceso a la tabla HABITACIONTIEMPOOCUPADA de la base de datos
	 */
	private SQLHabitacionTiempoOcupada sqlHabitacionTiempoOcupada;
	
	private SQLProveedor sqlProveedor;
	
	/**
	 * Atributo para el acceso a la tabla HOSTAL de la base de datos
	 */
	private SQLHostal sqlHostal;
	
	/**
	 * Atributo para el acceso a la tabla HOTEL de la base de datos
	 */
	private SQLHotel sqlHotel;
	
	/**
	 * Atributo para el acceso a la tabla INMUEBLEPERSONA de la base de datos
	 */
	private SQLInmueblePersona sqlInmueblePersona;
	
	/**
	 * Atributo para el acceso a la tabla INMUEBLETIEMPOOCUPADA de la base de datos
	 */
	private SQLInmuebleTiempoOcupada sqlInmuebleTiempoOcupada;
	
	/**
	 * Atributo para el acceso a la tabla MENAJE de la base de datos
	 */
	private SQLMenaje sqlMenaje;
	
	/**
	 * Atributo para el acceso a la tabla MENAJEINMUEBLE de la base de datos
	 */
	private SQLMenajeInmueble sqlMenajeInmueble;
	
	/**
	 * Atributo para el acceso a la tabla MENAJEVIVIENDAU de la base de datos
	 */
	private SQLMenajeViviendaU sqlMenajeViviendaU;
	
	/**
	 * Atributo para el acceso a la tabla RESERVA de la base de datos
	 */
	private SQLReserva sqlReserva;
	
	/**
	 * Atributo para el acceso a la tabla RESERVAHABITACION de la base de datos
	 */
	private SQLReservaHabitacion sqlReservaHabitacion;
	
	/**
	 * Atributo para el acceso a la tabla SERVICIO de la base de datos
	 */
	private SQLServicio sqlServicio;
	
	/**
	 * Atributo para el acceso a la tabla TIEMPOOCUPACION de la base de datos
	 */
	private SQLTiempoOcupacion sqlTiempoOcupacion;
	
	/**
	 * Atributo para el acceso a la tabla VIVIENDAU de la base de datos
	 */
	private SQLViviendaUniversitaria sqlViviendaUniversitaria;
	
	
	
	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */
	private PersistenciaAlohandes ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("Alohandes");		
		crearClasesSQL ();
		
		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add ("alohandes_sequence");
		tablas.add ("ALOJAMIENTO");
		tablas.add ("ALOJAMIENTO_SERVICIO");
		tablas.add ("CLIENTE");
		tablas.add ("EMPRESA");
		tablas.add ("HABITACION");
		tablas.add ("HABITACION_SERVICIO");
		tablas.add ("HABITACION_TIEMPO_OCUPADA");
		tablas.add ("HOSTAL");
		tablas.add ("HOTEL");
		tablas.add ("INMUEBLE_PERSONA");
		tablas.add ("INMUEBLE_TIEMPO_OCUPADA");
		tablas.add ("MENAJE");
		tablas.add ("MENAJE_INMUEBLE");
		tablas.add ("MENAJE_VIVIENDAU");
		tablas.add ("PROVEEDOR");
		tablas.add ("RESERVA");
		tablas.add ("RESERVA_HABITACION");
		tablas.add ("SERVICIO");
		tablas.add ("TIEMPO_OCUPACION");
		tablas.add ("VIVIENDA_UNIVERSITARIA");

}

	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patrón SINGLETON
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de la unidad de persistencia a manejar
	 */
	private PersistenciaAlohandes (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}

	/**
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaAlohandes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaAlohandes ();
		}
		return instance;
	}
	
	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaAlohandes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaAlohandes (tableConfig);
		}
		return instance;
	}

	/**
	 * Cierra la conexión con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	
	

	/**
	 * Crea los atributos de clases de apoyo SQL

	 */
	private void crearClasesSQL() {
		this.sqlUtil = new SQLUtil(this);
		this.sqlAlojamiento = new SQLAlojamiento(this);
		this.sqlAlojamientoServicio = new SQLAlojamientoServicio(this);
		this.sqlCliente = new SQLCliente(this);
		this.sqlEmpresa = new SQLEmpresa(this);
		this.sqlHabitacion = new SQLHabitacion(this);
		this.sqlHabitacionServicio = new SQLHabitacionServicio(this);
		this.sqlHabitacionTiempoOcupada = new SQLHabitacionTiempoOcupada(this);
		this.sqlHostal = new SQLHostal(this);
		this.sqlHotel = new SQLHotel(this);
		this.sqlInmueblePersona = new SQLInmueblePersona(this);
		this.sqlInmuebleTiempoOcupada = new SQLInmuebleTiempoOcupada(this);
		this.sqlMenaje = new SQLMenaje(this);
		this.sqlMenajeInmueble = new SQLMenajeInmueble(this);
		this.sqlMenajeViviendaU = new SQLMenajeViviendaU(this);
		this.sqlProveedor = new SQLProveedor(this);
		this.sqlReserva = new SQLReserva(this);
		this.sqlReservaHabitacion = new SQLReservaHabitacion(this);
		this.sqlServicio = new SQLServicio(this);
		this.sqlTiempoOcupacion = new SQLTiempoOcupacion(this);
		this.sqlViviendaUniversitaria = new SQLViviendaUniversitaria(this);
	}

	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de parranderos
	 */
	public String darSeqParranderos ()
	{
		return tablas.get (0);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de ALOJAMIENTO de ALOHANDES
	 */
	public String darTablaAlojamiento ()
	{
		return tablas.get (1);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de ALOJAMIENTO_SERVICIO de ALOHANDES
	 */
	public String darTablaAlojamientoServicio ()
	{
		return tablas.get (2);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de CLIENTE de ALOHANDES
	 */
	public String darTablaCliente ()
	{
		return tablas.get (3);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de EMPRESA de ALOHANDES
	 */
	public String darTablaEmpresa ()
	{
		return tablas.get (4);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de HABITACION de ALOHANDES
	 */
	public String darTablaHabitacion ()
	{
		return tablas.get (5);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de HABITACION_SERVICIO de ALOHANDES
	 */
	public String darTablaHabitacionServicio ()
	{
		return tablas.get (6);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de HABITACION_TIEMPO_OCUPADA de ALOHANDES
	 */
	public String darTablaHabitacionTiempoOcupada ()
	{
		return tablas.get (7);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de HOSTAL de ALOHANDES
	 */
	public String darTablaHostal ()
	{
		return tablas.get (8);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de HOTEL de ALOHANDES
	 */
	public String darTablaHotel ()
	{
		return tablas.get (9);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de INMUEBLE_PERSONA de ALOHANDES
	 */
	public String darTablaInmueblePersona ()
	{
		return tablas.get (10);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de INMUEBLE_TIEMPO_OCUPADA de ALOHANDES
	 */
	public String darTablaInmuebleTiempoOcupada ()
	{
		return tablas.get (11);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de MENAJE de ALOHANDES
	 */
	public String darTablaMenaje ()
	{
		return tablas.get (12);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de MENAJE_INMUEBLE de ALOHANDES
	 */
	public String darTablaMenajeInmueble ()
	{
		return tablas.get (13);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de MENAJE_VIVIENDAU de ALOHANDES
	 */
	public String darTablaMenajeViviendaU ()
	{
		return tablas.get (14);
	}
	
	public String darTablaProveedor ()
	{
		return tablas.get (15);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de RESERVA de ALOHANDES
	 */
	public String darTablaReserva ()
	{
		return tablas.get (16);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de RESERVA_HABITACION de ALOHANDES
	 */
	public String darTablaReservaHabitacion ()
	{
		return tablas.get (17);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de SERVICIO de ALOHANDES
	 */
	public String darTablaServicio ()
	{
		return tablas.get (18);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de TIEMPO_OCUPACION de ALOHANDES
	 */
	public String darTablaTiempoOcupacion ()
	{
		return tablas.get (19);
	}
	
	/**
	 * @return La cadena de caracteres con el nombre de la tabla de VIVIENDA_UNIVERSITARIA de ALOHANDES
	 */
	public String darTablaViviendaUniversitaria ()
	{
		return tablas.get (20);
	}
	
	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long nextval ()
	{
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        log.trace ("Generando secuencia: " + resp);
        return resp;
    }
	
	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle específico del problema encontrado
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
	 */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}

 
	/* ****************************************************************
	 * 			Métodos para manejar las RESERVAS
	 *****************************************************************/
	public TiempoOcupacion crearTiempo(Timestamp fechaLlegada, Timestamp fechaSalida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();            
            long id = nextval ();
            long tuplasInsertadas = sqlTiempoOcupacion.crearTiempoOcupacion(pm, fechaLlegada, fechaSalida, id);
            tx.commit();
            
            log.trace ("Inserción tiempo: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            return new TiempoOcupacion(id, fechaLlegada, fechaSalida);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla reserva
	 * Adiciona entradas al log de la aplicación
	 * @return El objeto Bebida adicionado. null si ocurre alguna Excepción
	 */
	public Reserva adicionarReserva(Timestamp fechaLlegada, Timestamp fechaSalida, long idCliente, String tipoDocCliente, long idAlojamiento, int costo) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
        	TiempoOcupacion to = crearTiempo(fechaLlegada, fechaSalida);
        	if (to != null){
        		long aux = to.getId();
        	Timestamp t = new Timestamp(System.currentTimeMillis());
            tx.begin();            
            long id = nextval ();
            String estado = "creacion exitosa";
            long tuplasInsertadas = sqlReserva.crearReserva(pm, estado, t, id, idCliente, tipoDocCliente,idAlojamiento, aux,costo);
            tx.commit();
            
            log.trace ("Inserción reserva: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            return new Reserva(estado, t, id, idCliente, tipoDocCliente, idAlojamiento, aux, costo);
        	}
        	else
        		return null;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla reserva, dado el id de la reserva
	 * Adiciona entradas al log de la aplicación
	 * @param id - El id de la reserva
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarReservaPorId (long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlReserva.eliminarReservaPorId(pm, id);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	

	/* ****************************************************************
	 * 			Métodos para manejar los ALOJAMIENTOS
	 *****************************************************************/
	
	

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla ALOJAMIENTO, dado el id del alojamiento
	 * Adiciona entradas al log de la aplicación
	 * @param id - El id del alojamiento
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public long eliminarAlojamientoPorId(long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
        	List<Reserva> reservas = darReservasPorAlojamiento(id);
        	if(reservas.size() == 0){
            tx.begin();
            long resp = sqlAlojamiento.eliminarAlojamientoPorId (pm, id);
            tx.commit();
            return resp;}
        	else
        		return -1;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	
	/**
	 * Método que consulta todas las tuplas en la tabla RESERVA que tienen el ID DEL ALOJAMIENTO dado
	 * @param idAlojamiento - El id del alojamiento
	 * @return La lista de objetos RESERVA, construidos con base en las tuplas de la tabla RESERVA
	 */
	public List<Reserva> darReservasPorAlojamiento (long idAlojamiento) 
	{
		return sqlReserva.verificarReserva (pmf.getPersistenceManager(), idAlojamiento);
	}
	
	/**
	 * RFC2 - Método que retorna los 20 Alojamientos más popolares en Alohandes
	 * @return La lista de objetos AlojamientosPopulares
	 */
	public List<AlojamientosPopulares> alojamientosPopulares ()
	{
		return sqlReserva.alojamientosPopulares(pmf.getPersistenceManager());
	}
	
	/**
	 * 
	 * @return La lista de objetos RESERVA, construidos con base en las tuplas de la tabla RESERVA
	 */
	public List<Reserva> darReservas ()
	{
		return sqlReserva.darReservas(pmf.getPersistenceManager());
	}
	
	/**
	 * RFC1 - Método que retorna la ganancia de cada proveedor durente el año actual y el año pasado
	 * @return La lista de objetos GananciaProveedor
	 */
	public List<GananciaProveedor> gananciaProveedores ()
	{
		return sqlReserva.gananciaProveedores(pmf.getPersistenceManager());
	}
	
	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Alohandes
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @return Un arreglo con 20 números que indican el número de tuplas borradas en las tablas ALOJAMIENTO,
	 * ALOJAMIENTO_SERVICIO, CLIENTE, EMPRESA, HABITACION, HABITACION_SERVICIO, HABITACION_TIEMPO_OCUPADA, 
	 * HOSTAL, HOTEL, INMUEBLE_PERSONA, INMUEBLE_TIEMPO_OCUPADA, MENAJE, MENAJE_INMUEBLE, MENAJE_VIVIENDAU,
	 * RESERVA, RESERVA_HABITACION, SERVICIO, TIEMPO_OCUPACION, VIVIENDA_UNIVERSITARIA, PROVEEDORES respectivamente
	 */
	public long [] limpiarAlohandes ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long [] resp = sqlUtil.limpiarAlohandes(pm);
            tx.commit ();
            log.info ("Borrada la base de datos");
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new long[] {-1, -1, -1, -1, -1, -1, -1};
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}
	
}