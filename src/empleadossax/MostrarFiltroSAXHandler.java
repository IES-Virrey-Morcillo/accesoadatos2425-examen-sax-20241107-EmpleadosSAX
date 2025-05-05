/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleadossax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author josema
 */
public class MostrarFiltroSAXHandler extends DefaultHandler {
    
    String filtro;
    String etiqueta;
    String nombre, cargo, fecha, departamento, telefono, id, nivel; 
    int numero;
    
    public MostrarFiltroSAXHandler(String filtro) {
        this.filtro = filtro;
        numero = 1;
        telefono = "";
    }    

    @Override
    public void startDocument() throws SAXException {
        System.out.println("#### JMBS MUESTRA EMPLEADOS CON FILTRO: " + filtro);
    }

    @Override
    public void endDocument() throws SAXException {
        if (numero == 1) {
            System.out.println("NO HAY EMPLEADOS EN ESE NIVEL");
        }
        System.out.println("####FIN MOSTRAR EMPLEADOS");
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        etiqueta=qName;
        if (etiqueta.equals("empleado")) {
            nivel = attributes.getValue("nivel");
            id = attributes.getValue("id");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("empleado")) {
            
            if (nivel.equals(filtro) || filtro.isEmpty()) {
                System.out.println("## EMPLEADO NÚMERO " + numero);
                numero++;
                System.out.println("#ID: " + id);
                System.out.println("#NOMBRE: " + nombre);
                System.out.println("#NIVEL: " + nivel);
                System.out.println("#CARGO: " + cargo);
                System.out.println("#FECHA CONTRATACION: " + fecha);
                System.out.println("#DPTO: " + departamento);
                if (!telefono.isEmpty())
                    System.out.println("#TELEFONO: " + telefono);
            }
            telefono = "";
        }       
        
        // La linea importante del programa.
        etiqueta="";
        
    }
    
    private String tratarCaracteres(char[] ch, int start, int length) {
        return new String(ch,start,length).trim();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        
        switch(etiqueta) {
            case "nombre" ->{
                nombre = tratarCaracteres(ch, start, length);
            }
            case "cargo" -> {
                cargo = tratarCaracteres(ch, start, length);
            }
            case "departamento" -> {
                departamento = tratarCaracteres(ch, start, length);
            }
            case "fechaContratacion" -> {
                fecha = tratarCaracteres(ch, start, length);
            }
            case "telefono" -> {
                telefono = tratarCaracteres(ch, start, length);
            }
            
        }
        
    }    
}
