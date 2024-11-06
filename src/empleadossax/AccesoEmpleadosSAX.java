/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleadossax;

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

    public int mostrarEmpleadosPorNivelSAXhandler(File f, String filtro) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
            MostrarEmpleadosPorNivelSAXHandler mh = new MostrarEmpleadosPorNivelSAXHandler(filtro);
            
            parser.parse(f, mh);
            return 0;

        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println("Error IOException/ParserConfigurationException !!!");
            e.printStackTrace();

            return -1;
        }
    }

}
