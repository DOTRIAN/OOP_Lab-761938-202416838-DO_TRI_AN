package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.media.Media;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;

    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) throws LimitExceededException {
        if (media == null) {
            throw new IllegalArgumentException("Media must not be null.");
        }

        if (itemsInStore.size() >= MAX_ITEMS_IN_STORE) {
            throw new LimitExceededException("ERROR: The number of media in the store has reached its limit.");
        }

        if (itemsInStore.contains(media)) {
            throw new IllegalStateException("The media already exists in the store.");
        }

        itemsInStore.add(media);
        System.out.println("The media has been added to the store");
    }

    public void removeMedia(Media media) {
        if (media == null) {
            throw new IllegalArgumentException("Media must not be null.");
        }

        if (itemsInStore.remove(media)) {
            System.out.println("The media has been removed from the store");
        } else {
            throw new IllegalStateException("The media was not found in the store.");
        }
    }

    public void displayStore() {
        System.out.println("Items in store:");

        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i));
        }
    }
    public void printStore() {
        System.out.println("\n***********************STORE***********************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public Media findMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.isMatch(title)) {
                return media;
            }
        }
        return null;
    }
}
