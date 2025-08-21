package island.model.animals;

import java.util.Random;

import island.IslandNode;
import island.behavior.IAnimal;

public abstract class Animal implements IAnimal {

    private static final Random r = new Random();

    private final double weight;
    private final int speed;

    private IslandNode location;

    private final double needToEat;

    protected Animal() {
        speed = getType().getSpeed();
        weight = getType().getWeight();
        needToEat = getType().getNeedToEat();
    }

    public abstract AnimalType getType();

    public IslandNode getLocation() {
        return  location;
    }

    public void setLocation(IslandNode location) {
        this.location = location;
    }

    @Override
    public void move() {
        int[] loc = { location.getX(), location.getY() };
        int willMove = r.nextInt(0, speed + 1);
        for (int i = 0; i < willMove; i++) {
            move(loc);
        }
        var island = location.getIsland();
        var tempLoc = island.getIslandNode(loc[0], loc[1]);
        tempLoc.addAnimal(this);
    }

    private void move(int[] loc) {
        if (0 == getSide()) {
            moveX(loc);
        } else {
            moverY(loc);
        }
    }

    private void moverY(int[] loc) {
        if (0 == getSide()) {
            if (0 == loc[1]) {
                return;
            }
            loc[1]--;
        } else {
            if (location.getIsland().getYLength() == loc[1]) {
                return;
            }
            loc[1]++;
        }
    }

    private void moveX(int[] loc) {
        if (0 == getSide()) {
            if (0 == loc[0]) {
                return;
            }
            loc[0]--;
        } else {
            if (location.getIsland().getXLength() == loc[0]) {
                return;
            }
            loc[0]++;
        }
    }

    private int getSide() {
        return r.nextInt(0, 2);
    }
}
