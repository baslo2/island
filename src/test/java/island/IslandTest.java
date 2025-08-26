package island;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import island.model.animals.AnimalType;

class IslandTest {

    @Test
    void initAnimalsTest() {
        var island = new Island(5, 5);
        int animalsValue = 2;
        island.init();
        island.initAnimals(animalsValue);
        Assertions.assertEquals(AnimalType.values().length * animalsValue, island.getAllAnimals().size());
    }
}
