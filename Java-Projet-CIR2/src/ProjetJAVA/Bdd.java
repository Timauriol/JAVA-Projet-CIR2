package ProjetJAVA;

import java.util.Properties;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Bdd {

    // instance globale
    static Bdd instance = null;

    // Déclaration des variables
    Connection connecBDD;
    String ip,bdd,port;
    String configPath = System.getProperty("user.dir") + System.getProperty("file.separator") + "config.txt";

    // Constructeur
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

    // lit la configuration depuis Config, puis recrée la connexion
    public void initConf() {
        Config c = Config.getInstance();
        c.charger();

        this.ip = c.ip;
        this.port = c.port;
        this.bdd = c.bdd;

        BDDConec();
    }//initConf

    // écrit la configuration dans Config
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
            // on affiche rien, User s'en occupe
            e.printStackTrace();
            connecBDD = null;
        }
    }//BDDConec
}//Bdd
