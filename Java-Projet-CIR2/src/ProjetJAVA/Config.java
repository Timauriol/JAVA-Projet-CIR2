package ProjetJAVA;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.io.IOException;


class Config{
    private static Config instance;

    public String ip = "localhost";
    public String port = "3306";
    public String bdd = "conge";
    public String urlPdf = "http://f.codl.fr/1306/Demande_CONGES_Formulaire.pdf";
    private Properties properties;
    private final String configPath = System.getProperty("user.dir") + System.getProperty("file.separator") + "config.txt";

    public static Config getInstance(){
        if(instance == null)
            instance = new Config();
        return instance;
    }

    private Config(){
        properties = new Properties();
    }

    public void charger(){
        try {
            FileInputStream fis = new FileInputStream(configPath);
            properties.load(fis);
            ip = properties.getProperty("ip", ip);
            port = properties.getProperty("port", port);
            bdd = properties.getProperty("bdd", bdd);
            urlPdf = properties.getProperty("urlPdf", urlPdf);
            fis.close();
        } catch (IOException e){
        }
    }

    public void enregistrer() throws IOException{
        FileOutputStream fos = new FileOutputStream(configPath);
        properties.setProperty("ip",ip);
        properties.setProperty("port",port);
        properties.setProperty("bdd",bdd);
        properties.setProperty("urlPdf",urlPdf);
        properties.store(fos, "Dernière mise a jour :");
        fos.close();
    }
}
