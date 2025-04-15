import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MemberFrame extends JFrame {
    static ArrayList<Member> members = new ArrayList<>();
    static int memberIdCounter = 1;

    public MemberFrame() {
        setTitle("Member Management");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField nameField = new JTextField();
        JButton addButton = new JButton("Add Member");
        JTextArea memberArea = new JTextArea();
        memberArea.setEditable(false);

        addButton.addActionListener(e -> {
            String name = nameField.getText();

            if (!name.isEmpty()) {
                members.add(new Member(memberIdCounter++, name));
                nameField.setText("");
                refreshMembers(memberArea);
            }
        });

        setLayout(new GridLayout(4, 1));
        add(new JLabel("Name:"));
        add(nameField);
        add(addButton);
        add(new JScrollPane(memberArea));

        refreshMembers(memberArea);
        setVisible(true);
    }

    private void refreshMembers(JTextArea area) {
        StringBuilder sb = new StringBuilder();
        for (Member m : members) {
            sb.append(m.toString()).append("\n");
        }
        area.setText(sb.toString());
    }
}
