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

public class DisplayAccountant extends JFrame implements ActionListener {
    JLabel label1;
    JButton button1, button2;
    JTable table;
    JScrollPane scrollPane;
    DefaultTableModel model;

    DisplayAccountant() {
        super("Banking Management System");

        label1 = new JLabel("DISPLAY ALL ACCOUNTANT DETAILS");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 30));
        label1.setBounds(310, 20, 1000, 50);
        add(label1);

        // Setting up the table and scroll pane
        model = new DefaultTableModel();
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(170, 100, 1000, 350);
        add(scrollPane);

        // Adding columns to the table
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Email");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Phone");

        button1 = new JButton("PROCEED");
        button1.setFont(new Font("Raleway", Font.BOLD, 15));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(820, 540, 120, 23);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("BACK");
        button2.setFont(new Font("Raleway", Font.BOLD, 15));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(680, 540, 100, 23);
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
                String query="Select * from accountant";
                PreparedStatement prst = c1.con.prepareStatement(query);
                ResultSet rs = prst.executeQuery();

                // Clearing previous data in the table
                model.setRowCount(0);

                // Populating the table with the result set
                while (rs.next()) {
                    String Auser_name = rs.getString("Auser_name");
                    String Apass = rs.getString("Apass");
                    String Amail = rs.getString("Amail");
                    String Afirst_name = rs.getString("Afirst_name");
                    String Alast_name = rs.getString("Alast_name");
                    String Aphone = rs.getString("Aphone");

                    model.addRow(new Object[]{Auser_name, Apass, Amail, Afirst_name, Alast_name, Aphone});
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
        new DisplayAccountant();
    }
}
