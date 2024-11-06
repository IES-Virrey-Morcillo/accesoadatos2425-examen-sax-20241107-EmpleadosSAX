/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package empleadossax;

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
        
        // CASOS DE PRUEBA DEL PRIMER EJERCICIO
        // CP1.1. MOSTRAR SIN FILTRO
        
        // CP1.2 MOSTRAR CON FILTRO QUE HAY EMPLEADOS
        
        // CP1.3 MOSTRAR CON FILTRO QUE NO HAY EMPLEADOS
        
        // CASOS DE PRUEBA DEL SEGUNDO EJERCICIO
        // CP2.1 ENCUENTRA EMPLEADO
        
        // CP2.2 NO ENCUENTRA EMPLEADO
        
        // CP2.3 ID NO INFORMADO
        
        // CASOS DE PRUEBA DEL SEGUNDO EJERCICIO
        // CP3.1 SALIDA OK (USANDO FICHERO DE ENTRADA entrada.csv)
        
        // CP3.2 FICHERO VACÍO (USANDO FICHERO DE ENTRADA entradaVacia.csv)
        
        // CP3.3 FICHERO NO EXISTE
    }
    
}
