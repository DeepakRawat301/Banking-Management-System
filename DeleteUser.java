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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DeleteUser extends JFrame implements ActionListener {
    JLabel label1, label2;
    JTextField usernameField;
    JButton button1, button2, button3;
    JTextArea outputTextArea;
    JScrollPane scrollPane;

    DeleteUser() {
        super("Banking Managment System");

        label1 = new JLabel("DELETE USER ");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 50));
        label1.setBounds(440, 30, 1000, 200);
        add(label1);

        label1 = new JLabel("ENTER USER'S USERNAME TO DELETE ");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 20));
        label1.setBounds(200, 130, 1000, 200);
        add(label1);

        usernameField = new JTextField();
        usernameField.setBounds(650, 220, 200, 30);
        add(usernameField);

        outputTextArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        scrollPane.setBounds(150, 300, 1000, 250);
        add(scrollPane);

        button1 = new JButton("DELETE");
        button1.setFont(new Font("Raleway", Font.BOLD, 15));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(900, 220, 100, 23);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("BACK");
        button2.setFont(new Font("Raleway", Font.BOLD, 15));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(900, 600, 100, 23);
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
                String query = "SELECT * FROM User WHERE Uuser_name = ?";
                PreparedStatement prst = c1.con.prepareStatement(query);
                prst.setString(1, username);
                ResultSet rs = prst.executeQuery();
                outputTextArea.append(" User details\n");
                outputTextArea.append("\n");
                outputTextArea.append("\n");
                outputTextArea.append("\n");
                int z = 0;
                while (rs.next()) {
                    z = 1;
                    String acc_no = rs.getString("acc_no");
                    String pin = rs.getString("pin");
                    String Uuser_name = rs.getString("Uuser_name");
                    String Upass = rs.getString("Upass");
                    String Umail = rs.getString("Umail");
                    String Ufirst_name = rs.getString("Ufirst_name");
                    String Ulast_name = rs.getString("Ulast_name");
                    String Uphone = rs.getString("Uphone");
                    double bal = rs.getDouble("bal");

                    outputTextArea.append("\n");
                    outputTextArea.append("\n");

                    outputTextArea.append(String.format("%30s %30s %30s %30s %30s %30s %30s %30s %30s \n", acc_no, pin,
                            Uuser_name, Upass, Umail,
                            Ufirst_name, Ulast_name, Uphone, bal));

                }
                if (z == 0) {
                    JOptionPane.showMessageDialog(this, "Record not found!");
                } else {
                    String query1 = "Delete from User where Uuser_name = ?";
                    PreparedStatement prst1 = c1.con.prepareStatement(query1);
                    prst1.setString(1, username);
                    int n = prst1.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(this, "User Record deleted!");
                        setVisible(false);
                        new ManagerOperation();
                    } else {
                        JOptionPane.showMessageDialog(this, "User Record not deleted!");
                        setVisible(false);
                        new ManagerOperation();
                    }
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
        new DeleteUser();
    }
}
