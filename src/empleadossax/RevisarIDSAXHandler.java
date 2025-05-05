/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleadossax;

import exceptions.AbortParseException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author josema
 */
public class RevisarIDSAXHandler extends DefaultHandler {
    
    String etiqueta;
    String nombre, cargo, telefono, id, idBuscado, nombreBuscado; 
    
    public RevisarIDSAXHandler(String linea) throws AbortParseException {
        
        String[] campos = linea.split(";");
        if (campos.length != 2) {
            System.out.println("# FORMATO INVALIDO. LAS LÍNEAS DE BÚSQUEDA DEBEN TENER 2 COLUMNAS");
            throw new AbortParseException("Formato invalido",-1);
        } else {
            idBuscado = campos[0];
            nombreBuscado = campos[1];
            System.out.println("Empleado buscado: " + idBuscado + nombreBuscado);
        }
        telefono = "";
    }    

    @Override
    public void startDocument() throws SAXException {

    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("# " + idBuscado + " (" + nombreBuscado + ") no es empleado de la empresa");
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        etiqueta=qName;
        if (etiqueta.equals("empleado")) {
            id = attributes.getValue("id");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("empleado")) {

            if (idBuscado.equalsIgnoreCase(id)) {
                
                if (nombre.equals(nombreBuscado)) {
                    System.out.println("# " + id + " es " + nombre + " (" + cargo + ")");
                } else {
                    System.out.println("# " + id + " no es " + nombreBuscado + ", si no " + nombre + "(" + cargo + ")");
                    escribirIncidencia();
                }                
                throw new AbortParseException("Encontrado",0);
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
            case "telefono" -> {
                telefono = tratarCaracteres(ch, start, length);
            }
            
        }
        
    }

    private void escribirIncidencia() {
    
        try {
            FileWriter fw = new FileWriter("correcciones.csv",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            String churro = id + ";" + nombre + ";" + cargo + ";" + telefono;
            
            pw.println(churro);
            
            pw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(RevisarIDSAXHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
