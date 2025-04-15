import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    JTextField userField;
    JPasswordField passField;

    public LoginFrame() {
        setTitle("Library Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel userLabel = new JLabel("Username:");
        userField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        passField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals("admin") && password.equals("1234")) {
                dispose();
                new DashboardFrame();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!");
            }
        });

        setLayout(new GridLayout(3, 2));
        add(userLabel); add(userField);
        add(passLabel); add(passField);
        add(loginButton);

        setVisible(true);
    }
}
