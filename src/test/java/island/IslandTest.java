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
        int expected = AnimalType.values().length * animalsValue;
        int actual = island.getAllAnimals().size();
        Assertions.assertEquals(expected, actual, "Island have wrong animals size: " + actual + ", but expected: " + expected);
    }
}
