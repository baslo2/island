package island;

import island.model.animals.Animal;
import island.model.animals.AnimalType;
import island.model.animals.predators.Wolf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoveTest {

    private static final String ERROR_MESSAGE = "In node x: %s, y: %s, expected wolves: %s, but: %s";

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

        int actual = getAnimalsSizeInNode(island, 0, 0, AnimalType.WOLF);
        Assertions.assertEquals(1, actual, ERROR_MESSAGE.formatted(0, 0, 1, actual));
        actual = getAnimalsSizeInNode(island,1, 1, AnimalType.WOLF);
        Assertions.assertEquals(0, actual, ERROR_MESSAGE.formatted(1, 1, 0, actual));

        wolf.move();

        actual = getAnimalsSizeInNode(island, 0, 0, AnimalType.WOLF);
        Assertions.assertEquals(0, actual, ERROR_MESSAGE.formatted(0, 0, 1, actual));
        actual = getAnimalsSizeInNode(island,1, 1, AnimalType.WOLF);
        Assertions.assertEquals(1, actual, ERROR_MESSAGE.formatted(1, 1, 0, actual));
    }

    private int getAnimalsSizeInNode(Island island, int x, int y, AnimalType type) {
        return island.getIslandNode(x,y).getAnimalsByType(AnimalType.WOLF).size();
    }
}
