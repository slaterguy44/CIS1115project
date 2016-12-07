package listpackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 55jphillip
 */
public class PetList {

    private final String fileName = "petdata.txt";
    private List<Pet> myList;

    public PetList() {
        myList = new ArrayList();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ex) {
            Logger.getLogger(PetList.class.getName()).log(Level.SEVERE, null, ex);
        }
        readList();
    }

    public void create(Pet pet) {
        myList.add(pet);
        writeList();
    }

    public Pet retrieve(int id) {
        for (Pet pet : myList) {
            if (pet.getId() == id) {
                return pet;
            }
        }
        return null;
    }
    
    public void delete(int id) {
        for (Pet pet : myList) {
            if (pet.getId() == id) {
                myList.remove(pet);
            }
        }
        writeList();
    }

    public String orderById() {
        myList.sort(Comparator.comparing(Pet::getId));
        return this.toString();       
    }

    public String orderBySpecies() {
        myList.sort(Comparator.comparing(Pet::getSpecies));
        return this.toString();     
    }
    
    public String orderByPrice() {
        myList.sort(Comparator.comparing(Pet::getPrice).reversed());
        return this.toString();     
    }

    public String orderBySpeciesPrice() {
        myList.sort(Comparator.comparing(Pet::getSpecies).thenComparing(Pet::getPrice).reversed());
        return this.toString();     
    }    

    private void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String species = data[1];
                double price = Double.parseDouble(data[2]);
                Pet mypet = new Pet(id, species, price);
                myList.add(mypet);
            }
        } catch (IOException ex) {
            Logger.getLogger(PetList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Pet pet : myList) {
                writer.write(String.format("%d,%s,%.2f\n",
                        pet.getId(),
                        pet.getSpecies(),
                        pet.getPrice()));
            }
        } catch (IOException ex) {
            Logger.getLogger(PetList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pet pet : myList) {
            sb.append(pet).append("\n");
        }
        return sb.toString();
        //return myList.toString();
    }
}
