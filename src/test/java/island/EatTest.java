package island;

import island.model.animals.AnimalType;
import island.model.animals.Plant;
import island.model.animals.herbivores.Boar;
import island.model.animals.herbivores.Caterpillar;
import island.model.animals.herbivores.Horse;
import island.model.animals.predators.Wolf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EatTest {

    @Test
    void wolfDidntFindAnyFoodTest() {
        var node = new IslandNode();
        var wolf = new Wolf();
        node.addAnimal(wolf);
        Assertions.assertEquals(1, node.getAllAnimals().size());

        wolf.eat();
        Assertions.assertEquals(0, node.getAllAnimals().size());
    }


    @Test
    void wolfFindSomeThingToEatTest() {
        var node = new IslandNode();
        var wolf = new Wolf() {
            @Override
            protected int getChanceToEat() {
                return 100;
            }
        };
        var horse = new Horse();
        node.addAnimal(wolf);
        node.addAnimal(horse);

        Assertions.assertEquals(2, node.getAllAnimals().size());

        wolf.eat();
        var animals = node.getAllAnimals();
        Assertions.assertEquals(1, animals.size());
        Assertions.assertEquals(AnimalType.WOLF, animals.get(0).getType());
    }

    @Test
    void boarEatTest() {
        var node = new IslandNode();
        var boar = new Boar() {
            @Override
            protected int getChanceToEat() {
                return 100;
            }

            @Override
            protected boolean getChanceToEatPlant() {
                return false;
            }
        };

        node.addAnimal(boar);
        for (int i=0;i<110;i++) {
            node.addAnimal(new Caterpillar());
        }
        var plant = new Plant();
        for (int i=0;i<49;i++) {
            node.addPlant(plant);
        }

        Assertions.assertEquals(111, node.getAllAnimals().size());
        Assertions.assertEquals(49, node.getAllPlants().size());

        boar.eat();

        var animals = node.getAllAnimals();
        Assertions.assertEquals(1, animals.size());
        Assertions.assertEquals(AnimalType.BOAR, animals.get(0).getType());
        Assertions.assertEquals(0, node.getAllPlants().size());

    }
}