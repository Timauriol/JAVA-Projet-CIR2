package ProjetJAVA;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erza
 */
public class Bdd {
    
    // Declaration des variables
    Connection connecBDD;
    String user,password,ip,bdd;
    
      //Construction de l'appli
  public Bdd(){
   super();                    
   initConf();
   BDDConec();   
   System.out.println("Objet BDD construit.");
  }
    
    public void initConf(){
        // Importation du fichier de configuration
        String configPath = "C:\\Users\\Erza\\Desktop\\Test\\JavaApplication_test1\\src\\javaapplication_test1\\config.txt"; // Chemin d'accès du ficher de congiguration
        Properties properties = new Properties();  

        try {
            FileInputStream fileStream = new FileInputStream(configPath);
            properties.load(fileStream);
            fileStream.close();
            System.out.println("Fchier de configuration chargé.");
        } catch (IOException e) {
            System.out.println("Unable to load config file.");
        }
        
         // On récupère les imformations donner par le fichier de configuration
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        ip = properties.getProperty("ip");
        bdd = properties.getProperty("bdd");
    }
    
    
    public void BDDConec() {
        
        // On initialise la connection à la BDD    
        Properties props = new Properties();
        //Statement s;
        props.put("user", user);
        props.put("password", password);
        try {
            connecBDD = DriverManager.getConnection("jdbc:mysql://"+ip+"/"+bdd, props);
            System.out.println("Connexion à la BDD réussi.");
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
