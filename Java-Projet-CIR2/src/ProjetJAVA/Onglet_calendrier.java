/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetJAVA;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Erza
 */
public class Onglet_calendrier extends JPanel {
    
    // Variables declaration
    private MCalendar calendrier;
    private	static GregorianCalendar now;
    private JLabel lab_solde_restant;
    private JComboBox cb_mois;
    private JButton b_precedant,b_suivant;
    
    // Constructeur
    public Onglet_calendrier(){
        System.out.println("Construct");
        initComponents();
    }
    
   /**
    * Cette methode est appelé dans le constructeur pour 
    * initialiser les éléments graphiques.
    */
    
    private void initComponents() {
        GridBagConstraints gridBagConstraints;
        System.out.println("initComponents");
        
        // Affectation        
        calendrier = new MCalendar();
        now = new GregorianCalendar();
        lab_solde_restant = new JLabel();
        b_precedant = new JButton();
        b_suivant = new JButton ();
        cb_mois = new JComboBox();
        //initCB(cb_mois);
        
        // Layout
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        
        lab_solde_restant.setText("Solde restant :");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.PAGE_START;
        add(lab_solde_restant, gridBagConstraints);

        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.PAGE_START;
        add(cb_mois, gridBagConstraints);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.PAGE_START;
        add(b_precedant, gridBagConstraints);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.PAGE_START;
        add(b_suivant, gridBagConstraints);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = GridBagConstraints.SOUTH;
        add(calendrier, gridBagConstraints);

        
        
        


        
  }//initComponents
    
    private void initCB(JComboBox cb){
      
        int mois = now.get(Calendar.MONTH);
        int year = now.get(Calendar.YEAR);
        String monthName[] = { "Janvier","Fevrier","Mars","Avril","Mai","Juin",
            "Juillet","Août","Septembre","Octobre","Novembre","Decembre"};
        String mois_annee[] = new String[11];
        for(int i = 0; i < 11; i++){
            mois_annee[i] = monthName[i]+" "+year;
        }
        
        // On initialise le JComboBox avec les paramètres calculé
        cb = new JComboBox(mois_annee);     
        cb.setSelectedIndex(mois);
        
         // On redéfinit le comportement du JComboBox
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JComboBox cb = (JComboBox)evt.getSource();
                int choix_mois = (int)cb.getSelectedIndex();
                calendrier = new MCalendar(choix_mois);
            }
      });
    }//initCB
}
