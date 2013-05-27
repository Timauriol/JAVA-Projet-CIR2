package ProjetJAVA;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
 
import javax.swing.*;

/**
 *
 * @author Erza
 */
public class Panel_consult extends JPanel {
    
    public Panel_consult(JFrame frame) {
        initComponents(frame);
        System.out.println("Création du Panel_consult");
        
    }
        
    private void initComponents(JFrame frame) {
        this.setLayout(new BorderLayout());
        JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);
       
        
        JPanel onglet1 = new JPanel();
        JLabel titreOnglet1 = new JLabel("Onglet 1");
        onglet1.add(titreOnglet1);
        onglet1.setPreferredSize(new Dimension(500, 500));
        onglets.addTab("onglet1", onglet1);
        
        JPanel onglet2 = new JPanel();
        JLabel titreOnglet2 = new JLabel("Onglet 2");
        onglet2.setPreferredSize(new Dimension(500, 500));
        onglet2.add(titreOnglet2);
        onglets.addTab("onglet2", onglet2);
        onglets.setOpaque(true);
        this.add(onglets);
        
        frame.getContentPane().add(this);


    }
}
