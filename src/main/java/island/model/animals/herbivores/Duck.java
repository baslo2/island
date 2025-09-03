package island.model.animals.herbivores;

import island.model.animals.AnimalType;

public class Duck extends Herbivore {

    public Duck() {
        super();
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
