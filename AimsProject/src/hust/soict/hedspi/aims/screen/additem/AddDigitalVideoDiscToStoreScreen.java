package hust.soict.hedspi.aims.screen.additem;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(6, 2, 8, 8));

        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfDirector = new JTextField();
        JTextField tfLength = new JTextField();
        JTextField tfCost = new JTextField();
        JButton btnAdd = new JButton("Add DVD");

        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());
            float cost = Float.parseFloat(tfCost.getText());
            store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
            JOptionPane.showMessageDialog(this, "DVD added to store.");
            tfTitle.setText("");
            tfCategory.setText("");
            tfDirector.setText("");
            tfLength.setText("");
            tfCost.setText("");
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
        center.add(new JLabel(""));
        center.add(btnAdd);

        return center;
    }
}
