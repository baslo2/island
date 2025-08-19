package island.model.animals;

import java.util.Random;

import island.behavior.IAnimal;

public abstract class Animal implements IAnimal {

    private static final Random r = new Random();

    private final int x;
    private final int y;

    private final double weight;
    private final int speed;

    private final double needToEat;

    protected Animal(int x, int y) {
        this.x = x;
        this.y = y;
        speed = getType().getSpeed();
        weight = getType().getWeight();
        needToEat = getType().getNeedToEat();
    }

    abstract public AnimalType getType();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int[] move() {
        int[] moveTo = { 0, 0 };
        int willMove = r.nextInt(0, speed + 1);
        for (int i = 0; i < willMove; i++) {
            moveTo[r.nextInt(0, 2)]++;
        }

        for (int i = 0; i < 2; i++) {
            if (0 == r.nextInt(0, 2)) {
                moveTo[i] = -moveTo[i];
            }
        }
        return moveTo;
    }

}
