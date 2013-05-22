/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erza
 */

//import com.mysql.jdbc.Statement;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;


public class main {
	public static void main(String[] args) {
/*        
        // Importation du fichier de configuration
        String configPath = "C:\\Users\\Erza\\Documents\\NetBeansProjects\\JAVA-Projet-CIR2\\Java-Projet-CIR2\\src\\config.txt"; // Chemin d'accès du ficher de congiguration
        Properties properties = new Properties();  

        // On charge le fichier de configuration 
        try {
            FileInputStream fileStream = new FileInputStream(configPath);
            properties.load(fileStream);
            fileStream.close();
            System.out.println("Fchier de configuration chargé.");
          
        } catch (IOException e) {
            System.out.println("Unable to load config file.");
        }
        
        // On récupère les imformations contenu dans le fichuer de conf
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String ip = properties.getProperty("ip");
        String bdd = properties.getProperty("bdd");
                          
        // On initialise la connection à la BDD    
		Connection conn;
		Properties props = new Properties();
		Statement s;
		props.put("user", user);
		props.put("password", password);
		try {
			conn = DriverManager.getConnection("jdbc:mysql://"+ip+"/"+bdd, props);
			System.out.println("Connecté.");
			s = conn.createStatement();
			System.out.println("Récupération des entrées:");
			ResultSet r = s.executeQuery("SELECT * FROM `utilisateur`");
			while(r.next()){
				System.out.println("Login : "+r.getString("login"));
                System.out.println("Nom & Prénom : "+r.getString("nom_prenom"));
                System.out.println("Mot de passe : "+r.getString("mdp"));
                System.out.println("E-Mail : "+r.getString("e_mail"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
  */      
        
        
     Bdd bdd = new Bdd();
     AppliFen truc = new AppliFen();
        
     
	}  
}
