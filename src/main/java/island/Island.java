package island;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import island.model.animals.Animal;
import island.model.animals.AnimalFactory;
import island.model.animals.AnimalType;

public class Island {

    public Island() {
        this(100, 20);
    }

    public Island(int x, int y) {
        map = new IslandNode[x][y];
    }

    private static final Random r = new Random();

    private final IslandNode[][] map;

    public void init() {
        int x = map.length;
        int y = map[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                map[i][j] = new IslandNode(i, j, this);
            }
        }
    }

    public IslandNode getIslandNode(int x, int y) {
        return map[x][y];
    }

    public int getXLength() {
        return map.length - 1;
    }

    public int getYLength() {
        return map[0].length - 1;
    }

    public void initAnimals(int animalsValue) {
        LinkedList<Animal> animals = new LinkedList<>();
        for (AnimalType type : AnimalType.values()) {
            animals.addAll(AnimalFactory.getNewAnimals(type, animalsValue));
        }

        while (!animals.isEmpty()) {
            var animal = animals.pop();
            // TODO refactor me
            while (!addAnimalInRandomNode(animal)) {
            }
        }
    }

    private boolean addAnimalInRandomNode(Animal animal) {
        return getIslandNode(getRandomXLocation(), getRandomYLocation()).addAnimal(animal);
    }

    private int getRandomXLocation() {
        return r.nextInt(0, map.length);
    }

    private int getRandomYLocation() {
        return r.nextInt(0, map[0].length);
    }

    public List<Animal> getAllAnimals() {
        List<Animal> animals = new ArrayList<>();
        int x = map.length;
        int y = map[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                animals.addAll(map[i][j].getAllAnimals());
            }
        }
        return animals;
    }
}