package iteracion2.Alohandes.negocio;

/**
 * Clase para modelar el concepto GananciaProveedores del negocio de ALOHANDES
 */
public class GananciaProveedor
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El tipo de documento del proveedor del alojamiento
	 */
	private String proveedorTipoDoc;
	
	/**
	 * El número de documento del proveedor del alojamiento
	 */
	private long proveedorNumDoc;
	
	/**
	 * Ganancia del proveedor en durante el año actual
	 */
	private long ganancia;

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    /**
     * Constructor por defecto
     */
	public GananciaProveedor() 
    {
		this.proveedorTipoDoc = "";
		this.proveedorNumDoc = 0;
		this.ganancia = 0;
	}

	/**
	 * Constructor con valores
	 * @param proveedorTipoDoc - El tipo de documento del proveedor del alojamiento
	 * @param proveedorNumDoc - El número de documento del proveedor del alojamiento
	 * @param ganancia - Ganancia del proveedor en durante el año actual
	 */
	public GananciaProveedor(String proveedorTipoDoc, long proveedorNumDoc, long ganancia)
	{
		this.proveedorTipoDoc = proveedorTipoDoc;
		this.proveedorNumDoc = proveedorNumDoc;
		this.ganancia = ganancia;
	}

    

	/**
	 * @return El proveedorTipoDoc
	 */
	public String getProveedorTipoDoc() {
		return proveedorTipoDoc;
	}

	/**
	 * @param proveedorTipoDoc - El nuevo proveedorTipoDoc
	 */
	public void setProveedorTipoDoc(String proveedorTipoDoc) {
		this.proveedorTipoDoc = proveedorTipoDoc;
	}

	/**
	 * @return El proveedorNumDoc
	 */
	public long getProveedorNumDoc() {
		return proveedorNumDoc;
	}

	/**
	 * @param proveedorNumDoc - El nuevo proveedorNumDoc
	 */
	public void setProveedorNumDoc(long proveedorNumDoc) {
		this.proveedorNumDoc = proveedorNumDoc;
	}

	/**
	 * @return La ganancia
	 */
	public long getGanancia() {
		return ganancia;
	}

	/**
	 * @param ganancia - La nueva ganancia
	 */
	public void setGanancia(long ganancia) {
		this.ganancia = ganancia;
	}

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos
	 */
	public String toString() 
	{
		return "GananciaProveedores [proveedorTipoDoc=" + proveedorTipoDoc + ", proveedorNumDoc=" + proveedorNumDoc + ", ganancia=" + ganancia +"]";
	}

}