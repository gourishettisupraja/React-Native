import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.*;
import java.util.*;

public class LoginScreen extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginScreen() {
        super("Login Screen");

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("admin") && password.equals("admin1234")) {
            System.out.println("Login successful!");
            // Allow access to the Game Play screen
            Scanner input = new Scanner(System.in);
            int coins = 21;
            System.out.println("Welcome to the Coin Game!");
            System.out.println("There are " + coins + " coins in the middle.");
            System.out.println("You can pick 1, 2, 3, or 4 coins at a time.");
            
            while (coins > 0) {
                // Player's turn
                int playerPick = 0;
                while (playerPick < 1 || playerPick > 4 || playerPick > coins) {
                    System.out.print("How many coins do you want to pick? ");
                    playerPick = input.nextInt();
                }
                coins -= playerPick;
                System.out.println("You picked " + playerPick + " coins.");
                System.out.println("There are " + coins + " coins left.");
                if (coins == 0) {
                    System.out.println("You lost the game.");
                    break;
                }
                
                // AI's turn
                int aiPick = 4 - playerPick;
                if (aiPick > coins) {
                    aiPick = coins;
                }
                coins -= aiPick;
                System.out.println("AI picked " + aiPick + " coins.");
                System.out.println("There are " + coins + " coins left.");
                if (coins == 0) {
                    System.out.println("AI won the game.");
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.");
        }
    }

    public static void main(String[] args) {
        new LoginScreen();
    }
}
