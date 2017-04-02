package mundo;

/**
 * Clase que almacena una etiqueta con su respectivo error.
 * @author 1151123, 1151061.
 */
public class ErrorHTML {

    private Error myError;
    private EtiquetaHTML myEtiqueta;

    /**
     * Constructor sin parametros.
     */
    public ErrorHTML() {
    }

    /**
     * Constructor con parametros.
     * @param myError Almacena la referencia al error.
     * @param myEtiqueta Almacena la referencia al la etiqueta.
     */
    public ErrorHTML(Error myError, EtiquetaHTML myEtiqueta) {
        this.myError = myError;
        this.myEtiqueta = myEtiqueta;
    }

    /**
     * Get del atributo myError.
     * @return Retorna el atributo myError.
     */
    public Error getMyError() {
        return myError;
    }

    /**
     * Actualiza el atributo myError.
     * @param myError Referencia que se usará para reemplazar la ya almacenada.
     */
    public void setMyError(Error myError) {
        this.myError = myError;
    }

    /**
     * Get del atributo myEtiqueta.
     * @return el atributo myEtiqueta.
     */
    public EtiquetaHTML getMyEtiqueta() {
        return myEtiqueta;
    }

    /**
     * Actualiza el atributo myEtiqueta.
     * @param myEtiqueta Referencia que se usará para reemplazar la ya almacenada.
     */
    public void setMyEtiqueta(EtiquetaHTML myEtiqueta) {
        this.myEtiqueta = myEtiqueta;
    }

    /**
     * Método que retorna en una cadena la imformación contenida.
     * @return Retorna una cadena con al información.
     */
    public String toString() {
        return this.myEtiqueta.getEtiqueta() + ";" + this.myError.getDescipcion();
    }
}
