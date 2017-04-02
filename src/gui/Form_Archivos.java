package gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import util.FiltroArchivos;
import util.IForm;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * Formulario que permite tener una vista al explorador de archivos del sistema operativo.
 * @author 1151061, 1151123.
 */
public class Form_Archivos extends javax.swing.JFrame {

    private IForm myF;
    private boolean tipo;

    /**
     * Constructor del Formulario.
     * @param myF Referencia al formulario que ha cargado el selector de archivos.
     * @param tipo Define el tipo de selector de archivos, true para cargar archivos false para solo abrir carpetas. 
     */
    public Form_Archivos(IForm myF, boolean tipo) {
        initComponents();
        this.myF = myF;
        this.tipo = tipo;
        this.definirTipo(this.tipo);
        this.addWindowListener(this.crearCeerradoPersonalizado());
    }
    
    /**
     * Ajusta el selector de archivos para mostrar solo archivos de texto y HTML.
     */
    private void armarParaSelector() {
        this.selectorArchivos.setFileFilter(new FiltroArchivos("txt", "Archivos de texto txt"));
        this.selectorArchivos.setFileFilter(new FiltroArchivos("html", "Archivos de texto html"));
        this.selectorArchivos.setFileFilter(new FiltroArchivos("htm", "Archivos de texto htm"));
        this.selectorArchivos.setAcceptAllFileFilterUsed(false);
    }
    
    /**
     * Ajusta el selector de archivos para mostrar solo carpetas.
     */
    private void ararParaCarpeta() {
        this.selectorArchivos.setAcceptAllFileFilterUsed(false);
        this.selectorArchivos.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }
    
    /**
     * Define que tipo de selector de archivos se requiere
     * @param tipo Es true si se desea mostrar archivos y false si se desea mostrar solo carpetas. 
     */
    private void definirTipo(boolean tipo) {
        if (tipo) {
            this.armarParaSelector();
        } else {
            this.ararParaCarpeta();
        }
    }
    /**
     * Crea un WindowListener personalizado para el formularo. 
     * @return Retorna un WindowListener con eventos personalizados. 
     */
    private WindowListener crearCeerradoPersonalizado() {
        WindowListener myL = new WindowListener() {
            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
            }

            @Override
            public void windowClosed(WindowEvent we) {
                JFrame myFM = (JFrame) myF;
                myFM.setEnabled(true);
            }

            @Override
            public void windowIconified(WindowEvent we) {
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
            }

            @Override
            public void windowActivated(WindowEvent we) {
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
            }
        };
        return myL;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectorArchivos = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        selectorArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectorArchivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(selectorArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(selectorArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectorArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectorArchivosActionPerformed
        String comando = evt.getActionCommand();
        if (comando.equals(JFileChooser.APPROVE_SELECTION)) {
            this.myF.cargarArchivo(this.selectorArchivos.getSelectedFile().getAbsolutePath(), this.tipo);
            this.dispose();
        } else if (comando.equals(JFileChooser.CANCEL_SELECTION)) {
            this.dispose();
        }
    }//GEN-LAST:event_selectorArchivosActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser selectorArchivos;
    // End of variables declaration//GEN-END:variables
}
