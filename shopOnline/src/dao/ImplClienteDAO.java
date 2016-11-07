package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import modelo.Cliente;

public class ImplClienteDAO implements I_DAO<Cliente, Integer>
{
	
	private final String INSERT="INSERT INTO cliente (nombre, apellido1, apellido2, direccion, ciudad, "
			+ "provincia, pais, codigoPostal, email, telefono1, telefono2, password, fechaNacimeinto, idPedido)"
			+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	//14elem
	
	private final String UPDATE="UPDATE cliente SET nombre=?, apellido1=?, apellido2=?, direccion=?, ciudad=?,"
			+ "provincia=?, pais=?, codigoPostal=?, email=?, telefono1=?, telefono2=?, password=?, "
			+ "fechaNacimiento=?, idPedido=? WHERE idCliente=?";	//15elem
	
	private final String DELETE="DELETE FROM cliente WHERE idCliente=?";	//1elem
	
	private final String GETONE="SELECT idCliente, nombre, apellido1, apellido2, direccion, ciudad, provincia,"
			+ " pais, codigoPostal, email, telefono1, telefono2, password, fechaNacimeinto, idPedido FROM cliente"
			+ " WHERE idCliente=?";//1elem
	
	private final String GETALL="SELECT idCliente, nombre, apellido1, apellido2, direccion, ciudad, provincia,"
			+ " pais, codigoPostal, email, telefono1, telefono2, password, fechaNacimeinto, idPedido FROM cliente";
	
	
	private Connection con = null;
	
	//Constructor (crea nueva conex.)
	public ImplClienteDAO()
	{
		con= new ConexionDB().getConnection();
	}
	
	
	//Metodo INSERT SQL
	public void insertar(Cliente cliente) throws DAOException
	{
		PreparedStatement stat=null;
		try
		{
			stat=con.prepareStatement(INSERT);
			stat.setString(1, cliente.getNombre());
			//el 1 indica el interrogante en la posicion 1 en (?,?,?,?,?,?,?,?,?,?,?,?,?,?)

			stat.setString(2, cliente.getApellido1());
			stat.setString(3, cliente.getApellido2());
			stat.setString(4, cliente.getDireccion());
			stat.setString(5, cliente.getCiudad());
			stat.setString(6, cliente.getProvincia());
			stat.setString(7, cliente.getPais());
			stat.setInt(8, cliente.getCodigoPostal());
			stat.setString(9, cliente.getEmail());
			stat.setInt(10, cliente.getTelefono1());
			stat.setInt(11, cliente.getTelefono2());
			stat.setString(12, cliente.getPassword());
			stat.setDate(13, (Date)cliente.getFechaNacimiento());
			stat.setInt(14, cliente.getIdPedido());
			
			if (stat.executeUpdate() != 1) 
				throw new DAOException("Error adding cliente");
		        
		}catch(SQLException e)
		{
			throw new DAOException("Error adding cliente in DAO", e);
			
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
					throw new DAOException("Error adding cliente in DAO", ex);
				}
			}
		}
	}
	
	//METODO UPDATE SQL
	public void modificar(Cliente cliente) throws DAOException
	{
		PreparedStatement stat=null;
		try
		{
			stat=con.prepareStatement(UPDATE);
			stat.setString(1, cliente.getNombre());
			stat.setString(2, cliente.getApellido1());
			stat.setString(3, cliente.getApellido2());
			stat.setString(4, cliente.getDireccion());
			stat.setString(5, cliente.getCiudad());
			stat.setString(6, cliente.getProvincia());
			stat.setString(7, cliente.getPais());
			stat.setInt(8, cliente.getCodigoPostal());
			stat.setString(9, cliente.getEmail());
			stat.setInt(10, cliente.getTelefono1());
			stat.setInt(11, cliente.getTelefono2());
			stat.setString(12, cliente.getPassword());
			stat.setDate(13, (Date)cliente.getFechaNacimiento());
			stat.setInt(14, cliente.getIdPedido());
			stat.setInt(15, cliente.getIdCliente());
				
			if (stat.executeUpdate() != 1) 
				throw new DAOException("Error update cliente");
		     
		}catch(SQLException e)
		{
			throw new DAOException("Error update cliente in DAO", e);
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
					throw new DAOException("Error update cliente in DAO", ex);
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
				throw new DAOException("Error delete cliente");
			
		}catch(SQLException e)
		{
			throw new DAOException("Error delete cliente in DAO", e);
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
					throw new DAOException("Error update cliente in DAO", ex);
				}
			}
		}
	}	
	
	//METODO GETONE SQL
	public Cliente obtenerPorId(Integer id)throws DAOException
	{
		
		PreparedStatement stat=null;
		ResultSet rs=null;
		Cliente cliente=null;
		
		try
		{
			stat=con.prepareStatement(GETONE);
			stat.setInt(1, id);
			rs=stat.executeQuery();
			
			if(rs.next())
				cliente=convertir(rs);
			else
	            throw new DAOException("No se ha encontrado registro");
			
		}catch(SQLException e)
		{
			throw new DAOException("Error delete cliente in DAO", e);
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
					throw new DAOException("Error update cliente in DAO", ex);
				}
			}
		}
		return(cliente);
	}
	
	//METODO GETALL SQL
	public List<Cliente> obtenerTodos()throws DAOException
	{
		PreparedStatement stat=null;
		ResultSet rs=null;
		List<Cliente> clientes=new ArrayList<>();
		
		try
		{
			stat=con.prepareStatement(GETALL);
			rs=stat.executeQuery();
			
			while(rs.next())
			{
				clientes.add(convertir(rs));
			}
		}
		catch(SQLException e)
		{
			throw new DAOException("Error delete cliente in DAO", e);
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
					throw new DAOException("Error update cliente in DAO", ex);
				}
			}
		}
		return(clientes);
		
	}
	
	//Obtiene un objeto Cliente a partir del resultado de la query
	public Cliente convertir(ResultSet rs) throws SQLException
	{
		//Obtengo atributos a partir de la consulta de la tabla (ResultSet)
		Integer idCliente=rs.getInt("idCliente");
		String nombre=rs.getString("nombre");
		String apellido1=rs.getString("apellido1");
		String apellido2=rs.getString("apellido2");
		String direccion=rs.getString("direccion");
		String ciudad=rs.getString("ciudad");
		String provincia=rs.getString("provincia");
		String pais=rs.getString("pais");
		Integer codigoPostal=rs.getInt("codigoPostal");
		String email=rs.getString("email");
		Integer telefono1=rs.getInt("telefono1");
		Integer telefono2=rs.getInt("telefono2");
		String password=rs.getString("password");
		Date fechaNacimiento=rs.getDate("fechaNacimiento");
		Integer idPedido=rs.getInt("idPedido");
		//Con los atributos creo el objeto		
		Cliente cliente= new Cliente(idCliente, nombre, apellido1, apellido2, direccion, ciudad, provincia,
			pais, codigoPostal, email, telefono1, telefono2, password, fechaNacimiento, idPedido);
		//Retorno el objeto creado
		return(cliente);
	}
	
	
	
	
	

}
