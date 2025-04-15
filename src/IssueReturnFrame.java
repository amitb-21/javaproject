import javax.swing.*;
import java.awt.*;

public class IssueReturnFrame extends JFrame {
    public IssueReturnFrame() {
        setTitle("Issue / Return Book");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JComboBox<Book> bookBox = new JComboBox<>();
        JComboBox<Member> memberBox = new JComboBox<>();
        JButton issueBtn = new JButton("Issue Book");
        JButton returnBtn = new JButton("Return Book");

        for (Book b : BookFrame.books) bookBox.addItem(b);
        for (Member m : MemberFrame.members) memberBox.addItem(m);

        issueBtn.addActionListener(e -> {
            Book selectedBook = (Book) bookBox.getSelectedItem();
            if (selectedBook != null && selectedBook.available) {
                selectedBook.available = false;
                JOptionPane.showMessageDialog(this, "Book issued.");
                bookBox.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "Book already issued.");
            }
        });

        returnBtn.addActionListener(e -> {
            Book selectedBook = (Book) bookBox.getSelectedItem();
            if (selectedBook != null && !selectedBook.available) {
                selectedBook.available = true;
                JOptionPane.showMessageDialog(this, "Book returned.");
                bookBox.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "Book is not issued.");
            }
        });

        setLayout(new GridLayout(5, 1));
        add(new JLabel("Select Book:"));
        add(bookBox);
        add(new JLabel("Select Member:"));
        add(memberBox);
        add(issueBtn);
        add(returnBtn);

        setVisible(true);
    }
}
