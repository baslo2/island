package island.model.animals.herbivores;

import island.model.animals.AnimalType;

public class Mouse extends Herbivore {

    public Mouse(int x, int y) {
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
        return AnimalType.MOUSE;
    }

}
