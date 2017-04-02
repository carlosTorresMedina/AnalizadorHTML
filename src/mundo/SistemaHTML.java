package mundo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ufps.util.ArchivoLeerTexto;
import ufps.util.ArchivoLeerURL;
import ufps.util.Cola;
import ufps.util.ExceptionUFPS;
import ufps.util.ListaCD;
import ufps.util.Pila;
import ufps.util.Secuencia;

/**
 * Clase que se encarga de la edición y validación del codigo HTML.
 * @author 1151123, 1151061.
 */
public class SistemaHTML {

    private Secuencia<TagGeneral> tags;
    private ListaCD<String> filasDelArchivo;
    private Pila<ErrorHTML> errores;
    private Error error1;
    private Error error2;
    private Error error3;
    private Error error4;
    
    /**
     * Contrcutor.
     * @throws ExceptionUFPS Redirecciona las posibles excepciones.
     */
    public SistemaHTML() throws ExceptionUFPS {
        this.error1 = new Error("etiqueta no reconocida");
        this.error2 = new Error("no tiene etiqueta de estructura");
        this.error3 = new Error("no tiene etiqueta de inicio");
        this.error4 = new Error("no tiene etiqueta de cierre");
        this.errores = new Pila();
        this.tags = new Secuencia<>(12);
        this.leertagsGeneral();
    }

    /**
     * Método que tiene como función leer el archivo de tags en la web y crear
     * los diferentes tags En el mundo.
     * @throws ExceptionUFPS Redirecciona las posibles excepciones.
     */
    private void leertagsGeneral() throws ExceptionUFPS {
        Object obj[] = this.leerURL("http://sandbox1.ufps.edu.co/~madarme/estructuras/html_w3c.txt");
        this.crearTag(obj);
    }

    /**
     * Get del atributo TagGeneral.
     * @return Retorna el atributo tags.
     */
    public Secuencia<TagGeneral> getTags() {
        return tags;
    }

/**
 * Método que se encarga de buscar un tag en la secuencia.
 * @param tipo Define le tipo de etiqueta que se desea buscar. 
 * @return Retorna los datos de la etiqueta. 
 */
    public String buscarTag(String tipo) {
        for (TagGeneral x : tags) {

            if (x.getTipo().equals(tipo)) {
                return x.toString();
            }
        }
        return "";
    }

    /**
     * Metodo que lee un archivo alojado en la web mediante su dirección URL.
     * @param url Dirección URL en la que que se encuentra el archivo. 
     * @return Retorna un arreglo de Objetos con las lineas que se descargaron del archivo. 
     * @throws ExceptionUFPS Se lanza en caso de no exitor un archivo alojado en la web quecorresponda a la URL espesificada. 
     */
    private Object[] leerURL(String url) throws ExceptionUFPS {
        Object obj[];
        try {
            ArchivoLeerURL file = new ArchivoLeerURL(url);
            obj = file.leerArchivo();
        } catch (Exception e) {
            throw new ExceptionUFPS("Error al cargar.");
        }
        return obj;
    }

    /**
     * Método que se encarga de verificar si un url es de un documento htm o
     * html.
     * @param url Dirección URL en la que que se encuentra el archivo. 
     * @throws ExceptionUFPS Se lanza en caso de no ser un documento valido. 
     */
    private void validarDocumentoHTML(String url) throws ExceptionUFPS {
        try {
            String v[] = url.split("/");
            String x = v[v.length - 1];
            int i = x.indexOf(".");
            x = x.substring(i + 1, x.length());
            if (!x.equalsIgnoreCase("htm") && !x.equalsIgnoreCase("html")) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new ExceptionUFPS("error el documento no se puede validar");
        }
    }

