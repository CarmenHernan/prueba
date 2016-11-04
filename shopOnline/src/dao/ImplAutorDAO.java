package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Autor;

public class ImplAutorDAO implements I_DAO<Autor, Integer>
{		
	private final String INSERT="INSERT INTO autor (nombre, idLibro) VALUES (?,?)";	//2elem
	private final String UPDATE="UPDATE autor SET nombre=?, idLibro=? WHERE idAutor=?";	//3elem
	private final String DELETE="DELETE FROM autor WHERE idAutor=?";	//1elem
	private final String GETONE="SELECT idAutor, nombre, idLibro FROM autor WHERE idAutor=?"; //1elem
	private final String GETALL="SELECT idAutor, nombre, idLibro FROM autor";	//0elem
	
	
	private Connection con = null;
	
	//Constructor (crea nueva conex.)
	public ImplAutorDAO()
	{
		con= new ConexionDB().getConnection();
	}

	
	//Metodo INSERT SQL
	public void insertar(Autor autor) throws DAOException
	{
		PreparedStatement stat=null;
		try
		{
			stat=con.prepareStatement(INSERT);
			stat.setString(1, autor.getNombre());	
			stat.setInt(2, autor.getIdLibro());	
			
			if (stat.executeUpdate() != 1) 
	            throw new DAOException("Error adding autor");
	        
		}catch(SQLException e)
		{
			throw new DAOException("Error adding autor in DAO", e);
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
					throw new DAOException("Error adding autor in DAO", ex);
				}
			}
		}
	}
	
	
	//METODO UPDATE SQL
	public void modificar(Autor autor) throws DAOException
	{
		PreparedStatement stat=null;
		try
		{
			stat=con.prepareStatement(UPDATE);
			stat.setString(1, autor.getNombre());	
			stat.setInt(2, autor.getIdLibro());	
			stat.setInt(3, autor.getIdAutor());
			
			if (stat.executeUpdate() != 1) 
	            throw new DAOException("Error update autor");
	     
		}catch(SQLException e)
		{
			throw new DAOException("Error update autor in DAO", e);
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
					throw new DAOException("Error update autor in DAO", ex);
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
	            throw new DAOException("Error delete autor");
	
		}catch(SQLException e)
		{
			throw new DAOException("Error delete autor in DAO", e);
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
					throw new DAOException("Error update autor in DAO", ex);
				}
			}
		}
	}
	
	//METODO GETONE SQL
	public Autor obtenerPorId(Integer id)throws DAOException
	{
		
		PreparedStatement stat=null;
		ResultSet rs=null;
		Autor autor=null;
		
		try
		{
			stat=con.prepareStatement(GETONE);
			stat.setInt(1, id);
			rs=stat.executeQuery();
			
			if(rs.next())
				autor=convertir(rs);
			else
		           throw new DAOException("No se ha encontrado registro");
			
		}catch(SQLException e)
		{
			throw new DAOException("Error delete autor in DAO", e);
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
					throw new DAOException("Error update autor in DAO", ex);
				}
			}
		}
		return(autor);
	}
	
	//METODO GETALL SQL
	public List<Autor> obtenerTodos()throws DAOException
	{
		PreparedStatement stat=null;
		ResultSet rs=null;
		List<Autor> autores=new ArrayList<>();
		
		try
		{
			stat=con.prepareStatement(GETALL);
			rs=stat.executeQuery();
				
			if(rs.next())
				autores.add(convertir(rs));
			else
				throw new DAOException("No se ha encontrado registro");
		}
		catch(SQLException e)
		{
			throw new DAOException("Error delete autor in DAO", e);
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
					throw new DAOException("Error update autor in DAO", ex);
				}
			}
		}
		return(autores);
	}
	
	
	//Obtiene un objeto Autor a partir del resultado de la query
	public Autor convertir(ResultSet rs) throws SQLException
	{
		//Obtengo atributos a partir de la consulta de la tabla (ResultSet)
		Integer idAutor=rs.getInt("idAutor");
		String nombre=rs.getString("nombre");
		Integer idLibro=rs.getInt("idLibro");
		//Con los atributos creo el objeto
		Autor autor= new Autor(idAutor, nombre, idLibro);
		//Retorno el objeto creado
		return(autor);
	}
}
