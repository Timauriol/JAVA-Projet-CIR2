package ProjetJAVA;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.border.MatteBorder;

class Calendrier extends JPanel {

    // Déclaration
    Jour[] jours;
    JLabel[] labelsJours;

    // Constructeur
    public Calendrier(int annee, int mois){
        construire();
        afficherMois(annee, mois, new ArrayList<Conge>());
    }

    // Méthode d'initialisation du calandrier
    private void construire(){
        this.setLayout(new BorderLayout(0,0));
        JPanel semaine = new JPanel(new GridLayout(1, 7));
        JPanel mois = new JPanel(new GridLayout(6, 7));

        String[] nomsJours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};

        // Affichage des noms des jours de la semaine dans le JPanel semaine.
        for(int i = 0; i < nomsJours.length; i++){
            JLabel jour = new JLabel(nomsJours[i], JLabel.CENTER);
            if(i == 0)
                jour.setBorder(new MatteBorder(1,1,0,1, new Color(0x888888)));
            else
                jour.setBorder(new MatteBorder(1,0,0,1, new Color(0x888888)));
            semaine.add(jour);
        }

        jours = new Jour[6*7];
        labelsJours = new JLabel[6*7];
        
        // Affichage des numéros des jours du mois dans le JPanel mois.
        for(int i = 0; i < 6*7; i++){
            jours[i] = new Jour();
            labelsJours[i] = jours[i].num_jour;
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

    // Affiche dans le calendrier les jours du mois et les congés envoyé en paramètres.
    public final void afficherMois(int annee, int mois, ArrayList<Conge> conges){
        GregorianCalendar cal = new GregorianCalendar(annee, mois, 1);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        
        /* On rembobine jusqu'au lundi qui précède le début du mois */
        while(cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY)
            cal.add(Calendar.DAY_OF_YEAR, -1);
        
        for(int i = 0; i < this.jours.length; i++){
            if(mois == cal.get(Calendar.MONTH)){
                labelsJours[i].setForeground(Color.black);
                jours[i].setBackground(Color.white);
                jours[i].transparent = false;
            }
            else{
                labelsJours[i].setForeground(Color.gray);
                jours[i].setBackground(new Color(0xf6f6f6));
                jours[i].transparent = true;
            }

            jours[i].couleur_am = null;
            jours[i].couleur_pm = null;

            for(int j = 0; j < conges.size(); j++){
                
                cal.set(Calendar.HOUR, 0);
                if(conges.get(j).date.equals(cal)){
                    switch (conges.get(j).type) {
                        case "weekend":
                            jours[i].couleur_am = new Color(0x99ccff);
                            break;
                        case "ferie":
                            jours[i].couleur_am = new Color(0xffdd88);
                            break;
                        default:
                            jours[i].couleur_am = new Color(0x88ee66);
                            break;
                    }
                }
                
                cal.set(Calendar.HOUR, 12);
                if(conges.get(j).date.equals(cal)){
                    switch (conges.get(j).type) {
                        case "weekend":
                            jours[i].couleur_pm = new Color(0x99ccff);
                            break;
                        case "ferie":
                            jours[i].couleur_pm = new Color(0xffdd88);
                            break;
                        default:
                            jours[i].couleur_pm = new Color(0x88ee66);
                            break;
                    }
                }
                cal.set(Calendar.HOUR, 0);
            }

            labelsJours[i].setText(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
            cal.add(Calendar.DAY_OF_YEAR, 1);

            jours[i].repaint();
        }
    }
}
