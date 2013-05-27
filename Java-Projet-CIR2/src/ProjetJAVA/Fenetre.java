package ProjetJAVA;

import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Erza
 */
public class Fenetre extends JFrame {
    
    /**
     * Creates new form Fenetre
     */
    
    // Variables declaration                
    private JMenuBar MainMenu;
    private JMenu Menu_Conf;
    Panel_login panel_login = new Panel_login();
    Panel_consult panel_consult = new Panel_consult(this);
    User user = new User();
    Bdd bdd = new Bdd();               

    
    // Constructeur
    public Fenetre() {
        initComponents(); // Initialisation de la fenetre
        System.out.println("Fenêtre principal généré");
        this.add("Center", panel_login); // Ajout du Panel_login à la fenetre
        
        panel_consult.setVisible(false);
        
        // On récupère le boutton panel_login
        JButton button_connexion = panel_login.getJButton();   
        
        // On redéfinit le comportement du boutton
        button_connexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                connexion();
            }
        });
        
        // On récupère le jTextField_Login
        JTextField jTextField_Login =  panel_login.getJTextField_Login();
        // On redéfinit le comportement du jTextField_Login
        jTextField_Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                connexion(); 
            }
        });
        
        // On récupère le jPasswordField
        JPasswordField jPasswordField = panel_login.getJPasswordField();
        // On redéfinit le comportement du jPasswordField
        jPasswordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                connexion(); 
            }
        });
        
        // Affichage du Panel_login
        panel_login.setVisible(true); 
        System.out.println("Affichage du panel_login");
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
                     
    private void initComponents() {

        MainMenu = new JMenuBar();
        Menu_Conf = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Super Congés 2000");
        setMinimumSize(new Dimension(250, 250));
        setPreferredSize(new Dimension(500, 500));

        Menu_Conf.setText("Configuration");
        Menu_Conf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Menu_ConfMouseClicked(evt);
            }
        });
        MainMenu.add(Menu_Conf);
        setJMenuBar(MainMenu);
        pack();
    }                      

    private void Menu_ConfMouseClicked(MouseEvent evt) {                                       
        String url_conf = JOptionPane.showInputDialog(null, "Entrez l'addresse du serveur (ip:port)");
        String[] temp;
        temp = url_conf.split(":");
        String url = temp[0];
        String port = temp[1];
        bdd.editConf(url,port);
        System.out.println(bdd.ip);
        System.out.println(bdd.port);
        System.out.println(bdd.bdd);
        bdd = new Bdd();  
    }                                      
    
    private void connexion () {
        String login = panel_login.getLogin();
        String mdp = panel_login.getPassword();
        user.verif_Auth(bdd.connecBDD,login,mdp);
        
       if (user.auth){
            panel_login.setVisible(false);
            System.out.println("On Masque le panel_login");
            this.add("Center", panel_consult); // Ajout du Panel_consult à la fenetre
            panel_consult.setVisible(true);
            System.out.println("Affichage du panel_consult");
       }
    }
}
