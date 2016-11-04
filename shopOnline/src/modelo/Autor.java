package modelo;

public class Autor 
{
	//Atributos de la clase autor
	private Integer idAutor;				//PK 
	private String nombre;
	private Integer idLibro;				//FK
	
	
	//Constructor vacio
	public Autor() 
	{
		
	}
	
	//Constructor por parametros
	public Autor(Integer idAutor, String nombre, Integer idLibro) 
	{
		this.idAutor=idAutor;
		this.nombre = nombre;
		this.idLibro = idLibro;
	}
	
	//Constructor por parametros (sin idAutor)
	public Autor(String nombre, Integer idLibro) 
	{
		this.nombre = nombre;
		this.idLibro = idLibro;
	}

	//Metodos Set/get
	public Integer getIdAutor()
	{
		return idAutor;
	}
	
	public void setIdAutor(Integer idAutor)
	{
		this.idAutor=idAutor;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	public Integer getIdLibro() 
	{
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) 
	{
		this.idLibro = idLibro;
	}
	
	//Sobreescritura del metodo toString
	public String toString() 
	{
		return "Autor [idAutor=" + idAutor + ", nombre=" + nombre + ", idLibro=" + idLibro + "]";
	}
	
	
	
	
	

}
