package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();
        Cart cart = new Cart();
        initStore(store);

        int choice;
        do {
            showMenu();
            choice = readInt(scanner);
            switch (choice) {
                case 1:
                    viewStore(scanner, store, cart);
                    break;
                case 2:
                    updateStore(scanner, store);
                    break;
                case 3:
                    seeCurrentCart(scanner, cart);
                    break;
                case 0:
                    System.out.println("Exit AIMS.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private static void initStore(Store store) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        Book book = new Book("Clean Code", "Programming", 29.95f);
        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "Producer A", 20.0f, "Artist A");
        cd.addTrack(new Track("Track 1", 4));
        cd.addTrack(new Track("Track 2", 5));

        try {
            store.addMedia(dvd1);
            store.addMedia(dvd2);
            store.addMedia(book);
            store.addMedia(cd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewStore(Scanner scanner, Store store, Cart cart) {
        int choice;
        do {
            store.printStore();
            storeMenu();
            choice = readInt(scanner);
            switch (choice) {
                case 1:
                    System.out.print("Enter media title: ");
                    String title = scanner.nextLine();
                    Media media = store.findMediaByTitle(title);
                    if (media == null) {
                        System.out.println("Media not found.");
                    } else {
                        System.out.println(media);
                        mediaDetails(scanner, cart, media);
                    }
                    break;
                case 2:
                    System.out.print("Enter media title: ");
                    Media toAdd = store.findMediaByTitle(scanner.nextLine());
                    if (toAdd == null) {
                        System.out.println("Media not found.");
                    } else {
                        try {
                            cart.addMedia(toAdd);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter media title: ");
                    Media toPlay = store.findMediaByTitle(scanner.nextLine());
                    playMedia(toPlay);
                    break;
                case 4:
                    seeCurrentCart(scanner, cart);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }

    private static void mediaDetails(Scanner scanner, Cart cart, Media media) {
        int choice;
        do {
            mediaDetailsMenu();
            choice = readInt(scanner);
            switch (choice) {
                case 1:
                    try {
                        cart.addMedia(media);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    playMedia(media);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }

    private static void seeCurrentCart(Scanner scanner, Cart cart) {
        int choice;
        do {
            cart.print();
            cartMenu();
            choice = readInt(scanner);
            switch (choice) {
                case 1:
                    System.out.println("Filter by: 1. ID, 2. Title");
                    int filterChoice = readInt(scanner);
                    if (filterChoice == 1) {
                        System.out.print("Enter id: ");
                        cart.searchById(readInt(scanner));
                    } else if (filterChoice == 2) {
                        System.out.print("Enter title: ");
                        cart.searchByTitle(scanner.nextLine());
                    } else {
                        System.out.println("Invalid filter option.");
                    }
                    break;
                case 2:
                    System.out.println("Sort by: 1. Title then Cost, 2. Cost then Title");
                    int sortChoice = readInt(scanner);
                    if (sortChoice == 1) {
                        cart.sortByTitleCost();
                    } else if (sortChoice == 2) {
                        cart.sortByCostTitle();
                    } else {
                        System.out.println("Invalid sort option.");
                    }
                    break;
                case 3:
                    System.out.print("Enter media title: ");
                    Media toRemove = cart.findMediaByTitle(scanner.nextLine());
                    if (toRemove == null) {
                        System.out.println("Media not found in cart.");
                    } else {
                        cart.removeMedia(toRemove);
                    }
                    break;
                case 4:
                    System.out.print("Enter media title: ");
                    Media toPlay = cart.findMediaByTitle(scanner.nextLine());
                    playMedia(toPlay);
                    break;
                case 5:
                    System.out.println("Order is created.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }

    private static void updateStore(Scanner scanner, Store store) {
        System.out.println("Update store: 1. Add DVD, 2. Remove by title");
        int choice = readInt(scanner);
        switch (choice) {
            case 1:
                System.out.print("Title: ");
                String title = scanner.nextLine();
                System.out.print("Category: ");
                String category = scanner.nextLine();
                System.out.print("Director: ");
                String director = scanner.nextLine();
                System.out.print("Length: ");
                int length = readInt(scanner);
                System.out.print("Cost: ");
                float cost = readFloat(scanner);
                try {
                    store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.out.print("Enter media title: ");
                Media media = store.findMediaByTitle(scanner.nextLine());
                if (media == null) {
                    System.out.println("Media not found.");
                } else {
                    try {
                        store.removeMedia(media);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void playMedia(Media media) {
        if (media == null) {
            System.out.println("Media not found.");
            return;
        }
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer.");
            scanner.nextLine();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private static float readFloat(Scanner scanner) {
        while (!scanner.hasNextFloat()) {
            System.out.println("Please enter a valid number.");
            scanner.nextLine();
        }
        float value = scanner.nextFloat();
        scanner.nextLine();
        return value;
    }
}
