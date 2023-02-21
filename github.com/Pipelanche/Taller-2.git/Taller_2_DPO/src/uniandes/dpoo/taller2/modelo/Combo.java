package uniandes.dpoo.taller2.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Combo implements Producto
{
	// ************************************************************************
	// At
	// ************************************************************************
	
	private double descuento;
	private String nombreCombo;
	private ArrayList<ProductoMenu> itemsCombo;
	
	// ************************************************************************
	// Me
	// ************************************************************************
	
	public Combo(String elNombreCombo, double elDescuento, ArrayList<ProductoMenu> losItemsCombo) 
	{
		this.nombreCombo = elNombreCombo;
		this.descuento = elDescuento;
		this.itemsCombo = losItemsCombo;
	}
	
	public void agregarItemACombo(ProductoMenu itemCombo) 
	{
		this.itemsCombo.add(itemCombo);
	}
	
	public int getPrecio() 
	{
		Iterator<ProductoMenu> itr = itemsCombo.iterator();
		int total = 0;
		while (itr.hasNext()) {
			Object element = itr.next();
			total += this.itemsCombo.get((int) element).getPrecioBase();
		}
		return (int) (total*(1-this.descuento));
	}
	
	public String generarTextoFactura() 
	{
		return getNombre() + ":" + Integer.toString(getPrecio());
	}
	
	@Override
	public String getNombre() {
		return this.nombreCombo;
	}
	
}
