
package mundo;

/**
 * Clase que guarda la información de una etiqueta HTML.
 * @author 1151123, 1151061.
 */
public class EtiquetaHTML {
    
    private String etiqueta;
    private String descipcion;

    /**
     * Contructor sin parametros.
     */
    public EtiquetaHTML() {
    }

    /**
     * Constructor con parametros. 
     * @param etiqueta Cadena que contiene la etiqueta HTML.
     * @param descipcion Cadena que contiene la descripción de la etiqueta. 
     */
    public EtiquetaHTML(String etiqueta, String descipcion) {
        this.etiqueta = etiqueta;
        this.descipcion = descipcion;
    }

    /**
     * Get del atributo etiqueta.
     * @return Retorna el atributo etiqueta. 
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Método que actualiza el atributo etiqueta.
     * @param etiqueta Etiqueta con la cual se reemplazará la ya almacenada.
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * Get del atributo desciocion.
     * @return Retorna el atributo descripcion. 
     */
    public String getDescipcion() {
        return descipcion;
    }

    /**
     * Método que actualiza el atributo descripcion.
     * @param descipcion Descrioción con la cual se reemplazará la ya almacenada.
     */
    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    /**
     * Método que retorna en una cadena la imformación contenida.
     * @return Retorna una cadena con al información.
     */
    public String toString(){
        return this.etiqueta+";"+this.descipcion;
    }
    
    
}
