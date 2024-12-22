import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddUser extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10;
    JButton button1, button2, button3;
    JTextField textAName, textPIName, textName, textPName, textMName, textFName, textLName, textOName, textBName;
    Random r = new Random();
    // int min = 100000000; // Minimum 10-digit number
    // int max = 999999999; // Maximum 10-digit number
    // int no = r.nextInt(max - min + 1) + min;
    // String acc_no = String.valueOf(no);
    String acc_no;

    private void generate_acc_no() {
        int min = 100000000; // Minimum 10-digit number
        int max = 999999999; // Maximum 10-digit number
        int no = r.nextInt(max - min + 1) + min;
        String acc_no = String.valueOf(no);
        textAName.setText(acc_no);
    }

    // private JOptionPane JOtionPane;

    AddUser() {
        super("Banking Managment System");

        label1 = new JLabel("ADD USER DETAILS");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 50));
        label1.setBounds(360, 6, 1000, 180);
        add(label1);

        label2 = new JLabel("ADD ACC NO");
        label2.setForeground(Color.black);
        label2.setFont(new Font("Raleway", Font.BOLD, 30));
        label2.setBounds(180, 100, 300, 130);
        add(label2);

        label3 = new JLabel("ADD PIN");
        label3.setForeground(Color.black);
        label3.setFont(new Font("Raleway", Font.BOLD, 30));
        label3.setBounds(180, 140, 300, 130);
        add(label3);

        label4 = new JLabel("ADD USER NAME");
        label4.setForeground(Color.black);
        label4.setFont(new Font("Raleway", Font.BOLD, 30));
        label4.setBounds(180, 180, 300, 130);
        add(label4);

        label5 = new JLabel("PASSWORD");
        label5.setForeground(Color.black);
        label5.setFont(new Font("Raleway", Font.BOLD, 30));
        label5.setBounds(180, 220, 300, 130);
        add(label5);

        label6 = new JLabel("MAIL");
        label6.setForeground(Color.black);
        label6.setFont(new Font("Raleway", Font.BOLD, 30));
        label6.setBounds(180, 260, 300, 130);
        add(label6);

        label7 = new JLabel("ADD FIRST NAME");
        label7.setForeground(Color.black);
        label7.setFont(new Font("Raleway", Font.BOLD, 30));
        label7.setBounds(180, 300, 300, 130);
        add(label7);

        label8 = new JLabel("ADD LAST NAME");
        label8.setForeground(Color.black);
        label8.setFont(new Font("Raleway", Font.BOLD, 30));
        label8.setBounds(180, 340, 300, 130);
        add(label8);

        label9 = new JLabel("ADD PHONE NO");
        label9.setForeground(Color.black);
        label9.setFont(new Font("Raleway", Font.BOLD, 30));
        label9.setBounds(180, 380, 300, 130);
        add(label9);

        label10 = new JLabel("ADD BALANCE");
        label10.setForeground(Color.black);
        label10.setFont(new Font("Raleway", Font.BOLD, 30));
        label10.setBounds(180, 420, 300, 130);
        add(label10);

        textAName = new JTextField();
        textAName.setFont(new Font("Raleway", Font.BOLD, 14));
        textAName.setBounds(650, 140, 270, 30);
        add(textAName);

        textPIName = new JTextField();
        textPIName.setFont(new Font("Raleway", Font.BOLD, 14));
        textPIName.setBounds(650, 180, 270, 30);
        add(textPIName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        textName.setBounds(650, 230, 270, 30);
        add(textName);

        textPName = new JTextField();
        textPName.setFont(new Font("Raleway", Font.BOLD, 14));
        textPName.setBounds(650, 270, 270, 30);
        add(textPName);

        textMName = new JTextField();
        textMName.setFont(new Font("Raleway", Font.BOLD, 14));
        textMName.setBounds(650, 310, 270, 30);
        add(textMName);

        textFName = new JTextField();
        textFName.setFont(new Font("Raleway", Font.BOLD, 14));
        textFName.setBounds(650, 350, 270, 30);
        add(textFName);

        textLName = new JTextField();
        textLName.setFont(new Font("Raleway", Font.BOLD, 14));
        textLName.setBounds(650, 390, 270, 30);
        add(textLName);

        textOName = new JTextField();
        textOName.setFont(new Font("Raleway", Font.BOLD, 14));
        textOName.setBounds(650, 430, 270, 30);
        add(textOName);

        textBName = new JTextField(20);
        textBName.setFont(new Font("Raleway", Font.BOLD, 14));
        textBName.setBounds(650, 470, 270, 30);
        add(textBName);

        button1 = new JButton("SAVE");
        button1.setFont(new Font("Raleway", Font.BOLD, 15));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(820, 530, 80, 23);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("BACK");
        button2.setFont(new Font("Raleway", Font.BOLD, 15));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(620, 530, 80, 23);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("GENERATE ACC NO");
        button3.setFont(new Font("Raleway", Font.BOLD, 10));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(1000, 140, 150, 23);
        button3.addActionListener(this);
        add(button3);

        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(1300, 680);
        setLocation(40, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        acc_no = textAName.getText();
        String pin = textPIName.getText();
        String Uuser_name = textName.getText();
        String Upass = textPName.getText();
        String Umail = textMName.getText();
        String Ufirst_name = textFName.getText();
        String Ulast_name = textLName.getText();
        String Uphone = textOName.getText();
        // double bal = Double.parseDouble(textBName.getText());

        if (e.getSource() == button3) {
            generate_acc_no();
        } else if (e.getSource() == button1) {
            // Validate fields
            if (textAName.getText().isEmpty() || textPIName.getText().isEmpty() || textName.getText().isEmpty() ||
                    textPName.getText().isEmpty() || textMName.getText().isEmpty() || textFName.getText().isEmpty() ||
                    textLName.getText().isEmpty() || textOName.getText().isEmpty() || textBName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            } else {
                try {
                    double bal = Double.parseDouble(textBName.getText());
                    DataConnection c1 = new DataConnection();
                    String query = "INSERT INTO User VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement prst = c1.con.prepareStatement(query);
                    prst.setString(1, acc_no);
                    prst.setString(2, pin);
                    prst.setString(3, Uuser_name);
                    prst.setString(4, Upass);
                    prst.setString(5, Umail);
                    prst.setString(6, Ufirst_name);
                    prst.setString(7, Ulast_name);
                    prst.setString(8, Uphone);
                    prst.setDouble(9, bal);
                    prst.executeUpdate();
                    c1.con.close(); // Close connection
                    JOptionPane.showMessageDialog(null, "User added successfully.");
                    new Manager();
                    setVisible(false);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid balance.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                setVisible(false);
                new AccountantOperation();
            }
        } else if (e.getSource() == button2) {
            setVisible(false);
            new AccountantOperation();
        }
    }

    public static void main(String[] args) {
        new AddUser();
    }
}
