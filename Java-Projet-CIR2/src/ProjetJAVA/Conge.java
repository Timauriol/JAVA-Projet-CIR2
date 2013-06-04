package ProjetJAVA;

import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




class Conge{
    private String type;
    private SimpleDateFormat date;

    public Conge(SimpleDateFormat date, String type){
        this.date = date;
        this.type = type;
    }

    public static ArrayList<Conge> getCongesMois(String login, int annee, int mois){
        try{
            Connection connecBDD = Bdd.getInstance().connecBDD;

            String sql = "SELECT type,date FROM conge WHERE login = ? date <= ? AND date >= ?";
            // On prépare la requête
            PreparedStatement statement = connecBDD.prepareStatement(sql);
            // On assigne les types des paramètres
            statement.setString(1, login);
            statement.setString(2,
                    String.valueOf(annee + (mois==0?-1:0)) + "-" +
                    String.valueOf((mois+11%12)+1) + "-22"
                    );
            statement.setString(3,
                    String.valueOf(annee + (mois==11?1:0)) + "-" +
                    String.valueOf(((mois+1)%12)+1) + "-14"
                    );
            // Exécution de la requête
            ResultSet result = statement.executeQuery();

            ArrayList<Conge> conges = new ArrayList<Conge>();
            while(result.next()){
                String type = result.getString(1);
                SimpleDateFormat date = new SimpleDateFormat(result.getString(2));
                Conge conge = new Conge(date, type);
                conges.add(conge);
            }
            return conges;
        }
        catch(SQLException e){
            e.printStackTrace();
            return new ArrayList<Conge>();
        }
    }
}
