import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddManager extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4, label5, label6, label7;
    JButton button1, button2;
    JTextField textName, textPName, textMName, textFName, textLName, textOName;

    AddManager() {
        super("Banking Managment System");

        label1 = new JLabel("ADD MANAGER DETAILS");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 50));
        label1.setBounds(340, 70, 1000, 200);
        add(label1);

        label2 = new JLabel("ADD USER NAME");
        label2.setForeground(Color.black);
        label2.setFont(new Font("Raleway", Font.BOLD, 30));
        label2.setBounds(180, 180, 300, 130);
        add(label2);

        label3 = new JLabel("PASSWORD");
        label3.setForeground(Color.black);
        label3.setFont(new Font("Raleway", Font.BOLD, 30));
        label3.setBounds(180, 220, 300, 130);
        add(label3);

        label4 = new JLabel("MAIL");
        label4.setForeground(Color.black);
        label4.setFont(new Font("Raleway", Font.BOLD, 30));
        label4.setBounds(180, 260, 300, 130);
        add(label4);

        label5 = new JLabel("ADD FIRST NAME");
        label5.setForeground(Color.black);
        label5.setFont(new Font("Raleway", Font.BOLD, 30));
        label5.setBounds(180, 300, 300, 130);
        add(label5);

        label6 = new JLabel("ADD LAST NAME");
        label6.setForeground(Color.black);
        label6.setFont(new Font("Raleway", Font.BOLD, 30));
        label6.setBounds(180, 340, 300, 130);
        add(label6);

        label7 = new JLabel("ADD PHONE NO");
        label7.setForeground(Color.black);
        label7.setFont(new Font("Raleway", Font.BOLD, 30));
        label7.setBounds(180, 380, 300, 130);
        add(label7);

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

        button1 = new JButton("SAVE");
        button1.setFont(new Font("Raleway", Font.BOLD, 15));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(820, 490, 80, 23);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("BACK");
        button2.setFont(new Font("Raleway", Font.BOLD, 15));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(680, 490, 80, 23);
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
        String Muser_name = textName.getText();
        String Mpass = textPName.getText();
        String Mmail = textMName.getText();
        String Mfirst_name = textFName.getText();
        String Mlast_name = textLName.getText();
        String Mphone = textOName.getText();

        if (e.getSource() == button1) {
            // validate fields
            if (textName.getText().isEmpty() || textPName.getText().isEmpty() || textMName.getText().isEmpty()
                    || textFName.getText().isEmpty() || textLName.getText().isEmpty()
                    || textOName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            } else {
                try {
                    DataConnection c1 = new DataConnection();
                    String query = "INSERT INTO Manager VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement prst = c1.con.prepareStatement(query);
                    prst.setString(1, Muser_name);
                    prst.setString(2, Mpass);
                    prst.setString(3, Mmail);
                    prst.setString(4, Mfirst_name);
                    prst.setString(5, Mlast_name);
                    prst.setString(6, Mphone);
                    prst.executeUpdate();
                    c1.con.close(); // Close connection
                    JOptionPane.showMessageDialog(null, "User added successfully.");

                } catch (SQLException F) {
                    F.printStackTrace();
                }
                setVisible(false);
                new Manager();
            }
        } else if (e.getSource() == button2) {
            setVisible(false);
            new Manager();
        }

    }

    public static void main(String[] args) {
        new AddManager();
    }
}
