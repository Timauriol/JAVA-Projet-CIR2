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
    
    // Déclaration 
    private JTabbedPane onglets;
    
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
        onglets = new JTabbedPane(SwingConstants.TOP);

        // Creation de l'onglet Calendrier
        Onglet_calendrier onglet_calendrier = new Onglet_calendrier();
        //onglet_calendrier.setPreferredSize(new Dimension(500, 500));
        onglets.addTab("Calendrier", onglet_calendrier);


        // Creation de l'onglet Planning
        JPanel onglet_planning = new JPanel();
        JLabel titreOnglet_planning = new JLabel("Planning");
        onglet_planning.setPreferredSize(new Dimension(500, 500));
        onglet_planning.add(titreOnglet_planning);
        onglets.addTab("Planning", onglet_planning);

        onglets.setOpaque(true);
        this.add(onglets);

        frame.getContentPane().add(this);
    }// initComponents

}//Panel_consult