    /**
     * Método que crea los diferentes tag en base al parámetro obj.
     * @param obj Almacena un arreglo de lineas de codigo. 
     */
    private void crearTag(Object[] obj) {
        String tipo = "";
        String cadena = "";
        String aux[] = null;
        int i = 0;
        for (Object o : obj) {
            String[] v = o.toString().split(";");
            if (tipo.isEmpty()) {
                tipo = v[0];
            }
            if (tipo.equals(v[0])) {
                cadena += v[1] + ";" + v[2] + "@-";
            } else {
                this.tags.set(i, new TagGeneral(tipo, cadena));
                cadena = v[1] + ";" + v[2] + "@-";
                tipo = v[0];
                aux = v;
                i++;
            }
        }
        this.tags.set(11, new TagGeneral(aux[0], cadena));
    }

    /**
     * Método que tiene como función buscar una etiqueta en el sistemas y
     * retornar su tipo y descripción.
     * @param etiqueta Etiqueta que se deea buscar. 
     * @return Retirorna  una etiqueta con tu tipo y descripción. Ejemplo: "tipo;descripción"
     */
    public String buscarEtiqueta(String etiqueta) {
        String dato = "<" + etiqueta + ">";
        EtiquetaHTML resultado;
        for (int i = 0; i < this.tags.length(); i++) {
            resultado = this.tags.get(i).buscarEtiqueta(dato);
            if (resultado != null) {
                return this.getTags().get(i).getTipo() + ";" + resultado.getDescipcion();
            }
        }
        return "no existe etiqueta";
    }

    /**
     * Método que recibe un url, lee el archivo y retorna lo retorna en un String.
     * @param url Ubicación del archivo. 
     * @return Retorna el archivo de texto listo para tratarse. 
     * @throws ExceptionUFPS Redirecciona las posibles excepciones.
     */
    public String cargarArchivoURL(String url) throws ExceptionUFPS {
        String resultado = "";
        this.validarDocumentoHTML(url);
        Object v[] = this.leerURL(url);
        for (Object x : v) {
            resultado += x + "\n";
        }
        return resultado;
    }

    /**
     * Método que carga una archivo local lo lee y lo retorna en un String
     * @param nombreArchivo Nombre y ubicación del archivo en el ordenador. 
     * @return Retorna el archivo de texto listo para tratarse.
     * @throws ExceptionUFPS Redirecciona las posibles excepciones.
     */
    public String cargarArchivoLocal(String nombreArchivo) throws Exception {
        ArchivoLeerTexto file = new ArchivoLeerTexto(nombreArchivo, "\n");
        String v[][] = file.leerTodo();
        String resultado = "";
        for (String x[] : v) {
            for (String y : x) {
                resultado += y + "\n";
            }
        }
        return resultado;
    }

    /**
     * Método que tiene como función pasar el String al atributo filasDelArchivo.
     * @param fuente Contiene las lineas de codigo. 
     */
    private void pasarLista(String fuente) {
        String v[] = fuente.split("\n");
        this.filasDelArchivo = new ListaCD();
        for (String x : v) {
            this.filasDelArchivo.addFin(x);
        }
    }

    /**
     * Método que se encarga de mostrar los errores que existen en la pila.
     * @return retorna los errores de la siguiente manera: etiquetaError;descripcionError-@.
     */
    public String mostrarPilaErrores() {
        String cadena = "";
        if (this.errores.esVacio()) {
            return "el archivo es correcto";
        }
        while (!this.errores.esVacio()) {
            String v = errores.pop().toString();
            cadena += v + "-@";
        }
        return cadena;
    }

