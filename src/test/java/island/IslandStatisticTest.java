package island;

import island.model.animals.Plant;
import island.model.animals.herbivores.Rabbit;
import island.model.animals.predators.Wolf;
import island.utils.IslandStatistic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

class IslandStatisticTest {

    private static final String START_STAT = """
Object Type|________________startDay/EndDay
WOLF|________________1/null
ANACONDA|________________0/null
BEAR|________________0/null
EAGLE|________________0/null
FOX|________________0/null
BOAR|________________0/null
BUFFALO|________________0/null
CATERPILLAR|________________0/null
DEER|________________0/null
DUCK|________________0/null
GOAT|________________0/null
HORSE|________________0/null
MOUSE|________________0/null
RABBIT|________________0/null
SHEEP|________________0/null
Plants|________________10/0""";

    private static final String END_STAT = """
            Object Type|________________startDay/EndDay
            WOLF|________________1/2
            ANACONDA|________________0/0
            BEAR|________________0/0
            EAGLE|________________0/0
            FOX|________________0/0
            BOAR|________________0/0
            BUFFALO|________________0/0
            CATERPILLAR|________________0/0
            DEER|________________0/0
            DUCK|________________0/0
            GOAT|________________0/0
            HORSE|________________0/0
            MOUSE|________________0/0
            RABBIT|________________0/1
            SHEEP|________________0/0
            Plants|________________10/10""";

    @Test
    void simpleStatTest(){
        var island = new Island(2, 2);
        island.init();
        island.initAnimals(5);
        IslandStatistic.cashStartDayStat(island);
        var firstStat = IslandStatistic.getDayStat();
        Assertions.assertNotNull(firstStat);
        island.initAnimals(5);
        IslandStatistic.cashEndDayStat(island);
        var secondStat = IslandStatistic.getDayStat();
        Assertions.assertNotNull(secondStat);
        Assertions.assertNotEquals(firstStat, secondStat);
    }

    @Test
    void printStatTest() {
        var island = new Island(2,2);
        island.init();
        var node = island.getIslandNode(0,0);
        node.addAnimal(new Wolf());
        for(int i=0; i<10; i++) {
            node.addPlant(new Plant());
        }
        IslandStatistic.cashStartDayStat(island);
        Assertions.assertEquals(START_STAT, IslandStatistic.getDayStat());

        node.addAnimal(new Rabbit());
        node.addAnimal(new Wolf());

        IslandStatistic.cashEndDayStat(island);
        Assertions.assertEquals(END_STAT, IslandStatistic.getDayStat());
    }
}
