package gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import mundo.SistemaHTML;
import ufps.util.ExceptionUFPS;

/**
 * Formulario Principal
 * @author 1151061, 1151123. 
 */
public class Form_Principal extends javax.swing.JFrame {

    private SistemaHTML mySistema;
    
    /**
     * Contructor del formulario.
     */
    public Form_Principal() {
        initComponents();
        try {
            this.mySistema = new SistemaHTML();
        } catch (ExceptionUFPS e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /**
     * Getter del negocio.
     * @return Retorna una referencia al objeto del sistema HTML.
     */
    public SistemaHTML getMySistema() {
        return mySistema;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        ayuda = new javax.swing.JLabel();
        editor = new javax.swing.JLabel();
        salir = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(595, 520));
        setPreferredSize(new java.awt.Dimension(595, 520));
        setResizable(false);
        getContentPane().setLayout(null);

        ayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/ayuda.png"))); // NOI18N
        ayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ayudaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ayudaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ayudaMouseExited(evt);
            }
        });
        getContentPane().add(ayuda);
        ayuda.setBounds(70, 270, 222, 106);

        editor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/editor.png"))); // NOI18N
        editor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editorMouseExited(evt);
            }
        });
        getContentPane().add(editor);
        editor.setBounds(20, 140, 208, 122);

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/salir.png"))); // NOI18N
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salirMouseExited(evt);
            }
        });
        getContentPane().add(salir);
        salir.setBounds(20, 380, 187, 102);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/logo.png"))); // NOI18N
        logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoMouseExited(evt);
            }
        });
        getContentPane().add(logo);
        logo.setBounds(400, 310, 185, 179);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/fondo.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 600, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        this.dispose();
    }//GEN-LAST:event_salirMouseClicked

    private void ayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ayudaMouseClicked
        Form_Ayuda d = new Form_Ayuda(this);
        d.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ayudaMouseClicked

    private void editorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editorMouseClicked
        Form_EditorHTML d = new Form_EditorHTML(this);
        d.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_editorMouseClicked

    private void logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseClicked
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                try {
                    desktop.browse(new URI("http://ingsistemas.ufps.edu.co/"));
                } catch (IOException ex) {
                    Logger.getLogger(Form_Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (URISyntaxException ex) {
                Logger.getLogger(Form_Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_logoMouseClicked

    private void logoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseEntered
        URL myURL = this.getClass().getResource("/pictures/logo2.png");
        ImageIcon myIcon = new ImageIcon(myURL);
        this.logo.setIcon(myIcon);
    }//GEN-LAST:event_logoMouseEntered

    private void logoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseExited
        URL myURL = this.getClass().getResource("/pictures/logo.png");
        ImageIcon myIcon = new ImageIcon(myURL);
        this.logo.setIcon(myIcon);
    }//GEN-LAST:event_logoMouseExited

    private void editorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editorMouseEntered
        URL myURL = this.getClass().getResource("/pictures/editor2.png");
        ImageIcon myIcon = new ImageIcon(myURL);
        this.editor.setIcon(myIcon);
    }//GEN-LAST:event_editorMouseEntered

    private void editorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editorMouseExited
        URL myURL = this.getClass().getResource("/pictures/editor.png");
        ImageIcon myIcon = new ImageIcon(myURL);
        this.editor.setIcon(myIcon);
    }//GEN-LAST:event_editorMouseExited

    private void ayudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ayudaMouseEntered
        URL myURL = this.getClass().getResource("/pictures/ayuda2.png");
        ImageIcon myIcon = new ImageIcon(myURL);
        this.ayuda.setIcon(myIcon);
    }//GEN-LAST:event_ayudaMouseEntered

    private void ayudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ayudaMouseExited
        URL myURL = this.getClass().getResource("/pictures/ayuda.png");
        ImageIcon myIcon = new ImageIcon(myURL);
        this.ayuda.setIcon(myIcon);
    }//GEN-LAST:event_ayudaMouseExited

    private void salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseEntered
        URL myURL = this.getClass().getResource("/pictures/salir2.png");
        ImageIcon myIcon = new ImageIcon(myURL);
        this.salir.setIcon(myIcon);
    }//GEN-LAST:event_salirMouseEntered

    private void salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseExited
        URL myURL = this.getClass().getResource("/pictures/salir.png");
        ImageIcon myIcon = new ImageIcon(myURL);
        this.salir.setIcon(myIcon);
    }//GEN-LAST:event_salirMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame.setDefaultLookAndFeelDecorated(true);
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new Form_Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ayuda;
    private javax.swing.JLabel editor;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel salir;
    // End of variables declaration//GEN-END:variables
}
