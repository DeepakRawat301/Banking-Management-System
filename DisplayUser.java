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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DisplayUser extends JFrame implements ActionListener {
    JLabel label1;
    JButton button1, button2;
    JTable table;
    JScrollPane scrollPane;
    DefaultTableModel model;

    DisplayUser() {
        super("Banking Management System");

        label1 = new JLabel("DISPLAY ALL USER DETAILS");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 30));
        label1.setBounds(340, 70, 1000, 50);
        add(label1);

        // Setting up the table and scroll pane
        model = new DefaultTableModel();
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(130, 150, 1000, 300);
        add(scrollPane);

        // Adding columns to the table
        model.addColumn("Account No");
        model.addColumn("PIN");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Email");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Phone");
        model.addColumn("Balance");

        button1 = new JButton("PROCEED");
        button1.setFont(new Font("Raleway", Font.BOLD, 15));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(820, 520, 110, 23);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("BACK");
        button2.setFont(new Font("Raleway", Font.BOLD, 15));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(680, 520, 80, 23);
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
            try {
                DataConnection c1 = new DataConnection();
                PreparedStatement prst = c1.con.prepareStatement("SELECT * FROM USER");
                ResultSet rs = prst.executeQuery();

                // Clearing previous data in the table
                model.setRowCount(0);

                // Populating the table with the result set
                while (rs.next()) {
                    String acc_no = rs.getString("acc_no");
                    String pin = rs.getString("pin");
                    String Uuser_name = rs.getString("Uuser_name");
                    String Upass = rs.getString("Upass");
                    String Umail = rs.getString("Umail");
                    String Ufirst_name = rs.getString("Ufirst_name");
                    String Ulast_name = rs.getString("Ulast_name");
                    String Uphone = rs.getString("Uphone");
                    double bal = rs.getDouble("bal");

                    model.addRow(new Object[]{acc_no, pin, Uuser_name, Upass, Umail,
                            Ufirst_name, Ulast_name, Uphone, bal});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == button2) {
            setVisible(false);
            new AccountantOperation();
        }

    }

    public static void main(String[] args) {
        new DisplayUser();
    }
}
