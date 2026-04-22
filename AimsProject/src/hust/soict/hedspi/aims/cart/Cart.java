package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The media has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed");
        } else {
            System.out.println("The media was not found");
        }
    }

    public float totalCost() {
        float sum = 0;

        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }

        return sum;
    }

    public void displayCart() {
        System.out.println("Items in cart:");

        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).getTitle() + " - " + itemsOrdered.get(i).getCost());
        }

        System.out.println("Total cost: " + totalCost());
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i));
        }

        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media);
                return;
            }
        }

        System.out.println("No match found.");
    }

    public void searchByTitle(String title) {
        boolean found = false;

        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println(media);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No match found.");
        }
    }
}