    /**
     * Método que se encarga de analizar y validar los errores de un documento
     * html. 
     * @param fuente Contiene el código HTML que se desea analizar. 
     * @throws ExceptionUFPS Se lanza en caso de no haber nada que analizar. 
     */
    public void Analizador(String fuente) throws ExceptionUFPS {
        Cola<String> cola = new Cola();
        Cola<String> colaEstructura = new Cola();
        Cola<String> colaEtiquetaNormal = new Cola();
        try {
            if (fuente.isEmpty()) {
                throw new Exception("no hay nada que validar");
            }
            cola = this.acomodarFuente(fuente);
            while (!cola.esVacio()) {
                String etiqueta = cola.deColar();
                if (this.validarEtiquetaExista(etiqueta)) {
                    if (validarEtiquetaEstructura(etiqueta)) {
                        colaEstructura.enColar(etiqueta);
                    } else if (!validarMonaria(etiqueta) && !this.validarComentaria(etiqueta)) {
                        colaEtiquetaNormal.enColar(etiqueta);
                    }
                }
            }
            this.analizarSintaxisEtiqueta(colaEtiquetaNormal);
            validacionEstructuras(colaEstructura);
        } catch (Exception e) {
            throw new ExceptionUFPS(e.getMessage());
        }
    }

    /**
     * Método que se encarga de acomodar la fuente retornando una cola de
     * etiquetas para evaluar. 
     * @param fuente Contiene las lineas de codigo que se desea analizar.
     * @return Retorna una cola de etiquetas lista para evaluar. 
     */
    private Cola<String> acomodarFuente(String fuente) {
        Cola<String> cola = new Cola();
        ListaCD<String> etiquetas;
        this.pasarLista(fuente);
        etiquetas = this.SeparadorEtiqueta();
        cola = this.limpiarEtiquetas(etiquetas);
        return cola;
    }

    /**
     * Método que se encarga de validar la pila con las etiquetas que sobran
     * después de analizar etiqueta por etiqueta.
     * @param pila Pila que almacena las etiquetas sobrantes de una serie de validaciones anteriores. 
     */
    private void validacionPilaEtiqueta(Pila<String> pila) {
        while (!pila.esVacio()) {
            EtiquetaHTML et = this.retornarEtiqueta(pila.pop());
            this.errores.push(new ErrorHTML(this.error4, et));
        }
    }

    /**
     * Método que se encarga de validar las etiquetas de estructura.
     * @param cola Contiene las etiquetas a evaluar.
     */
    private void validacionEstructuras(Cola<String> cola) {
        if (cola.esVacio()) {
            this.generarErroresEstructura();
        } else {
            this.generarErroresEstructura(cola);
        }
    }

    /**
     * Método que se encarga de generar los errores de estructura cuando
     * existen etiquetas de estructura.
     * @param cola Contiene las etiquetas a evaluar.
     */
    private void generarErroresEstructura(Cola<String> cola) {
        Cola<String> colaEs = this.ColaEstructura();
        cola = this.limpiarColaEstructura(cola);
        cola = this.analizarSintaxisColaEstructura(cola);
        String x = cola.deColar();
        while (!colaEs.esVacio()) {
            String y = colaEs.deColar();
            if (!y.equalsIgnoreCase(x)) {
                EtiquetaHTML et = this.retornarEtiqueta(y);
                this.errores.push(new ErrorHTML(this.error2, et));
            } else {
                if (!cola.esVacio()) {
                    x = cola.deColar();
                }
            }
        }
    }

    /**
     * Método que se encarga de validar la sintaxis de las etiquetas.
     * @param cola Contiene las etiquetas a evaluar.
     */
    private void analizarSintaxisEtiqueta(Cola<String> cola) {
        Pila<String> pila = new Pila();
        while (!cola.esVacio()) {
            String etiqueta = cola.deColar();
            if (validarEtiquetaInicio(etiqueta)) {
                pila.push(etiqueta);
            } else {
                this.validacionEtiquetas(etiqueta, pila);
            }
        }
        this.validacionPilaEtiqueta(pila);
    }

