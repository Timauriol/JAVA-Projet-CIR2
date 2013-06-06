package ProjetJAVA;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Panel_login extends JPanel {

    // Variables declaration                  
    private JButton jButton_Connexion;
    private JLabel jLabel_Auth;
    private JLabel jLabel_Password;
    private JLabel jLabel_login;
    private JPasswordField jPasswordField;
    private JTextField jTextField_Login;  
    
    // Constructeur
    public Panel_login() {
        initComponents();
        System.out.println("Création du Panel_login");  
    }

    // Initialisation des composants graphique du panel_login
    private void initComponents() {
        GridBagConstraints gridBagConstraints;
        
        // Déclaration
        jLabel_Auth = new JLabel();
        jLabel_login = new JLabel();
        jTextField_Login = new JTextField();
        jPasswordField = new JPasswordField();
        jLabel_Password = new JLabel();
        jButton_Connexion = new JButton();

        // Layout
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        jLabel_Auth.setText("Authentification");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(jLabel_Auth, gridBagConstraints);

        jLabel_login.setText("Login :");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(jLabel_login, gridBagConstraints);
        
        // Dimension
        jTextField_Login.setMinimumSize(new Dimension(125, 22));
        jTextField_Login.setPreferredSize(new Dimension(125, 22));

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        add(jTextField_Login, gridBagConstraints);
        
        // Dimension
        jPasswordField.setMinimumSize(new Dimension(125, 22));
        jPasswordField.setPreferredSize(new Dimension(125, 22));

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        add(jPasswordField, gridBagConstraints);

        jLabel_Password.setText("Password");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        add(jLabel_Password, gridBagConstraints);

        jButton_Connexion.setText("Connexion");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        add(jButton_Connexion, gridBagConstraints);
    }// initComponents                      
    
    // Getter sur Login
    public String getLogin() {
        String login = jTextField_Login.getText();
        return login;
    }
    
    // Getter sur Password
    public String getPassword() {
        char[] mdp_buff = jPasswordField.getPassword();
        String mdp = new String (mdp_buff);
        return mdp;
    } 
    
    // Getter sur JButton
    public JButton getJButton() {
        return jButton_Connexion;
    } 
    
    // Getter sur JTextField
    public JTextField getJTextField_Login() {
        return jTextField_Login;
    }
    
    // Getter sur JPassword
    public JPasswordField getJPasswordField() {
        return jPasswordField;
    }        
}
