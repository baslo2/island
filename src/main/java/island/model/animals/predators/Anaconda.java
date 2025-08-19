package island.model.animals.predators;

import island.model.animals.AnimalType;

public class Anaconda extends Predator {

    public Anaconda(int x, int y) {
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
        return AnimalType.ANACONDA;
    }

}
