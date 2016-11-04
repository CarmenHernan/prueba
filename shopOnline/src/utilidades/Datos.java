package utilidades;

/**
 *
 * @author Antonio Santos
 */
import java.util.Scanner;
import java.util.Date;

public class Datos {

    public Datos() {
    }

    public static String recogeString() throws Exception {
    	//lanza Exception por si pasa algo pero no sabe qué puede pasar
    	// en la API por ejemplo pone los tipos de error que pueden saltar, que están recogidos en EXCEPTION
    	//CON ENTRADA/SALIDA siempre hay error, x ej busco readLine--> pone que sólo hay IOException, podría poner sólo esa
        String dato = new Scanner(System.in).nextLine();
        return dato;
    }

    public static String recogeString(String msg) throws Exception {
        System.out.println(msg);
        return recogeString();
    }

    public static int recogeInt() throws Exception {
        int dato = new Scanner(System.in).nextInt();
        return dato;
    }

    public static int recogeInt(String msg) throws Exception {
        System.out.println(msg);
        return recogeInt();
    }
   


    
    public static double recogeDouble() throws Exception {
        double dato = new Scanner(System.in).nextDouble();
        return dato;
    }

    public static double recogeDouble(String msg) throws Exception {
        System.out.println(msg);
        return recogeDouble();
    }
}
   