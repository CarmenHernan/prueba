package modelo;

public class Precio 
{
	//atributos clase Precio
	private Integer idPrecio;				//PK
	private Float precio;
	private Integer idLibro;				//FK


	//Constructor vacio
	public Precio() 
	{
	
	}
	
	//Constructor por parametros (sin idPrecio)
	public Precio(Integer idLibro, float precio)
	{
		this.idLibro = idLibro;
		this.precio = precio;
	}
	
	//Constructor por parametros
	public Precio(Integer idPrecio, Float precio, Integer idLibro)
	{
		this.idPrecio=idPrecio;
		this.precio = precio;
		this.idLibro = idLibro;
	}

	//Metodos Set/get
	public Integer getIdPrecio() 
	{
		return idPrecio;
	}

	public void setIdPrecio(Integer idPrecio) 
	{
		this.idPrecio = idPrecio;
	}

	public float getPrecio() 
	{
		return precio;
	}

	public void setPrecio(Float precio) 
	{
		this.precio = precio;
	}

	public Integer getIdLibro() 
	{
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) 
	{
		this.idLibro = idLibro;
	}
	
	//Sobreescritura metodo toString
	public String toString() 
	{
		return "Precio [idPrecio=" + idPrecio + ", precio=" + precio + ", idLibro=" + idLibro + "]";
	}
	


}
