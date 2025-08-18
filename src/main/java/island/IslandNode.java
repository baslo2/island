package island;

import java.util.ArrayList;
import java.util.List;

import island.model.animals.Animal;
import island.model.animals.Plant;
import island.model.animals.predators.Fox;
import island.model.animals.predators.Wolf;

public class IslandNode {

    private int wolvesCounter;
    private int foxesCounter;

    List<Animal> animals = new ArrayList<>();
    List<Plant> plants = new ArrayList<>();

    public boolean addAnimal(Wolf wolf) {
        if (wolvesCounter == 30) {
            return false;
        }
        wolvesCounter++;
        return animals.add(wolf);
    }

    public boolean addAnimal(Fox fox) {
        if (foxesCounter == 30) {
            return false;
        }
        foxesCounter++;
        return animals.add(fox);
    }

    public void removeAnimsl(Wolf wolf) {
        animals.remove(wolf);
        wolvesCounter--;
    }

    public void removeAnimal(Fox fox) {
        animals.remove(fox);
        foxesCounter--;
    }
}
