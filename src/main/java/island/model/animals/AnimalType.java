package island.model.animals;

public enum AnimalType {

    WOLF(30),
    ANACONDA(30),
    BEAR(30),
    EAGLE(20),
    FOX(30),
    BOAR(50),
    BUFFALO(10),
    CATERPILLAR(1000),
    DEER(20),
    DUCK(200),
    GOAT(140),
    HORSE(20),
    MOUSE(500),
    RABBIT(150),
    SHEEP(140);

    private final int maxCount;

    private AnimalType(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getMaxCount() {
        return maxCount;
    }

}
