import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Firstpage extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4;
    JButton button1, button2, button3;

    Firstpage() {
        super("Banking Managment System");

        label1 = new JLabel("WELCOME TO BANKING");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 60));
        label1.setBounds(280, 120, 800, 200);
        add(label1);

        label2 = new JLabel("MANAGER");
        label2.setForeground(Color.black);
        label2.setFont(new Font("AvantGarde", Font.BOLD, 40));
        label2.setBounds(250, 300, 250, 200);
        add(label2);

        label3 = new JLabel("ADMIN");
        label3.setForeground(Color.black);
        label3.setFont(new Font("AvantGarde", Font.BOLD, 40));
        label3.setBounds(580, 300, 200, 200);
        add(label3);

        label4 = new JLabel("USER");
        label4.setForeground(Color.black);
        label4.setFont(new Font("AvantGarde", Font.BOLD, 40));
        label4.setBounds(880, 300, 200, 200);
        add(label4);

        button1 = new JButton("CLICK");
        button1.setFont(new Font("Arial", Font.BOLD, 15));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(280, 460, 80, 17);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLICK");
        button2.setFont(new Font("Arial", Font.BOLD, 15));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(600, 460, 80, 17);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("CLICK");
        button3.setFont(new Font("Arial", Font.BOLD, 15));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(900, 460, 80, 17);
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
                new Manager();
            } else if (e.getSource() == button2) {
                setVisible(false);
                new Accountant();
            } else if (e.getSource() == button3) {
                setVisible(false);
                new User();
            }

        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Firstpage();

    }
}
