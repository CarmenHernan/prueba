package modelo;


public class Categoria 
{
	//Atributos de la clase Categoria
	private Integer idCategoria;			//PK
	private String nombre;
	private Integer idLibro;				//FK

	//Constructor vacio
	public Categoria() 
	{

	}
	
	//Constructor por parametros
	public Categoria(Integer idCategoria, String nombre, Integer idLibro)
	{
		this.idCategoria=idCategoria;
		this.nombre=nombre;
		this.idLibro=idLibro;
	}
	
	//Constructor por parametros (sin idCategoria)
	public Categoria( String nombre, Integer idLibro)
	{
		this.nombre=nombre;
		this.idLibro=idLibro;
	}
	
	//Metodos Set/get
	public Integer getIdCategoria() 
	{
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) 
	{
		this.idCategoria = idCategoria;
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
		return "Categoria [idCategoria=" + idCategoria + ", nombre=" + nombre + ", idLibro=" + idLibro + "]";
	}

}
