package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;

    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsInStore.size() >= MAX_ITEMS_IN_STORE) {
            System.out.println("The store is full");
            return;
        }

        if (itemsInStore.contains(media)) {
            System.out.println("The media already exists in the store");
            return;
        }

        itemsInStore.add(media);
        System.out.println("The media has been added to the store");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The media has been removed from the store");
        } else {
            System.out.println("The media was not found in the store");
        }
    }

    public void displayStore() {
        System.out.println("Items in store:");

        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i));
        }
    }
}
