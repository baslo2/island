package island.model.animals.herbivores;

import java.util.List;

import island.model.animals.Animal;
import island.model.animals.AnimalType;
import island.model.animals.Plant;

public abstract class Herbivore extends Animal {
    @Override
    protected void eat(int index, List<AnimalType> canEat) {
        var hasPlants = 0 != location.getAllPlants().size();
        if (hasPlants && canEat.isEmpty()) {
            location.removePlant();
            needToEat -= Plant.WEIGHT;
            return;
        }

        if (hasPlants && getChanceToEatPlant()) {
            location.removePlant();
            needToEat -= Plant.WEIGHT;
            return;
        }

        super.eat(index, canEat);
    }

    protected boolean getChanceToEatPlant() {
        return r.nextBoolean();
    }
}
