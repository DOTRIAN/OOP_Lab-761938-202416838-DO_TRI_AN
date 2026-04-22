package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Aladin", "Animation", 18.99f);
        Book book = new Book("Clean Code", "Programming", 30.0f);
        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "Producer A", 15.0f, "Artist A");
        Track track1 = new Track("Track 1", 4);
        Track track2 = new Track("Track 2", 5);

        cd.addTrack(track1);
        cd.addTrack(track2);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(book);
        cart.addMedia(cd);

        cart.print();
        cart.searchById(dvd2.getId());
        cart.searchByTitle("The Lion King");
    }
}
