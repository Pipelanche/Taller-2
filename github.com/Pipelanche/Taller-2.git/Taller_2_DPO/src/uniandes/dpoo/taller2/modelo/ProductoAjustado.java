package uniandes.dpoo.taller2.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductoAjustado implements Producto
{
	// ************************************************************************
	// At
	// ************************************************************************
	
	private ProductoMenu base;
	private ArrayList<Ingrediente> adicion;
	private ArrayList<Ingrediente> removed;
	
	// ************************************************************************
	// Me
	// ************************************************************************
	
	public ProductoAjustado(ProductoMenu laBase, ArrayList<Ingrediente> laAdicion, ArrayList<Ingrediente> aRemoved)
	{
		this.base = laBase;
		this.adicion = laAdicion;
		this.removed = aRemoved;
	}

	@Override
	public String getNombre() {
		return this.base.getNombre();
	}

	public int getPrecio() 
	{
		Iterator<Ingrediente> itr = adicion.iterator();
		Iterator<Ingrediente> itr2 = removed.iterator();
		int totalAdded = 0;
		int totalRemoved = 0;
		while (itr.hasNext()) {
			Object element = itr.next();
			totalAdded += this.adicion.get((int) element).getCostoAdicional();
			while (itr2.hasNext()) {
				Object element2 = itr2.next();
				totalRemoved += this.removed.get((int) element2).getCostoAdicional();
			}
		}
		return this.base.getPrecioBase() + totalAdded - totalRemoved;
		}
	
	@Override
	public String generarTextoFactura() 
	{
		String eachAdded = "";
		String eachRemoved = "";
			if (this.adicion.size() > 0 || this.removed.size() > 0) {
			Iterator<Ingrediente> itr = adicion.iterator();
			Iterator<Ingrediente> itr2 = removed.iterator();
			while (itr.hasNext()) {
				Object element = itr.next();
				eachAdded += "adicionado de " + this.adicion.get((int) element).getNombre();
				while (itr2.hasNext()) {
					Object element2 = itr2.next();
					eachRemoved += "sin " + this.removed.get((int) element2).getNombre();
				}
			}
			}
		return this.base.getNombre() + eachAdded + eachRemoved;
	}
}	
