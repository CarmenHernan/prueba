package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import modelo.Libro;

public class ImplLibroDAO implements I_DAO<Libro, Integer>
{
	
	private final String INSERT="INSERT INTO libro (isbn, titulo, autor, edicion, fechaPublicacion, descripcion, urlImagen)"
			+ " VALUES (?,?,?,?,?,?,?)";	//6elem
	//no va en el orden de la tabla sino en el de las interrogaciones
	
	private final String UPDATE="UPDATE libro SET isbn=?, titulo=?, autor=?, edicion=?, fechaPublicacion=?, descripcion=?, urlImagen=?"
			+ " WHERE idLibro=?";	//7elem
	
	private final String DELETE="DELETE FROM libro WHERE idLibro=?";	//1elem
	
	private final String GETONE="SELECT idLibro, isbn, titulo, autor, edicion, fechaPublicacion, descripcion, urlImagen FROM libro"
			+ " WHERE idLibro=?";//1elem
	
	private final String GETALL="SELECT idLibro, isbn, titulo,autor, edicion, fechaPublicacion, descripcion, urlImagen FROM libro";
	
	
	private Connection con = null;
	
	//Constructor (crea nueva conex.)
	public ImplLibroDAO()
	{
		con= new ConexionDB().getConnection();
	}
	
	
	//Metodo INSERT SQL
	public void insertar(Libro libro) throws DAOException
	{
		PreparedStatement stat=null;
		try
		{
			stat=con.prepareStatement(INSERT);
			stat.setString(1, libro.getIsbn());
			stat.setString(2, libro.getTitulo());
			//el 1 indica el interrogante en la posicion 1 en (?,?,?,?,?,?,?,?,?,?,?,?,?,?)
			stat.setString(3, libro.getAutor());
			stat.setInt(4, libro.getEdicion());
			stat.setString(5, "2016-10-25");
			stat.setString(6, libro.getDescripcion());
			stat.setString(7, libro.getUrlImagen());
			
		
	
			if (stat.executeUpdate() != 1) 
				throw new DAOException("Error adding libro");
		        
		}catch(SQLException e)
		{
			throw new DAOException("Error adding libro in DAO", e);
			
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
					throw new DAOException("Error adding libro in DAO", ex);
				}
			}
		}
	}
	
	//METODO UPDATE SQL
	public void modificar(Libro libro) throws DAOException
	{
		PreparedStatement stat=null;
		try
		{
			stat=con.prepareStatement(UPDATE);
			
			stat.setString(1, libro.getIsbn());
			stat.setString(2, libro.getTitulo());
			stat.setString(3, libro.getAutor());
			stat.setInt(4, libro.getEdicion());
			stat.setString(5, "2016-10-25");
			stat.setString(6, libro.getDescripcion());
			stat.setString(7, libro.getUrlImagen());
			stat.setInt(8, libro.getIdLibro());
			System.out.println(stat);
			
			
			if (stat.executeUpdate() != 1) 
				throw new DAOException("Error update libro");
		     
		}catch(SQLException e)
		{
			throw new DAOException("Error update libro in DAO", e);
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
	public Libro obtenerPorId(Integer id)throws DAOException
	{
		
		PreparedStatement stat=null;
		ResultSet rs=null;
		Libro libro=null;
		
		try
		{
			stat=con.prepareStatement(GETONE);
			stat.setInt(1, id);
			rs=stat.executeQuery();
			
			if(rs.next())
				libro=convertir(rs);
			else
	            throw new DAOException("No se ha encontrado registro");
			
		}catch(SQLException e)
		{
			throw new DAOException("Error delete libro in DAO", e);
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
		return(libro);
	}
	
	//METODO GETALL SQL
	public List<Libro> obtenerTodos()throws DAOException
	{
		PreparedStatement stat=null;
		ResultSet rs=null;
		List<Libro> libros=new ArrayList<>();
		
		try
		{
			stat=con.prepareStatement(GETALL);
			rs=stat.executeQuery();
			
			while(rs.next())
			{
				libros.add(convertir(rs));
			}
		}
		catch(SQLException e)
		{
			throw new DAOException("Error delete libro in DAO", e);
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
					throw new DAOException("Error update libro in DAO", ex);
				}
			}
		}
		return(libros);
		
	}
	
	//Obtiene un objeto Libro a partir del resultado de la query
	public Libro convertir(ResultSet rs) throws SQLException
	{
		//Obtengo atributos a partir de la consulta de la tabla (ResultSet)
		Integer idLibro=rs.getInt("idLibro");
		String isbn=rs.getString("isbn");
		String titulo=rs.getString("titulo");
		String autor=rs.getString("autor");
		Integer edicion=rs.getInt("edicion");
		Date fechaPublicacion=rs.getDate("fechaPublicacion");
		String descripcion=rs.getString("descripcion");
		String urlImagen=rs.getString("urlImagen");
		
		
		
		//Con los atributos creo el objeto		
		Libro libro= new Libro(idLibro, isbn, titulo, autor, edicion, fechaPublicacion,descripcion,urlImagen);
		//Retorno el objeto creado
		return(libro);
	}
	
	
	
	
	

}
