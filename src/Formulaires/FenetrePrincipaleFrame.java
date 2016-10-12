package Formulaires;


import GestionFichierTXT.LectureDesActifsDuFichier;
import GestionFichierTXT.LectureDuFichierComplet;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import metier.AppelJavadoc ;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;


/**
* Ouvre la fenêtre principale du logiciel. Donne accès à la gestion des clients, des prospects et des représentants.
* @author Sandrine Ociepka
* @author Stephane Coulon
* @version 1.0
*/
public class FenetrePrincipaleFrame extends javax.swing.JFrame {

    /**
    * Constructeur avec des arguments ajoutés pour créer la fenêtre à partir de la classe "Principale"
    * @param parent : déclaration de la fenêtre parent à ouvrir
    * @param modal true ou false
    * @throws java.io.IOException erreur si le fichier parent n'existe pas
    */
    public FenetrePrincipaleFrame(java.awt.Frame parent, boolean modal) throws IOException {
        initComponents();
        initialise () ;

        /**
        * Commande pour centrer la fenêtre dans l'écran
        */
        setLocationRelativeTo(null);
    }
    
    private void initialise(){
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/logo.png")));
    }
   
    /**
     * Constructeur d'origine sans arguments
     */
    public FenetrePrincipaleFrame()  {
        initComponents();
    }
    
