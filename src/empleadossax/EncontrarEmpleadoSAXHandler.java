/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleadossax;

import exceptions.AbortParseException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author josema
 */
public class EncontrarEmpleadoSAXHandler extends DefaultHandler {
    
    String idBuscado;
    String etiqueta;
    String nombre, cargo, departamento, id, nivel; 
    int numero;
    
    public EncontrarEmpleadoSAXHandler(String idBuscado) {
        this.idBuscado = idBuscado;
        numero = 1;
    }    

    @Override
    public void startDocument() throws SAXException {
        System.out.println("#### JMBS ENCUENTRA EMPLEADOS CON ID: " + idBuscado);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("No se encuentra al empleado con identificador: " + idBuscado);
        System.out.println("####FIN ENCONTRAR EMPLEADOS");
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
            
            if (idBuscado.equalsIgnoreCase(id)) {
                System.out.println("#ID: " + id);
                System.out.println("#NOMBRE: " + nombre);
                System.out.println("#NIVEL: " + nivel);
                System.out.println("#CARGO: " + cargo);
                System.out.println("#DPTO: " + departamento);
                throw new AbortParseException("Encontrado",0);
            }
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
            
        }
        
    }    
}
