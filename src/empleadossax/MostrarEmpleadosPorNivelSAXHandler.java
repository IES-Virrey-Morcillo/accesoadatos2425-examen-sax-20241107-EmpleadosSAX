/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleadossax;

import java.time.LocalDate;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author josema
 */
public class MostrarEmpleadosPorNivelSAXHandler extends DefaultHandler {

    String filtro;
    String etiqueta;

    String id;
    String nivel;
    
    int contador;
    boolean encontrado;

    public MostrarEmpleadosPorNivelSAXHandler(String filtro) {
        this.filtro = filtro;
        etiqueta = "";
        contador = 1;
        encontrado = false;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("#### EMPLEADOS CON FILTRO: " + filtro);
    }

    @Override
    public void endDocument() throws SAXException {
        if (!encontrado) System.out.println("#NO HAY EMPLEADOS EN ESE NIVEL");
        System.out.println("####FIN MOSTRAR EMPLEADOS");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        etiqueta = qName;
        if (qName.equals("empleado")) {
            id = attributes.getValue("id");
            nivel = attributes.getValue("nivel");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        etiqueta = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String car = new String(ch, start, length);
        car = car.replaceAll("\n", "");
        car = car.replaceAll("\t", "");
        car = car.trim();

        if (filtro.equals("") || filtro.equals(nivel)) {
            encontrado = true;
            switch (etiqueta) {
                case "empleado" -> {
                    System.out.println("## EMPLEADO NÚMERO " + contador++);
                }
                case "nombre" -> {
                    System.out.println("#ID: " + id);
                    System.out.println("#NOMBRE: " + car);
                    System.out.println("#NIVEL: " + nivel);
                }
                case "cargo" -> {
                    System.out.println("#CARGO: " + car );
                }
                case "departamento" -> {
                    System.out.println("#DEPARTAMENTO: " + car);
                }
                case "fechaContratacion" -> {
                    System.out.println("#FECHA CONTRATACIÓN: " + car + " (" + 
                            (LocalDate.now().getYear() - LocalDate.parse(car).getYear()) +
                            " AÑOS CONTRATADO)");
                }
                case "telefono" -> {
                    System.out.println("#TELEFONO: " + car);
                }
            }
        }
    }
}
