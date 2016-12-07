package listpackage;

/**
 * Pet class.
 *
 * @author 55jphillip
 */
public class Pet {
    private int id;
    private String species;
    private double price;

    public Pet() {
    }

    public Pet(int id, String species, double price) {
        this.id = id;
        this.species = species;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        //return "Pet{" + "id=" + id + ", species=" + species + ", price=" + price + '}';
        return String.format("%5d %-10s %8.2f", id, species, price);
    }

}
