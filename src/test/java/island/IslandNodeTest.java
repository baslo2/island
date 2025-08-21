package island;

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
        Assertions.assertEquals(true, iNode.addAnimal(wolf));
    }

    @Test
    void checkAnimalSizeTest() {
        IslandNode iNode = new IslandNode();
        Animal wolf = new Wolf();
        iNode.addAnimal(wolf);
        Assertions.assertEquals(1, iNode.getAnimalsByType(AnimalType.WOLF).size());
    }

    @Test
    void addAnimalAfterMaxSizeTest() {
        IslandNode iNode = new IslandNode();
        for (int i = 0; i < 30; i++) {
            Animal wolf = new Wolf();
            iNode.addAnimal(wolf);
        }
        Assertions.assertEquals(false, iNode.addAnimal(new Wolf()));
    }

    @Test
    void removeAnimalTest() {
        IslandNode iNode = new IslandNode();
        Animal wolf = new Wolf();
        iNode.addAnimal(wolf);
        Assertions.assertEquals(1, iNode.getAnimalsByType(AnimalType.WOLF).size());
        iNode.removeAnimal(wolf);
        Assertions.assertEquals(0, iNode.getAnimalsByType(AnimalType.WOLF).size());
    }

}
