package uniandes.dpoo.taller2.consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.ArrayList;

import uniandes.dpoo.taller2.modelo.Producto;
//import uniandes.dpoo.taller2.modelo.Ingrediente;
import uniandes.dpoo.taller2.modelo.ProductoMenu;
import uniandes.dpoo.taller2.modelo.Restaurante;
import uniandes.dpoo.taller2.modelo.ProductoAjustado;
import uniandes.dpoo.taller2.modelo.Combo;
import uniandes.dpoo.taller2.modelo.Ingrediente;
import uniandes.dpoo.taller2.modelo.Pedido;

public class Aplicacion
{
	/**
	 * Estas son las clases dedicadas exclusivamente a mediar la interacción con los usuarios
	 */
	
	private Restaurante restaurante = new Restaurante();

	public void ejecutarAplicacion()
	{
		System.out.println("¡Bienvenido a Hamburguesas!\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				cargarDatos();
				if (opcion_seleccionada == 1)
					ejecutarMostrarMenu();
				else if (opcion_seleccionada == 2)
					ejecutarIniciarPedido();
				else if (opcion_seleccionada == 3)
					ejecutarAgregarUnElemento();
				else if (opcion_seleccionada == 4)
					ejecutarCerrarYGuardar();
				else if (opcion_seleccionada == 5)
					ejecutarConsultaPorId();
				else if (opcion_seleccionada == 6)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}

	/**
	 * Muestra al usuario el menú con las opciones para que escoja la siguiente
	 * acción que quiere ejecutar.
	 */
	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Mostrar el menú");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guardar la factura");
		System.out.println("5. Consultar la información de un pedido dado su id");
		System.out.println("6. Salir de la aplicación\n");
	}
	
	private void ejecutarMostrarMenu()
	{
		ArrayList<ProductoMenu> productosMenu = restaurante.getMenuBase();
		System.out.println("Menú: ");
		
		Iterator<ProductoMenu> itr = productosMenu.iterator();
		while (itr.hasNext()) {
			Object element = itr.next();
			String nombre = productosMenu.get((int) element).getNombre();
			int precio = productosMenu.get((int) element).getPrecioBase();
			System.out.println(nombre + " " + precio + ".");
		}
	}
	/**
	 * Inicia el pedido del cliente
	 */
	private void ejecutarIniciarPedido() 
	{
		if (restaurante.getNumeroPedidos() == 0) {
			String nombre = input("Ingrese el nombre de la persona que paga: ");
			String direccion = input("Ingrese su dirección: ");
			restaurante.iniciarPedido(nombre, direccion, Math.random()*30+1);
			System.out.println("¡Pedido creado!");
		}
		}
		

	/**
	 * Agrega un elemento al pedido
	 */
	private void ejecutarAgregarUnElemento()
	{
		if (restaurante.pedidoEnCurso != null) {
			String adicion = input("Ingrese la adición que desea: ");
			//ProductoAjustado add (restaurante.pedidoEnCurso adicion, "");
			}
	}

	/**
	 * Termina el pedido y lo guarda
	 */
	private void ejecutarCerrarYGuardar()
	{
		restaurante.cerrarYGuardarPedido(Math.random()*30+1);}

	/**
	 * Consulta un pedido dado su ID
	 */
	private void ejecutarConsultaPorId()
	{
		double id = Integer.parseInt(input("Ingrese un ID del pedido"));
		Pedido pedido = restaurante.getId(id);
		System.out.println("Nombre del que paga: " + pedido.getNombreCliente());
		System.out.println("Dirección: " + pedido.getDireccionCliente());
		
		Iterator<Producto> itr = pedido.getItemsPedidos().iterator();
		while (itr.hasNext()) {
			Object element = itr.next();
			System.out.println(pedido.getItemsPedidos().get((int) element).getNombre());
		}
	}

	/**
	 * Este método sirve para imprimir un mensaje en la consola pidiéndole
	 * información al usuario y luego leer lo que escriba el usuario.
	 * 
	 * @param mensaje El mensaje que se le mostrará al usuario
	 * @return La cadena de caracteres que el usuario escriba como respuesta.
	 */
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	private void cargarDatos()
	{
		try
		{
			File combos = new File("data/combos.txt");
			File ingredientes = new File("data/ingredientes.txt");
			File menu = new File("data/menu.txt");
			restaurante.cargarInformacionRestaurante(ingredientes, menu, combos);
		}
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo.");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Este es el método principal de la aplicación, con el que inicia la ejecución
	 * de la aplicación
	 * 
	 * @param args Parámetros introducidos en la línea de comandos al invocar la
	 *             aplicación
	 */
	public static void main(String[] args)
	{
		Aplicacion aplicacion = new Aplicacion();
		aplicacion.ejecutarAplicacion();
	}

}