package uniandes.dpoo.taller2.modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Pedido 
{
	// ************************************************************************
	// At
	// ************************************************************************
	
	//private int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> itemsPedidos = new ArrayList<Producto>();
	
	// ************************************************************************
	// Me
	// ************************************************************************
	
	public Pedido(String elNombreCliente, String laDireccionCliente, double idPedido2, ArrayList<Producto> losItemsPedidos) 
	{
		this.nombreCliente = elNombreCliente;
		this.direccionCliente = laDireccionCliente;
		this.idPedido = idPedido2;
		this.itemsPedidos = losItemsPedidos;
	}
	
	/*public int getNumeroPedidos() {
		return numeroPedidos;
	}*/

	
	public int getIdPedido() {
		return this.idPedido;
	}
	
	public String getNombreCliente() {
		return this.nombreCliente;
	}
	
	public String getDireccionCliente() {
		return this.direccionCliente;
	}
	
	public ArrayList<Producto> getItemsPedidos() {
		return this.itemsPedidos;
	}
	
	public void agregarProducto(Producto item) {
		itemsPedidos.add(item);
	}
	
	private int getPrecioNetoPedido()
	{
		Iterator<Producto> itr = itemsPedidos.iterator();
		int total = 0;
		while (itr.hasNext()) {
			Object element = itr.next();
			this.itemsPedidos.get((int) element);
			total += Producto.getPrecio();
		}
		return total;
	}
	
	private int getPrecioIVAPedido() {
		return (int) (getPrecioNetoPedido()*0.19);}
	
	private int getPrecioTotalPedido() {
		return getPrecioNetoPedido() + getPrecioIVAPedido();}
	
	public String generarTextoFactura;
	
	public void guardarFactura(File rutaRegistroFacturas) throws IOException 
	{
		rutaRegistroFacturas.createNewFile();
		FileWriter register = new FileWriter(rutaRegistroFacturas);
		register.write("Hamburguesas S.A.S." + "\n");
		register.write("Factura # " + Integer.toString(idPedido) + "\n");
		register.write("Persona que paga: " + this.nombreCliente + "\n");
		register.write("Dirección: " + this.direccionCliente + "\n");
		register.write("Pedido:" + "\n");
		Iterator<Producto> itr = itemsPedidos.iterator(); 
		while (itr.hasNext()) {
			Object element = itr.next();
			register.write(this.itemsPedidos.get((int) element).generarTextoFactura()+"\n");
		}
		register.write("Valor neto:" + getPrecioNetoPedido() + "\n");
		register.write("IVA:" + getPrecioIVAPedido() +"\n");
		register.write("Valor total a pagar:" + getPrecioTotalPedido() +"\n");
		register.close();
	}
	
}
