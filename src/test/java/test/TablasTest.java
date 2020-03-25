
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import iteracion2.Alohandes.negocio.ALOHANDES;
import iteracion2.Alohandes.negocio.Alojamiento;
import iteracion2.Alohandes.negocio.Cliente;
import iteracion2.Alohandes.negocio.Reserva;
import iteracion2.Alohandes.negocio.VOAlojamiento;
import iteracion2.Alohandes.negocio.VOHabitacionServicio;

/**
 * Clase con los métdos de prueba de funcionalidad sobre TIPOBEBIDA
 * @author Germán Bravo
 *
 */
public class TablasTest
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(TablasTest.class.getName());
	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos: La unidad de persistencia existe y el esquema de la BD también
	 */
	private static final String CONFIG_TABLAS_A = "./src/main/resources/config/TablasBD.json"; 
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
    /**
     * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
     */
    private JsonObject tableConfig;
    
	/**
	 * La clase que se quiere probar
	 */
    private ALOHANDES alohandes;
	
    /* ****************************************************************
	 * 			Métodos de prueba para la tabla TipoBebida - Creación y borrado
	 *****************************************************************/
	/**
	 * Método que prueba las operaciones sobre la tabla TipoBebida
	 * 1. Adicionar un tipo de bebida
	 * 2. Listar el contenido de la tabla con 0, 1 y 2 registros insertados
	 * 3. Borrar un tipo de bebida por su identificador
	 * 4. Borrar un tipo de bebida por su nombre
	 */
    @Test
	public void CRDTipoBebidaTest() 
	{
    	// Probar primero la conexión a la base de datos
		try
		{
			log.info ("Probando las operaciones CRD sobre TipoBebida");
			alohandes = new ALOHANDES (openConfig (CONFIG_TABLAS_A));
		}
		catch (Exception e)
		{
//			e.printStackTrace();
			log.info ("Prueba de CRD de Tipobebida incompleta. No se pudo conectar a la base de datos !!. La excepción generada es: " + e.getClass ().getName ());
			log.info ("La causa es: " + e.getCause ().toString ());

			String msg = "Prueba de CRD de Tipobebida incompleta. No se pudo conectar a la base de datos !!.\n";
			msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepción";
			System.out.println (msg);
			fail (msg);
		}
		
		// Ahora si se pueden probar las operaciones
    	try
		{
			// Lectura de los tipos de bebida con la tabla vacía
//    		long num = 1;
//			VOAlojamiento lista = alohandes.darAlojamientoId(num);
//			//assertEquals ("No debe haber tipos de bebida creados!!", 1 , lista);
//			System.out.println(lista);
//			
//			List<Alojamiento> lista2 = alohandes.darAlojamientos();
//			System.err.println(lista2.size());
//			for (Alojamiento alojamiento : lista2) {
//				System.err.println(alojamiento);
//			}
			
//			List<Cliente> lista2 = alohandes.darClientes();
//			System.err.println(lista2.size());
//			for (Cliente alojamiento : lista2) {
//				System.err.println(alojamiento);
//			}
    		
//			System.out.println("Ahora a borrar");
//			long aux = alohandes.eliminarAlojamiento(2);
//			System.out.println(aux);
//			List<Alojamiento> lista3 = alohandes.darAlojamientos();
//			System.err.println(lista3.size());
			
//			@SuppressWarnings("deprecation")
//			Timestamp fechaLlegada = new Timestamp(120, 3-1, 28, 0,0,0,0);
//			@SuppressWarnings("deprecation")
//			Timestamp fechaSalida = new Timestamp(120, 5-1, 28, 0,0,0,0);
//			Reserva l = alohandes.adicionarReserva(fechaLlegada, fechaSalida, 1111666666, "CE", 3, 254125);
//			System.out.println(l);
//			System.out.println(alohandes.eliminarReserva(64));
			
			
			// Lectura de los tipos de bebida con un tipo de bebida adicionado
//			@SuppressWarnings("deprecation")
//			int año = 2020-1900;
//			@SuppressWarnings("deprecation")
//			Timestamp fechaLlegada = new Timestamp(120, 3-1, 28, 0,0,0,0);
//			@SuppressWarnings("deprecation")
//			Timestamp fechaSalida = new Timestamp(120, 5-1, 28, 0,0,0,0);
//			Reserva reserva1 = alohandes.adicionarReserva(fechaLlegada, fechaSalida, 1111111111, "TI", 1, 245212);
//			lista = alohandes.darReservas();
//			assertEquals ("Debe haber una reserva creada !!", 1, lista.size ());
//			assertEquals ("El objeto creado y el traido de la BD deben ser iguales !!", reserva1, lista.get (0));
//
//			// Lectura de los tipos de bebida con dos tipos de bebida adicionados
//			String nombreTipoBebida2 = "Cerveza";
//			VOHabitacionServicio tipoBebida2 = alohandes.adicionarTipoBebida (nombreTipoBebida2);
//			lista = alohandes.darVOTiposBebida();
//			assertEquals ("Debe haber dos tipos de bebida creados !!", 2, lista.size ());
//			assertTrue ("El primer tipo de bebida adicionado debe estar en la tabla", tipoBebida1.equals (lista.get (0)) || tipoBebida1.equals (lista.get (1)));
//			assertTrue ("El segundo tipo de bebida adicionado debe estar en la tabla", tipoBebida2.equals (lista.get (0)) || tipoBebida2.equals (lista.get (1)));
//
//			// Prueba de eliminación de un tipo de bebida, dado su identificador
//			long tbEliminados = alohandes.eliminarTipoBebidaPorId (tipoBebida1.getId ());
//			assertEquals ("Debe haberse eliminado un tipo de bebida !!", 1, tbEliminados);
//			lista = alohandes.darVOTiposBebida();
//			assertEquals ("Debe haber un solo tipo de bebida !!", 1, lista.size ());
//			assertFalse ("El primer tipo de bebida adicionado NO debe estar en la tabla", tipoBebida1.equals (lista.get (0)));
//			assertTrue ("El segundo tipo de bebida adicionado debe estar en la tabla", tipoBebida2.equals (lista.get (0)));
//			
//			// Prueba de eliminación de un tipo de bebida, dado su identificador
//			tbEliminados = alohandes.eliminarTipoBebidaPorNombre (nombreTipoBebida2);
//			assertEquals ("Debe haberse eliminado un tipo de bebida !!", 1, tbEliminados);
//			lista = alohandes.darVOTiposBebida();
//			assertEquals ("La tabla debió quedar vacía !!", 0, lista.size ());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			String msg = "Error en la ejecución de las pruebas de operaciones sobre la tabla TipoBebida.\n";
			msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepción";
			System.out.println (msg);

    		fail ("Error en las pruebas sobre la tabla TipoBebida");
		}
		finally
		{
//			alohandes.limpiarAlohandes();
    		alohandes.cerrarUnidadPersistencia ();    		
		}
	}
