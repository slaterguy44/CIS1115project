package listpackage;

/**
 * Pet Application
 *
 * @author 55jphillip
 */
public class PetApp {

    public static void main(String[] args) {
        PetArray pa = new PetArray();
        pa.create(new Pet(1,"dog", 500));
        pa.create(new Pet(2, "dog", 300));
        pa.create(new Pet(3, "cat", 100));

        System.out.println(pa);
        
        PetList pl = new PetList();
        pl.create(new Pet(1,"dog", 500));
        pl.create(new Pet(2, "dog", 300));
        pl.create(new Pet(3, "cat", 100));
        
        System.out.println(pl);
    }
}
