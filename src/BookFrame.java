import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BookFrame extends JFrame {
    static ArrayList<Book> books = new ArrayList<>();
    static int bookIdCounter = 1;

    public BookFrame() {
        setTitle("Book Management");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JButton addButton = new JButton("Add Book");
        JTextArea bookArea = new JTextArea();
        bookArea.setEditable(false);

        addButton.addActionListener(e -> {
            String title = titleField.getText();
            String author = authorField.getText();

            if (!title.isEmpty() && !author.isEmpty()) {
                books.add(new Book(bookIdCounter++, title, author));
                titleField.setText("");
                authorField.setText("");
                refreshBooks(bookArea);
            }
        });

        setLayout(new GridLayout(5, 1));
        add(new JLabel("Title:"));
        add(titleField);
        add(new JLabel("Author:"));
        add(authorField);
        add(addButton);
        add(new JScrollPane(bookArea));

        refreshBooks(bookArea);
        setVisible(true);
    }

    private void refreshBooks(JTextArea area) {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.toString()).append("\n");
        }
        area.setText(sb.toString());
    }
}
