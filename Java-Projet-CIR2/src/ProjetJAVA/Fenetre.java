package ProjetJAVA;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.net.URI;
import java.awt.Desktop;
import java.net.URISyntaxException;
import java.io.IOException;


public class Fenetre extends JFrame {

    // Variables declaration                
    private JMenuBar MainMenu;
    Panel_login panel_login;
    Panel_calendrier panel_calendrier;
    User user;


    // Constructeur
    public Fenetre() {
        initComponents(); // Initialisation de la fenetre
        System.out.println("Fenêtre principal généré");
        this.add("Center", panel_login); // Ajout du Panel_login à la fenetre

        panel_calendrier.setVisible(false);

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
    }// Constructeur


    // Methode d'initialisation des composants de la fenêtre
    private void initComponents() {

        // Creation des objets
        panel_login = new Panel_login();
        user = new User();
        panel_calendrier = new Panel_calendrier(this, user);
        MainMenu = new JMenuBar();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Super Congés 2000");
        setIconImage(Toolkit.getDefaultToolkit().getImage("favicon.png")); 
        
        // Dimension Fenêtre
        setMinimumSize(new Dimension(250, 250));
        setPreferredSize(new Dimension(500, 500));
        
        // Creation des menu et sous-menu
        JMenu menu = new JMenu("Fichier");
        JMenuItem config = new JMenuItem("Configuration");
        JMenuItem pdf = new JMenuItem("Télécharger PDF de demande de congé");

        // Ajout de l'action au clic sourie sur le menu conf
        config.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                editMenuConf();
            }
        });
        
        // Ajout de l'action au clic sourie sur le menu Télécharger PDF
        pdf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try{
                    Config c = Config.getInstance();
                    c.charger();
                    Desktop.getDesktop().browse(new URI(c.urlPdf));
                } catch (URISyntaxException | IOException ex) {
                }
            }
        });
        
        menu.add(config);
        menu.add(pdf);
        MainMenu.add(menu);
        setJMenuBar(MainMenu);
        pack();
    }//initComponents

    /* Affiche un boite de dialogue à l'utilisateur et récupère l'ip le port 
     * et le nom de la BDD donné par l'utilisateur
     */
    private void editMenuConf() {
        // Boite de dialogue
        String url_conf = JOptionPane.showInputDialog(null,
                "Entrez l'addresse du serveur (ip:port/bdd)");
        String[] temp;
        String[] temp1;
        temp = url_conf.split("/");
        temp1 = temp[0].split(":");

        String url;
        String port;
        String bdd_name;

        if ( temp.length == 2){
            bdd_name = temp[1];
        }
        else bdd_name = "conge";

        if (temp1.length == 2){
            port = temp1[1];
        }
        else port = "3306";

        if (temp1[0].length() == 0){
            url = "127.0.0.1";

        }
        else url = temp1[0];

        // Edition du fichier de conf avec les param donné par l'utilisateur
        Bdd bdd = Bdd.getInstance();
        bdd.editConf(url,port,bdd_name);
        bdd.initConf();
    }//editMenuConf

    // Fonction lançant la connexion avec les paramètres login/mdp saisie par l'utilisateur
    private void connexion () {
        String login = panel_login.getLogin();
        String mdp = panel_login.getPassword();
        user.verifAuth(login,mdp);

        // Si l'authentification est réussi, on charge la suite du programme
        if (user.auth){
            panel_login.setVisible(false);
            panel_calendrier.majSolde(); // Mise à jour du solde
            panel_calendrier.majCalendrier(); // Mise à jour du calandrier
            this.add("Center", panel_calendrier); // Ajout du Panel_calendrier à la fenetre
            panel_calendrier.setVisible(true);
        }
    }//connexion
}//Classe Fenetre
