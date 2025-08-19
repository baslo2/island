package island.model.animals.predators;

import island.model.animals.AnimalType;

public class Eagle extends Predator {

    public Eagle(int x, int y) {
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
        return AnimalType.EAGLE;
    }

}
