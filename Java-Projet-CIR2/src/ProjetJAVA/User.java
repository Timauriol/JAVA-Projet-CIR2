package ProjetJAVA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Erza
 */

public class User {

    // Variables declaration
    public String login;
    public boolean auth;
    public String nomprenom;
    public int solde;

    // Constructeur
    public User(){
        auth = false;

    }

    // Fonction de vérification de la combinaison login/mdp donner par l'utilisateur avec la BDD
    public void verifAuth(String test_login, String test_password){

        try {
            Connection connecBDD = Bdd.getInstance().connecBDD;
            // Requête SQL
            String sql = "SELECT utilisateur.nom_prenom, solde.solde FROM utilisateur, solde WHERE utilisateur.login = ? AND utilisateur.mdp = sha2(?, 512) AND utilisateur.login = solde.login AND solde.annee = YEAR(NOW())";
            // On préparation de la requête
            PreparedStatement statement = connecBDD.prepareStatement(sql);
            // On assigne les types des paramètres
            statement.setString(1,test_login);
            statement.setString(2,test_password);
            // Exécution de la requête
            ResultSet result = statement.executeQuery();

            //Verifie si la requête à trouvé un utilisateur
            if (result.next()){
                this.login = test_login;
                nomprenom = result.getString(1);
                solde = result.getInt(2);
                auth = true;
                System.out.println("Solde : " + String.valueOf(solde));
                return;
            }
            // Affiche un message pour l'utilisateur en cas d'erreur.
            JOptionPane.showMessageDialog(null,"Combinaison utilisateur / Mot de passe incorrect !" );
            // Retourne false si l'authentification est incorrect
            auth = false;

        } catch(SQLException ex) {
            // Affiche un message pour l'utilisateur
            JOptionPane.showMessageDialog(null,"Connexion à la BDD perdue");
            // Retourne false si il y a une erreur avec la BDD
            auth = false;
        } catch (NullPointerException ex){
            JOptionPane.showMessageDialog(null,"Connexion à la BDD échouée, veuillez vérifier la configuration");
            auth = false;
        }
    }//Verif_Auth


}//User
