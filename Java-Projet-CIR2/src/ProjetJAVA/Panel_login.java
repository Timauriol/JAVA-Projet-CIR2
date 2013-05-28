package ProjetJAVA;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Erza
 */

public class Panel_login extends JPanel {

    // Variables declaration                  
    private JButton jButton_Connexion;
    private JLabel jLabel_Auth;
    private JLabel jLabel_Password;
    private JLabel jLabel_login;
    private JPasswordField jPasswordField;
    private JTextField jTextField_Login;  
    
    
    /**
     * Creates new form Fen
     */
    public Panel_login() {
        initComponents();
        System.out.println("Création du Panel_login");
        
    }

   /**
    * Cette methode est appelé dans le constructeur pour 
    * initialiser les éléments graphiques.
    */
                       
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        jLabel_Auth = new JLabel();
        jLabel_login = new JLabel();
        jTextField_Login = new JTextField();
        jPasswordField = new JPasswordField();
        jLabel_Password = new JLabel();
        jButton_Connexion = new JButton();

        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[] {0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
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

        jTextField_Login.setMinimumSize(new Dimension(125, 22));
        jTextField_Login.setName(""); // NOI18N
        jTextField_Login.setPreferredSize(new Dimension(125, 22));

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        add(jTextField_Login, gridBagConstraints);

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
    }// </editor-fold>                        
                                                                                    
    public String getLogin() {
        String login = jTextField_Login.getText();
        return login;
    }
    public String getPassword() {
    char[] mdp_buff = jPasswordField.getPassword();
    String mdp = new String (mdp_buff);
    return mdp;
    } 

    public JButton getJButton() {
        return jButton_Connexion;
    } 
    
    public JTextField getJTextField_Login() {
    return jTextField_Login;
    }

    public JPasswordField getJPasswordField() {
    return jPasswordField;
    } 
            
}
