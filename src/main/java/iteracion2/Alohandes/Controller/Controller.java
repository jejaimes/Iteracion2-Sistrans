package iteracion2.Alohandes.Controller;

import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.crypto.Cipher;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import iteracion2.Alohandes.negocio.ALOHANDES;
import iteracion2.Alohandes.negocio.Alojamiento;
import iteracion2.Alohandes.negocio.AlojamientosPopulares;
import iteracion2.Alohandes.negocio.Cliente;
import iteracion2.Alohandes.negocio.GananciaProveedor;
import iteracion2.Alohandes.negocio.Hostal;
import iteracion2.Alohandes.negocio.Hotel;
import iteracion2.Alohandes.negocio.InmueblePersona;
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
				int anio = lector.nextInt();
				System.out.println("Ingrese el mes (en numero, Ej: Enero sería 01.)");
				int mes = lector.nextInt();
				System.out.println("Ingrese el día");
				int dia = lector.nextInt();
				
				Timestamp fechaLlegada = new Timestamp(anio-1900, mes-1, dia, 0,0,0,0);
				
				System.out.println("Ingrese los datos correspondientes a la fecha de salida del alojamiento: ");
				System.out.println("Ingrese el año");
				int anio2 = lector.nextInt();
				System.out.println("Ingrese el mes (en numero, Ej: Enero sería 01.)");
				int mes2 = lector.nextInt();
				System.out.println("Ingrese el día");
				int dia2 = lector.nextInt();
				
				Timestamp fechaSalida = new Timestamp(anio2-1900, mes2-1, dia2, 0,0,0,0);
				
				System.out.println("Ingrese los datos correspondientes a su usuario (tiene que estar registrado como cliente)");
				System.out.println("\n");
				System.out.println("Si desea conocer la lista de clientes del sistema, presione 1, de lo contrario presione 0.");
				int auxx = lector.nextInt();
				if(auxx == 1){
					List<Cliente> clientes2 = modelo.darClientes();
					System.out.println("Hasta el momento hay " + clientes2.size() + " clientes registrados");
					for (Cliente alojamiento : clientes2) {
						System.out.println(alojamiento);
					}
				}
				else
				{}
				System.out.println("\n");
				System.out.println("Ingrese su tipo de documento (CE, TI, CC)");
				String tipoDoc = lector.next();
				System.out.println("Ingrese su documento");
				long numDoc = lector.nextLong();
				String aloja = "";
				boolean cierto = true;
				while(cierto){
				System.out.println("A continuación ingrese el tipo de alojamiento en el cual desea hospedarse. Escribalo sin ningún espacio:");
				System.out.println("Escriba: Hostal, Hotel, ViviendaUniversitaria o InmueblePersona. Por favor escriba el alojamiento sin nungún espacio o caracter extra.");
				aloja = lector.next();
				aloja = aloja.toLowerCase();
				aloja = aloja.replace(" ", "");
				
				if(aloja.equals("hostal"))
				{
					boolean activo = true;
					while(activo){
					System.out.println("¿Desea escoger preferencias de Servicios? Escoga 1 para activarlas, 0 para pasar");
					int valor1 = lector.nextInt();
					if(valor1 == 1)
					{
						System.out.println("Ingrese los servicios que desea para su Hostal. Escriba los servicios separados por coma sin espacio entre ellos y mayuscula inicial (Ej:Restaurante,Piscina)");
						System.out.println("Los posibles servicios que puede escoger son:");
						System.out.println("- Restaurante");
						System.out.println("- Piscina");
						System.out.println("- Parqueadero");
						System.out.println("- Internet");
						String serviciosHos = lector.next();
						List<Hostal> hos = modelo.darHostalesPorServicio(serviciosHos);
						if(hos.size()!= 0){
						System.out.println("Hasta el momento hay " + hos.size() + " hostales disponibles con las especificaciones dadas");
						for (Hostal alojamiento : hos) {
							System.out.println(alojamiento);
						}activo = false; cierto = false;}
						else{System.out.println("No hay hostales con las especificaciones recibidas");}
					}
					else {
						System.out.println("Los posibles hostales que puede escoger son:");
						List<Hostal> hos = modelo.darHostales();
						System.out.println("Hasta el momento hay " + hos.size() + " hostales disponibles");
						for (Hostal alojamiento : hos) {
							System.out.println(alojamiento);
						}
						activo = false; cierto = false;
					}
					}
				}
				else if (aloja.equals("hotel"))
				{
					boolean activo = true;
					while(activo){
					System.out.println("¿Desea escoger preferencias de Servicios? Escoga 1 para activarlas, 0 para pasar");
					int valor1 = lector.nextInt();
					if(valor1 == 1)
					{
						System.out.println("Ingrese los servicios que desea para su Hotel. Escriba los servicios separados por coma sin espacio entre ellos y mayuscula inicial (Ej:Restaurante,Piscina)");
						System.out.println("Tenga en cuenta que, por defecto, todos los hoteles tienen atención en portería las 24 horas");
						System.out.println("Los posibles servicios que puede escoger son:");
						System.out.println("- Restaurante");
						System.out.println("- Piscina");
						System.out.println("- Parqueadero");
						System.out.println("- Internet");
						String serviciosHos = lector.next();
						List<Hotel> hos = modelo.darHotelesPorServicio(serviciosHos);
						if(hos.size()!= 0){
						System.out.println("Hasta el momento hay " + hos.size() + " hoteles disponibles con las especificaciones dadas");
						for (Hotel alojamiento : hos) {
							System.out.println(alojamiento);
						} activo = false;cierto = false;
						}
						else{System.out.println("No hay hoteles con las especificaciones recibidas");}
					}
					else {
						System.out.println("Los posibles hoteles que puede escoger son:");
						List<Hostal> hos = modelo.darHostales();
						System.out.println("Hasta el momento hay " + hos.size() + " hostales disponibles");
						for (Hostal alojamiento : hos) {
							System.out.println(alojamiento);
						}activo = false;cierto = false;
					} 
					}
				}
				else if (aloja.equals("viviendauniversitaria"))
				{
					cierto = false;
				}
				else if (aloja.equals("inmueblepersona"))
				{
					boolean activo = true;
					while(activo){
					System.out.println("¿Desea escoger preferencias de Servicios? Escoga 1 para activarlas, 0 para pasar");
					int valor1 = lector.nextInt();
					if(valor1 == 1)
					{
						System.out.println("Ingrese los servicios que desea para su inmueble. Escriba los servicios separados por comas sin ningun espacio y exactamente igual a como están escritos (Ej:Bañera,TVCable,ServiciosPublicos)");
						System.out.println("Los posibles servicios que puede escoger son:");
						System.out.println("- Cocineta");
						System.out.println("- TVCable");
						System.out.println("- Parqueadero");
						System.out.println("- ServiciosPublicos");
						System.out.println("- ServicioDeAseo");
						System.out.println("- Comidas");
						System.out.println("- BañoPrivado");
						System.out.println("- Internet");
						System.out.println("- Bañera");
						String serviciosHos = lector.next();
						List<InmueblePersona> hos = modelo.darInmueblesPorServicio(serviciosHos.toLowerCase());
						if(hos.size()!= 0){
							System.out.println("Hasta el momento hay " + hos.size() + " inmuebles disponibles con las especificaciones dadas");
							for (InmueblePersona alojamiento : hos) {
								System.out.println(alojamiento);
							} activo = false;cierto = false;
							}
							else{System.out.println("No hay hoteles con las especificaciones recibidas");}
					}
					else {
						System.out.println("Los posibles Inmuebles que puede escoger son:");
						List<InmueblePersona> hos = modelo.darInmueblesPersona();
						System.out.println("Hasta el momento hay " + hos.size() + " inmuebles disponibles");
						for (InmueblePersona alojamiento : hos) {
							System.out.println(alojamiento);
						}
						activo = false;cierto = false;
					}
				}}
				else 
					System.out.println("no ingresó un nombre correcto");
				
			}
				Reserva l = null;
				
				if(!aloja.equals("viviendauniversitaria")){
					
				System.out.println("Ingrese el ID del " + aloja + " en el cual se desea hospedar (este debe existir)");
				long idAl = lector.nextLong();
				l = modelo.adicionarReserva(fechaLlegada, fechaSalida, numDoc, tipoDoc, idAl , 554832);
				}
				else{
					l = modelo.adicionarReserva(fechaLlegada, fechaSalida, numDoc, tipoDoc, 23 , 554832);
					}
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
				System.out.println("\n");
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
