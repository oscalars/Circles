import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener {

    JPanel loginPanel;
    String user;
    JTextField username;
    JPasswordField password;
    JLabel loginError;
    JPanel mainPanel;

    public Login(MainFrame frame){
        frame.setMinimumSize(new Dimension(500,300));
        loginPanel = this.makeLoginPanel();
        frame.add(loginPanel);
        frame.setLocation(100,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        String sourceClicked = e.getActionCommand();

        switch (sourceClicked){
            //klicka på registered skicka till registered
            //klicka på login validate!!
        }
    }
    private JPanel makeLoginPanel() {

        JPanel finishedPanel = new JPanel();
        finishedPanel.setBackground(Color.WHITE);
        finishedPanel.setLayout(new GridLayout(3, 1, 0, 10));
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(2, 1, 3, 3));
        textPanel.setBackground(Color.WHITE);
        JLabel welcome = new JLabel("Welcome to Circles");
        welcome.setHorizontalAlignment(0);
        welcome.setVerticalAlignment(JLabel.BOTTOM);
        welcome.setFont(new Font("Arial Black", Font.BOLD, 24));
        welcome.setForeground(Color.decode("#C6E2FF"));


        JLabel prompt = new JLabel("Please login or register to continue:");
        prompt.setHorizontalAlignment(0);
        textPanel.add(welcome);
        textPanel.add(prompt);
        finishedPanel.add(textPanel);


        JPanel userpass = new JPanel();
        JPanel userpassFinal = new JPanel();
        userpassFinal.setBackground(Color.WHITE);
        userpassFinal.setLayout(new FlowLayout());
        JPanel emptyu1 = new JPanel();
        JPanel emptyu2 = new JPanel();
        emptyu2.setBackground(Color.WHITE);
        emptyu1.setBackground(Color.WHITE);
        userpassFinal.add(emptyu1);
        userpass.setLayout(new GridLayout(2, 2, 0, 0));
        userpass.setBackground(Color.WHITE);
        JLabel uname = new JLabel("Username: ");
        uname.setHorizontalAlignment(0);
        JLabel pass = new JLabel("Password: ");
        pass.setHorizontalAlignment(0);
        username = new JTextField();
        username.setColumns(15);
        password = new JPasswordField();
        password.setColumns(15);
        userpass.add(uname);
        userpass.add(username);
        userpass.add(pass);
        userpass.add(password);

        userpassFinal.add(userpass);
        userpassFinal.add(emptyu2);

        finishedPanel.add(userpassFinal);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 1, 10));
        buttonPanel.setBackground(Color.WHITE);
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        JPanel alignPanel = new JPanel();
        JPanel empty1 = new JPanel();
        empty1.setBackground(Color.WHITE);
        JPanel empty2 = new JPanel();
        empty2.setBackground(Color.WHITE);
        alignPanel.setLayout(new BoxLayout(alignPanel, BoxLayout.X_AXIS));
        alignPanel.add(empty1);
        alignPanel.add(buttonPanel);
        alignPanel.add(empty2);
        finishedPanel.add(alignPanel);
        return finishedPanel;
    }
}