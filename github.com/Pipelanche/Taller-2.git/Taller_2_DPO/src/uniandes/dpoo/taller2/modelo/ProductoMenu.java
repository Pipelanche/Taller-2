package uniandes.dpoo.taller2.modelo;

public class ProductoMenu implements Producto
{
	// ************************************************************************
	// At
	// ************************************************************************
	
	private String nombre;
	private int precioBase;
	
	// ************************************************************************
	// Me
	// ************************************************************************
	
	public ProductoMenu(String elNombre, int elPrecioBase) 
	{
		this.nombre = elNombre;
		this.precioBase = elPrecioBase;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getPrecioBase() {
		return precioBase;
	}
	
	public String generarTextoFactura() 
	{
		return getNombre() + ":" + Integer.toString(Producto.getPrecio());
	}
}
