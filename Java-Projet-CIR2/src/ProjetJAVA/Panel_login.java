package ProjetJAVA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
    * This method is called from within the constructor to initialize the form.
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
        jTextField_Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jTextField_LoginActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        add(jTextField_Login, gridBagConstraints);

        jPasswordField.setMinimumSize(new Dimension(125, 22));
        jPasswordField.setPreferredSize(new Dimension(125, 22));
        jPasswordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });
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

    private void jTextField_LoginActionPerformed(ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void jPasswordFieldActionPerformed(ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                                                                        

 public JButton getButton() {
  return jButton_Connexion;
 }  
 
  public String getjTextField_Login() {
  String login = jTextField_Login.getText();
  return login;
 }
  public String getPasswordField() {
  char[] mdp_buff = jPasswordField.getPassword();
  String mdp = new String (mdp_buff);
  return mdp;
 } 
    
    

                 
}
