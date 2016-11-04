package modelo;

/*
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;*/

import java.io.Serializable;
import java.util.Date;


public class Pedido implements Serializable
{
	
	//Atributos clase Pedido
	private Integer idPedido;				//PK
	private Date fechaPedido;
	private Date fechaEntrega;
	private Date horaPedido;
	private Float precioTotal;
	private String formaPago;
	private Integer idCliente;				//FK
	

	//private Map <String, Integer> articulos;

	//Constructor vacio
    public Pedido ()
    {
 
    }

    //Constructor con parametros (sin idPedido)
    public Pedido(Integer idCliente, Date fechaPedido, Date fechaEntrega) 
    {
		this.idCliente = idCliente;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
	}
    
  //Constructor con parametros
  public Pedido(int idPedido, Integer idCliente, Date fechaPedido, Date fechaEntrega) 
  {
	this.idPedido = idPedido;
	this.idCliente = idCliente;
	this.fechaPedido = fechaPedido;
	this.fechaEntrega = fechaEntrega;
}
   
   

    //Constructor con parametros 
	public Pedido(int idPedido, Integer idCliente) 
	{
		this.idPedido = idPedido;
		this.idCliente = idCliente;
	}

	//Constructor con parametros
	public Pedido(Integer idPedido, Date fechaPedido, Date fechaEntrega, Float precioTotal,
			String formaPago, Integer idCliente, Date horaPedido)
	{
		this.idPedido=idPedido;					
		this.fechaPedido=fechaPedido;
		this.fechaEntrega=fechaEntrega;
		this.precioTotal=precioTotal;
		this.formaPago=formaPago;
		this.idCliente=idCliente;				
		this.horaPedido=horaPedido;
	}

	//Metodos Set/get
	public Integer getIdPedido() 
	{
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) 
	{
		this.idPedido = idPedido;
	}

	public Date getFechaPedido() 
	{
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) 
	{
		this.fechaPedido = fechaPedido;
	}

	public Date getFechaEntrega() 
	{
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) 
	{
		this.fechaEntrega = fechaEntrega;
	}

	public Float getPrecioTotal() 
	{
		return precioTotal;
	}

	public void setPrecioTotal(Float precioTotal) 
	{
		this.precioTotal = precioTotal;
	}

	public String getFormaPago() 
	{
		return formaPago;
	}

	public void setFormaPago(String formaPago) 
	{
		this.formaPago = formaPago;
	}

	public Integer getIdCliente() 
	{
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) 
	{
		this.idCliente = idCliente;
	}

	public Date getHoraPedido() 
	{
		return horaPedido;
	}

	public void setHoraPedido(Date horaPedido) 
	{
		this.horaPedido = horaPedido;
	}

	//Sobreescritura del metodo toString
	public String toString() 
	{
		return "Pedido [idPedido=" + idPedido + ", fechaPedido=" + fechaPedido + ", fechaEntrega=" + fechaEntrega
				+ ", precioTotal=" + precioTotal + ", formaPago=" + formaPago + ", idCliente=" + idCliente
				+ ", horaPedido=" + horaPedido + "]";
	}
	
	
	
	
	
	
	
	
	
	
	



	
	/*

	//no tenemos guardados como atributos ni newProd, ni int cantidad, ni double prodPrice
    public void addProduct (ArticuloDTO newProd, int cantidad, double prodPrice)
    {
    	//Ponía String newProduct
    	//Método que comprueba si una clave está dada de alta en el mapa. 
    	//public boolean containsKey(Object key)
        if (this.articulos.containsKey(newProd) == true)
        {
        	//si el producto ya estaba en el carrito sólo aumenta la cantidad de éste
            int newCant = this.articulos.get(newProd) + cantidad;
            //newCant lo está creando ahora
            //this.articulos.get(newProd) debería dar la cantidad antigua de ese producto
            //put(K key, V value): Associates the specified value with the specified key in this map.
            this.articulos.put(newProd, newCant);
            //como en el Map no puede haber elementos repetidos creo que reemplaza el que había antes por este nuevo con la cantidad nueva
            //enlaza nuevo producto con la cantidad que pide el cliente
            this.precioPedido += (cantidad * prodPrice);
        }
        else
        {
            this.articulos.put(newProd, cantidad);
            //aquí newCant=cantidad, porque el producto no estaba aun en el carrito
            this.precioPedido += (prodPrice * cantidad);
        }
    }

    public boolean editCant (ArticuloDTO prod, int cantidad, double prodPrice)
    {
    	
        if (this.articulos.containsKey(prod) == true)
        {
            if (cantidad == 0)
            {
            	//Si la cantidad es cero elimina el producto
                removeProd (prod, prodPrice);
                return true;
            }
            int cantidadActual = this.articulos.get(prod);
            this.precioPedido += ((cantidad-cantidadActual) * prodPrice);
            //Al precio antiguo se le añade el precio de la nueva cantidad menos la que ya había
            this.articulos.put(prod, cantidad);
            //añado el nuevo producto con la nueva cantidad
            return true;
        }
        else
        {
            return false;
            //entra si intento cambiar la cantidad de un producto que no está aun en el carrito, ya que en ese caso sería añadir producto
        }
    }

    public void removeProd(ArticuloDTO prod, double prodPrice)
    {
    	
        this.precioPedido -= (prodPrice * this.articulos.get(prod));
        //le resta al precio del pedido el precio del artículo que quiero quitar multiplicado por la cantidad que había
        this.articulos.remove(prod);
    }

    public void delProd (ArticuloDTO prod)
    {
        this.articulos.remove(prod);
    }

   

    public void setArticulos(Map<ArticuloDTO, Integer> articulos)
    {
    	//le metería como parámetro el nuevo map
        this.articulos = articulos;
    }

    //listar pedido
    public void listarPedido() 
    {
    	ArticuloDTO prod;
        Iterator<ArticuloDTO> productos = articulos.keySet().iterator();
        System.out.println("-- LISTADO DE PRODUCTOS --");
        while (productos.hasNext()) {
          prod = productos.next();
            System.out.println("[" + prod + "]: " + articulos.get(prod));
        }
    }
    
    //Metodo serializar objeto
    public void serializarStock(String fichero) 
    {
        System.out.println("-- serializando");
        try {
            FileOutputStream f = new FileOutputStream(fichero);
            try (ObjectOutputStream s = new ObjectOutputStream(f)) {
                s.writeObject(articulos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Metodo deserializar objeto
    public void deSerializarStock(String fichero) 
    {
        System.out.println("-- Deserializando");
        try {
            File fich = new File(fichero);
            FileInputStream f = new FileInputStream(fich);
            try (ObjectInputStream s = new ObjectInputStream(f)) {
                articulos = (Map<ArticuloDTO, Integer>) s.readObject();
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
    	*/
}
   