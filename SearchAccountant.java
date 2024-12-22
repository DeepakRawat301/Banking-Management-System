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

public class SearchAccountant extends JFrame implements ActionListener {
    JLabel label1, label2;
    JTextField usernameField;
    JButton button1, button2;
    JTextArea outputTextArea;
    JScrollPane scrollPane;

    SearchAccountant() {
        super("Banking Managment System");

        label1 = new JLabel("SEARCH ACCOUNTANT ");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 50));
        label1.setBounds(340, 30, 1000, 200);
        add(label1);

        label1 = new JLabel("ENTER ACCOUNTANT USERNAME TO SEARCH ");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 20));
        label1.setBounds(240, 130, 1000, 200);
        add(label1);

        usernameField = new JTextField();
        usernameField.setBounds(750, 220, 200, 30);
        add(usernameField);

        outputTextArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        scrollPane.setBounds(130, 300, 1000, 250);
        add(scrollPane);

        button1 = new JButton("PROCEED");
        button1.setFont(new Font("Raleway", Font.BOLD, 15));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(1000, 225, 120, 23);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("BACK");
        button2.setFont(new Font("Raleway", Font.BOLD, 15));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(1000, 600, 90, 23);
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
                String query = "SELECT * FROM Accountant WHERE Auser_name = ?";
                PreparedStatement prst = c1.con.prepareStatement(query);
                prst.setString(1, username);
                ResultSet rs = prst.executeQuery();
                outputTextArea.append("All Accountant details\n");
                outputTextArea.append("\n");
                outputTextArea.append("\n");
                outputTextArea.append("\n");
                while (rs.next()) {
                    String Auser_name = rs.getString("Auser_name");
                    String Apass = rs.getString("Apass");
                    String Amail = rs.getString("Amail");
                    String Afirst_name = rs.getString("Afirst_name");
                    String Alast_name = rs.getString("Alast_name");
                    String Aphone = rs.getString("Aphone");

                    outputTextArea.append("\n");
                    outputTextArea.append("\n");

                    outputTextArea.append(String.format("%30s %30s %30s %30s %30s %30s\n", Auser_name, Apass, Amail,
                            Afirst_name, Alast_name, Aphone));

                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == button2) {
            setVisible(false);
            new ManagerOperation();
        }

    }

    public static void main(String[] args) {
        new SearchAccountant();
    }
}
