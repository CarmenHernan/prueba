package dao;

public class DAOFactory 
{
	
	public static ImplLibroDAO crearArticuloDAO()
	{
		return (new ImplLibroDAO());
	}
	
	public static ImplClienteDAO crearClienteDAO()
	{
		return (new ImplClienteDAO());
	}
	
	public static ImplPedidoDAO crearPedidoDAO()
	{
		return (new ImplPedidoDAO());
	}

	public static ImplAutorDAO crearAutorDAO()
	{
		return (new ImplAutorDAO());
	}
	
	public static ImplCategoriaDAO crearCategoriaDAO()
	{
		return (new ImplCategoriaDAO());
	}
	
	public static ImplEditorialDAO crearEditorialDAO()
	{
		return (new ImplEditorialDAO());
	}
	
	public static ImplPrecioDAO crearPrecioDAO()
	{
		return (new ImplPrecioDAO());
	}
	
	public static ImplStockDAO crearStockDAO()
	{
		return (new ImplStockDAO());
	}	
	
	public static void creaDAOImpl(short tipo)
	{
		switch(tipo)
		{
			case 1: crearArticuloDAO();
				break;
			case 2: crearClienteDAO();
				break;
			case 3: crearPedidoDAO();
				break;
			case 4: crearAutorDAO();
				break;
			case 5: crearCategoriaDAO();
				break;
			case 6: crearEditorialDAO();
				break;
			case 7: crearPrecioDAO();
				break;
			case 8: crearStockDAO();
				break;
			
		}
	}

}

