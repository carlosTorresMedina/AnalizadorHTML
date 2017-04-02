
package util;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * Clase que permite crear un FileFilter personalizado.
 * @author 1151061
 */
public class FiltroArchivos extends FileFilter {
    
    private String extension;
    private String descripcion;

    public FiltroArchivos(String extension, String descripcion) {
        this.descripcion=descripcion;
        this.extension=extension;
    }


    @Override
    public boolean accept(File file) {
        if(file.isDirectory())
            return true;
        else if(file.getName().endsWith(extension))
            return true;
        return false;
    }

    @Override
    public String getDescription() {
        return this.descripcion;
    }
    
}
