
package iteracion2.Alohandes.negocio;

import java.sql.Timestamp;

/**
 * Clase para modelar la instancia HOSTAL del negocio de ALOHANDES
 * 
 */
public class Hostal extends Empresa implements VOHostal
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El idEmpresa
	 */
	private long idEmpresa;

	/**
	 * El horario de atención del Hostal
	 */
	private String horarioDeAtencion;
	
	/**
	 * El id de la superintendencia
	 */
	private String idSuperintendencia;
	
	/**
	 * El id de la camara
	 */
	private String idCamara;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Hostal() 
	{
		this.idEmpresa = 0;
		this.horarioDeAtencion = "";
		this.idSuperintendencia = "";
		this.idCamara = "";
	}

	

	/**
	 * Constructor con valores
	 * @param idEmpresa
	 * @param horarioDeAtencion
	 * @param idSuperintendencia
	 * @param idCamara
	 */
	public Hostal(long idEmpresa, String horarioDeAtencion, String idSuperintendencia, String idCamara) {
		this.idEmpresa = idEmpresa;
		this.horarioDeAtencion = horarioDeAtencion;
		this.idSuperintendencia = idSuperintendencia;
		this.idCamara = idCamara;
	}



	/**
	 * @return El idEmpresa
	 */
	public long getIdEmpresa() {
		return idEmpresa;
	}



	/**
	 * @param El nuevo idEmpresa
	 */
	public void setIdEmpresa(long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}



	/**
	 * @return El horario de atención del Hostal
	 */
	public String getHorarioDeAtencion() {
		return horarioDeAtencion;
	}



	/**
	 * @param El nuevo horario de atención del Hostal
	 */
	public void setHorarioDeAtencion(String horarioDeAtencion) {
		this.horarioDeAtencion = horarioDeAtencion;
	}



	/**
	 * @return El id de la superintendencia
	 */
	public String getIdSuperintendencia() {
		return idSuperintendencia;
	}



	/**
	 * @param El nuevo id de la superintendencia
	 */
	public void setIdSuperintendencia(String idSuperintendencia) {
		this.idSuperintendencia = idSuperintendencia;
	}



	/**
	 * @return El id de la camara
	 */
	public String getIdCamara() {
		return idCamara;
	}



	/**
	 * @param El nuevo id de la camara
	 */
	public void setIdCamara(String idCamara) {
		this.idCamara = idCamara;
	}



	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString() 
	{
		return "Hostal [idEmpresa=" + idEmpresa + ", HorarioDeAtencion=" + horarioDeAtencion + ", idSuperintendencia=" + idSuperintendencia + ", idCamara=" + idCamara+ "]";
	}
}