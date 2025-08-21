package island;

import island.model.animals.Animal;
import island.model.animals.AnimalType;
import island.model.animals.predators.Wolf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoveTest {

    @Test
    void animalMoveTest() throws NoSuchMethodException {

        Animal wolf = new Wolf(){
            @Override
            protected int[] getNewLocation() {
                return new int[] {1,1};
            }
        };
        var island = new Island();
        island.init();
        island.getIslandNode(0,0).addAnimal(wolf);
        Assertions.assertEquals(1, island.getIslandNode(0,0).getAnimalsByType(AnimalType.WOLF).size());
        Assertions.assertEquals(0, island.getIslandNode(1,1).getAnimalsByType(AnimalType.WOLF).size());
        wolf.move();
        Assertions.assertEquals(0, island.getIslandNode(0,0).getAnimalsByType(AnimalType.WOLF).size());
        Assertions.assertEquals(1, island.getIslandNode(1,1).getAnimalsByType(AnimalType.WOLF).size());
    }
}
