package ProjetJAVA;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;




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
    Panel_login panel_login;
    Panel_consult panel_consult;
    User user;


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
    }// Constructeur

    /**
     * This method is called from within the constructor to initialize the form.
     */

    private void initComponents() {

        panel_login = new Panel_login();
        user = new User();
        panel_consult = new Panel_consult(this, user);
        MainMenu = new JMenuBar();
        Menu_Conf = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Super Congés 2000");
        setIconImage(Toolkit.getDefaultToolkit().getImage("favicon.png")); 
        setMinimumSize(new Dimension(250, 250));
        setPreferredSize(new Dimension(500, 500));

        Menu_Conf.setText("Configuration");
        Menu_Conf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                editMenuConf();
            }
        });
        MainMenu.add(Menu_Conf);
        setJMenuBar(MainMenu);
        pack();
    }//initComponents

    /* Affiche un boite de dialogue à l'user et récupère l'ip et le port 
     * entré par celui-ci.
     */
    private void editMenuConf() {  
        // Boitede dialogue
        String url_conf = JOptionPane.showInputDialog(null,
                "Entrez l'addresse du serveur (ip:port/bdd)");
        String[] temp;
        String[] temp1;
        temp = url_conf.split("/");
        temp1 = temp[0].split(":");

        String url = null;
        String port = null;
        String bdd_name = null;

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

        Bdd bdd = Bdd.getInstance();
        bdd.editConf(url,port,bdd_name);
        bdd.initConf();

        // Affichage de controle
        System.out.println(bdd.ip);
        System.out.println(bdd.port);
        System.out.println(bdd.bdd);

    }//editMenuConf

    // Fonction lancant la connexion avec les paramètres login/mdp saisie par l'user
    private void connexion () {
        String login = panel_login.getLogin();
        String mdp = panel_login.getPassword();
        user.verifAuth(login,mdp);

        if (user.auth){
            panel_login.setVisible(false);
            System.out.println("On Masque le panel_login");
            panel_consult.onglet_calendrier.majSolde();
            panel_consult.onglet_calendrier.majCalendrier();
            this.add("Center", panel_consult); // Ajout du Panel_consult à la fenetre
            panel_consult.setVisible(true);
            System.out.println("Affichage du panel_consult");
        }
    }//connexion
}//Classe Fenetre
