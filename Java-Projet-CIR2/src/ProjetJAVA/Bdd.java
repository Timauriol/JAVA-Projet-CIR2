package ProjetJAVA;

import java.util.Properties;
/*
import java.io.File;
*/
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Erza
 */
public class Bdd {

    // Declaration des variables
    Connection connecBDD;
    String ip,bdd,port;
    String configPath = System.getProperty("user.dir") + System.getProperty("file.separator") + "config.txt";
    static Bdd instance = null;

    //Constructeur
    public Bdd(){
        super();
        initConf();
        System.out.println("Objet BDD construit.");
    }

    public static Bdd getInstance(){
        if(instance == null){
            System.out.println("Création d'une Bdd");
            instance = new Bdd();
        }
        return instance;
    }

    // Chargement et lecture du fichier de configuration
    public void initConf() {
        Config c = Config.getInstance();
        c.charger();

        this.ip = c.ip;
        this.port = c.port;
        this.bdd = c.bdd;

        BDDConec();
    }//initConf

    // Charge puis ferme le fichier de conf, et édite ensuite les valeurs associés au key.
    public void editConf(String ip, String port, String bdd){
        this.ip = ip;
        this.port = port;
        this.bdd = bdd;

        Config c = Config.getInstance();
        c.ip = ip;
        c.port = port;
        c.bdd = bdd;
        try{
            c.enregistrer();
        } catch (IOException e){
            System.out.println("Impossible d'écrire le fichier de configuration");
        }
    }//editConf

    // Fonction utilisant les paramètre courant de la classe Bdd
    // pour creer une connexion à une BDD.
    public void BDDConec() {

        // On initialise la connection à la BDD
        Properties props = new Properties();
        props.put("user", "conge");
        props.put("password", "conge");
        try {
            // Creation de la connexion
            connecBDD = DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/"+bdd, props);
            System.out.println("Connexion à la BDD réussie.");
            } catch (SQLException e) {
            e.printStackTrace();
            // Affiche un message pour l'utilisateur en cas d'erreur.
            JOptionPane.showMessageDialog(null,"Echec de la connexion à la BDD, veuillez corriger les informations de connexion." );
        }
    }//BDDConec
}//Bdd
