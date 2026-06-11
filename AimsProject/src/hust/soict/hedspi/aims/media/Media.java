package hust.soict.hedspi.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media implements Comparable<Media> {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            new MediaComparatorByCostTitle();

    private static int nbMedia = 0;

    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {
        nbMedia++;
        this.id = nbMedia;
    }

    public Media(String title) {
        this();
        validateTitle(title);
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        this();
        validateTitle(title);
        validateCost(cost);
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        validateTitle(title);
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        validateCost(cost);
        this.cost = cost;
    }

    private void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be blank.");
        }
    }

    private void validateCost(float cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Cost must not be negative.");
        }
    }

    public boolean isMatch(String title) {
        return this.title != null && this.title.equalsIgnoreCase(title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Media)) {
            return false;
        }

        Media other = (Media) obj;
        return Objects.equals(this.title, other.getTitle())
                && Float.compare(this.cost, other.getCost()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, cost);
    }

    @Override
    public int compareTo(Media other) {
        if (other == null) {
            throw new NullPointerException("Cannot compare Media with null.");
        }

        int titleComparison = this.title.compareToIgnoreCase(other.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }

        return Float.compare(this.cost, other.getCost());
    }
}