    /**
     * Método que se encarga de analizar la sintaxis de las etiquetas de
     * estructura.
     * @param cola Contiene las etiquetas a evaluar.
     * @return Retorna las etiquetas sobrantes. 
     */
    private Cola<String> analizarSintaxisColaEstructura(Cola<String> cola) {
        Cola<String> retorno = new Cola();
        Cola<String> etiquetaDocumento = new Cola();
        Cola<String> etiquetaInformacion = new Cola();
        Cola<String> etiquetaCuerpo = new Cola();
        Cola<String> etiquetaTitle = new Cola();
        while (!cola.esVacio()) {
            String y = cola.deColar();
            if (verificarEtiquetaDocumento(y)) {
                etiquetaDocumento.enColar(y);
            }
            if (verificarEtiquetaInformacion(y)) {
                etiquetaInformacion.enColar(y);
            }
            if (verificarEtiquetaTitle(y)) {
                etiquetaTitle.enColar(y);
            }
            if (verificarEtiquetaCuerpo(y)) {
                etiquetaCuerpo.enColar(y);
            }
            retorno.enColar(y);
        }
        this.analizarSintaxisEtiqueta(etiquetaDocumento);
        this.analizarSintaxisEtiqueta(etiquetaInformacion);
        this.analizarSintaxisEtiqueta(etiquetaCuerpo);
        this.analizarSintaxisEtiqueta(etiquetaTitle);
        return retorno;
    }

    /**
     * Método que se encarga de limpiar la cola dejando solo las etiquetas que
     * se pueden evaluar
     * @param cola Contiene las etiquetas a evaluar.
     * @return Retorna las etiquetas evalables.
     */
    private Cola<String> limpiarColaEstructura(Cola<String> cola) {
        boolean exito = true;
        Cola<String> retorno = new Cola();
        while (!cola.esVacio()) {
            String y = cola.deColar();
            if (exito) {
                retorno.enColar(y);
            } else {
                EtiquetaHTML et = this.retornarEtiqueta(y);
                this.errores.push(new ErrorHTML(this.error2, et));
            }
            if (y.equalsIgnoreCase("</html>")) {
                exito = false;
            }
        }
        return retorno;
    }

    /**
     * Método que se encarga de generar los errores de estuctura cuando no
     * existen etiquetas de estructura.
     */
    private void generarErroresEstructura() {
        EtiquetaHTML doc = this.retornarEtiqueta("<!doctype>");
        EtiquetaHTML htm = this.retornarEtiqueta("<html>");
        EtiquetaHTML htmC = this.retornarEtiqueta("</html>");
        EtiquetaHTML hed = this.retornarEtiqueta("<head>");
        EtiquetaHTML tit = this.retornarEtiqueta("<title>");
        EtiquetaHTML titC = this.retornarEtiqueta("</title>");
        EtiquetaHTML hedC = this.retornarEtiqueta("</head>");
        EtiquetaHTML bod = this.retornarEtiqueta("<body>");
        EtiquetaHTML bodC = this.retornarEtiqueta("</body>");
        this.errores.push(new ErrorHTML(this.error2, doc));
        this.errores.push(new ErrorHTML(this.error2, htm));
        this.errores.push(new ErrorHTML(this.error2, hed));
        this.errores.push(new ErrorHTML(this.error2, tit));
        this.errores.push(new ErrorHTML(this.error2, titC));
        this.errores.push(new ErrorHTML(this.error2, hedC));
        this.errores.push(new ErrorHTML(this.error2, bod));
        this.errores.push(new ErrorHTML(this.error2, bodC));
        this.errores.push(new ErrorHTML(this.error2, htmC));
    }

