/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

import org.xml.sax.SAXException;

/**
 *
 * @author josema
 */
public class AbortParseException extends SAXException {
    private int codigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public AbortParseException(String message) {
        super(message);
    }
    
    public AbortParseException(String message, int codigo) {
        super(message);
        this.codigo = codigo;
    }
}
