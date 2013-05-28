package ProjetJAVA;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author Erza
 */
public class Panel_consult extends JPanel {
    
    // Constructeur
    public Panel_consult(JFrame frame) {
        initComponents(frame);
        System.out.println("Création du Panel_consult");
        
    }
    
   /**
    * Cette methode est appelé dans le constructeur pour 
    * initialiser les éléments graphiques.
    */
    private void initComponents(JFrame frame) {
        // Ajout du type de layout au panel_consult
        this.setLayout(new BorderLayout());
        JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);
       
        // Cration de l'onglet Calendrier
        JPanel onglet_calendrier = new JPanel();
        JLabel titreOnglet_calendrier = new JLabel("Calendrier");
        onglet_calendrier.add(titreOnglet_calendrier);
        onglet_calendrier.setPreferredSize(new Dimension(500, 500));
        onglets.addTab("Calendrier", onglet_calendrier);
        
        // Cration de l'onglet Planning
        JPanel onglet_planning = new JPanel();
        JLabel titreOnglet_planning = new JLabel("Planning");
        onglet_planning.setPreferredSize(new Dimension(500, 500));
        onglet_planning.add(titreOnglet_planning);
        onglets.addTab("Planning", onglet_planning);
        onglets.setOpaque(true);
        this.add(onglets);
        
        frame.getContentPane().add(this);


    }
}
