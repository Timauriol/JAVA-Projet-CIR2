package ProjetJAVA;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.awt.Desktop;

import java.net.URISyntaxException;
import java.io.IOException;

/**
 *
 * @author Erza
 */
public class Panel_consult extends JPanel {
    
    // Déclaration
    private JTabbedPane onglets;
    private User user;
    public Onglet_calendrier onglet_calendrier;

    // Constructeur
    public Panel_consult(JFrame frame, User user) {
        this.user = user;
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
        onglet_calendrier = new Onglet_calendrier(user);
        //onglet_calendrier.setPreferredSize(new Dimension(500, 500));
        onglets.addTab("Calendrier", onglet_calendrier);

        JLabel lien = new JLabel("<html><a href='http://crouton.net/'>Télécharger le formulaire de congé</a></html>");
        this.add(lien, BorderLayout.SOUTH);
        lien.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try{
                    Desktop.getDesktop().browse(new URI("http://crouton.net/"));
                } catch (URISyntaxException | IOException ex) {
                    System.out.println("caca");
                }
            }
        });


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
