package hust.soict.hedspi.test.screen.customer.cart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import hust.soict.hedspi.aims.store.Store;

public class TestCartScreen extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
        CartController cartController = new CartController(store, cart);
        fxmlLoader.setController(cartController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Cart");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        cart.addMedia(new DigitalVideoDisc("Harry Potter and the Philosopher's Stone (2001)", "Fantasy", "Chris Columbus", 152, 3.0f));
        cart.addMedia(new DigitalVideoDisc("Harry Potter and the Chamber of Secrets (2002)", "Fantasy", "Chris Columbus", 161, 3.5f));
        cart.addMedia(new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban (2004)", "Fantasy", "Alfonso Cuaron", 142, 5.0f));
        cart.addMedia(new DigitalVideoDisc("Harry Potter and the Goblet of Fire (2005)", "Fantasy", "Mike Newell", 157, 4.5f));

        Book book = new Book("Green Eggs and Ham", "Book", 3.3f);
        cart.addMedia(book);

        CompactDisc cd = new CompactDisc("Eduro Nostalgia", "Music", "Producer A", 9.65f, "Various Artists");
        cd.addTrack(new Track("Track A", 4));
        cart.addMedia(cd);

        launch(args);
    }
}
