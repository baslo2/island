package island.model.animals.predators;

import island.model.animals.AnimalType;

public class Fox extends Predator {

    public Fox(int x, int y) {
        super(x, y);
    }

    @Override
    public void eat() {
        // TODO Auto-generated method stub

    }

    @Override
    public void drink() {
        // TODO Auto-generated method stub

    }

    @Override
    public AnimalType getType() {
        return AnimalType.FOX;
    }

}
