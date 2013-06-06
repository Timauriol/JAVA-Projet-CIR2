package ProjetJAVA;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel_calendrier extends JPanel {

    // Variables declaration
    private Calendrier calendrier;
    private User user;
    private int annee, mois;
    private JLabel solde;
    private JComboBox selecteur;
    private JButton precedent, suivant;

    // Constructeur
    public Panel_calendrier(JFrame frame, User u){
        System.out.println("Construct");
        user = u;
        GregorianCalendar cal = new GregorianCalendar();
        annee = cal.get(Calendar.YEAR);
        mois = cal.get(Calendar.MONTH);
        initComponents(frame);
    }

    /**
     * Cette methode est appelé dans le constructeur pour
     * initialiser les éléments graphiques.
     */
    private void initComponents(JFrame frame) {

        setLayout(new BorderLayout());
        JPanel barreoutils = new JPanel(new BorderLayout());
        initBarreOutils(barreoutils);
        calendrier = new Calendrier(annee, mois);

        this.add(barreoutils, BorderLayout.NORTH);
        this.add(calendrier, BorderLayout.CENTER);

        frame.getContentPane().add(this);
    }//initComponents

    // Met à jour le calendrier au mois et année correspondante.
    public void majCalendrier(){
        calendrier.afficherMois(annee, mois, Conge.getCongesMois(user.login, annee, mois));
    }

    // Met à jour le solde de l'utilisateur
    public void majSolde(){
        this.solde.setText("Solde courant : " + String.valueOf(user.solde));
    }

    // Initialisation des composants de la barre d'outil
    private void initBarreOutils(JPanel barre){
        solde = new JLabel();
        
        String[] nom_mois = { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre" };
        String[] mois_annee = new String[12];
        
        for(int i = 0; i < nom_mois.length; i++)
            mois_annee[i] = nom_mois[i] + " " + String.valueOf(annee);

        JPanel barre_de_droite = new JPanel(new FlowLayout());

        selecteur = new JComboBox(mois_annee);
        precedent = new JButton("<");
        suivant = new JButton(">");

        selecteur.setSelectedIndex(mois);
        
        // Comportemement des actions sur le JComboBox selecteur
        selecteur.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                mois = selecteur.getSelectedIndex();
                majCalendrier();
                if(mois == 0) precedent.setEnabled(false);
                else precedent.setEnabled(true);
                if(mois == 11) suivant.setEnabled(false);
                else suivant.setEnabled(true);
            }
        });
        
        // Comportemement des actions sur le JButton precedent
        precedent.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                selecteur.setSelectedIndex(Math.max(0, selecteur.getSelectedIndex() - 1));
            }
        });
        
        // Comportemement des actions sur le JButton suivant
        suivant.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                selecteur.setSelectedIndex(Math.min(11, selecteur.getSelectedIndex() + 1));
            }
        });

        // Ajout des elements à la barre d'outil 
        barre.add(solde, BorderLayout.WEST);
        barre_de_droite.add(selecteur);
        barre_de_droite.add(precedent);
        barre_de_droite.add(suivant);
        barre.add(barre_de_droite, BorderLayout.EAST);
    }
}