    /**
     * Les parties en grisées ne sont modifiables que par la partie "Design".
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        lbPresentation = new javax.swing.JLabel();
        imageArbres = new javax.swing.JButton();
        lbToutBoiscest = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbBienvenue = new javax.swing.JLabel();
        imagefond = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mFichier = new javax.swing.JMenu();
        mImport = new javax.swing.JMenuItem();
        mExport = new javax.swing.JMenuItem();
        mRepresentants = new javax.swing.JMenu();
        mClients = new javax.swing.JMenu();
        mProspects = new javax.swing.JMenu();
        mAide = new javax.swing.JMenu();
        maproposde = new javax.swing.JMenuItem();
        mjavadoc = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Logiciel de gestion ToutBois");
        setBackground(new java.awt.Color(187, 235, 219));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        lbPresentation.setBackground(new java.awt.Color(255, 255, 255));
        lbPresentation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbPresentation.setText("Logiciel de gestion des représentants et de leurs clients présents et potentiels !");
        jPanel1.add(lbPresentation);
        lbPresentation.setBounds(10, 60, 550, 50);

        imageArbres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/téléchargement.jpg"))); // NOI18N
        imageArbres.setBorder(null);
        imageArbres.setMargin(new java.awt.Insets(0, 0, 0, 0));
        imageArbres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageArbresActionPerformed(evt);
            }
        });
        jPanel1.add(imageArbres);
        imageArbres.setBounds(320, 170, 270, 180);

        lbToutBoiscest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbToutBoiscest.setText("ToutBois, c'est :");
        jPanel1.add(lbToutBoiscest);
        lbToutBoiscest.setBounds(30, 120, 210, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("x Reprentants");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 200, 160, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("x clients");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 230, 110, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("x prospects");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 260, 130, 22);

        lbBienvenue.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        lbBienvenue.setText("Bienvenue chez ToutBois !!");
        jPanel1.add(lbBienvenue);
        lbBienvenue.setBounds(20, 20, 560, 37);

        imagefond.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        imagefond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/meubles1.jpg"))); // NOI18N
        jPanel1.add(imagefond);
        imagefond.setBounds(0, -100, 620, 510);

        mFichier.setText("Fichier");

        mImport.setText("Importer");
        mImport.setToolTipText("");
        mFichier.add(mImport);

        mExport.setText("Exporter");
        mFichier.add(mExport);

        jMenuBar1.add(mFichier);

        mRepresentants.setText("Représentants");
        mRepresentants.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mRepresentantsMouseClicked(evt);
            }
        });
        mRepresentants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRepresentantsActionPerformed(evt);
            }
        });
        jMenuBar1.add(mRepresentants);

        mClients.setText("Clients");
        mClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mClientsMouseClicked(evt);
            }
        });
        jMenuBar1.add(mClients);

        mProspects.setText("Prospects");
        mProspects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mProspectsMouseClicked(evt);
            }
        });
        jMenuBar1.add(mProspects);

        mAide.setText("Aide");

        maproposde.setText("A propos de");
        maproposde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maproposdeActionPerformed(evt);
            }
        });
        mAide.add(maproposde);

        mjavadoc.setText("javadoc");
        mjavadoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mjavadocMouseClicked(evt);
            }
        });
        mjavadoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mjavadocActionPerformed(evt);
            }
        });
        mAide.add(mjavadoc);

        jMenuBar1.add(mAide);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imageArbresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageArbresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imageArbresActionPerformed

    private void mRepresentantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRepresentantsActionPerformed
          
    }//GEN-LAST:event_mRepresentantsActionPerformed

    private void mRepresentantsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mRepresentantsMouseClicked
        /*
        * Ouverture de la fenetre de gestion des représentants via le menu.
        */
        AddRep dlg = null;
        try {
            dlg = new AddRep(new javax.swing.JFrame(), true);
        } catch (IOException ex) {
            Logger.getLogger(FenetrePrincipaleFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dlg.setVisible(true);
    }//GEN-LAST:event_mRepresentantsMouseClicked

    private void mClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mClientsMouseClicked
        /*
        * Ouverture de la fenetre de gestion des clients via le menu.
        */      
        AddClient dlg = null;
        try {
            dlg = new AddClient(new javax.swing.JFrame(), true);
        } catch (IOException ex) {
            Logger.getLogger(FenetrePrincipaleFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dlg.setVisible(true);
    }//GEN-LAST:event_mClientsMouseClicked

    private void mProspectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mProspectsMouseClicked
        /*
        * Ouverture de la fenetre de gestion des prospect via le menu.
        */   
        AddProspect dlg = null;
        try {
            dlg = new AddProspect(new javax.swing.JFrame(), true);
        } catch (IOException ex) {
            Logger.getLogger(FenetrePrincipaleFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dlg.setVisible(true);
    }//GEN-LAST:event_mProspectsMouseClicked

    private void maproposdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maproposdeActionPerformed
        /*
        * Ouverture de la fenetre A propos de
        */
        aide dlg = null;
        try {
            dlg = new aide(new javax.swing.JFrame(), true);
        } catch (IOException ex) {
            Logger.getLogger(FenetrePrincipaleFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dlg.setVisible(true);
    }//GEN-LAST:event_maproposdeActionPerformed

    private void mjavadocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mjavadocMouseClicked
       
    }//GEN-LAST:event_mjavadocMouseClicked


    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        /**
        * Rafraichissement des nombres de représentants, clients et prospects (Actifs). 
        * Charge le nombre de représentants , clients et prospects. Et les affiches sur la fenêtre principale.
        */
        try {
            int nbderepresentants = 0 ;
            int nbdeclients = 0 ;
            int nbdeprospects = 0 ;
            //
            // Uilisé si l'on désire faire apparaire les totaux actifs + inactifs.
            //
            //int nbderepresentantstotal = 0 ;
            //int nbdeclientstotal = 0 ;
            //int nbdeprospectstotal = 0 ;
       
            /*
            * Charge le nombres de représentants, clients et prospects actifs    
            */
            LectureDesActifsDuFichier fichierrepresentant = new LectureDesActifsDuFichier ("Data/Representants.txt") ;
            nbderepresentants = fichierrepresentant.getRowCount() ;
            LectureDuFichierComplet fichierclients = new LectureDuFichierComplet ("Data/Clients.txt") ;
            nbdeclients = fichierclients.getNbdelignes() - 1 ;
            LectureDuFichierComplet fichierprospects = new LectureDuFichierComplet ("Data/prospects.txt") ;
            nbdeprospects = fichierprospects.getNbdelignes() - 1 ;
            //
            // Uilisé si l'on désire faire apparaire les totaux actifs + inactifs.
            //
            //LectureDuFichierComplet fichierrepresentanttotal = new LectureDuFichierComplet ("Data/Representants.txt") ;
            //nbderepresentantstotal = fichierrepresentanttotal.getNbdelignes() - 1 ;
            //LectureDuFichierComplet fichierclienttotal = new LectureDuFichierComplet ("Data/Clients.txt") ;
            //nbdeclientstotal = fichierclienttotal.getNbdelignes() - 1 ;
            //LectureDuFichierComplet fichierprospecttotal = new LectureDuFichierComplet ("Data/Prospects.txt") ;
            //nbdeprospectstotal = fichierprospecttotal.getNbdelignes() - 1 ;

            
            jLabel3.setText (nbderepresentants + " Representants");
            jLabel5.setText (nbdeclients + " Clients");
            jLabel6.setText (nbdeprospects + " Prospects");
            //
            // Uilisé si l'on désire faire apparaire les totaux actifs + inactifs.
            //
            //jLabel3.setText (nbderepresentants + "/" + nbderepresentantstotal + " Representants");
            //jLabel3.setText (nbdeclients + "/" + nbdeclientstotal + " Clients");
            //jLabel3.setText (nbdeprospects + "/" + nbdeprospectstotal + " Prospects");
            jLabel3.setVisible(true);
            jLabel5.setVisible(true);
            jLabel6.setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FenetrePrincipaleFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowActivated

    private void mjavadocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mjavadocActionPerformed
        try {
            AppelJavadoc.lancerjavadoc ();
        } catch (URISyntaxException ex) {
            Logger.getLogger(FenetrePrincipaleFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mjavadocActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipaleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipaleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipaleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipaleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetrePrincipaleFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton imageArbres;
    private javax.swing.JLabel imagefond;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbBienvenue;
    private javax.swing.JLabel lbPresentation;
    private javax.swing.JLabel lbToutBoiscest;
    private javax.swing.JMenu mAide;
    private javax.swing.JMenu mClients;
    private javax.swing.JMenuItem mExport;
    private javax.swing.JMenu mFichier;
    private javax.swing.JMenuItem mImport;
    private javax.swing.JMenu mProspects;
    private javax.swing.JMenu mRepresentants;
    private javax.swing.JMenuItem maproposde;
    private javax.swing.JMenuItem mjavadoc;
    // End of variables declaration//GEN-END:variables

    public void setIcon(ImageIcon imageIcon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
