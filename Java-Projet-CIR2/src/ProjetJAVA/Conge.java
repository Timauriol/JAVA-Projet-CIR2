package ProjetJAVA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

class Conge{
    
    // Déclaration
    public String type;
    public Calendar date;

    // Constructeur
    public Conge(Calendar date, String type){
        this.date = date;
        this.type = type;
    }

    // Retourne une liste de congé correspondant aux paramètres passés.
    public static ArrayList<Conge> getCongesMois(String login, int annee, int mois){
        try{
            Connection connecBDD = Bdd.getInstance().connecBDD;

            String sql = "SELECT type, EXTRACT(YEAR FROM date), EXTRACT(MONTH FROM date),"
                    + " EXTRACT(DAY FROM date), EXTRACT(HOUR FROM date) FROM conges WHERE login = ? AND date >= ? AND date <= ?";
            
            PreparedStatement statement = connecBDD.prepareStatement(sql);
            statement.setString(1, login);
            statement.setString(2,
                    String.valueOf(annee + (mois==0?-1:0)) + "-" +
                    String.valueOf(((mois+11)%12)+1) + "-22"
                    );
            statement.setString(3,
                    String.valueOf(annee + (mois==11?1:0)) + "-" +
                    String.valueOf(((mois+1)%12)+1) + "-14"
                    );
            ResultSet result = statement.executeQuery();

            ArrayList<Conge> conges = new ArrayList<>();
            
            // Boucle de traitement des valeur de la réponse SQL
            while(result.next()){
                String type = result.getString(1);
                Calendar date = new GregorianCalendar(result.getInt(2), result.getInt(3) - 1, result.getInt(4), result.getInt(5), 0, 0);
                date.setFirstDayOfWeek(Calendar.MONDAY);
                Conge conge = new Conge(date, type);
                conges.add(conge);
            }
            return conges;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Connexion à la BDD perdue");
            // Retourne un tableau vide en cas d'erreur.
            return new ArrayList<>();
        }
    }
}
