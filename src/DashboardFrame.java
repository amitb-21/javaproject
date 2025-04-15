import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {
    public DashboardFrame() {
        setTitle("Library Dashboard");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton manageBooks = new JButton("Manage Books");
        JButton manageMembers = new JButton("Manage Members");
        JButton issueReturn = new JButton("Issue/Return Book");

        manageBooks.addActionListener(e -> new BookFrame());
        manageMembers.addActionListener(e -> new MemberFrame());
        issueReturn.addActionListener(e -> new IssueReturnFrame());

        setLayout(new GridLayout(3, 1));
        add(manageBooks);
        add(manageMembers);
        add(issueReturn);

        setVisible(true);
    }
}
