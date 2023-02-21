package uniandes.dpoo.taller2.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Restaurante 
{
	public Restaurante() {}
	
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	private static int numeroPedidos = 0;
	
	public Pedido pedidoEnCurso;
		
	public void iniciarPedido(String nombreCliente, String direccionCliente, double idPedido) 
	{
		ArrayList<Producto> itemsPedidos = new ArrayList<Producto>(); 
		pedidoEnCurso = new Pedido(nombreCliente, direccionCliente, idPedido, itemsPedidos);
	}
	
	public void cerrarYGuardarPedido(double idPedido) throws IOException 
	{
		File rutaRegistroFacturas = new File("Facturas/" + Double.toString(idPedido) + ".txt");
		pedidoEnCurso.guardarFactura(rutaRegistroFacturas);
		pedidos.add(pedidoEnCurso);
		numeroPedidos++;
	}
	
	public Pedido getPedidoEnCurso() {
		return getPedidoEnCurso();
	}
	
	public ArrayList<ProductoMenu> getMenuBase() {
		return getMenuBase();
	}
	
	public ArrayList<Ingrediente> getIngredientes() {
		return getIngredientes();
	}
	
	public int getNumeroPedidos(){
		return numeroPedidos;}
	
	
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) throws IOException 
	{
		ArrayList<Ingrediente> ingredientes = cargarIngredientes(archivoIngredientes);
		ArrayList<ProductoMenu> productosMenu = cargarMenu(archivoMenu);
		//ArrayList<Combo> combos = cargarCombos(archivoCombos);
	}
	
	private ArrayList<Ingrediente> cargarIngredientes(File archivoIngredientes) throws FileNotFoundException, IOException 
	{
		try (BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes)))
		{
			String linea;
			ArrayList<Ingrediente> ingrediente = new ArrayList<Ingrediente>();
			while ((linea = br.readLine()) != null) 
			{
				String[] split = linea.split(";");
				Ingrediente ingredientes = new Ingrediente(split[0],Integer.parseInt(split[1]));
				ingrediente.add(ingredientes);
			}
			return ingrediente;
		}
	}
	
	private ArrayList<ProductoMenu> cargarMenu(File archivoMenu) throws IOException 
	{
		try (BufferedReader br = new BufferedReader(new FileReader(archivoMenu)))
		{
		String linea;
		ArrayList<ProductoMenu> productos = new ArrayList<ProductoMenu>();
		while ((linea = br.readLine()) != null) 
		{
			String[] split = linea.split(";");
			ProductoMenu productoMenu = new ProductoMenu(split[0],Integer.parseInt(split[1]));
			productos.add(productoMenu);
		}
		return productos;
		}
	}

	public Pedido getId(double id) {
		return getId(id);
	}
	
	// private ArrayList<Combo> cargarCombos(File archivoCombos) throws IOException 
	
}
