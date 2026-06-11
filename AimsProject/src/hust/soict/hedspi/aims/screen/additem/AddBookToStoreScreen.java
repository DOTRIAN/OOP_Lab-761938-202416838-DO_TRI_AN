package hust.soict.hedspi.aims.screen.additem;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(4, 2, 8, 8));

        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfCost = new JTextField();
        JButton btnAdd = new JButton("Add Book");

        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                float cost = Float.parseFloat(tfCost.getText());
                store.addMedia(new Book(title, category, cost));
                JOptionPane.showMessageDialog(this, "Book added to store.");
                tfTitle.setText("");
                tfCategory.setText("");
                tfCost.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid cost value.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        center.add(new JLabel("Title"));
        center.add(tfTitle);
        center.add(new JLabel("Category"));
        center.add(tfCategory);
        center.add(new JLabel("Cost"));
        center.add(tfCost);
        center.add(new JLabel(""));
        center.add(btnAdd);

        return center;
    }
}
