import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AccountantOperation extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4, label5;
    JButton button1, button2, button3, button4, button5, button6, button7;

    AccountantOperation() {
        super("Banking Managment System");

        label1 = new JLabel("ADD USER");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 25));
        label1.setBounds(300, 20, 300, 200);
        add(label1);

        label2 = new JLabel("DISPLAY ALL USER");
        label2.setForeground(Color.black);
        label2.setFont(new Font("AvantGarde", Font.BOLD, 25));
        label2.setBounds(300, 120, 300, 200);
        add(label2);

        label3 = new JLabel("SEARCH USER");
        label3.setForeground(Color.black);
        label3.setFont(new Font("AvantGarde", Font.BOLD, 25));
        label3.setBounds(300, 220, 300, 200);
        add(label3);

        label4 = new JLabel("DEBIT");
        label4.setForeground(Color.black);
        label4.setFont(new Font("AvantGarde", Font.BOLD, 25));
        label4.setBounds(300, 320, 300, 200);
        add(label4);

        label5 = new JLabel("CREDIT");
        label5.setForeground(Color.black);
        label5.setFont(new Font("AvantGarde", Font.BOLD, 25));
        label5.setBounds(300, 420, 300, 200);
        add(label5);

        button1 = new JButton("CLICK");
        button1.setFont(new Font("Arial", Font.BOLD, 15));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(800, 110, 80, 22);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLICK");
        button2.setFont(new Font("Arial", Font.BOLD, 15));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(800, 210, 80, 22);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("CLICK");
        button3.setFont(new Font("Arial", Font.BOLD, 15));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(800, 310, 80, 22);
        button3.addActionListener(this);
        add(button3);

        button4 = new JButton("CLICK");
        button4.setFont(new Font("Arial", Font.BOLD, 15));
        button4.setForeground(Color.WHITE);
        button4.setBackground(Color.BLACK);
        button4.setBounds(800, 410, 80, 22);
        button4.addActionListener(this);
        add(button4);

        button5 = new JButton("CLICK");
        button5.setFont(new Font("Arial", Font.BOLD, 15));
        button5.setForeground(Color.WHITE);
        button5.setBackground(Color.BLACK);
        button5.setBounds(800, 510, 80, 22);
        button5.addActionListener(this);
        add(button5);

        button6 = new JButton("LOGOUT");
        button6.setFont(new Font("Arial", Font.BOLD, 15));
        button6.setForeground(Color.WHITE);
        button6.setBackground(Color.BLACK);
        button6.setBounds(750, 600, 100, 22);
        button6.addActionListener(this);
        add(button6);

        setLayout(null);
        setSize(1300, 680);
        setLocation(40, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == button1) {
                setVisible(false);
                new AddUser();
            } else if (e.getSource() == button2) {
                setVisible(false);
                new DisplayUser();
            } else if (e.getSource() == button3) {
                setVisible(false);
                new SearchUser();
            } else if (e.getSource() == button4) {
                setVisible(false);
                new DebitMoney();
            } else if (e.getSource() == button5) {
                setVisible(false);
                new CreditMoney();
            } else if (e.getSource() == button6) {
                setVisible(false);
                new LoginAccountant();
            }

        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new AccountantOperation();

    }
}
