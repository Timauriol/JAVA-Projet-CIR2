/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetJAVA;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Erza
 */
public class Onglet_calendrier extends JPanel {

    // Variables declaration
    private Calendrier calendrier;

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
        System.out.println("initComponents");

        setLayout(new BorderLayout());

        calendrier = new Calendrier(2013, 1);
        this.add(calendrier);
    }//initComponents
}