    /**
     * Método que retorna una cola con las etiquetas de estructura.
     * @return Retorna una cola con las etiquetas de estructura.
     */
    private Cola<String> ColaEstructura() {
        Cola<String> x = new Cola();
        x.enColar("<!doctype>");
        x.enColar("<html>");
        x.enColar("<head>");
        x.enColar("<title>");
        x.enColar("</title>");
        x.enColar("</head>");
        x.enColar("<body>");
        x.enColar("</body>");
        x.enColar("</html>");
        return x;
    }
    /**
     * Método que se encarga de validar las etiiquetas de apertura y de cierre.
     * @param etiqueta
     * @param pila
     */
    private void validacionEtiquetas(String etiqueta, Pila<String> pila) {
        if (pila.getSize() >= 1) {
            String e1 = pila.pop();
            e1 = e1.substring(1, e1.length() - 1);
            etiqueta = etiqueta.substring(2, etiqueta.length() - 1);
            if (!e1.equalsIgnoreCase(etiqueta)) {
                EtiquetaHTML d = this.retornarEtiqueta("<" + e1 + ">");
                ErrorHTML e = new ErrorHTML(this.error4, d);
                this.errores.push(e);
                EtiquetaHTML c = this.retornarEtiqueta("</" + etiqueta + ">");
                ErrorHTML x = new ErrorHTML(this.error3, c);
                this.errores.push(x);
            }
        } else {
            EtiquetaHTML d = this.retornarEtiqueta(etiqueta);
            ErrorHTML er = new ErrorHTML(this.error3, d);
            this.errores.push(er);
        }
    }

    /**
     * Método que se encarga de retornar un objeto etiquetaHTML según el
     * parámetro etiqueta.
     * @param etiqueta Etiqueta que se busca. 
     * @return Retorna el objeto etiquetaHTML correpondiente a la etiqueta buscada.
     */
    private EtiquetaHTML retornarEtiqueta(String etiqueta) {
        EtiquetaHTML d = null;
        if (etiqueta.equalsIgnoreCase("<!doctype>")) {
            etiqueta = etiqueta + " ";
        }
        for (int i = 0; i < this.tags.length(); i++) {
            d = this.tags.get(i).buscarEtiqueta(etiqueta);
            if (d != null) {
                return d;
            }
        }
        return null;
    }
    /**
     * Método que valida si la etiqueta es de inicio.
     * @param etiqueta Etiqueta que se va a evaluar. 
     * @return returna true si es de inicio false si no lo es. 
     */
    private boolean validarEtiquetaInicio(String etiqueta) {
        int k = etiqueta.indexOf("</");
        return (k == -1);
    }

    /**
     * Método que se encarga de validar si la etiqueta es unaria.
     * @param etiqueta Etiqueta que se va a evaluar. 
     * @return Retorna true si es unaria false si no lo es. 
     */
    private boolean validarMonaria(String etiqueta) {
        int k = etiqueta.indexOf("/>");
        return (k != -1);
    }

    /**
     * Valida si la etiqueta es de comentario. 
     * @param etiqueta Etiqueta a evaluar. 
     * @return Retorna true si es una etiqueta de comentario false si no lo es. 
     */
    private boolean validarComentaria(String etiqueta) {
        return (etiqueta.equalsIgnoreCase("<!--...-->"));
    }
    
    /**
     * Método que se encarga de validar si una determinada etiqueta es de
     * estructura. 
     * @param etiqueta Etiqueta a evaluar. 
     * @return Retorna true si es de estructura false si no lo es. 
     */
    private boolean validarEtiquetaEstructura(String etiqueta) {
        if (etiqueta.equalsIgnoreCase("<!doctype>")) {
            return true;
        }
        if (etiqueta.equalsIgnoreCase("<html>") || etiqueta.equalsIgnoreCase("</html>")) {
            return true;
        }
        if (etiqueta.equalsIgnoreCase("<head>") || etiqueta.equalsIgnoreCase("</head>")) {
            return true;
        }
        if (etiqueta.equalsIgnoreCase("<title>") || etiqueta.equalsIgnoreCase("</title>")) {
            return true;
        }
        if (etiqueta.equalsIgnoreCase("<body>") || etiqueta.equalsIgnoreCase("</body>")) {
            return true;
        }
        return false;
    }

