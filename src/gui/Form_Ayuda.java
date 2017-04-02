
package gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import mundo.SistemaHTML;


/**
 * Formulario de Ayuda
 * @author 1151061, 1151123. 
 */
public class Form_Ayuda extends javax.swing.JFrame {

    private Form_Principal myPrin;
   
    /**
     * Constructor del Formulario de ayuda.
     * @param x Guarda la referencia al formulario principal del programa.
     */
    public Form_Ayuda(Form_Principal x) {
        initComponents();
        this.myPrin = x;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TxtEtiqueta = new javax.swing.JTextField();
        Cmd_Buscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TxtTipo = new javax.swing.JTextField();
        TxtDescripcion = new javax.swing.JTextField();
        cmd_Salir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(411, 352));
        setPreferredSize(new java.awt.Dimension(411, 352));
        getContentPane().setLayout(null);
        getContentPane().add(TxtEtiqueta);
        TxtEtiqueta.setBounds(160, 120, 138, 20);

        Cmd_Buscar.setText("Buscar");
        Cmd_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmd_BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(Cmd_Buscar);
        Cmd_Buscar.setBounds(300, 120, 70, 23);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(230, 59, 13, 0);

        TxtTipo.setEditable(false);
        getContentPane().add(TxtTipo);
        TxtTipo.setBounds(160, 170, 212, 20);

        TxtDescripcion.setEditable(false);
        getContentPane().add(TxtDescripcion);
        TxtDescripcion.setBounds(160, 220, 212, 20);

        cmd_Salir.setText("Salir");
        cmd_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_SalirActionPerformed(evt);
            }
        });
        getContentPane().add(cmd_Salir);
        cmd_Salir.setBounds(170, 270, 64, 23);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/fondo2.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 400, 320);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cmd_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmd_BuscarActionPerformed
        String etiqueta = this.TxtEtiqueta.getText();
        String resultado = this.myPrin.getMySistema().buscarEtiqueta(etiqueta);
        if (resultado.equals("no existe etiqueta")) {
            JOptionPane.showMessageDialog(null, "La etiqueta que está buscando no hace parte del estándar W3C");
            this.TxtDescripcion.setText("");
            this.TxtTipo.setText("");
            this.TxtDescripcion.setText("");
            return;
        }
        String dato[] = resultado.split(";");
        this.TxtTipo.setText(dato[0]);
        this.TxtDescripcion.setText(dato[1]);

    }//GEN-LAST:event_Cmd_BuscarActionPerformed

    private void cmd_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_SalirActionPerformed
        this.myPrin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cmd_SalirActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cmd_Buscar;
    private javax.swing.JTextField TxtDescripcion;
    private javax.swing.JTextField TxtEtiqueta;
    private javax.swing.JTextField TxtTipo;
    private javax.swing.JButton cmd_Salir;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
