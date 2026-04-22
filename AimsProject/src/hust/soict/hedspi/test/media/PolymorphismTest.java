package hust.soict.hedspi.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;

public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        Book book = new Book("Clean Architecture", "Programming", 28.0f);
        book.addAuthor("Robert C. Martin");

        DigitalVideoDisc dvd = new DigitalVideoDisc(
                "The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        CompactDisc cd = new CompactDisc(
                "Greatest Hits", "Music", "Producer A", 20.0f, "Artist A");
        cd.addTrack(new Track("Track 1", 4));
        cd.addTrack(new Track("Track 2", 5));

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}
