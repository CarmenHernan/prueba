package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;

public class ImplCategoriaDAO implements I_DAO<Categoria, Integer>
{
	
	private final String INSERT="INSERT INTO categoria (nombre, idLibro) VALUES (?,?)";	//2elem
	private final String UPDATE="UPDATE categoria SET nombre=?, idLibro=? WHERE idCategoria=?";	//3elem
	private final String DELETE="DELETE FROM categoria WHERE idCategoria=?";	//1elem
	private final String GETONE="SELECT idCategoria, nombre, idLibro FROM categoria WHERE idCategoria=?"; //1elem
	private final String GETALL="SELECT idCategoria, nombre, idLibro FROM categoria";	//0elem
	
	private Connection con = null;
	
	//Constructor (crea nueva conex.)
	public ImplCategoriaDAO()
	{
		con= new ConexionDB().getConnection();
	}
	
	
	//Metodo INSERT SQL
	public void insertar(Categoria categoria) throws DAOException
	{
		PreparedStatement stat=null;
		try
		{
			stat=con.prepareStatement(INSERT);
			stat.setString(1, categoria.getNombre());	
			stat.setInt(2, categoria.getIdLibro());	
				
			if (stat.executeUpdate() != 1) 
				throw new DAOException("Error adding categoria");
		        
		}catch(SQLException e)
		{
			throw new DAOException("Error adding categoria in DAO", e);
			
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
					throw new DAOException("Error adding categoria in DAO", ex);
				}
			}
		}
	}
	
	//METODO UPDATE SQL
	public void modificar(Categoria categoria) throws DAOException
	{
		PreparedStatement stat=null;
		try
		{
			stat=con.prepareStatement(UPDATE);
			stat.setString(1, categoria.getNombre());	
			stat.setInt(2, categoria.getIdLibro());	
			stat.setInt(3, categoria.getIdCategoria());
			
			if (stat.executeUpdate() != 1) 
	            throw new DAOException("Error update categoria");
	     
		}catch(SQLException e)
		{
			throw new DAOException("Error update categoria in DAO", e);
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
					throw new DAOException("Error update categoria in DAO", ex);
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
				throw new DAOException("Error delete categoria");
		
		}catch(SQLException e)
			{
			throw new DAOException("Error delete categoria in DAO", e);
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
					throw new DAOException("Error update categoria in DAO", ex);
				}
			}
		}
	}	
	
	
	//METODO GETONE SQL
	public Categoria obtenerPorId(Integer id)throws DAOException
	{
			
		PreparedStatement stat=null;
		ResultSet rs=null;
		Categoria categoria=null;
			
		try
		{
			stat=con.prepareStatement(GETONE);
			stat.setInt(1, id);
			rs=stat.executeQuery();
				
			if(rs.next())
				categoria=convertir(rs);
			else
				throw new DAOException("No se ha encontrado registro");
			
		}catch(SQLException e)
		{
			throw new DAOException("Error delete categoria in DAO", e);
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
					throw new DAOException("Error update categoria in DAO", ex);
				}
			}
		}
		return(categoria);
	}
		

	//METODO GETALL SQL
	public List<Categoria> obtenerTodos()throws DAOException
	{
		PreparedStatement stat=null;
		ResultSet rs=null;
		List<Categoria> categorias=new ArrayList<>();
			
		try
		{
			stat=con.prepareStatement(GETALL);
			rs=stat.executeQuery();
					
			if(rs.next())
				categorias.add(convertir(rs));
			else
				throw new DAOException("No se ha encontrado registro");
		}
		catch(SQLException e)
		{
			throw new DAOException("Error delete categoria in DAO", e);
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
					throw new DAOException("Error update categoria in DAO", ex);
				}
			}
		}
		return(categorias);
	}

	//Obtiene un objeto Categoria a partir del resultado de la query
	public Categoria convertir(ResultSet rs) throws SQLException
	{
		//Obtengo atributos a partir de la consulta de la tabla (ResultSet)
		Integer idCategoria=rs.getInt("idCategoria");
		String nombre=rs.getString("nombre");
		Integer idLibro=rs.getInt("idLibro");
		//Con los atributos creo el objeto
		Categoria categoria= new Categoria(idCategoria, nombre, idLibro);
		//Retorno el objeto creado
		return(categoria);
	}

}
