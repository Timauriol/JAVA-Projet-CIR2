/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erza
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class AppliFen extends JFrame{
 
  //Déclaration et instanciation des composants            
  //Creation du panel
  private JPanel panel = new JPanel();
  //Déclaration de la barre de menu
  private JMenuBar menuBar = new JMenuBar();                
  //Déclaration des choix et sous choix sur le menu
  private JMenu menu1 = new JMenu("Conf");
       
  //Déclaration des éléments du menu
  private JMenuItem item1 = new JMenuItem("Configugrer");
 
  //Construction de l'appli
  public AppliFen(){
   super();                    
   build();
   System.out.println("Fenêtre généré");
  }
 
 
  //Methode qui définit les caracteristiques de l'appli
  private void build(){                                        
    //On définit la taille    
    setSize(850, 400);                
    //On définit le titre
    setTitle("Super Conge 2000");     
    //On rend la fenetre visible
    setVisible(true);                
    //On centre
    setLocationRelativeTo(null);                
    //On peut la redimmensionner
    setResizable(true);                
    //On dit à l'application de se fermer lors du clic sur la croix
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                 
    //Construction du panel
    setContentPane(buildContentPane());
 
 
    //Création des onglets
    JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);

    //Taille préférée des onglets
    onglets.setMinimumSize(new Dimension(700,300));
   
    //Couleurs des onglets
    onglets.setBackground(Color.green);

    //Listener des onglets
    ChangeListener changeListener = new ChangeListener() {
 
      public void stateChanged(ChangeEvent changeEvent) {
        JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
        int index = sourceTabbedPane.getSelectedIndex();
        System.out.println("Tab changed to: " + sourceTabbedPane.getTitleAt(index));
      }
    };
    onglets.addChangeListener(changeListener);

 
    //Création des panels d'onglets        
    //Panel de l'onglet Overview se trouve dans la classe OO
    JPanel onglet1 = new JPanel();
 
    //On ajoute l'onglet au menu d'onglets
    onglets.add(onglet1, "Calendrier");
 
    //Panel de l'onglet Threads se trouve dans la classe OT
    JPanel onglet2 = new JPanel();
 
    //On ajoute l'onglet au menu d'onglets
    onglets.add(onglet2, "Planning");   
 
    //Ajoute les onglets au panel panel
    panel.add(onglets);
 
 
    //Opacité des onglets
    onglets.setOpaque(true);
 
 
    //f.getContentPane().add(panel);
    //f.setVisible(true);
  }
 
  //Création du panel
  private JPanel buildContentPane(){
    //Instanciation du panel
    panel = new JPanel(new BorderLayout());                       
    panel.setBackground(Color.white);
   
    //Retour de la méthode=affichage du panel
    return panel;      
  }       
}
