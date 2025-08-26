package island;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IslandTest {

    @Test
    void initAnimalsTest() {
        var island = new Island(5, 5);
        island.init();
        island.initAnimals(2);
        Assertions.assertEquals(30, island.getAllAnimals().size());
    }
}
