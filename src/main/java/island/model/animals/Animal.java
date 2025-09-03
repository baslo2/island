package island.model.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import island.IslandNode;
import island.behavior.IAnimal;

public abstract class Animal implements IAnimal {

    protected static final Random r = new Random();

    private final int sequence;
    private final double weight;
    private final int speed;
    protected double needToEat;

    private static int globalCount = 0;

    private boolean isReproduced;

    protected IslandNode location;

    protected Animal() {
        speed = getType().getSpeed();
        weight = getType().getWeight();
        needToEat = getType().getNeedToEat();
        sequence = globalCount;
        globalCount++;
    }

    public abstract AnimalType getType();

    public IslandNode getLocation() {
        return  location;
    }

    public void setLocation(IslandNode location) {
        this.location = location;
    }

    public void setReproduced(boolean isReproduced) {
        this.isReproduced = isReproduced;
    }

    public boolean isReproduced() {
        return isReproduced;
    }

    @Override
    public void move() {
        int[] loc = getNewLocation();
        var island = location.getIsland();
        var tempLoc = island.getIslandNode(loc[0], loc[1]);
        tempLoc.addAnimal(this);
    }

    protected int[] getNewLocation() {
        int willMove = r.nextInt(0, speed + 1);
        int[] loc = { location.getX(), location.getY() };
        for (int i = 0; i < willMove; i++) {
            move(loc);
        }
        return loc;
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

    @Override
    public void eat() {
        int random = ThreadLocalRandom.current().nextInt(0, 101);
        List<AnimalType> canEat = new ArrayList<>();
        getType().getEatingProbabilities().entrySet().stream()
                .filter(e -> (random - e.getValue()) <= 0)
                .forEach(e -> canEat.add(e.getKey()));
        int index = 0;
        while (needToEat > 0) {
            eat(index, canEat);
        }
    }

    protected void eat(int index, List<AnimalType> canEat) {
        index = r.nextInt(0, canEat.size() + 1);
        AnimalType preyType = canEat.get(index);
        Animal prey = location.getPreyByType(preyType);
        if (null == prey) {
            canEat.remove(preyType);
            return;
        }
        needToEat -= preyType.getWeight();
        location.removeAnimal(prey);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return sequence == animal.sequence && Objects.equals(getLocation(), animal.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(sequence, location);
    }
}
