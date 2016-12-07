package listpackage;

/**
 *
 * @author 55jphillip
 */
public class PetArray {
    private Pet[] pets;
    private int n;
    
    public PetArray() {
        pets = new Pet[100];
        n = 0;
    }
    
    // CRUD - create new pet, retrieve pets, update pet object, delete pet object
    public void create(Pet pet) {
        pets[n] = pet;
        n++;
    }
    
    @Override
    public String toString() {        
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<n; i++) {
            sb.append(pets[i]).append("\n");
        }
        return sb.toString();
    }
}