//
//    /**
//     * Método de prueba de la restricción de unicidad sobre el nombre de TipoBebida
//     */
//	@Test
//	public void unicidadTipoBebidaTest() 
//	{
//    	// Probar primero la conexión a la base de datos
//		try
//		{
//			log.info ("Probando la restricción de UNICIDAD del nombre del tipo de bebida");
//			alohandes = new ALOHANDES (openConfig (CONFIG_TABLAS_A));
//		}
//		catch (Exception e)
//		{
////			e.printStackTrace();
//			log.info ("Prueba de UNICIDAD de Tipobebida incompleta. No se pudo conectar a la base de datos !!. La excepción generada es: " + e.getClass ().getName ());
//			log.info ("La causa es: " + e.getCause ().toString ());
//
//			String msg = "Prueba de UNICIDAD de Tipobebida incompleta. No se pudo conectar a la base de datos !!.\n";
//			msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepción";
//			System.out.println (msg);
//			fail (msg);
//		}
//		
//		// Ahora si se pueden probar las operaciones
//		try
//		{
//			// Lectura de los tipos de bebida con la tabla vacía
//			List <VOHabitacionServicio> lista = alohandes.darVOTiposBebida();
//			assertEquals ("No debe haber tipos de bebida creados!!", 0, lista.size ());
//
//			// Lectura de los tipos de bebida con un tipo de bebida adicionado
//			String nombreTipoBebida1 = "Vino tinto";
//			VOHabitacionServicio tipoBebida1 = alohandes.adicionarTipoBebida (nombreTipoBebida1);
//			lista = alohandes.darVOTiposBebida();
//			assertEquals ("Debe haber un tipo de bebida creado !!", 1, lista.size ());
//
//			VOHabitacionServicio tipoBebida2 = alohandes.adicionarTipoBebida (nombreTipoBebida1);
//			assertNull ("No puede adicionar dos tipos de bebida con el mismo nombre !!", tipoBebida2);
//		}
//		catch (Exception e)
//		{
////			e.printStackTrace();
//			String msg = "Error en la ejecución de las pruebas de UNICIDAD sobre la tabla TipoBebida.\n";
//			msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepción";
//			System.out.println (msg);
//
//    		fail ("Error en las pruebas de UNICIDAD sobre la tabla TipoBebida");
//		}    				
//		finally
//		{
//			alohandes.limpiarParranderos ();
//    		alohandes.cerrarUnidadPersistencia ();    		
//		}
//	}
//
//	/* ****************************************************************
//	 * 			Métodos de configuración
//	 *****************************************************************/
    /**
     * Lee datos de configuración para la aplicación, a partir de un archivo JSON o con valores por defecto si hay errores.
     * @param tipo - El tipo de configuración deseada
     * @param archConfig - Archivo Json que contiene la configuración
     * @return Un objeto JSON con la configuración del tipo especificado
     * 			NULL si hay un error en el archivo.
     */
    private JsonObject openConfig (String archConfig)
    {
    	JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración de tablas válido");
		} 
		catch (Exception e)
		{
//			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de tablas válido: ", "TipoBebidaTest", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }	
}
