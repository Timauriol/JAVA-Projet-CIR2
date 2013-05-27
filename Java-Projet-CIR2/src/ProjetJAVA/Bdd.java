package ProjetJAVA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    String ip,bdd,port;
    
    String configPath = "C:\\Users\\Erza\\Documents\\NetBeansProjects\\JAVA-Projet-CIR2\\Java-Projet-CIR2\\src\\ProjetJAVA\\config.txt";
                        //System.getProperty("user.dir") + "/config/" + fichier;
      //Construction de l'appli
  public Bdd(){
   super();
   initConf();
   BDDConec();   
   System.out.println("Objet BDD construit.");
  }
    
    public void initConf() {
       Properties properties = new Properties();
        loadFile(properties);
        // On récupère les imformations donner par le fichier de configuration
        ip = properties.getProperty("ip");
        port = properties.getProperty("port");
        bdd = properties.getProperty("bdd");
        System.out.println(ip);
        System.out.println(port);
        System.out.println(bdd);
        
    }
    
    public void editConf(String ip, String port){
      /*  Properties properties = new Properties();
        loadFile(properties);
        try {
            FileOutputStream fileOutStream = new FileOutputStream(configPath);
            properties.setProperty("ip",ip);
            properties.setProperty("port",port);
            fileOutStream.close();
            
        } catch (IOException e) {
            System.out.println("Unable to load config file.");
        }
       */
        FileOutputStream fos = null;
        Properties config = null;
        FileInputStream fis = null;
        
         try
        {
            config = new Properties();
            if (configPath != null)
            {
                File fileRes = new File(configPath);
                if (fileRes.isFile())
                {
                    fis = new FileInputStream(configPath);
                    config.load(fis);
                    fis.close();
                }
            }
            if (fis == null)
            {
                fos = new FileOutputStream(configPath, true);
            }
            else
            {
                fos = new FileOutputStream(configPath);
            }
            config.setProperty("ip",ip);
            config.setProperty("port",port);
            config.store(fos, "Dernière mise a jour :");
            fos.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
           // fos = null;
           // fis = null;
           // config = null;
        }
    }
    
    public void loadFile (Properties properties){
         // Chemin d'accès du ficher de congiguration  
        try {
            FileInputStream fileStream = new FileInputStream(configPath);
            properties.load(fileStream);
            fileStream.close();
            System.out.println("Fchier de configuration chargé.");
        } catch (IOException e) {
            System.out.println("Unable to load config file.");
        }
         
    }
    
    
    public void BDDConec() {
        
        // On initialise la connection à la BDD    
        Properties props = new Properties();
        //Statement s;
        props.put("user", "conge");
        props.put("password", "conge");
        try {
            connecBDD = DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/"+bdd, props);
            System.out.println("Connexion à la BDD réussi.");
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
