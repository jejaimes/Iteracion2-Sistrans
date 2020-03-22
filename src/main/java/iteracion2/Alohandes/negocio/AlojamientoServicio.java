/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package iteracion2.Alohandes.negocio;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase para modelar el concepto ALOJAMIENTOSERVICIO del negocio de ALOHANDES
 *
 * @author Germán Bravo
 */
public class AlojamientoServicio implements VOAlojamientoServicio
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO del alojamiento
	 */
	private long idAlojamiento;	
	
	/**
	 * El nombre del bebedor
	 */
	private String nombreServicio;
	
	/**
	 * La ciudad del bebedor
	 */
	private int costo;
	
	
	/**
	 * Las visitas realizadas por el bebedor. 
	 * Cada visita es una tripleta de objetos [Bar, Timestamp, String], que representan el bar, la fecha 
	 * y el horario en que el bebedor realizó la visita
	 */
	private List<Object []> visitasRealizadas;

	/**
	 * Las bebidas que le gustan el bebedor. 
	 * Cada visita es una pareja de objetos [Bebida, String], que representan la bebida y el nombre del 
	 * tipo de bebida que le gustan al bebedor 
	 */
	private List<Object []> bebidasQueLeGustan;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public AlojamientoServicio() 
	{
		this.idAlojamiento = 0;
		this.nombreServicio = "";
		this.costo = 0;
		visitasRealizadas = new LinkedList<Object []> ();
		bebidasQueLeGustan = new LinkedList<Object []> ();
	}


	public AlojamientoServicio(long id, String nombre, int costo) 
	{
		this.idAlojamiento = id;
		this.nombreServicio = nombre;
		this.costo = costo;
		
		// Estos valores no se conocen en el momento de la construcción 
		visitasRealizadas = new LinkedList<Object []> ();
		bebidasQueLeGustan = new LinkedList<Object []> ();
	}

	/**
	 * @return El id del alojamiento
	 */
	public long getIdAlojamiento() 
	{
		return idAlojamiento;
	}

	/**
	 * @param id - El nuevo id del alojamiento
	 */
	public void setIdalojamiento(long id) 
	{
		this.idAlojamiento = id;
	}

	/**
	 * @return El nombre del servicio
	 */
	public String getNombreServicio() 
	{
		return nombreServicio;
	}

	/**
	 * @param nombre - El nuevo nombre del servicio
	 */
	public void setNombreServicio(String nombre) 
	{
		this.nombreServicio = nombre;
	}

	/**
	 * @return el costo del servicio
	 */
	public int getCosto() 
	{
		return costo;
	}

	/**
	 * @param ciudad - el nuevo costo del servicio
	 */
	public void setCosto(int costo) 
	{
		this.costo = costo;
	}

	/**
	 * @return La lista de visitasRealizadas por el bebedor 
	 */
	public List<Object []> getVisitasRealizadas() 
	{
		return visitasRealizadas;
	}

	/**
	 * @param visitasRealizadas - La nueva lista de visitas del bebedor
	 */
	public void setVisitasRealizadas (List<Object []> visitasRealizadas) 
	{
		this.visitasRealizadas = visitasRealizadas;
	}

	/**
	 * @return Las bebidasQueLeGustan al bebedor
	 */
	public List<Object[]> getBebidasQueLeGustan() 
	{
		return bebidasQueLeGustan;
	}

	/**
	 * @param bebidasQueLeGustan - La nueva lista de bebidas que le gustan al bebedor
	 */
	public void setBebidasQueLeGustan(List<Object[]> bebidasQueLeGustan) 
	{
		this.bebidasQueLeGustan = bebidasQueLeGustan;
	}

	/**
	 * @return Una cadena de caracteres con la información básica del bebedor
	 */
	@Override
	public String toString() 
	{
		return "Bebedor [id=" + idAlojamiento + ", nombre=" + nombreServicio + ", ciudad=" + costo + "]";
	}

	/**
	 * @return Una cadena de caracteres con la información COMPLEtA del bebedor.
	 * Además de la información básica, contiene las visitas realizadas (una por línea) y 
	 * las bebidas que le gustan al bebedor (una por línea)
	 */
	public String toStringCompleto () 
	{
		String resp =  this.toString();
		resp += "\n --- Visitas realizadas\n";
		int i = 1;
		for (Object [] visita : visitasRealizadas)
		{
			Alojamiento bar = (Alojamiento) visita [0];
			Timestamp fecha = (Timestamp) visita [1];
			String horario = (String) visita [2];
			resp += i++ + ". " + "[" +bar.toString() + ", fecha= " + fecha + ", horario= " + horario + "]\n";
		}
		resp += "\n\n --- Bebidas que le gustan\n";
		i = 1;
		for (Object [] gusta : bebidasQueLeGustan)
		{
			Cliente bebida = (Cliente) gusta [0];
			String tipoBebida = (String) gusta [1];
			resp += i++ + ". " + "[" + bebida.toString() + ", Tipo Bebida= " + tipoBebida + "]\n";
		}
		return resp;
	}

}
