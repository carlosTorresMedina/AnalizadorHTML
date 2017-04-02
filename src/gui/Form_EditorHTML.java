package gui;

import util.IForm;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mundo.SistemaHTML;
import mundo.TagGeneral;
import ufps.util.ExceptionUFPS;
import ufps.util.ListaCD;
import ufps.util.Secuencia;
import util.ArchivoGuardar;

/**
 * Formulario que permite manipular codigo HTML.
 * @author 1151061, 1151123.
 */
public class Form_EditorHTML extends javax.swing.JFrame implements IForm {

    private Form_Principal myPrin;
    private Form_EditorHTML myE;

    /**
     * Constructor del formulario.
     * @param x Almacena la referencia al formulario principal. 
     */
    public Form_EditorHTML(Form_Principal x) {
        initComponents();
        this.myPrin = x;
        this.myE = this;
        this.addWindowListener(this.crearCeerradoPersonalizado());
        this.llenarTags();
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
                myPrin.setVisible(true);
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
     * Llena los ComboBox del formulario con las etiquetas. 
     */
    private void llenarTags() {
        Secuencia<TagGeneral> tags = this.myPrin.getMySistema().getTags();
        this.cmb_tag.addItem("No selección");
        for (int i = 0; i < tags.length(); i++) {

            this.cmb_tag.addItem(tags.get(i).getTipo());
        }
    }
    /**
     * Método implementado de IForm que permite guardar y cargar archivos del equipo.
     * @param cad Ruta del archivo.
     * @param val Es true si se quiere cargar un archivo y false si se lo desea guardar. 
     */
    @Override
    public void cargarArchivo(String cad, boolean val) {
        if (val) {
            String resultado = "";
            try {
                resultado = this.myPrin.getMySistema().cargarArchivoLocal(cad);
                this.TxtFuente.setText(resultado);
                this.setEnabled(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo");
            } finally {
                this.setEnabled(true);
            }
        } else {
            ArchivoGuardar myA = new ArchivoGuardar();
            try {
                boolean exito = myA.guardarAtchivo(cad, this.TxtFuente.getText());
                if(exito)
                    JOptionPane.showMessageDialog(null, "El archivo se ha guardado con éxito.");
                else
                    JOptionPane.showMessageDialog(null, "El archivo no se ha guardado, verifique que tenga permisos para hacerlo.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo.");
            } finally {
                this.setEnabled(true);
            }
        }
    }
    /**
     * Toma el URL digitado y lo envía al negocio para cargar a partir de él el archivo. 
     * @param url Dirección URL en donde que indica en qué lugar se encuentra alojado el archivo. 
     */
    private void cargarTextoURL(String url) {
        String resultado = "";
        try {
            resultado = this.myPrin.getMySistema().cargarArchivoURL(url);
            this.TxtFuente.setText(resultado);
        } catch (ExceptionUFPS ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TxtFuente = new javax.swing.JTextArea();
        panel3 = new javax.swing.JPanel();
        cmd_Guardar = new javax.swing.JButton();
        cmdSalir = new javax.swing.JButton();
        panel1 = new javax.swing.JPanel();
        cmb_tag = new javax.swing.JComboBox();
        cmb_etiqueta = new javax.swing.JComboBox();
        panel2 = new javax.swing.JPanel();
        cmb_ArchivoLocal = new javax.swing.JButton();
        txtUrl = new javax.swing.JTextField();
        cmd_Abrir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(806, 519));
        setPreferredSize(new java.awt.Dimension(806, 519));
        setResizable(false);
        getContentPane().setLayout(null);

        TxtFuente.setColumns(20);
        TxtFuente.setRows(5);
        jScrollPane1.setViewportView(TxtFuente);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 110, 460, 360);

        panel3.setOpaque(false);

        cmd_Guardar.setText("Guardar");
        cmd_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_GuardarActionPerformed(evt);
            }
        });

        cmdSalir.setText("Salir");
        cmdSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(cmdSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmd_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmd_Guardar)
                    .addComponent(cmdSalir))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(panel3);
        panel3.setBounds(500, 370, 280, 70);

        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        panel1.setOpaque(false);

        cmb_tag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tagActionPerformed(evt);
            }
        });

        cmb_etiqueta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_etiquetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmb_etiqueta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_tag, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmb_tag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmb_etiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(panel1);
        panel1.setBounds(500, 110, 280, 100);

        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        panel2.setOpaque(false);

        cmb_ArchivoLocal.setText("Buscar en la PC");
        cmb_ArchivoLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_ArchivoLocalActionPerformed(evt);
            }
        });

        cmd_Abrir.setText("Buscar en la red");
        cmd_Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_AbrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(cmb_ArchivoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(cmd_Abrir))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_ArchivoLocal)
                    .addComponent(cmd_Abrir))
                .addGap(49, 49, 49)
                .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panel2);
        panel2.setBounds(500, 230, 280, 120);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/gui2.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 800, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_etiquetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_etiquetaActionPerformed
        if (!(this.cmb_etiqueta.getItemCount() <= 1)) {
            String etiqueta = this.cmb_etiqueta.getSelectedItem().toString();
            if (etiqueta.equalsIgnoreCase("No selección")) {
                JOptionPane.showMessageDialog(null, "Selecciones una etiqueta");
                return;
            }
            if (etiqueta.equals("<!DOCTYPE> ") || etiqueta.equals("<!--...-->")) {
                this.TxtFuente.insert(etiqueta, this.TxtFuente.getCaretPosition());
                return;
            }
            String[] temp = etiqueta.split("<");
            String cierre = "</" + temp[1];
            this.TxtFuente.insert(etiqueta + " " + cierre, this.TxtFuente.getCaretPosition());
        }
    }//GEN-LAST:event_cmb_etiquetaActionPerformed

    private void cmb_tagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tagActionPerformed
        this.cmb_etiqueta.removeAllItems();
        this.cmb_etiqueta.addItem("No selección");
        if (!this.cmb_tag.getSelectedItem().toString().equals("No selección")) {
            String cad = this.myPrin.getMySistema().buscarTag(this.cmb_tag.getSelectedItem().toString()).toString();
            String[] temp = cad.split("@-");
            for (String dato : temp) {
                String[] v = dato.split(";");
                if (!v[0].contains("/")) {
                    if (v[0].equals("<html>")) {
                        this.cmb_etiqueta.addItem("<html>");

                    } else {
                        this.cmb_etiqueta.addItem(v[0]);
                    }

                }
            }
        }
    }//GEN-LAST:event_cmb_tagActionPerformed

    private void cmdSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSalirActionPerformed
        this.myPrin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cmdSalirActionPerformed

    private void cmb_ArchivoLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_ArchivoLocalActionPerformed
        Form_Archivos f = new Form_Archivos(this, true);
        f.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_cmb_ArchivoLocalActionPerformed

    private void cmd_AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_AbrirActionPerformed
        if (this.txtUrl.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor digite una URL");
        } else {
            this.cargarTextoURL(this.txtUrl.getText());
        }
    }//GEN-LAST:event_cmd_AbrirActionPerformed

    private void cmd_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_GuardarActionPerformed
        try {
            this.myPrin.getMySistema().Analizador(this.TxtFuente.getText());
            String cadena = this.myPrin.getMySistema().mostrarPilaErrores();
            if (cadena.equalsIgnoreCase("el archivo es correcto")) {
                Form_Archivos f = new Form_Archivos(this, false);
                f.setVisible(true);
                this.setEnabled(false);
            } else {
                Form_Validar myFv = new Form_Validar(this, cadena, this.TxtFuente.getText());
                myFv.setVisible(true);
                this.setVisible(false);
            }
        } catch (ExceptionUFPS ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_cmd_GuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TxtFuente;
    private javax.swing.JButton cmb_ArchivoLocal;
    private javax.swing.JComboBox cmb_etiqueta;
    private javax.swing.JComboBox cmb_tag;
    private javax.swing.JButton cmdSalir;
    private javax.swing.JButton cmd_Abrir;
    private javax.swing.JButton cmd_Guardar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JTextField txtUrl;
    // End of variables declaration//GEN-END:variables
}
