
package gui;

import util.IForm;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.ArchivoGuardar;

/**
 * Formulario que muestra un informe de errores.
 * @author 1151061, 1151123.
 */
public class Form_Validar extends javax.swing.JFrame implements IForm{

    private Form_EditorHTML myFE;
    private String errores;
    
    /**
     * Constructor del formulario. 
     * @param myFE Referencia al formulario de edición de HTML.
     * @param errores Recopilado de errores que luego se usará para generar el informe.
     * @param archivo Código que fue analizado.
     */
    public Form_Validar(Form_EditorHTML myFE,String errores, String archivo) {
        initComponents();
        this.errores=errores;
        this.myFE=myFE;
        this.txt_Fuente.setText(archivo);
        this.llenarInforme();
        this.addWindowListener(this.crearCeerradoPersonalizado());
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
                myFE.setVisible(true);
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
    
    /**
     * Llena el informe que luego se mostrará al usuario en forma de tabla. 
     */
    private void llenarInforme() {
        String[] datos = this.errores.split("-@");
        DefaultTableModel myModel = new DefaultTableModel();
        myModel.setColumnCount(0);
        myModel.addColumn("Etiqueta");
        myModel.addColumn("Error");
        myModel.setNumRows(datos.length);
        for (int i = 0; i < datos.length; i++) {
            String[] info = datos[i].split(";");
            if (info[0].equals("<html>")) {
                myModel.setValueAt("\n<html>", i, 0);
                myModel.setValueAt(info[1], i, 1);
            } else {
                myModel.setValueAt(info[0], i, 0);
                myModel.setValueAt(info[1], i, 1);
            }
        }
        this.tabla.setModel(myModel);
    }

    /**
     * Método implementado de IForm que permite guardar y cargar archivos del equipo.
     * @param cad Ruta del archivo.
     * @param val Es true si se quiere cargar un archivo y false si se lo desea guardar. 
     */
    @Override
    public void cargarArchivo(String cad, boolean val) {
        try {
            ArchivoGuardar myA= new ArchivoGuardar();  
            myA.createPdf(cad,this.errores);
            this.setEnabled(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Fuente = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(556, 629));
        setPreferredSize(new java.awt.Dimension(556, 629));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);

        jButton1.setText("Guardar Informe");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Etiqueta", "Error"
            }
        ));
        jScrollPane2.setViewportView(tabla);

        txt_Fuente.setEditable(false);
        txt_Fuente.setColumns(20);
        txt_Fuente.setRows(5);
        jScrollPane1.setViewportView(txt_Fuente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 546, 602);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/fondo3.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 550, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Form_Archivos myFA = new Form_Archivos(this, false);
        myFA.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTextArea txt_Fuente;
    // End of variables declaration//GEN-END:variables
}
