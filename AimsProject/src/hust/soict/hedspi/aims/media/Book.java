package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<String>();

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("The author has been added");
        } else {
            System.out.println("The author already exists");
        }
    }
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("The author has been removed");
        } else {
            System.out.println("The author does not exist");
        }
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - " + getCost() + " $";
    }
}
