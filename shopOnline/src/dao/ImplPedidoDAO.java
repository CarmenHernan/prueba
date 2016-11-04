package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import modelo.Pedido;

public class ImplPedidoDAO implements I_DAO<Pedido, Integer>
{

	
	private final String INSERT="INSERT INTO pedido (fechaPedido, fechaEntrega, precioTotal, formaPago, idCliente,horaPedido)"
			+ " VALUES (?,?,?,?,?,?)";	//6elem
	//no va en el orden de la tabla sino en el de las interrogaciones
	
	private final String UPDATE="UPDATE pedido SET fechaPedido=?, fechaEntrega=?, precioTotal=?, formaPago=?, idCliente=?,"
			+ "horaPedido? WHERE idPedido=?";	//7elem
	
	private final String DELETE="DELETE FROM pedido WHERE idPedido=?";	//1elem
	
	private final String GETONE="SELECT fechaPedido, fechaEntrega, precioTotal, formaPago, idCliente,horaPedido FROM pedido"
			+ " WHERE idLibro=?";//1elem
	
	private final String GETALL="SELECT fechaPedido, fechaEntrega, precioTotal, formaPago, idCliente,horaPedido FROM pedido";
	
	
	private Connection con = null;
	
	//Constructor (crea nueva conex.)
	public ImplPedidoDAO()
	{
		con= new ConexionDB().getConnection();
	}
	
	
	//Metodo INSERT SQL
	public void insertar(Pedido pedido) throws DAOException
	{
		PreparedStatement stat=null;
		try
		{
		
			stat=con.prepareStatement(INSERT);
			stat.setDate(1,(Date)pedido.getFechaPedido());
		    stat.setDate(2,(Date)pedido.getFechaEntrega());
			stat.setFloat(3, pedido.getPrecioTotal());
			stat.setString(4,pedido.getFormaPago());
			stat.setInt(5, pedido.getIdCliente());
			stat.setDate(6, (Date)pedido.getHoraPedido());
		
		
	
			if (stat.executeUpdate() != 1) 
				throw new DAOException("Error adding pedido");
		        
		}catch(SQLException e)
		{
			throw new DAOException("Error adding pedido in DAO", e);
			
		}
		finally
		{
			if(stat!=null)
			{
				try
				{
					stat.close();
				}catch(SQLException ex)
				{
					throw new DAOException("Error adding pedido in DAO", ex);
				}
			}
		}
	}
	
	//METODO UPDATE SQL
	public void modificar(Pedido pedido) throws DAOException
	{
		PreparedStatement stat=null;
		try
		{
			stat=con.prepareStatement(INSERT);
			stat.setDate(1,(Date)pedido.getFechaPedido());
		    stat.setDate(2,(Date)pedido.getFechaEntrega());
			stat.setFloat(3, pedido.getPrecioTotal());
			stat.setString(4,pedido.getFormaPago());
			stat.setInt(5, pedido.getIdCliente());
			stat.setDate(6, (Date)pedido.getHoraPedido());
			stat.setInt(7, pedido.getIdPedido());
			
			if (stat.executeUpdate() != 1) 
				throw new DAOException("Error update pedido");
		     
		}catch(SQLException e)
		{
			throw new DAOException("Error update pedido in DAO", e);
		}
		finally
		{
			if(stat!=null)
			{
				try
				{
					stat.close();
				}catch(SQLException ex)
				{
					throw new DAOException("Error update pedido in DAO", ex);
				}
			}
		}
	}
	
	
	//METODO DELETE SQL
	public void eliminarPorId(Integer id) throws DAOException
	{
		PreparedStatement stat=null;
		try
		{
			stat=con.prepareStatement(DELETE);
			stat.setInt(1, id);
					
			if (stat.executeUpdate() != 1) 
				throw new DAOException("Error delete pedido");
			
		}catch(SQLException e)
		{
			throw new DAOException("Error delete pedido in DAO", e);
		}
		finally
		{
			if(stat!=null)
			{
				try
				{
					stat.close();
				}catch(SQLException ex)
				{
					throw new DAOException("Error update pedido in DAO", ex);
				}
			}
		}
	}	
	
	//METODO GETONE SQL
	public Pedido obtenerPorId(Integer id)throws DAOException
	{
		
		PreparedStatement stat=null;
		ResultSet rs=null;
		Pedido pedido=null;
		
		try
		{
			stat=con.prepareStatement(GETONE);
			stat.setInt(1, id);
			rs=stat.executeQuery();
			
			if(rs.next())
				pedido=convertir(rs);
			else
	            throw new DAOException("No se ha encontrado registro");
			
		}catch(SQLException e)
		{
			throw new DAOException("Error delete pedido in DAO", e);
		}
		finally
		{
			if(stat!=null)
			{
				try
				{
					stat.close();
				}catch(SQLException ex)
				{
					throw new DAOException("Error update libro in DAO", ex);
				}
			}
		}
		return(pedido);
	}
	
	//METODO GETALL SQL
	public List<Pedido> obtenerTodos()throws DAOException
	{
		PreparedStatement stat=null;
		ResultSet rs=null;
		List<Pedido> pedidos=new ArrayList<>();
		
		try
		{
			stat=con.prepareStatement(GETALL);
			rs=stat.executeQuery();
			
			if(rs.next())
				pedidos.add(convertir(rs));
			else
	            throw new DAOException("No se ha encontrado registro");
		}
		catch(SQLException e)
		{
			throw new DAOException("Error delete pedido in DAO", e);
		}
		finally
		{
			if(stat!=null)
			{
				try
				{
					stat.close();
				}
				catch(SQLException ex)
				{
					throw new DAOException("Error update pedido in DAO", ex);
				}
			}
		}
		return(pedidos);
		
	}
	
	//Obtiene un objeto Libro a partir del resultado de la query
	public Pedido convertir(ResultSet rs) throws SQLException
	{
		
		//Obtengo atributos a partir de la consulta de la tabla (ResultSet)
		Date fechaPedido=rs.getDate("fechaPedido,");
		Date fechaEntrega=rs.getDate("fechaEntrega");
		Float precioTotal=rs.getFloat("precioTotal");
		String formaPago=rs.getString("formaPago");
	    Integer idCliente=rs.getInt("idCliente");
		Date horaPedido=rs.getDate("horaPedido");
		String isbn=rs.getString("isbn");
		Integer idPedido=rs.getInt("idPedido");
		
		
		//Con los atributos creo el objeto		
		Pedido pedido= new Pedido(idPedido, fechaPedido, fechaEntrega, precioTotal,
				formaPago, idCliente, horaPedido);
		//Retorno el objeto creado
		return(pedido);
	}
	
	
	
	
	

}
