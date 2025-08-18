package island.model.animals.herbivores;

import island.model.animals.AnimalType;

public class Caterpillar extends Herbivore {

    public Caterpillar(int weight, int maxMoveSpeed) {
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
        return AnimalType.CATERPILLAR;
    }

}
