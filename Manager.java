import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Manager extends JFrame implements ActionListener {
    JLabel label1 = new JLabel("WELCOME TO MANAGER WORKBENCH");
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JButton button1;
    JButton button2;
    JButton button3;

    Manager() {
        super("Banking Managment System");
        label1 = new JLabel("WELCOME TO MANAGER WORKBENCH");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", 1, 50));
        label1.setBounds(170, 100, 1000, 200);
        add(label1);

        label2 = new JLabel("ADD NEW MANAGER");
        label2.setForeground(Color.black);
        label2.setFont(new Font("AvantGarde", 1, 30));
        label2.setBounds(140, 300, 450, 200);
        add(label2);

        label3 = new JLabel("EXISTING MANAGER");
        label3.setForeground(Color.black);
        label3.setFont(new Font("AvantGarde", 1, 30));
        label3.setBounds(850, 300, 350, 200);
        add(label3);

        label4 = new JLabel("BACK TO PREVIOUS WINDOW");
        label4.setForeground(Color.black);
        label4.setFont(new Font("AvantGarde", 1, 30));
        label4.setBounds(400, 440, 600, 200);
        add(label4);

        button1 = new JButton("ADD");
        button1.setFont(new Font("Arial", 1, 15));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(230, 430, 80, 22);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("LOGIN");
        button2.setFont(new Font("Arial", 1, 15));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(930, 430, 100, 22);
        button2.addActionListener(this);
        add(this.button2);

        button3 = new JButton("BACK");
        button3.setFont(new Font("Arial", 1, 15));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(550, 560, 80, 22);
        button3.addActionListener(this);
        add(button3);

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
                new AddManager();
            } else if (e.getSource() == button2) {
                setVisible(false);
                new LoginManager();
            } else if (e.getSource() == button3) {
                setVisible(false);
                new Firstpage();
            }

        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] var0) {
        new Manager();
    }
}
