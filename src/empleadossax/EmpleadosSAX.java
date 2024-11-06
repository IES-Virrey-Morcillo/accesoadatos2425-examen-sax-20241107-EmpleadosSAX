/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package empleadossax;

import java.io.File;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author josema
 */
public class EmpleadosSAX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
            
        } catch(UnsupportedEncodingException e) {
            System.out.println("No se verán las tildes ni ñ");
        }
        
        File f = new File("Empleados.xml");
        AccesoEmpleadosSAX e = new AccesoEmpleadosSAX();
        
        e.mostrarEmpleadosPorNivelSAXhandler(f, "");
        e.mostrarEmpleadosPorNivelSAXhandler(f, "junior");
        e.mostrarEmpleadosPorNivelSAXhandler(f, "principiante");
    }
    
}
