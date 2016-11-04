package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Editorial;

public class ImplEditorialDAO implements I_DAO<Editorial, Integer>
{
	//Querys
	private final String INSERT="INSERT INTO editorial (nombre, idLibro) VALUES (?,?)";	//2elem
	//no añade el identificador de la tabla en insert, ya que es autoincremental
	//si es insertar no devuelve nada (no tiene resultSet), igual que update y delete, pero select sí, xq es mostrar
	private final String UPDATE="UPDATE editorial SET nombre=?, idLibro=? WHERE idEditorial=?";	//3elem
	private final String DELETE="DELETE FROM editorial WHERE idEditorial=?";	//1elem
	private final String GETONE="SELECT idEditorial, nombre, idLibro FROM editorial WHERE idEditorial=?"; //1elem
	private final String GETALL="SELECT idEditorial, nombre, idLibro FROM editorial";	//0elem
	
	private Connection con = null;
	
	//Constructor (crea nueva conex.)
	public ImplEditorialDAO()
	{
		con= new ConexionDB().getConnection();
		//Retrieves the Connection object that produced this Statement object.
	}
	
	
	//Metodo INSERT SQL
	
	//Creo filas en la BBDD desde java, no hay resultset porque no obtengo nada
	//Para rellenar la tabla en la BBDD creo objetos en Java (editoriales) y con sus métodos get voy rellenando
	public void insertar(Editorial editorial) throws DAOException
	//inserto los datos del objeto editorial
	{
		PreparedStatement stat=null;//ya existe en JAva PreparedStatement, hya que importarla
		try
		{
			stat=con.prepareStatement(INSERT);//pone el string de arriba que contiene los comandos
			//relleno las columnas 1 y 2
			stat.setString(1, editorial.getNombre());	
			stat.setInt(2, editorial.getIdLibro());	
			//xq el id de la tabla (idEditorial) se rellena sólo al añadir una fila más porque 
			//es autoincremental en esa tabla, sin embargo el de libro no, xq es autoincremental 
			//pero en otra tabla
					
			if (stat.executeUpdate() != 1) 
				throw new DAOException("Error adding editorial");
			        
		}catch(SQLException e)
		{
			throw new DAOException("Error adding editorial in DAO", e);
				
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
					throw new DAOException("Error adding editorial in DAO", ex);
				}
			}
		}
	}
	
	
	//METODO UPDATE SQL
	public void modificar(Editorial editorial) throws DAOException
	{
		PreparedStatement stat=null;
		try
		{
			stat=con.prepareStatement(UPDATE);
			//Se pone en el orden en que aparece en la tabla
			stat.setString(1, editorial.getNombre());	
			stat.setInt(2, editorial.getIdLibro());	
			stat.setInt(3, editorial.getIdEditorial());
			//aquí sí modifica las tres columnas de la fila
			
			if (stat.executeUpdate() != 1) 
				throw new DAOException("Error update editorial");
		     
		}catch(SQLException e)
		{
			throw new DAOException("Error update editorial in DAO", e);
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
					throw new DAOException("Error update editorial in DAO", ex);
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
			stat.setInt(1, id);//no entiendo esto
					
			if (stat.executeUpdate() != 1) 
				throw new DAOException("Error delete editorial");
			
		}catch(SQLException e)
		{
			throw new DAOException("Error delete editorial in DAO", e);
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
					throw new DAOException("Error update editorial in DAO", ex);
				}
			}
		}
	}	
		
		
	//METODO GETONE SQL
	public Editorial obtenerPorId(Integer id)throws DAOException
	{
				
		PreparedStatement stat=null;
		ResultSet rs=null;//aquí si hay resultset
		Editorial editorial=null;
				
		try
		{
			stat=con.prepareStatement(GETONE);
			//GETONE es la query q manda
			stat.setInt(1, id);
			rs=stat.executeQuery();//rs guarda la tabla de resultado
					
			if(rs.next())//no pone llaves en if ni en else
				//no entiendo la condicion q impone en l if
				editorial=convertir(rs);
			//crea un objeto editorial en java con los datos de la tabla
			else
				throw new DAOException("No se ha encontrado registro");
				
		}catch(SQLException e)
		{
			throw new DAOException("Error delete editorial in DAO", e);
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
					throw new DAOException("Error update editorial in DAO", ex);
				}
			}
		}
		return(editorial);
	}
			

	//METODO GETALL SQL
	public List<Editorial> obtenerTodos()throws DAOException
	{
		PreparedStatement stat=null;
		ResultSet rs=null;
		List<Editorial> editoriales=new ArrayList<>();
				
		try
		{
			stat=con.prepareStatement(GETALL);
			rs=stat.executeQuery();
						
			if(rs.next())
				//Resultset.next() Moves the cursor forward one row from its current position.
				//cada fila es una nueva editorial, en las columnas están los atributos
				editoriales.add(convertir(rs));
			//añade al ArrayList objetos de tipo editorial
		
			else
				throw new DAOException("No se ha encontrado registro");
		}
		catch(SQLException e)
		{
			throw new DAOException("Error delete editorial in DAO", e);
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
					throw new DAOException("Error update editorial in DAO", ex);
				}
			}
		}
		return(editoriales);
	}

	//Obtiene un objeto Editorial a partir del resultado de la query
	public Editorial convertir(ResultSet rs) throws SQLException
	{
		//Obtengo atributos a partir de la consulta de la tabla (ResultSet)
		Integer idEditorial=rs.getInt("idEditorial");
		String nombre=rs.getString("nombre");
		Integer idLibro=rs.getInt("idLibro");
		//Con los atributos creo el objeto
		Editorial editorial= new Editorial(idEditorial, nombre, idLibro);
		//Retorno el objeto creado
		return(editorial);
	}
}
