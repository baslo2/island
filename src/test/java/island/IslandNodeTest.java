package island;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import island.model.animals.Animal;
import island.model.animals.AnimalType;
import island.model.animals.predators.Wolf;

class IslandNodeTest {

    @Test
    void addAnimalTest() {
        IslandNode iNode = new IslandNode();
        Animal wolf = new Wolf();
        Assertions.assertEquals(true, iNode.addAnimal(wolf), "New animal didn't add at empty IslandNode");
    }

    @Test
    void addAnimalAfterMaxSizeTest() {
        IslandNode iNode = new IslandNode();
        for (int i = 0; i < 30; i++) {
            Animal wolf = new Wolf();
            iNode.addAnimal(wolf);
        }
        Assertions.assertEquals(false, iNode.addAnimal(new Wolf()), "Added wolves more then max size: " + iNode.getAnimalsByType(AnimalType.WOLF).size() + ", but max size: " + AnimalType.WOLF.getMaxCount());
    }

    @Test
    void removeAnimalTest() {
        IslandNode iNode = new IslandNode();
        Animal wolf = new Wolf();

        iNode.addAnimal(wolf);
        Assertions.assertEquals(1, iNode.getAnimalsByType(AnimalType.WOLF).size(), "After added wolves must be 1");

        iNode.removeAnimal(wolf);
        Assertions.assertEquals(0, iNode.getAnimalsByType(AnimalType.WOLF).size(), "After remove wolves must be 0");
    }

    @Test
    void reproduceTest() {
        IslandNode iNode = new IslandNode();
        for (int i = 0; i<3; i++) {
            iNode.addAnimal(new Wolf());
        }

        Assertions.assertEquals(3, iNode.getAllAnimals().size(), "Animals before reproduce must be 3");

        iNode.reproduce(false);
        List<Animal> reproducesAnimals = new ArrayList<>();
        List<Animal> notReproduced = new ArrayList<>();
        for (var animal : iNode.getAllAnimals()) {
            if (animal.isReproduced()) {
                reproducesAnimals.add(animal);
            } else {
                notReproduced.add(animal);
            }
        }

        Assertions.assertEquals(4, iNode.getAllAnimals().size(), "Animals after reproduce must be 4");
        Assertions.assertEquals(3, reproducesAnimals.size(), "Reproduced animals must be 3");
        Assertions.assertEquals(1, notReproduced.size(), "Not reproduced animals must be 1");
    }

}
