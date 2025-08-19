package island.model.animals;

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

    private AnimalType(int maxCount, double weight, int speed, double needToEat) {
        this.maxCount = maxCount;
        this.weight = weight;
        this.speed = speed;
        this.needToEat = needToEat;
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
