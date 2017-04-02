package mundo;

import ufps.util.Cola;

/**
 * Clase que almacena un grupo de tiquetas del mismo tipo. 
 * @author 1151123, 1151061.
 */
public class TagGeneral {

    private String tipo;
    private Cola<EtiquetaHTML> etiquetas;

    /**
     * Contructor sin parametros. 
     */
    public TagGeneral() {
    }

    /**
     * Contructor con parametros. 
     * @param tipo Define le tipo de etiquetas.
     * @param etiquetas Cadena que contiene las etiquetas que se van a almacenar. 
     */
    public TagGeneral(String tipo, String etiquetas) {
        this.tipo = tipo;
        this.etiquetas = new Cola<EtiquetaHTML>();
        this.separarEtiqueta(etiquetas);
    }

    /**
     * Método que se encarga de crear las etiquetas que se van a alamacenar. 
     * @param e Cadena que contiene las etiquetas que se van a almacenar. 
     */
    private void separarEtiqueta(String e) {
        String[] temp = e.split("@-");
        for (int i = 0; i < temp.length; i++) {
            String[] dato = temp[i].split(";");

            if (dato[0].equals("<h1> to <h6>")) {
                crearEtiquetaEspecial(dato[1]);

            } else if (dato[0].equals("<!--...-->")) {
                EtiquetaHTML d = new EtiquetaHTML(dato[0], dato[1]);
                this.etiquetas.enColar(d);

            } else if (dato[0].equals("<!DOCTYPE> ")) {
                EtiquetaHTML d = new EtiquetaHTML(dato[0], dato[1]);
                this.etiquetas.enColar(d);

            } else if (dato[0].equals("<html>") || dato[0].equals("<head>") || dato[0].equals("<title>") || dato[0].equals("<body>")) {
                EtiquetaHTML d = new EtiquetaHTML(dato[0], dato[1]);
                this.etiquetas.enColar(d);
                String dat = dato[0];

                String aux = dat.substring(1, dat.length() - 1);
                EtiquetaHTML c = new EtiquetaHTML("</" + aux + ">", dato[1]);
                this.etiquetas.enColar(c);

            } else {
                String dat = dato[0];
                EtiquetaHTML d = new EtiquetaHTML(dat, dato[1]);
                this.etiquetas.enColar(d);
                String aux = dat.substring(1, dat.length() - 1);
                EtiquetaHTML c = new EtiquetaHTML("</" + aux + ">", dato[1]);
                this.etiquetas.enColar(c);
                EtiquetaHTML b = new EtiquetaHTML("<" + aux + "/>", dato[1]);
                this.etiquetas.enColar(b);
            }
        }
    }

    /**
     * Método que retorna un objeto etiqueta.
     * @param etiqueta Define la etiqueta que se desea buscar. 
     * @return Retorna la referencia de la etiqueta que se buscó. Es null si no se ha encontrado la etiqueta. 
     */
    protected EtiquetaHTML buscarEtiqueta(String etiqueta) {
        EtiquetaHTML aux2 = null;
        Cola<EtiquetaHTML> aux = new Cola();
        while (!this.etiquetas.esVacio()) {
            EtiquetaHTML x = this.etiquetas.deColar();
            if (x.getEtiqueta().equalsIgnoreCase(etiqueta)) {
                aux2 = x;
            }
            aux.enColar(x);
        }
        this.etiquetas = aux;
        return aux2;
    }

    /**
     * Método que se encarga de crear las etiquetas h1,h2,h3,h4,h5,h6;
     * @param def Almacena la descripción de la etiqueta. 
     */
    private void crearEtiquetaEspecial(String def) {
        for (int i = 1; i < 7; i++) {
            EtiquetaHTML n = new EtiquetaHTML("<h" + i + ">", def);
            this.etiquetas.enColar(n);
            EtiquetaHTML c = new EtiquetaHTML("</h" + i + ">", def);
            this.etiquetas.enColar(c);
            EtiquetaHTML b = new EtiquetaHTML("<h" + i + "/>", def);
            this.etiquetas.enColar(b);
        }
    }

    /**
     * Get del atributo tipo.
     * @return Retorna el atributo tipo.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método que actualiza el atributo tipo.
     * @param tipo Define el tipo de etiqueta por el que se va a reemplazar el ya exitente. 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Get del atributo etiquetas.
     * @return Retorna la cola de etiquetas.
     */
    public Cola<EtiquetaHTML> getEtiquetas() {
        return etiquetas;
    }

    /**
     * Método que actualiza la cola de etiquetas.
     * @param etiquetas Etiquetas que se usarán para reemplazar las ya existentes. 
     */
    public void setEtiquetas(Cola<EtiquetaHTML> etiquetas) {
        this.etiquetas = etiquetas;
    }

    /**
     * Método que retorna en una cadena la imformación contenida.
     * @return Retorna una cadena con al información.
     */
    public String toString() {
        Cola<EtiquetaHTML> temp = new Cola();
        String cad = "";
        while (!this.etiquetas.esVacio()) {
            EtiquetaHTML dato = this.etiquetas.deColar();
            cad += dato.toString() + "@-";
            temp.enColar(dato);
        }
        this.etiquetas = temp;
        return cad;
    }
}
