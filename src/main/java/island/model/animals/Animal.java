package island.model.animals;

import island.behavior.IAnimal;

public abstract class Animal implements IAnimal {

    private final int weight;
    private final int maxMoveSpeed;

    protected Animal(int weight, int maxMoveSpeed) {
        this.weight = weight;
        this.maxMoveSpeed = maxMoveSpeed;
    }

    abstract public AnimalType getType();

}
