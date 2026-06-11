package hust.soict.hedspi.aims.screen.additem;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(7, 2, 8, 8));

        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfDirector = new JTextField();
        JTextField tfLength = new JTextField();
        JTextField tfCost = new JTextField();
        JTextField tfArtist = new JTextField();
        JButton btnAdd = new JButton("Add CD");

        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String director = tfDirector.getText();
                int length = Integer.parseInt(tfLength.getText());
                float cost = Float.parseFloat(tfCost.getText());
                String artist = tfArtist.getText();
                store.addMedia(new CompactDisc(title, category, director, length, cost, artist));
                JOptionPane.showMessageDialog(this, "CD added to store.");
                tfTitle.setText("");
                tfCategory.setText("");
                tfDirector.setText("");
                tfLength.setText("");
                tfCost.setText("");
                tfArtist.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid length or cost value.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        center.add(new JLabel("Title"));
        center.add(tfTitle);
        center.add(new JLabel("Category"));
        center.add(tfCategory);
        center.add(new JLabel("Director"));
        center.add(tfDirector);
        center.add(new JLabel("Length"));
        center.add(tfLength);
        center.add(new JLabel("Cost"));
        center.add(tfCost);
        center.add(new JLabel("Artist"));
        center.add(tfArtist);
        center.add(new JLabel(""));
        center.add(btnAdd);

        return center;
    }
}
