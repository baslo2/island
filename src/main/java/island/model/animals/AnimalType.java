package island.model.animals;

import java.util.Collections;
import java.util.HashMap;
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
        initEatingProbabilities();
    }

    void initEatingProbabilities() {
        switch (this) {
            case WOLF:
                eatingProbabilities.put(HORSE, 10);
                eatingProbabilities.put(DEER, 15);
                eatingProbabilities.put(RABBIT, 60);
                eatingProbabilities.put(MOUSE, 80);
                eatingProbabilities.put(GOAT, 60);
                eatingProbabilities.put(SHEEP, 70);
                eatingProbabilities.put(BOAR, 15);
                eatingProbabilities.put(BUFFALO, 10);
                eatingProbabilities.put(DUCK, 40);
                break;
            case ANACONDA:
                eatingProbabilities.put(FOX, 15);
                eatingProbabilities.put(RABBIT, 20);
                eatingProbabilities.put(MOUSE, 40);
                eatingProbabilities.put(DUCK, 10);
                break;
            case FOX:
                eatingProbabilities.put(RABBIT, 70);
                eatingProbabilities.put(MOUSE, 90);
                eatingProbabilities.put(DUCK, 60);
                eatingProbabilities.put(CATERPILLAR, 40);
                break;
            case BEAR:
                eatingProbabilities.put(ANACONDA, 80);
                eatingProbabilities.put(HORSE, 40);
                eatingProbabilities.put(DEER, 80);
                eatingProbabilities.put(RABBIT, 80);
                eatingProbabilities.put(GOAT, 70);
                eatingProbabilities.put(SHEEP, 70);
                eatingProbabilities.put(BOAR, 50);
                eatingProbabilities.put(BUFFALO, 20);
                eatingProbabilities.put(DUCK, 10);
                break;
            case EAGLE:
                eatingProbabilities.put(FOX, 10);
                eatingProbabilities.put(RABBIT, 90);
                eatingProbabilities.put(MOUSE, 90);
                eatingProbabilities.put(DUCK, 80);
                break;
            case BOAR:
                eatingProbabilities.put(MOUSE, 50);
            case DUCK:
                eatingProbabilities.put(CATERPILLAR, 90);
                break;
            case HORSE:
            case DEER:
            case RABBIT:
            case MOUSE:
            case GOAT:
            case SHEEP:
            case BUFFALO:
            case CATERPILLAR:
                break;
            default:
                throw new IllegalArgumentException("Unexpected AnimalType: " + this);
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
