package island.model.animals.herbivores;

import java.util.List;

import island.model.animals.Animal;
import island.model.animals.AnimalType;
import island.model.animals.Plant;

public abstract class Herbivore extends Animal {
    @Override
    protected void eat(int index, List<AnimalType> canEat) {
        if (canEat.isEmpty()) {
            location.removePlant(new Plant());
            needToEat -= Plant.WEIGHT;
            return;
        }

        if (r.nextBoolean()) {
            location.removePlant(new Plant());
            needToEat -= Plant.WEIGHT;
            return;
        }

        super.eat(index, canEat);
    }
}
