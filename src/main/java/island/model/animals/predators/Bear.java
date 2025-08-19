package island.model.animals.predators;

import island.model.animals.AnimalType;

public class Bear extends Predator {

    public Bear(int x, int y) {
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
        return AnimalType.BEAR;
    }

}
