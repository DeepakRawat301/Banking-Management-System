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

public class TransferMoney extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4, label5;
    JButton button1, button2;
    JTextField textName, textPName, textBName, textRName;

    TransferMoney() {
        super("Banking Managment System");

        label1 = new JLabel("TRANSFER TRANSACTION BENCHWORK");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 40));
        label1.setBounds(220, 20, 800, 200);
        add(label1);

        label2 = new JLabel("SENDER ACCOUNT NO");
        label2.setForeground(Color.black);
        label2.setFont(new Font("Raleway", Font.BOLD, 30));
        label2.setBounds(330, 160, 400, 130);
        add(label2);

        label3 = new JLabel("PIN");
        label3.setForeground(Color.black);
        label3.setFont(new Font("Raleway", Font.BOLD, 30));
        label3.setBounds(330, 240, 400, 130);
        add(label3);

        label4 = new JLabel("RECEIVER ACCOUNT NO");
        label4.setForeground(Color.black);
        label4.setFont(new Font("Raleway", Font.BOLD, 30));
        label4.setBounds(330, 320, 400, 130);
        add(label4);

        label5 = new JLabel("AMOUNT");
        label5.setForeground(Color.black);
        label5.setFont(new Font("Raleway", Font.BOLD, 30));
        label5.setBounds(330, 400, 400, 130);
        add(label5);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        textName.setBounds(750, 205, 270, 30);
        add(textName);

        textPName = new JTextField();
        textPName.setFont(new Font("Raleway", Font.BOLD, 14));
        textPName.setBounds(750, 285, 270, 30);
        add(textPName);

        textRName = new JTextField();
        textRName.setFont(new Font("Raleway", Font.BOLD, 14));
        textRName.setBounds(750, 370, 270, 30);
        add(textRName);

        textBName = new JTextField();
        textBName.setFont(new Font("Raleway", Font.BOLD, 14));
        textBName.setBounds(750, 445, 270, 30);
        add(textBName);

        button1 = new JButton("PROCEED");
        button1.setFont(new Font("Raleway", Font.BOLD, 15));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(820, 570, 110, 23);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("BACK");
        button2.setFont(new Font("Raleway", Font.BOLD, 15));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(520, 570, 80, 23);
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
        String sender_acc_no = textName.getText();
        String pin = textPName.getText();
        String receiver_acc_no = textRName.getText();

        if (e.getSource() == button1) {
            // validate fields
            if (textName.getText().isEmpty() || textPName.getText().isEmpty() || textRName.getText().isEmpty() ||
                    textBName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            } else {
                try {
                    double amount = Double.parseDouble(textBName.getText());
                    DataConnection c1 = new DataConnection();

                    c1.con.setAutoCommit(false);
                    if (sender_acc_no != null && receiver_acc_no != null) {
                        PreparedStatement prst = c1.con
                                .prepareStatement("SELECT * FROM User WHERE acc_no = ? AND pin = ? ");
                        prst.setString(1, sender_acc_no);
                        prst.setString(2, pin);
                        ResultSet rs = prst.executeQuery();

                        if (rs.next()) {
                            double current_balance = rs.getDouble("bal");
                            if (amount <= current_balance) {

                                // Write debit and credit query

                                String debit_query = "UPDATE User SET bal = bal - ? WHERE acc_no = ?";
                                String credit_query = "UPDATE User SET bal = bal + ? WHERE acc_no = ?";

                                // Debit and Credit prepared Statements

                                PreparedStatement creditprst = c1.con.prepareStatement(credit_query);
                                PreparedStatement debitprst = c1.con.prepareStatement(debit_query);

                                // Set Values for debit and credit prepared statements

                                creditprst.setDouble(1, amount);
                                creditprst.setString(2, receiver_acc_no);
                                debitprst.setDouble(1, amount);
                                debitprst.setString(2, sender_acc_no);
                                int rowsAffected1 = debitprst.executeUpdate();
                                int rowsAffected2 = creditprst.executeUpdate();
                                if (rowsAffected1 > 0 && rowsAffected2 > 0) {
                                    JOptionPane.showMessageDialog(this, "Transaction Successful.");
                                    JOptionPane.showMessageDialog(this, "Rs. " + amount + " Transferred Successfully.");
                                    c1.con.commit();
                                    c1.con.setAutoCommit(true);
                                }

                                else {
                                    JOptionPane.showMessageDialog(this, "Transaction Failed!.");
                                    JOptionPane.showMessageDialog(this, "Invalid Receiver Account no!.");
                                    c1.con.rollback();
                                    c1.con.setAutoCommit(true);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Insufficient Balance!.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Invalid Account no or Pin!.");
                        }

                        c1.con.setAutoCommit(true);
                    }

                } catch (SQLException F) {
                    F.printStackTrace();
                }
                setVisible(false);
                new UserOperation();
            }
        } else if (e.getSource() == button2) {
            setVisible(false);
            new UserOperation();
        }
    }

    public static void main(String[] args) {
        new TransferMoney();
    }
}
