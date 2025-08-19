package island;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import island.model.animals.Animal;
import island.model.animals.AnimalType;
import island.model.animals.predators.Wolf;

class IslandNodeTest {

    @Test
    void testAddAnimal() {
        IslandNode iNode = new IslandNode(0, 0);
        Animal wolf = new Wolf(0, 0);
        Assertions.assertEquals(true, iNode.addAnimal(wolf));
    }

    @Test
    void testCheckAnimalSize() {
        IslandNode iNode = new IslandNode(0, 0);
        Animal wolf = new Wolf(0, 0);
        iNode.addAnimal(wolf);
        Assertions.assertEquals(1, iNode.getAnimalsByType(AnimalType.WOLF).size());
    }

    @Test
    void testAddAnimalAfterMaxSize() {
        IslandNode iNode = new IslandNode(0, 0);
        Animal wolf = new Wolf(0, 0);
        for (int i = 0; i < 30; i++) {
            iNode.addAnimal(wolf);
        }
        Assertions.assertEquals(false, iNode.addAnimal(wolf));
    }

    @Test
    void testRemoveAnimal() {
        IslandNode iNode = new IslandNode(0, 0);
        Animal wolf = new Wolf(0, 0);
        iNode.addAnimal(wolf);
        Assertions.assertEquals(1, iNode.getAnimalsByType(AnimalType.WOLF).size());
        iNode.removeAnimal(wolf);
        Assertions.assertEquals(0, iNode.getAnimalsByType(AnimalType.WOLF).size());
    }

}
