package hust.soict.hedspi.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Track)) {
            return false;
        }

        Track other = (Track) obj;
        return length == other.length && title != null && title.equals(other.title);
    }
    @Override
    public void play() {
        if (this.getLength() <= 0) {
            System.out.println("ERROR: Track length is non-positive!");
            return;
        }

        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
}
