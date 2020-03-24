package iteracion2.Alohandes.Controller;

public class AlohandesVIEW 
{
	    /**
	     * Metodo constructor
	     */
	    public AlohandesVIEW()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Visualizar lista de alojamientos");
			System.out.println("2. Visualizar lista de clientes");
			System.out.println("3. Agregar una Reserva");
			System.out.println("4. Visualizar lista de Reserva");
			System.out.println("5. Eliminar una Reserva");
			System.out.println("6. Eliminar un Alojamiento");
			System.out.println("7. Mostrar el dinero recibido por cada proveedor");
			System.out.println("8. Mostrar las 20 ofertas mas populares");
			System.out.println("9. Salir");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
}