    /**
     * Método que limpia las etiquetas.
     * @param etiquetas Contiene las etiquetas quu se desean depurar. 
     * @return Retorna las etiquetas ya depuradas. 
     */
    private Cola<String> limpiarEtiquetas(ListaCD<String> etiquetas) {
        Cola<String> aux = new Cola();
        for (String x : etiquetas) {
            int i = x.indexOf("<!-- ");
            int j = x.indexOf(" -->");
            if (i != -1) {
                if (j != -1) {
                    aux.enColar("<!--...-->");
                } else {
                    aux.enColar(x);
                }
            } else if (this.validarMonaria(x)) {
                String v[] = x.split(" ");
                if (v.length == 1) {
                    aux.enColar(v[0]);
                } else {
                    aux.enColar(v[0] + "/>");
                }
            } else if (this.validarEtiquetaInicio(x)) {
                String v[] = x.split(" ");
                if (v.length == 1) {
                    aux.enColar(v[0]);
                } else {
                    aux.enColar(v[0] + ">");
                }
            } else {
                aux.enColar(x);
            }
        }
        return aux;
    }

    /**
     * Método tiene como función convertir a String el atributo filasDeArchivos
     * a String
     * @return Returona un estring con las filas concatenadas. 
     */
    private String convertirStringLista() {
        String resultado = "";
        for (String x : this.filasDelArchivo) {
            resultado += x;
        }
        return resultado;
    }

    /**
     * Método que tiene como función separar la lista circular doble en las
     * etiquetas que esta contenga.
     * @return Retorna una lista con las etiquetas separadas. 
     */
    private ListaCD<String> SeparadorEtiqueta() {
        String resultado = "";
        boolean controlador = true;
        ListaCD<String> retorno = new ListaCD();
        resultado = this.convertirStringLista();
        while (controlador) {
            int i = resultado.indexOf("<");
            int j = resultado.indexOf(">");
            if (i == -1 || j == -1) {
                controlador = false;
            } else {
                if (i > j) {
                    resultado = resultado.substring(i + 1, resultado.length());
                } else {
                    String x = resultado.substring(i, j + 1);
                    resultado = resultado.substring(j + 1, resultado.length());
                    retorno.addFin(x);
                }
            }
        }
        return retorno;
    }

    /**
     * Valida quela etiqueta exista en el estandar AHML.
     * @param dato Etiqueta a evaluar.
     * @return Retorna true si existe false si no. 
     */
    private boolean validarEtiquetaExista(String dato) {
        boolean exito = true;
        EtiquetaHTML d = this.retornarEtiqueta(dato);
        if (d == null) {
            this.errores.push(new ErrorHTML(this.error1, new EtiquetaHTML(dato, null)));
            exito = false;
        }
        return exito;
    }

    /**
     * Método que se encarga de validar si una etiqueta es de tipo documento.
     * @param y Etiqueta a evaluar. 
     * @return Retorna true si es de tipo documento false si no lo es. 
     */
    private boolean verificarEtiquetaDocumento(String y) {
        return (y.equalsIgnoreCase("<html>") || y.equalsIgnoreCase("</html>"));
    }

    /**
     * Método que se encarga de validar si una etiqueta es de tipo información.
     * @param y Etiqueta a evaluar. 
     * @return Retorna true si es de tipo información false si no lo es.
     */
    private boolean verificarEtiquetaInformacion(String y) {
        return (y.equalsIgnoreCase("<head>") || y.equalsIgnoreCase("</head>"));
    }

    /**
     * Método que se encarga de validar si una etiqueta es de tipo title.
     * @param y Etiqueta a evaluar. 
     * @return Retorna true si es de tipo title false si no lo es.
     */
    private boolean verificarEtiquetaTitle(String y) {
        return (y.equalsIgnoreCase("<title>") || y.equalsIgnoreCase("</title>"));
    }

    /**
     * Método que se encarga de validar si una etiqueta es de tipo cuerpo.
     * @param y Etiqueta a evaluar. 
     * @return Retorna true si es de tipo cuerpo false si no lo es.
     */
    private boolean verificarEtiquetaCuerpo(String y) {
        return (y.equalsIgnoreCase("<body>") || y.equalsIgnoreCase("</body>"));
    }


}
