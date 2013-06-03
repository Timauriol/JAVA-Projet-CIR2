package ProjetJAVA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;
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
    
    //Constructeur
    public Bdd(){
        super();
        initConf();
        BDDConec();   
        System.out.println("Objet BDD construit.");
    }
    
    // Chargement et lecture du fichier de configuration 
    public void initConf() {
        Properties properties = new Properties();
        
        // Chemin d'accès du ficher de congiguration  
        try {
            FileInputStream fileStream = new FileInputStream(configPath);
            properties.load(fileStream);
            
            // On récupère les imformations donner par le fichier de configuration
            ip = properties.getProperty("ip");
            port = properties.getProperty("port");
            bdd = properties.getProperty("bdd");
            fileStream.close();
            System.out.println("Fchier de configuration chargé.");
        } catch (IOException e) {
            System.out.println("Unable to load config file.");
        }
        
        // Affichage pour controler les valeurs
        System.out.println(ip);
        System.out.println(port);
        System.out.println(bdd);
    }//initConf
    
    // Charge puis ferme le fichier de conf, et édite ensuite les valeurs associés au key.
    public void editConf(String ip, String port,String bdd_name){
        FileOutputStream fos = null;
        Properties config = null;
        FileInputStream fis = null;
        
         try {
            config = new Properties();
            if (configPath != null) {
                File fileRes = new File(configPath);
                if (fileRes.isFile()) {
                    fis = new FileInputStream(configPath);
                    config.load(fis);
                    fis.close();
                }
            }
            if (fis == null) {
                fos = new FileOutputStream(configPath, true);
            }
            else {
                fos = new FileOutputStream(configPath);
            }
            // Edite les valeurs du fichier de conf
            config.setProperty("ip",ip);
            config.setProperty("port",port);
            config.setProperty("bdd",bdd_name);
            config.store(fos, "Dernière mise a jour :");
            fos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            fos = null;
            fis = null;
            config = null;
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
            System.out.println("Connexion à la BDD réussi.");
            } catch (SQLException e) {
            e.printStackTrace();
            // Affiche un message pour l'utilisateur en cas d'erreur.
            JOptionPane.showMessageDialog(null,"Connection BDD échoué, veuillez éditer correctement les informations de connexion." );
        }
    }//BDDConec
}//Bdd
