package island.model.animals.herbivores;

import island.model.animals.AnimalType;

public class Sheep extends Herbivore {

    public Sheep(int weight, int maxMoveSpeed) {
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
        return AnimalType.SHEEP;
    }

}
