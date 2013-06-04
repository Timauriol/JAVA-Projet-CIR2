package ProjetJAVA;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.border.MatteBorder;

class Calendrier extends JPanel {

    JPanel[] jours;
    JLabel[] labelsJours;

    public Calendrier(int annee, int mois){
        construire();
        afficherMois(annee, mois);
    }

    private void construire(){
        this.setLayout(new BorderLayout(0,0));
        JPanel semaine = new JPanel(new GridLayout(1, 7));
        JPanel mois = new JPanel(new GridLayout(6, 7));

        /*mois.setBackground(Color.red);
        semaine.setBackground(Color.green);*/

        String[] nomsJours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};

        for(int i = 0; i < nomsJours.length; i++){
            JLabel jour = new JLabel(nomsJours[i], JLabel.CENTER);
            if(i == 0)
                jour.setBorder(new MatteBorder(1,1,0,1, new Color(0x888888)));
            else
                jour.setBorder(new MatteBorder(1,0,0,1, new Color(0x888888)));
            semaine.add(jour);
        }

        jours = new JPanel[6*7];
        labelsJours = new JLabel[6*7];

        for(int i = 0; i < 6*7; i++){
            jours[i] = new JPanel(new BorderLayout());
            labelsJours[i] = new JLabel();
            jours[i].add(labelsJours[i], BorderLayout.NORTH);
            /* bordures */
            /* il y a surement un moyen moins dégeulasse de faire ça */
            if(i == 0)
                jours[i].setBorder(new MatteBorder(1,1,1,1, new Color(0x888888)));
            else if(i < 7)
                jours[i].setBorder(new MatteBorder(1,0,1,1, new Color(0x888888)));
            else if(i % 7 == 0)
                jours[i].setBorder(new MatteBorder(0,1,1,1, new Color(0x888888)));
            else
                jours[i].setBorder(new MatteBorder(0,0,1,1, new Color(0x888888)));
            mois.add(jours[i]);
        }

        this.add(semaine, BorderLayout.NORTH);
        this.add(mois, BorderLayout.CENTER);
    }

    public void afficherMois(int annee, int mois){
        GregorianCalendar cal = new GregorianCalendar(annee, mois, 1);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        /* On rembobine jusqu'au lundi qui précède le début du mois */
        while(cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY)
            cal.add(Calendar.DAY_OF_YEAR, -1);
        for(int i = 0; i < this.jours.length; i++){
            if(mois == cal.get(Calendar.MONTH)){
                labelsJours[i].setForeground(Color.black);
                jours[i].setBackground(new Color(0xeeeeee));
            }
            else{
                labelsJours[i].setForeground(Color.gray);
                jours[i].setBackground(Color.white);
            }
            labelsJours[i].setText(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
            cal.add(Calendar.DAY_OF_YEAR, 1);
        }
    }
}
