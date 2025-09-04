package island.model.animals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum AnimalType {

    WOLF(30, 50, 3, 8),
    ANACONDA(30, 15, 1, 3),
    BEAR(5, 500, 2, 80),
    EAGLE(20, 6, 3, 1),
    FOX(30, 8, 2, 2),
    BOAR(50, 400, 2, 50),
    BUFFALO(10, 700, 3, 100),
    CATERPILLAR(1000, 0.01, 0, 0),
    DEER(20, 300, 4, 50),
    DUCK(200, 1, 4, 0.15),
    GOAT(140, 60, 3, 10),
    HORSE(20, 400, 4, 60),
    MOUSE(500, 0.05, 1, 0.01),
    RABBIT(150, 2, 2, 0.45),
    SHEEP(140, 70, 3, 15);

    private final int maxCount;
    private final double weight;
    private final int speed;
    private final double needToEat;

    private final Map<AnimalType, Integer> eatingProbabilities = new HashMap<>();

    private AnimalType(int maxCount, double weight, int speed, double needToEat) {
        this.maxCount = maxCount;
        this.weight = weight;
        this.speed = speed;
        this.needToEat = needToEat;
    }

    static {
        initEatingProbabilities();
    }

    private static void initEatingProbabilities() {
        WOLF.eatingProbabilities.put(HORSE, 10);
        WOLF.eatingProbabilities.put(DEER, 15);
        WOLF.eatingProbabilities.put(RABBIT, 60);
        WOLF.eatingProbabilities.put(MOUSE, 80);
        WOLF.eatingProbabilities.put(GOAT, 60);
        WOLF.eatingProbabilities.put(SHEEP, 70);
        WOLF.eatingProbabilities.put(BOAR, 15);
        WOLF.eatingProbabilities.put(BUFFALO, 10);
        WOLF.eatingProbabilities.put(DUCK, 40);

        ANACONDA.eatingProbabilities.put(FOX, 15);
        ANACONDA.eatingProbabilities.put(RABBIT, 20);
        ANACONDA.eatingProbabilities.put(MOUSE, 40);
        ANACONDA.eatingProbabilities.put(DUCK, 10);

        FOX.eatingProbabilities.put(RABBIT, 70);
        FOX.eatingProbabilities.put(MOUSE, 90);
        FOX.eatingProbabilities.put(DUCK, 60);
        FOX.eatingProbabilities.put(CATERPILLAR, 40);

        BEAR.eatingProbabilities.put(ANACONDA, 80);
        BEAR.eatingProbabilities.put(HORSE, 40);
        BEAR.eatingProbabilities.put(DEER, 80);
        BEAR.eatingProbabilities.put(RABBIT, 80);
        BEAR.eatingProbabilities.put(GOAT, 70);
        BEAR.eatingProbabilities.put(SHEEP, 70);
        BEAR.eatingProbabilities.put(BOAR, 50);
        BEAR.eatingProbabilities.put(BUFFALO, 20);
        BEAR.eatingProbabilities.put(DUCK, 10);

        EAGLE.eatingProbabilities.put(FOX, 10);
        EAGLE.eatingProbabilities.put(RABBIT, 90);
        EAGLE.eatingProbabilities.put(MOUSE, 90);
        EAGLE.eatingProbabilities.put(DUCK, 80);

        BOAR.eatingProbabilities.put(MOUSE, 50);
        BOAR.eatingProbabilities.put(CATERPILLAR, 90);

        DUCK.eatingProbabilities.put(CATERPILLAR, 90);

        checkAllTypesInitEatingProbabilities();
    }

    private static void checkAllTypesInitEatingProbabilities() {
        List<AnimalType> validTypes = Arrays.asList(WOLF, ANACONDA, BEAR, BOAR, BUFFALO, CATERPILLAR, DEER, DUCK, EAGLE,
                FOX, GOAT, HORSE, MOUSE, RABBIT, SHEEP);
        for (var e : AnimalType.values()) {
            if (!validTypes.contains(e)) {
                throw new IllegalArgumentException(
                        "Added new AnimalType, and didn't init eatingProbabilities or didn't add new type to validTypes. new type is:"
                                + e);
            }
        }

    }

    public Map<AnimalType, Integer> getEatingProbabilities() {
        return Collections.unmodifiableMap(eatingProbabilities);
    }

    public int getMaxCount() {
        return maxCount;
    }

    public double getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }

    public double getNeedToEat() {
        return needToEat;
    }

}
