package iteracion2.Alohandes.Controller;

import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import iteracion2.Alohandes.negocio.ALOHANDES;
import iteracion2.Alohandes.negocio.Alojamiento;
import iteracion2.Alohandes.negocio.AlojamientosPopulares;
import iteracion2.Alohandes.negocio.Cliente;
import iteracion2.Alohandes.negocio.GananciaProveedor;
import iteracion2.Alohandes.negocio.Reserva;
import iteracion2.Alohandes.negocio.TiempoOcupacion;
import iteracion2.Alohandes.persistencia.PersistenciaAlohandes;



public class Controller {


	/* Instancia del Modelo*/
	private ALOHANDES modelo;

	/* Instancia de la Vista*/
	private AlohandesVIEW view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new AlohandesVIEW();
		modelo = new ALOHANDES();
	}

	public void run() throws JsonIOException, JsonSyntaxException, FileNotFoundException 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				List<Alojamiento> lista2 = modelo.darAlojamientos();
				System.out.println("Hasta el momento hay " + lista2.size() + " alojamientos registrados");
				for (Alojamiento alojamiento : lista2) {
					System.out.println(alojamiento);
				}
				System.out.println("\n");
				break;

			case 2:
				List<Cliente> clientes = modelo.darClientes();
				System.out.println("Hasta el momento hay " + clientes.size() + " clientes registrados");
				for (Cliente alojamiento : clientes) {
					System.out.println(alojamiento);
				}
				System.out.println("\n");
				break;
				
			case 3:
				System.out.println("Ingrese los datos correspondientes a la fecha de llegada al alojamiento: ");
				System.out.println("Ingrese el año");
				int año = lector.nextInt();
				System.out.println("Ingrese el mes (en numero, Ej: Enero sería 01.)");
				int mes = lector.nextInt();
				System.out.println("Ingrese el día");
				int dia = lector.nextInt();
				
				Timestamp fechaLlegada = new Timestamp(año-1900, mes-1, dia, 0,0,0,0);
				
				System.out.println("Ingrese los datos correspondientes a la fecha de salida del alojamiento: ");
				System.out.println("Ingrese el año");
				int año2 = lector.nextInt();
				System.out.println("Ingrese el mes (en numero, Ej: Enero sería 01.)");
				int mes2 = lector.nextInt();
				System.out.println("Ingrese el día");
				int dia2 = lector.nextInt();
				
				Timestamp fechaSalida = new Timestamp(año2-1900, mes2-1, dia2, 0,0,0,0);
				
				System.out.println("Ingrese los datos correspondientes a su usuario (tiene que estar registrado como cliente)");
				System.out.println("Ingrese su tipo de documento (CE, TI, CC)");
				String tipoDoc = lector.next();
				System.out.println("Ingrese su documento");
				long numDoc = lector.nextLong();
				
				System.out.println("Ingrese el ID del alojamiento en el cual se desea hospedar (este debe existir)");
				long idAl = lector.nextLong();
				Reserva l = modelo.adicionarReserva(fechaLlegada, fechaSalida, numDoc, tipoDoc, idAl , 554832);
				if (l != null){
				System.out.println("Los datos de su reserva son:");
				System.out.println(l);}
				else 
					System.out.println("Ocurrió un error y no se pudo ingresar la reserva. Resive los datos ingresados");
				System.out.println("\n");
				
				break;
				
			case 4:
				List<Reserva> lista3 = modelo.darReservas();
				System.out.println("Hasta el momento hay " + lista3.size() + " reserva(s) registradas");
				for (Reserva alojamiento : lista3) {
					System.out.println(alojamiento);
				}
				System.out.println("\n");
				System.out.println("Si desea mayor información sobre el idTiempo, el cual referencia las fechas de estadia, digite 1, de lo contrario digite 0");
					int aux = lector.nextInt();
					if (aux ==1)
					{
						List<TiempoOcupacion> tiempos = modelo.darTiempos();
						System.out.println("Hasta el momento hay " + tiempos.size() + " tiempos registrados");
						for (TiempoOcupacion alojamiento : tiempos) {
							System.out.println(alojamiento);
						}
					}
					else
					{
						
					}
				System.out.println("\n");
				break;
				
				
			case 5:
				System.out.println("Ingrese el ID de la reserva que desea eliminar");
				long idReserva = lector.nextLong();
				long numerito = modelo.eliminarReserva(idReserva);
				if(numerito ==1)	
					System.out.println("su reserva fue eliminada con exito");
				else
					System.out.println("Ocurrió un error a la hora de eliminar su reserva");
				System.out.println("\n");
				break;

			case 6:
				System.out.println("Ingrese el ID del alojamiento que desea eliminar. Recuerde que solo se podrá eliminar el alojamiento si no hay reservas en este.");
				long alojamiento = lector.nextLong();
				long numerito2 = modelo.eliminarAlojamiento(alojamiento);
				if(numerito2 ==1)	
					System.out.println("El alojamiento fue eliminado con exito");
				else
					System.out.println("Ocurrió un error a la hora de eliminar su alojamiento");
				System.out.println("\n");
				break;


			case 7:
				List<GananciaProveedor> lista4 = modelo.gananciaProveedores();
				System.out.println("Hasta el momento " + lista4.size() + " proveedor(es) recibieron dinero este año");
				for (GananciaProveedor ganancia : lista4) {
					System.out.println(ganancia);
				}
				System.out.println("\n");
				break;
				
			case 8:
				List<AlojamientosPopulares> lista5 = modelo.alojamientosPopulares();
				if(lista5.size() == 0)
					System.out.println("No hay ofertas de alojamiento");
				else{
				System.out.println("Las 20 ofertas de alojamiento más populares son:");
				for (AlojamientosPopulares alo : lista5) {
					System.out.println(alo);
				}
				}
				break;
				
			case 9:
				System.out.println("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;

			
			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
