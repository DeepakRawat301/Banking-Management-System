import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchUser extends JFrame implements ActionListener {
    JLabel label1, label2;
    JTextField usernameField;
    JButton button1, button2, button3;
    JTextArea outputTextArea;
    JScrollPane scrollPane;

    SearchUser() {
        super("Banking Managment System");

        label1 = new JLabel("SEARCH USER ");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 50));
        label1.setBounds(360, 30, 1000, 200);
        add(label1);

        label1 = new JLabel("ENTER USER USERNAME TO SEARCH ");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 20));
        label1.setBounds(220, 130, 1000, 200);
        add(label1);

        usernameField = new JTextField();
        usernameField.setBounds(700, 220, 200, 30);
        add(usernameField);

        outputTextArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        scrollPane.setBounds(130, 300, 1000, 250);
        add(scrollPane);

        button1 = new JButton("PROCEED");
        button1.setFont(new Font("Raleway", Font.BOLD, 15));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(1000, 220, 120, 23);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("BACK");
        button2.setFont(new Font("Raleway", Font.BOLD, 15));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(1000, 600, 120, 23);
        button2.addActionListener(this);
        add(button2);

        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(1300, 680);
        setLocation(40, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button1) {
            String username = usernameField.getText().trim();
            try {
                DataConnection c1 = new DataConnection();
                String query = "SELECT * FROM User WHERE Uuser_name = ?";
                PreparedStatement prst = c1.con.prepareStatement(query);
                prst.setString(1, username);
                ResultSet rs = prst.executeQuery();
                outputTextArea.append("All Accountant details\n");
                outputTextArea.append("\n");
                outputTextArea.append("\n");
                outputTextArea.append("\n");
                while (rs.next()) {
                    String acc_no = rs.getString("acc_no");
                    String pin = rs.getString("pin");
                    String Uuser_name = rs.getString("Uuser_name");
                    String Upass = rs.getString("Upass");
                    String Umail = rs.getString("Umail");
                    String Ufirst_name = rs.getString("Ufirst_name");
                    String Ulast_name = rs.getString("Ulast_name");
                    String Uphone = rs.getString("Uphone");
                    double bal = rs.getDouble("bal");

                    outputTextArea.append("\n");
                    outputTextArea.append("\n");

                    outputTextArea.append(String.format("%30s %30s %30s %30s %30s %30s %30s %30s %30s \n", acc_no, pin,
                            Uuser_name, Upass, Umail,
                            Ufirst_name, Ulast_name, Uphone, bal));

                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == button2) {
            setVisible(false);
            new AccountantOperation();
        }

    }

    public static void main(String[] args) {
        new SearchUser();
    }
}
