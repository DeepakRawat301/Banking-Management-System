import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class User extends JFrame implements ActionListener {
    JLabel label1;
    JButton button1, button2;

    User() {
        super("Banking Managment System");

        label1 = new JLabel("EXISTING USER");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", 1, 40));
        label1.setBounds(450, 100, 800, 200);
        add(label1);

        button1 = new JButton("NEXT");
        button1.setFont(new Font("Arial", 1, 15));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(700, 350, 80, 22);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("BACK");
        button2.setFont(new Font("Arial", 1, 15));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(430, 350, 80, 22);
        button2.addActionListener(this);
        add(this.button2);

        setLayout((LayoutManager) null);
        setSize(1300, 680);
        setLocation(40, 40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == button1) {
                setVisible(false);
                new LoginUser();
            } else if (e.getSource() == button2) {
                setVisible(false);
                new Firstpage();
            }

        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] var0) {
        new User();
    }
}
