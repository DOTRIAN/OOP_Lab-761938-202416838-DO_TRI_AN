package Lab02.src;

public class Aims {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f
        );
        System.out.println("Title: " + dvd1.getTitle());
        System.out.println("Category: " + dvd1.getCategory());
        System.out.println("Director: " + dvd1.getDirector());
        System.out.println("Length: " + dvd1.getLength());
        System.out.println("Cost: " + dvd1.getCost());
    }
}