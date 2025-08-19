package island.model.animals.herbivores;

import island.model.animals.AnimalType;

public class Duck extends Herbivore {

    public Duck(int x, int y) {
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
        return AnimalType.DUCK;
    }

}
