package modelo;

public class Editorial 
{
	
	//Atributos de la clase Editorial
	private Integer idEditorial;			//PK
	private String nombre;
	private Integer idLibro;				//FK
	//private List<ArticuloDTO> librosEditorial;	//CLAVE FORANEA (PRIMERA FORMA)
	
	
	//Constructor vacio
	public Editorial() 
	{
	}
	
	//Constructor por parametros (sin idEditorial)
	public Editorial(String nombre, Integer idLibro)
	{
		this.nombre=nombre;
		this.idLibro=idLibro;
	}
		
	//Constructor por parametros
	public Editorial(Integer idEditorial, String nombre, Integer idLibro)
	{
		this.idEditorial=idEditorial;
		this.nombre=nombre;
		this.idLibro=idLibro;
	}

	
	//Metodos Set/get
	public Integer getIdEditorial() 
	{
		return idEditorial;
	}

	public void setIdEditorial(Integer idEditorial) 
	{
		this.idEditorial = idEditorial;
	}

	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	
	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	
	//Sobreescritura del metodo toString
	public String toString() 
	{
		return "Editorial [idEditorial=" + idEditorial + ", nombre=" + nombre + ", idLibro=" + idLibro + "]";
	}

	






}
