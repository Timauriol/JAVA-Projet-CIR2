package ProjetJAVA;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.util.GregorianCalendar;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.border.MatteBorder;

class Calendrier extends JPanel {

    JPanel[] jours;

    public Calendrier(int annee, int mois){
        construire();
        afficherMois(annee, mois);
    }

    private void construire(){
        this.setLayout(new BorderLayout());
        JPanel semaine = new JPanel(new GridLayout(1, 7));
        JPanel mois = new JPanel(new GridLayout(6, 7));

        String[] nomsJours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};

        for(int i = 0; i < nomsJours.length; i++){
            JLabel jour = new JLabel(nomsJours[i]);
            if(i != 0) // on met une bordure à gauche sur tous les jours sauf le premier pour les séparer
                jour.setBorder(new MatteBorder(0,1,0,0, new Color(0x888888)));
            semaine.add(jour);
        }

        jours = new JPanel[42];

        for(int i = 0; i < 6*7; i++){
            jours[i] = new JPanel();
            jours[i].setBackground(new Color(0xffffff - 30*i));
            mois.add(jours[i]);
        }

        this.add(semaine, BorderLayout.NORTH);
        this.add(mois, BorderLayout.CENTER);
    }

    private void afficherMois(int annee, int mois){
        GregorianCalendar cal = new GregorianCalendar(annee, mois, 1);
        // des trucs
    }

}
