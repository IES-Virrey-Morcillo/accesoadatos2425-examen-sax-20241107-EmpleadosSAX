/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleadossax;

import exceptions.AbortParseException;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author josema
 */
public class AccesoEmpleadosSAX {

    SAXParser parser;

    public int ejemploSAXhandler(File f) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
            EjemploSAXHandler mh = new EjemploSAXHandler();
            parser.parse(f, mh);
            return 0;

        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Error IOException/ParserConfigurationException !!!");
            e.printStackTrace();

            return -1;
        }
    }

    public int mostrarPorNivel(File f, String filtro) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
            if (filtro == null) {
                System.out.println("#### EL FILTRO NO PUEDE SER NULO. NO SE ANALIZA EL FICHERO.");
                return -1;
            }
            MostrarFiltroSAXHandler mh = new MostrarFiltroSAXHandler(filtro);
            parser.parse(f, mh);
            return 0;

        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Error IOException/ParserConfigurationException !!!");
            e.printStackTrace();

            return -1;
        }
    }

    public int encontrarEmpleado(File f, String id) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
            if (id == null) {
                System.out.println("#### EL id NO PUEDE SER NULO. NO SE ANALIZA EL FICHERO.");
                return -1;
            }
            EncontrarEmpleadoSAXHandler mh = new EncontrarEmpleadoSAXHandler(id);
            parser.parse(f, mh);
            return 0;

        } catch (AbortParseException e) {
            if (e.getCodigo() != 0) {
                System.out.println("ERROR: " + e.getMessage());
            }
            return e.getCodigo();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Error IOException/ParserConfigurationException !!!");
            e.printStackTrace();

            return -1;
        }
    }
    public int revisarEmpleado(File f, String linea) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();

            RevisarIDSAXHandler mh = new RevisarIDSAXHandler(linea);
            parser.parse(f, mh);
            return 0;

        } catch (AbortParseException e) {
            if (e.getCodigo() != 0) {
                System.out.println("ERROR: " + e.getMessage());
            }
            return e.getCodigo();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Error IOException/ParserConfigurationException !!!");
            e.printStackTrace();

            return -1;
        }
    }
}
