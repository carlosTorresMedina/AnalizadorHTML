package mundo;

 /**
  * Clase que almacena un tipo de error. 
  * @author 1151123, 1151061.
  */
public class Error {

    private String descipcion;

    /**
     * Constructor sin parametros.
     */
    public Error() {
    }

    /**
     * Constructor con parametros.
     * @param descipcion Almacena la descripción del error.
     */
    public Error(String descipcion) {
        this.descipcion = descipcion;
    }

    /**
     * Método que retorna el atributo descripción. 
     * @return Retorna la descripción.
     */
    public String getDescipcion() {
        return descipcion;
    }

    /**
     * Método que actualiza el atributo descripción.
     * @param descipcion Descripción que se usará para reemplazar la ya existente. 
     */
    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    /**
     * Método que retorna en una cadena la imformación contenida.
     * @return Retorna una cadena con al información.
     */
    public String toString() {
        return this.descipcion;
    }
}
