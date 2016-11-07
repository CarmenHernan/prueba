package modelo;

/*
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.List;
import utilidades.*;
import utilidades.Datos;*/
import java.util.Date;

public class Libro 
{
	//Atributos de la clase articulo		//No tiene FK
	private Integer idLibro;				//PK
	private String isbn;
	private String titulo;	
	private String autor;				
	private Integer edicion;	
	private Date fechaPublicacion;
	private String descripcion;
	private String urlImagen;
	

	//Constructor vacio
	public Libro() 	
	{

	}
	
	//Constructor por parametros
	public Libro(Integer idLibro, String isbn, String titulo, String autor, Integer edicion, Date fechaPublicacion,
				String descripcion, String urlImagen)
	{
		this.idLibro=idLibro;
		this.isbn=isbn;
		this.titulo=titulo;
		this.edicion=edicion;
		this.fechaPublicacion=fechaPublicacion;
		this.descripcion=descripcion;
		this.autor=autor;
		this.urlImagen=urlImagen;
	}
		
	//Constructor por parametros (sin idLibro ya que se lo asigna autoincremento mysql)
	public Libro(String isbn, String titulo, String autor, Integer edicion, Date fechaPublicacion,
					String descripcion, String urlImagen)
	{
		this.isbn=isbn;
		this.titulo=titulo;
		this.edicion=edicion;
		this.fechaPublicacion=fechaPublicacion;
		this.descripcion=descripcion;
		this.autor=autor;
		this.urlImagen=urlImagen;
	}
		

	//Constructor por parametros (quitando los valores que pueden ser nulos)
	public Libro(Integer idLibro, String isbn, String titulo)
	{
		this.idLibro=idLibro;
		this.isbn=isbn;
		this.titulo=titulo;
	}
	
	//Constructor por parametros (quitando los valores que pueden ser nulos e idLibro)
	public Libro(String isbn, String titulo)
	{
		this.isbn=isbn;
		this.titulo=titulo;
	}
	
	
	//Metodos Set/get
	public Integer getIdLibro() 
	{
		return idLibro;
	}


	public void setIdLibro(Integer idLibro) 
	{
		this.idLibro = idLibro;
	}


	public String getIsbn()
	{
		return isbn;
	}


	public void setIsbn(String isbn) 
	{
		this.isbn = isbn;
	}


	public String getTitulo() 
	{
		return titulo;
	}


	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}


	public Integer getEdicion() 
	{
		return edicion;
	}


	public void setEdicion(Integer edicion) 
	{
		this.edicion = edicion;
	}


	public Date getFechaPublicacion() 
	{
		return fechaPublicacion;
	}


	public void setFechaPublicacion(Date fechaPublicacion) 
	{
		this.fechaPublicacion = fechaPublicacion;
	}


	public String getDescripcion() 
	{
		return descripcion;
	}


	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}

	public String getAutor() 
	{
		return autor;
	}


	public void setAutor(String autor) 
	{
		this.autor = autor;
	}
	
	
	public String getUrlImagen() 
	{
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) 
	{
		this.urlImagen = urlImagen;
	}


	//Sobreescritura del metodo toString
	public String toString() 
	{
		return "Libro [idLibro=" + idLibro + ", isbn=" + isbn + ", titulo=" + titulo + ", edicion=" + edicion
				+ ", fechaPublicacion=" + fechaPublicacion + ", descripcion=" + descripcion + ", autor=" + autor
				+ "]";
	}

	


	
	
	/*
	//otros metodos
	public void crearArticulo() 
	{
		try 
		{
			// this.codigo = Datos.recogeInt("Introduzca el cÃ³digo del producto");
			//no respeta las tildes, en UTF8 si respeta las tildes, se pone en codificación
			this.nombre = Datos.recogeString("Introduce el nombre del artículo");
			this.isbn = Datos.recogeString("Introduce el ISBN del artículo");
			this.edicion = Datos.recogeString("Introduce la edicion del artículo");
			this.fechaPubli= DatosBuffer.recogeDate();
			//tendría que crear
		} 
		catch (Exception e) 
		{
			// e.getStackTrace();
			//te detecta cualquiera que pueda surgir, por ehemplo IO
			//jamás ñ o tildes en código   
        }
	}*/
	
}
