package utilidades;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.*;

public class DatosBuffer {
	//cambiar scanner por buffer

    BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

    public String recogeString() throws Exception {
        String dato = teclado.readLine();
        return dato;
    }

    public int recogeInt() throws Exception {
        int dato = Integer.parseInt(teclado.readLine());//de String a entero
        return dato;
    }

    public double recogeDouble() throws Exception {
        double dato = Double.parseDouble(teclado.readLine());
        return dato; 
    }
    
    
public Date recogeDate() throws Exception{
	// SimpleDateFormat df = new SimpleDateFormat("mm/dd/yyyy");
	 System.out.print("ENTER DATE STRING (mm/dd/yyyy ): ");
	   String dateString = teclado.readLine();
	   // Parse the date
	   Date date = new SimpleDateFormat("mm/dd/yyyy").parse(dateString); 
	   return date;
}

}
