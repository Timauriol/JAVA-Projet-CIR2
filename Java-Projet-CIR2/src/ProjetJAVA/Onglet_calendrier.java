/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetJAVA;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Erza
 */
public class Onglet_calendrier extends JPanel {

    // Variables declaration
    private Calendrier calendrier;
    private User user;
    private int annee, mois;
    private JLabel solde;
    private JComboBox selecteur;
    private JButton precedent, suivant;

    // Constructeur
    public Onglet_calendrier(User u){
        System.out.println("Construct");
        user = u;
        GregorianCalendar cal = new GregorianCalendar();
        annee = cal.get(Calendar.YEAR);
        mois = cal.get(Calendar.MONTH);
        initComponents();
    }

    /**
     * Cette methode est appelé dans le constructeur pour
     * initialiser les éléments graphiques.
     */
    private void initComponents() {
        System.out.println("initComponents");

        setLayout(new BorderLayout());

        JPanel barreoutils = new JPanel(new BorderLayout());

        calendrier = new Calendrier(annee, mois);

        initBarreOutils(barreoutils);

        this.add(barreoutils, BorderLayout.NORTH);
        this.add(calendrier, BorderLayout.CENTER);
    }//initComponents

    public void majSolde(){
        this.solde.setText("Solde courant : " + String.valueOf(user.solde));
    }

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
        selecteur.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mois = selecteur.getSelectedIndex();
                // TODO aller chercher les congés
                calendrier.afficherMois(annee, mois);
                if(mois == 0) precedent.setEnabled(false);
                else precedent.setEnabled(true);
                if(mois == 11) suivant.setEnabled(false);
                else suivant.setEnabled(true);
            }
        });
        precedent.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selecteur.setSelectedIndex(Math.max(0, selecteur.getSelectedIndex() - 1));
            }
        });
        suivant.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selecteur.setSelectedIndex(Math.min(11, selecteur.getSelectedIndex() + 1));
            }
        });

        barre.add(solde, BorderLayout.WEST);
        barre_de_droite.add(selecteur);
        barre_de_droite.add(precedent);
        barre_de_droite.add(suivant);
        barre.add(barre_de_droite, BorderLayout.EAST);
    }
}
