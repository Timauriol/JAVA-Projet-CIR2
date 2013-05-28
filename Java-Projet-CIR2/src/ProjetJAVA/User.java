package ProjetJAVA;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Erza
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erza
 */
public class User {
    
    // Variables declaration   
    public boolean auth;
    String nom,prenom;
    int solde_conge,solde_conge_extra;
    
    // Constructeur
    public User(){
        auth = false;

    }
    
    // Fonction de vérification de la combinaison login/mdp donner par l'utilisateur avec la BDD
    public void verif_Auth(Connection connecBDD,String test_login,String test_password ){
        
        try {
            // Requête SQL
            String sql = "SELECT admin FROM utilisateur WHERE login = ? AND mdp = sha2(?, 512)";
            // On préparation de la requête
            PreparedStatement statement = connecBDD.prepareStatement(sql);
            // On assigne les types des paramètres
            statement.setString(1,test_login);
            statement.setString(2,test_password);
            // Exécution de la requête
            ResultSet result = statement.executeQuery();
            
            //Verifie si la requête à trouvé un utilisateur
            if (result.next()){
                auth = true;
                return;
            }
            // Affiche un message pour l'utilisateur en cas d'erreur.
            JOptionPane.showMessageDialog(null,"Combinaison utilisateur / Mot de passe incorrect !" );
            // Retourne false si l'authentification est incorrect
            auth = false; 
            
        }catch(SQLException | HeadlessException ex) {
            ex.printStackTrace();
            // Affiche un message pour l'utilisateur
            JOptionPane.showMessageDialog(null,"Connexion à la BDD échoué" );
            // Retourne false si il y a une erreur avec la BDD
            auth = false;
        }       
    }//Verif_Auth
       

}
