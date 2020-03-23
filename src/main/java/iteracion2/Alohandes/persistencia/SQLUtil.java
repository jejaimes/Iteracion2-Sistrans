package iteracion2.Alohandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

/**
 * Clase que encapsula los métodos sobre varios conceptos que hacen acceso a la base de datos de Alohandes
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 */
class SQLUtil
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
	public SQLUtil (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para obtener un nuevo número de secuencia
	 * @param pm - El manejador de persistencia
	 * @return El número de secuencia generado
	 */
	public long nextval (PersistenceManager pm)
	{
        Query q = pm.newQuery(SQL, "SELECT "+ pp.darSeqParranderos () + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
	}

	/**
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @param pm - El manejador de persistencia
	 * @return Un arreglo con 19 números que indican el número de tuplas borradas en las tablas ALOJAMIENTO,
	 * ALOJAMIENTO_SERVICIO, CLIENTE, EMPRESA, HABITACION, HABITACION_SERVICIO, HABITACION_TIEMPO_OCUPADA, 
	 * HOSTAL, HOTEL, INMUEBLE_PERSONA, INMUEBLE_TIEMPO_OCUPADA, MENAJE, MENAJE_INMUEBLE, MENAJE_VIVIENDAU,
	 * RESERVA, RESERVA_HABITACION, SERVICIO, TIEMPO_OCUPACION, VIVIENDA_UNIVERSITARIA, respectivamente
	 */
	public long [] limpiarAlohandes (PersistenceManager pm)
	{
        Query qAlojamientoServicio = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAlojamientoServicio());          
        Query qHabitacionServicio = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacionServicio());
        Query qHabitacionTiempoOcupada = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacionTiempoOcupada());
        Query qInmuebleTiempoOcupada = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaInmuebleTiempoOcupada());
        Query qMenajeInmueble = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMenajeInmueble());
        Query qMenajeViviendaU = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMenajeViviendaU());
        Query qReservaHabitacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReservaHabitacion());
        Query qHotel = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotel());
        Query qHostal = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHostal());
        Query qViviendaUniversitaria = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaViviendaUniversitaria());
        Query qInmueblePersona = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaInmueblePersona());
        Query qReserva = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva());
        Query qEmpresa = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaEmpresa());
        Query qMenaje = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMenaje());
        Query qHabitacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacion());
        Query qTiempoOcupacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTiempoOcupacion());
        Query qServicio = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio());
        Query qCliente = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCliente());
        Query qAlojamiento = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAlojamiento());

        long alojamientoServicioEliminados = (long) qAlojamientoServicio.executeUnique ();
        long habitacionServicioEliminados = (long) qHabitacionServicio.executeUnique ();
        long habitacionTiempoOcupadaEliminadas = (long) qHabitacionTiempoOcupada.executeUnique ();
        long inmuebleTiempoOcupadaEliminadas = (long) qInmuebleTiempoOcupada.executeUnique ();
        long menajeInmuebleEliminados = (long) qMenajeInmueble.executeUnique ();
        long menajeViviendaUEliminados = (long) qMenajeViviendaU.executeUnique ();
        long reservaHabitacionEliminados = (long) qReservaHabitacion.executeUnique ();
        long hotelEliminados = (long) qHotel.executeUnique ();
        long hostalEliminados = (long) qHostal.executeUnique ();
        long viviendaUniversitariaEliminados = (long) qViviendaUniversitaria.executeUnique ();
        long inmueblePersonaEliminados = (long) qInmueblePersona.executeUnique ();
        long reservaEliminados = (long) qReserva.executeUnique ();
        long empresaEliminados = (long) qEmpresa.executeUnique ();
        long menajeEliminados = (long) qMenaje.executeUnique ();
        long habitacionEliminados = (long) qHabitacion.executeUnique ();
        long tiempoOcupacionEliminados = (long) qTiempoOcupacion.executeUnique ();
        long servicioEliminados = (long) qServicio.executeUnique ();
        long clienteEliminados = (long) qCliente.executeUnique ();
        long alojamientoEliminados = (long) qAlojamiento.executeUnique ();
        
        return new long[] {alojamientoServicioEliminados, habitacionServicioEliminados, habitacionTiempoOcupadaEliminadas,
        		inmuebleTiempoOcupadaEliminadas, menajeInmuebleEliminados, menajeViviendaUEliminados,
        		reservaHabitacionEliminados, hotelEliminados, hostalEliminados, viviendaUniversitariaEliminados,
        		inmueblePersonaEliminados, reservaEliminados, empresaEliminados, menajeEliminados, habitacionEliminados,
        		tiempoOcupacionEliminados, servicioEliminados, clienteEliminados, alojamientoEliminados};
	}

}
