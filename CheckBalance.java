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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CheckBalance extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4;
    JButton button1, button2;
    JTextField textName, textPName, textBName;

    CheckBalance() {
        super("Banking Managment System");

        label1 = new JLabel("ACCOUNT BALANCE");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 50));
        label1.setBounds(420, 70, 1000, 200);
        add(label1);

        label2 = new JLabel("ACCOUNT NO");
        label2.setForeground(Color.black);
        label2.setFont(new Font("Raleway", Font.BOLD, 30));
        label2.setBounds(360, 200, 400, 130);
        add(label2);

        label3 = new JLabel("PIN");
        label3.setForeground(Color.black);
        label3.setFont(new Font("Raleway", Font.BOLD, 30));
        label3.setBounds(360, 300, 400, 130);
        add(label3);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        textName.setBounds(780, 250, 270, 30);
        add(textName);

        textPName = new JTextField();
        textPName.setFont(new Font("Raleway", Font.BOLD, 14));
        textPName.setBounds(780, 350, 270, 30);
        add(textPName);

        button1 = new JButton("PROCEED");
        button1.setFont(new Font("Raleway", Font.BOLD, 15));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(820, 420, 100, 23);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("BACK");
        button2.setFont(new Font("Raleway", Font.BOLD, 15));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(520, 425, 80, 23);
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
        String acc_no = textName.getText();
        String pin = textPName.getText();

        if (e.getSource() == button1) {
            // validate fields
            if (textName.getText().isEmpty() || textPName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            } else {
                try {
                    DataConnection c1 = new DataConnection();

                    PreparedStatement prst = c1.con
                            .prepareStatement("SELECT bal FROM User WHERE acc_no = ? AND pin = ?");
                    prst.setString(1, acc_no);
                    prst.setString(2, pin);
                    ResultSet resultSet = prst.executeQuery();
                    if (resultSet.next()) {
                        double bal = resultSet.getDouble("bal");
                        JOptionPane.showMessageDialog(this, "Account balance is. " + bal);

                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid Account no or Pin!");

                    }
                } catch (SQLException E) {
                    E.printStackTrace();
                }
            }
        } else if (e.getSource() == button2) {
            setVisible(false);
            new UserOperation();
        }

    }

    public static void main(String[] args) {
        new CheckBalance();
    }
}
