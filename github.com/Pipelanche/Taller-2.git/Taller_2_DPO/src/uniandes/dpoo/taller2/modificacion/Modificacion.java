package uniandes.dpoo.taller2.modificacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import uniandes.dpoo.taller2.modelo.Ingrediente;
import uniandes.dpoo.taller2.modelo.ProductoMenu;

public class Modificacion { 
	
	private <Bebida, Bebidas> ArrayList<Bebida> cargarBebidas(File archivoBebidas) throws FileNotFoundException, IOException 
	{
		try (BufferedReader br = new BufferedReader(new FileReader(archivoBebidas)))
		{
			String linea;
			ArrayList<Bebida> bebida = (ArrayList<Bebida>) new ArrayList<Bebidas>();
			while ((linea = br.readLine()) != null) 
			{
				String[] split = linea.split(";");
				Bebida bebidas = new Bebida(split[0],Integer.parseInt(split[1]));
				bebida.add(bebidas);
			}
			return bebida;
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		File bebidas = new File("data/bebidas.txt");
		//if (Pedido pedidoEnCurso equals iniciarPedido)
	}

}
