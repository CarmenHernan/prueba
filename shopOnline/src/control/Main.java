package control;

import dao.ImplLibroDAO;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import dao.DAOException;
import modelo.Libro;


public class Main 
{

	public static void main(String[] args) throws DAOException 
	{
		
		//PRUEBAS CON LA TABLA LIBRO
		
		
		ImplLibroDAO dao= new ImplLibroDAO();
		
		//INSERTAR OBJETO
		Libro l1= new Libro("9788408159735", "Solo para tus ojos","J. J. Benitez",4, new Date(), "En septiembre de 2016, J. J. Benítez cumple 70 años y 45 de investigación ovni. En estos momentos es uno de los investigadores más veteranos. Coincidiendo con estos dos aniversarios, el autor escribe Solo para tus ojos como obra conmemorativa, tras 22 libros sobre el tema","soloParaTusOjos.jpg" );
		dao.insertar(l1);
		
		System.out.println("hola holita");
		System.out.println("aduis");
		System.out.println("Hola, soy Sonia");
		//ELIMINAR OBJETO (FIJARSE EN QUE EXISTA ID)
		//dao.eliminarPorId(12);
		
		
		
		//ACTUALIZAR OBJETO (FIJARSE EN QUE EXITA ID)
		//Libro l2= new Libro(8,"9788408159735", "Solo para ti","J. J. Benitez",4, new Date(), "En septiembre de 2016, J. J. Benítez cumple 70 años y 45 de investigación ovni. En estos momentos es uno de los investigadores más veteranos. Coincidiendo con estos dos aniversarios, el autor escribe Solo para tus ojos como obra conmemorativa, tras 22 libros sobre el tema","soloParaTusOjos.jpg");
		//dao.modificar(l2);
		
		
		
		//CREAR OBJETO A PARTIR DE UN ID
		Libro l0=new Libro();
		l0=dao.obtenerPorId(1);
		System.out.println(l0);
		
		
		
		//LISTAR TODOS LOS OBJETOS
		List <Libro> libros= new ArrayList<>();
		
		libros=dao.obtenerTodos();
		
		for(Libro l: libros)
			System.out.println(l);
		
		
	}

}
