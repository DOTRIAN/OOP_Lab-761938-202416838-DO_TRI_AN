package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Aladin", "Animation", 18.99f);
        Book book = new Book("Refactoring", "Programming", 25.0f);
        CompactDisc cd = new CompactDisc("Acoustic Sessions", "Music", "Producer B", 20.0f, "Artist B");
        Track track1 = new Track("Intro", 3);
        Track track2 = new Track("Live Song", 6);

        cd.addTrack(track1);
        cd.addTrack(track2);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book);
        store.addMedia(cd);

        store.displayStore();

        store.removeMedia(dvd2);
        store.displayStore();

        store.removeMedia(dvd2); // test case not found
    }
}
