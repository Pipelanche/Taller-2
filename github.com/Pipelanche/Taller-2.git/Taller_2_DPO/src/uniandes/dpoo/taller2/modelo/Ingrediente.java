package uniandes.dpoo.taller2.modelo;

public class Ingrediente 
{
	// ************************************************************************
	// At
	// ************************************************************************
	
	private String nombre;
	private int costoAdicional;

	// ************************************************************************
	// e
	// ************************************************************************

	public Ingrediente(String elNombre, int elCostoAdicional)	
	{
		this.nombre = elNombre;
		this.costoAdicional = elCostoAdicional;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getCostoAdicional() {
		return costoAdicional;
	}

}
