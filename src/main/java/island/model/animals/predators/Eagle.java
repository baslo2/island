package island.model.animals.predators;

import island.model.animals.AnimalType;

public class Eagle extends Predator {

    public Eagle(int weight, int maxMoveSpeed) {
        super(weight, maxMoveSpeed);
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
    public void move() {
        // TODO Auto-generated method stub

    }

    @Override
    public AnimalType getType() {
        return AnimalType.EAGLE;
    }

}
