import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class LoginGUI extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnClear;
    private JCheckBox chkShowPass;

    private Map<String, String> accounts = new HashMap<>();

    public LoginGUI() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(350, 260);
        setLocationRelativeTo(null);

        createAccounts();
        initComponents();
        setVisible(true);
    }

    private void createAccounts() {
        accounts.put("admin", "12345");
        accounts.put("student", "pass001");
    }

    private void initComponents() {
        JLabel lblTitle = new JLabel("LOGIN PAGE");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBounds(115, 10, 200, 30);
        add(lblTitle);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(30, 60, 100, 25);
        add(lblUser);

        txtUsername = new JTextField();
        txtUsername.setBounds(120, 60, 180, 25);
        add(txtUsername);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(30, 100, 100, 25);
        add(lblPass);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(120, 100, 180, 25);
        add(txtPassword);

        chkShowPass = new JCheckBox("Show Password");
        chkShowPass.setBounds(120, 130, 150, 20);
        chkShowPass.addActionListener(e -> {
            txtPassword.setEchoChar(chkShowPass.isSelected() ? (char) 0 : '\u2022');
        });
        add(chkShowPass);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(70, 170, 90, 30);
        add(btnLogin);

        btnClear = new JButton("Clear");
        btnClear.setBounds(180, 170, 90, 30);
        add(btnClear);

        btnClear.addActionListener(e -> {
            txtUsername.setText("");
            txtPassword.setText("");
            txtUsername.requestFocus();
        });

        btnLogin.addActionListener(e -> loginAttempt());
    }

    private void loginAttempt() {
        String user = txtUsername.getText().trim();
        String pass = new String(txtPassword.getPassword());

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        if (accounts.containsKey(user) && accounts.get(user).equals(pass)) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
            openDashboard(user);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
            txtPassword.setText("");
        }
    }

    private void openDashboard(String username) {
        JFrame dash = new JFrame("Dashboard");
        dash.setSize(300, 160);
        dash.setLocationRelativeTo(this);

        JLabel lbl = new JLabel("Welcome, " + username, SwingConstants.CENTER);
        lbl.setFont(new Font("Arial", Font.BOLD, 18));
        dash.add(lbl);

        dash.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginGUI());
    }
}
