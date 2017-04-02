package util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Date;

/**
 * Clase que permite guardar archivos de texto.
 * @author 1151061
 */
public class ArchivoGuardar {

    /**
     * Guarda un archivo de texto en una determinada ruta y con un determinado
     * nombre.
     * @param nombre Nombre dle archivo.
     * @param archivo Contenido del archivo.
     * @return Retorna true si el guardado fue exitoso o false en caso
     * contrario.
     * @throws Exception Redirecciona las posibles excepciones.
     */
    public boolean guardarAtchivo(String nombre, String archivo) throws Exception {
        boolean exito = false;
        FileWriter fstream = new FileWriter(nombre);
        BufferedWriter out = new BufferedWriter(fstream);
        out.write(archivo);
        out.close();
        exito = true;
        return exito;
    }
     /**
      * Crea un archivo pdf.
      * @param filename Nombre del archivo-
      * @param cad Datos que se desean almacenar. 
      * @throws Exception Redirecciona las posibles excepciones. 
      */
    public void createPdf(String filename, String cad) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename + "\\informe.pdf"));
        document.setMargins(75, 75, 80, 80);
        document.open();
        Date fecha = new Date();
        document.add(new Paragraph("Informe de errores analizador HTML. \n" + fecha.toString() + "\n\n\n\n"));
        PdfPTable table = this.crearTabla(cad);
        table.setSpacingBefore(7);
        table.setSpacingAfter(7);
        document.add(table);
        document.close();

    }

    /**
     * Crea una tabla
     * @param cad Almacena los datos que se guardaran en la tabla.
     * @return Retoruna PdfPTable lista para ser insertada en le documento.
     * @throws Exception Captura las posibles excepciones.
     */
    public PdfPTable crearTabla(String cad) throws Exception {
        String[] v = cad.split("-@");
        PdfPTable table = new PdfPTable(2);
        table.setTotalWidth(350);
        table.setLockedWidth(true);
        table.setWidths(new float[]{1, 3});
        PdfPCell cell;
        table.addCell("Etiqueta");
        table.addCell("Descrición del error");
        for (int i = 0; i < v.length; i++) {
            String[] temp = v[i].split(";");
            table.addCell(temp[0]);
            table.addCell(temp[1]);
        }
        return table;
    }
}
