package modelo;

public class Stock 
{
	//Atributo clase Stock
	private Integer idStock;				//PK
	private Integer idLibro;				//FK
	private Integer cantidadStock;
	
	//private Map<String, Integer> stock;	
	
	//Constructor vacio
	public Stock() 
	{

	}
	
	//Constructor por parametros (sin idStock)
	public Stock( Integer idLibro, int cantidadStock) 
	{
		this.idLibro = idLibro;
		this.cantidadStock = cantidadStock;
	}
		
	//Constructor por parametros
	public Stock(Integer idStock, Integer idLibro, Integer cantidadStock) 
	{
		this.idStock=idStock;
		this.idLibro = idLibro;
		this.cantidadStock = cantidadStock;
	}
	

	
	
	//metodo set/get
	public Integer getIdStock() 
	{
		return idStock;
	}

	public void setIdStock(Integer idStock) 
	{
		this.idStock = idStock;
	}

	public Integer getIdLibro() 
	{
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) 
	{
		this.idLibro = idLibro;
	}

	public int getCantidadStock() 
	{
		return cantidadStock;
	}

	public void setCantidadStock(int cantidadStock) 
	{
		this.cantidadStock = cantidadStock;
	}

	
	//Sobreescribir metodo toString
	public String toString() 
	{
		return "Stock [idStock=" + idStock + ", idLibro=" + idLibro + ", cantidadStock=" + cantidadStock + "]";
	}
	

	
}
