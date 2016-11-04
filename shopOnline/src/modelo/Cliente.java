package modelo;
import java.util.Date;

public class Cliente 
{
	//Atributos de la clase Cliente			//NO TIENE fk
	private Integer idCliente;				//PK
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String direccion;
	private String ciudad;
	private String provincia;
	private String pais;
	private Integer codigoPostal;
	private String email;
	private Integer telefono1;
	private Integer telefono2;
	private String password;
	private Date fechaNacimiento;	
	private Integer idPedido;				
	//private List<PedidoDTO> pedidos;	//CLAVE FORANEA (PRIMERA FORMA)
	
	//Constructor vacio
	public Cliente() 
	{

	}

	
	//Constructor con todos los parametros
	public Cliente(Integer idCliente, String nombre, String apellido1, String apellido2, String direccion,
			String ciudad, String provincia, String pais, Integer codigoPostal, String email, Integer telefono1,
			Integer telefono2, String password, Date fechaNacimiento, Integer idPedido)
	{
		this.idCliente=idCliente;
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.direccion=direccion;
		this.ciudad=ciudad;
		this.provincia=provincia;
		this.pais=pais;
		this.codigoPostal=codigoPostal;
		this.email=email;
		this.telefono1=telefono1;
		this.telefono2=telefono2;
		this.password=password;
		this.fechaNacimiento=fechaNacimiento;
		this.idPedido=idPedido;
	}
	
	
	//Constructor por parametros (sin idCliente)
	public Cliente( String nombre, String apellido1, String apellido2, String direccion,
			String ciudad, String provincia, String pais, Integer codigoPostal, String email, Integer telefono1,
			Integer telefono2, String password, Date fechaNacimiento, Integer idPedido)
	{
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.direccion=direccion;
		this.ciudad=ciudad;
		this.provincia=provincia;
		this.pais=pais;
		this.codigoPostal=codigoPostal;
		this.email=email;
		this.telefono1=telefono1;
		this.telefono2=telefono2;
		this.password=password;
		this.fechaNacimiento=fechaNacimiento;
		this.idPedido=idPedido;
		
	}
	
	//Constructor por parametros (sin idCliente y sin los valores que pueden ser nulos)
	public Cliente(Integer idCliente, String nombre, String apellido1, String direccion, String ciudad, String provincia, String 
						pais, Integer codigoPostal, String email, Integer telefono1, String password)
	{
		this.idCliente=idCliente;
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.direccion=direccion;			
		this.ciudad=ciudad;	
		this.provincia=provincia;
		this.pais=pais;
		this.codigoPostal=codigoPostal;
		this.email=email;
		this.telefono1=telefono1;
		this.password=password;
	}
		
	//Constructor por parametros (sin idCliente y sin los valores que pueden ser nulos)
	public Cliente(String nombre, String apellido1, String direccion, String ciudad, String provincia, String 
					pais, Integer codigoPostal, String email, Integer telefono1, String password)
	{
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.direccion=direccion;			
		this.ciudad=ciudad;	
		this.provincia=provincia;
		this.pais=pais;
		this.codigoPostal=codigoPostal;
		this.email=email;
		this.telefono1=telefono1;
		this.password=password;
	}	
	
	
	//Metodos Set/get
	public Integer getIdCliente() 
	{
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) 
	{
		this.idCliente = idCliente;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getApellido1() 
	{
		return apellido1;
	}

	public void setApellido1(String apellido1) 
	{
		this.apellido1 = apellido1;
	}

	public String getApellido2() 
	{
		return apellido2;
	}

	public void setApellido2(String apellido2) 
	{
		this.apellido2 = apellido2;
	}

	public String getDireccion() 
	{
		return direccion;
	}

	public void setDireccion(String direccion) 
	{
		this.direccion = direccion;
	}

	public String getCiudad() 
	{
		return ciudad;
	}

	public void setCiudad(String ciudad) 
	{
		this.ciudad = ciudad;
	}

	public String getProvincia() 
	{
		return provincia;
	}

	public void setProvincia(String provincia) 
	{
		this.provincia = provincia;
	}

	public String getPais() 
	{
		return pais;
	}

	public void setPais(String pais) 
	{
		this.pais = pais;
	}

	public Integer getCodigoPostal() 
	{
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) 
	{
		this.codigoPostal = codigoPostal;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public Integer getTelefono1() 
	{
		return telefono1;
	}

	public void setTelefono1(Integer telefono1) 
	{
		this.telefono1 = telefono1;
	}

	public Integer getTelefono2() 
	{
		return telefono2;
	}

	public void setTelefono2(Integer telefono2) 
	{
		this.telefono2 = telefono2;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public Date getFechaNacimiento() 
	{
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) 
	{
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getIdPedido() 
	{
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) 
	{
		this.idPedido = idPedido;
	}

	//Sobreescritura del metodo toString
	public String toString() 
	{
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", direccion=" + direccion + ", ciudad=" + ciudad + ", provincia=" + provincia + ", pais="
				+ pais + ", codigoPostal=" + codigoPostal + ", email=" + email + ", telefono1=" + telefono1
				+ ", telefono2=" + telefono2 + ", password=" + password + ", fechaNacimiento=" + fechaNacimiento
				+ ", idPedido=" + idPedido + "]";
	}
	

}
