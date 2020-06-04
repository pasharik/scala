package variance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

// Producer Extend, Consumer Super
// PECS - from collection point of view. E.g. List<Pet>
public class PeCs {
    class Animal {}
    class Pet extends Animal {}
    class Dog extends Pet {}
    class Cat extends Pet {}

    // Collection is a PRODUCER of Pets
    void printPetCollection(Collection<? extends Pet> pets) {
        pets.forEach(System.out::println);
        //pets.add(new Pet()); // Can NOT do this, because don't know which exact type is stored in collection
        // Can NOT add anything at all :(
    }

    // Collection is a CONSUMER of Pets
    void updatePetCollection(Collection<? super Pet> pets) {
        pets.add(new Pet());
        pets.add(new Dog());
        pets.add(new Cat());
        //pets.add(new Animal()); // Can NOT do this - should be Pet or higher
    }

    // If collection should do both - produce and consume - can only be fixed type <Pet>
    void updateAndPrintPet(Collection<Pet> pets) {
        //pets.add(new Pet());  // CAN add manually
        //pets.add(new Dog());
        //pets.add(new Cat());
        updatePetCollection(pets); // CAN call update method
        //pets.add(new Animal()); // Can NOT do this - should be Pet or higher
        printPetCollection(pets);  // CAN call print method
    }

    // MAIN DIFFERENCE!
    void updateAndPrintDog(Collection<Dog> pets) {
        //updatePetCollection(pets); // Can NOT do this - should be Pet or lower. Otherwise Collection<Dog> will contain Pet
        printPetCollection(pets);    // CAN call print - Pet or higher
    }

    // MAIN DIFFERENCE!
    void updateAndPrintAnimal(Collection<Animal> pets) {
        updatePetCollection(pets);   // CAN call update - Pet or lower
        //printPetCollection(pets);  // Can NOT call print - should be Pet or higher.
        // Print expects Pet properties, which Animal doesn't have
    }

    void test() {
        //producer
        List<Dog> extDog = Arrays.asList(new Dog(), new Dog());
        printPetCollection(extDog);
        List<Cat> extCat = Arrays.asList(new Cat(), new Cat());
        printPetCollection(extCat);
        List<Pet> extPet = Arrays.asList(new Dog(), new Cat());
        printPetCollection(extPet);

        //consumer
        updatePetCollection(new ArrayList<Pet>());
        updatePetCollection(new ArrayList<Animal>());
        //updatePetCollection(new ArrayList<Cat>()); // Can NOT do this - should be Pet or lower

        //updateAndPrintAnimal(new ArrayList<Dog>());  // Can NOT call this, incompatible: List<Dog> => Collection<Animal>
        // Should be List<Animal> or Set<Animal>

        updateAndPrintAnimal(new ArrayList<Animal>());
    }

    public static void main(String[] args) { new PeCs().test(); }
}
