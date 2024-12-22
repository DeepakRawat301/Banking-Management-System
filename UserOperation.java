import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserOperation extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4, label5;
    JButton button1, button2, button3;

    UserOperation() {
        super("Banking Managment System");

        label1 = new JLabel("USER WORKBENCH");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 40));
        label1.setBounds(450, 20, 800, 200);
        add(label1);

        label2 = new JLabel("TRANSFER AMOUNT");
        label2.setForeground(Color.black);
        label2.setFont(new Font("AvantGarde", Font.BOLD, 25));
        label2.setBounds(300, 150, 300, 200);
        add(label2);

        label3 = new JLabel("CHECK BALANCE");
        label3.setForeground(Color.black);
        label3.setFont(new Font("AvantGarde", Font.BOLD, 25));
        label3.setBounds(300, 300, 300, 200);
        add(label3);

        button1 = new JButton("CLICK");
        button1.setFont(new Font("Arial", Font.BOLD, 15));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(800, 230, 80, 22);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLICK");
        button2.setFont(new Font("Arial", Font.BOLD, 15));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(800, 400, 80, 22);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("LOGOUT");
        button3.setFont(new Font("Arial", Font.BOLD, 15));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(750, 550, 100, 22);
        button3.addActionListener(this);
        add(button3);

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
                new TransferMoney();
            } else if (e.getSource() == button2) {
                setVisible(false);
                new CheckBalance();
            } else if (e.getSource() == button3) {
                setVisible(false);
                new LoginUser();
            }

        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new UserOperation();

    }
}
