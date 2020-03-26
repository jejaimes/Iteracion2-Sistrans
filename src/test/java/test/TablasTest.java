
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
import iteracion2.Alohandes.negocio.GananciaProveedor;
import iteracion2.Alohandes.negocio.Reserva;
import iteracion2.Alohandes.negocio.VOAlojamiento;
import iteracion2.Alohandes.negocio.VOHabitacionServicio;
import iteracion2.Alohandes.negocio.VOReserva;

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
	public void AgregarYEliminarReserva() 
	{
    	// Probar primero la conexión a la base de datos
		try
		{
			log.info ("Probando agregar una reserva");
			alohandes = new ALOHANDES (openConfig (CONFIG_TABLAS_A));
		}
		catch (Exception e)
		{
//			e.printStackTrace();
			log.info ("Prueba de agregar una reserva incompleta. No se pudo conectar a la base de datos !!. La excepción generada es: " + e.getClass ().getName ());
			log.info ("La causa es: " + e.getCause ().toString ());

			String msg = "Prueba de agregar una reserva incompleta. No se pudo conectar a la base de datos !!.\n";
			msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepción";
			System.out.println (msg);
			fail (msg);
		}
		
		// Ahora si se pueden probar las operaciones
    	try
		{
			// Lectura de las reservas. La tabla está vacía
			List<Reserva> lista = alohandes.darReservas();
			assertEquals ("No debe haber reservas existentes!!", 0 , lista.size());
			
			//Ingresar una reserva
			Timestamp fechaLlegada = new Timestamp(2020-1900, 5-1, 14, 0,0,0,0);
			
			Timestamp fechaSalida = new Timestamp(2020-1900, 11-1, 26, 0,0,0,0);
			
			
			Reserva l = alohandes.adicionarReserva(fechaLlegada, fechaSalida, 3638722, "CE", 1 , 554832);
			lista = alohandes.darReservas();
			assertEquals("No se agregó ninguna reserva!!" ,1, lista.size());
			List<Reserva> lista2 = alohandes.darReservas();
			assertEquals ("Debería haber una reserva existente!!", 1 , lista.size());
			
			//Eliminar una reserva
			alohandes.eliminarReserva(lista2.get(0).getId());
			lista = alohandes.darReservas();
			assertEquals ("Se debió eliminar la reserva!!", 0 , lista.size());

		}
		catch (Exception e)
		{
			e.printStackTrace();
			String msg = "Error en la ejecución de las pruebas de operaciones sobre la tabla.\n";
			msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepción";
			System.out.println (msg);

    		fail ("Error en las pruebas sobre la tabla");
		}
		finally
		{
//			alohandes.limpiarAlohandes();
    		alohandes.cerrarUnidadPersistencia ();    		
		}
	}

    
    @Test
	public void EliminarAlojamiento() 
	{
    	// Probar primero la conexión a la base de datos
		try
		{
			log.info ("Probando eliminar un alojamiento");
			alohandes = new ALOHANDES (openConfig (CONFIG_TABLAS_A));
		}
		catch (Exception e)
		{
//			e.printStackTrace();
			log.info ("Prueba de eliminar un alojamiento incompleta. No se pudo conectar a la base de datos !!. La excepción generada es: " + e.getClass ().getName ());
			log.info ("La causa es: " + e.getCause ().toString ());

			String msg = "Prueba de eliminar un alojamiento incompleta. No se pudo conectar a la base de datos !!.\n";
			msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepción";
			System.out.println (msg);
			fail (msg);
		}
		
		// Ahora si se pueden probar las operaciones
    	try
		{
			// Lectura de los alojamientos. 
			List<Alojamiento> lista = alohandes.darAlojamientos();
			assertEquals ("Debería haber una reserva existente!!", 28 , lista.size());
			
			//Eliminar una reserva
			alohandes.eliminarAlojamiento(28);
			lista = alohandes.darAlojamientos();
			assertEquals ("Se debió eliminar el alojamiento!!", 27 , lista.size());

		}
		catch (Exception e)
		{
			e.printStackTrace();
			String msg = "Error en la ejecución de las pruebas de operaciones sobre la tabla .\n";
			msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepción";
			System.out.println (msg);

    		fail ("Error en las pruebas.");
		}
		finally
		{
//			alohandes.limpiarAlohandes();
    		alohandes.cerrarUnidadPersistencia ();    		
		}
	}  
    
    
    @Test
  	public void verificarRFC1() 
  	{
      	// Probar primero la conexión a la base de datos
  		try
  		{
  			log.info ("Probando el requerimiento funcional de consulta 1");
  			alohandes = new ALOHANDES (openConfig (CONFIG_TABLAS_A));
  		}
  		catch (Exception e)
  		{
//  			e.printStackTrace();
  			log.info ("Prueba de el requerimiento funcional de consulta 1 incompleta. No se pudo conectar a la base de datos !!. La excepción generada es: " + e.getClass ().getName ());
  			log.info ("La causa es: " + e.getCause ().toString ());

  			String msg = "Prueba de el requerimiento funcional de consulta 1 incompleta. No se pudo conectar a la base de datos !!.\n";
  			msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepción";
  			System.out.println (msg);
  			fail (msg);
  		}
  		
  		// Ahora si se pueden probar las operaciones
      	try
  		{
      		Timestamp fechaLlegada = new Timestamp(2020-1900, 5-1, 14, 0,0,0,0);
			
			Timestamp fechaSalida = new Timestamp(2020-1900, 11-1, 26, 0,0,0,0);
			
			
			Reserva l = alohandes.adicionarReserva(fechaLlegada, fechaSalida, 3638722, "CE", 1 , 554832);
			List<GananciaProveedor> lis = alohandes.gananciaProveedores();
			assertEquals ("Debe haber un único proveedor con ingresos!!", 1 , lis.size());
			assertEquals ("Debe haber un único proveedor con ingresos!!", 554832 , lis.get(0).getGanancia());
			alohandes.eliminarReserva(alohandes.darReservas().get(0).getId());
			

  		}
  		catch (Exception e)
  		{
  			e.printStackTrace();
  			String msg = "Error en la ejecución de las pruebas de operaciones sobre la tabla.\n";
  			msg += "Revise el log de parranderos y el de datanucleus para conocer el detalle de la excepción";
  			System.out.println (msg);

      		fail ("Error en las pruebas.");
  		}
  		finally
  		{
//  			alohandes.limpiarAlohandes();
      		alohandes.cerrarUnidadPersistencia ();    		
  		}
  	}  
    
    
    
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
