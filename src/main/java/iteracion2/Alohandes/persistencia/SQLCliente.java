package iteracion2.Alohandes.persistencia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import iteracion2.Alohandes.negocio.Alojamiento;
import iteracion2.Alohandes.negocio.Cliente;

public class SQLCliente
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
	public SQLCliente (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS CLIENTES de la 
	 * base de datos de Alohandes
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos CLIENTE
	 */
	public List<Cliente> darClientes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCliente ());
		
		List<Object[]> aux = (List<Object[]>) q.executeList();
		List<Cliente> lista =  new ArrayList<>();
		for (Object[] datos : aux)
		{
				String nombre = datos[0].toString();
				String tipoPersona = datos[1].toString();
				String tipoDoc = datos[2].toString();
				long numDoc = ((BigDecimal)datos[3]).longValue();
				lista.add( new Cliente(nombre, tipoPersona, tipoDoc, numDoc));
		}
		return lista;
	}
}
