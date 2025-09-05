package island;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import island.model.animals.Animal;
import island.model.animals.AnimalFactory;
import island.model.animals.AnimalType;
import island.model.animals.Plant;

public class Island {

    private static final Random r = new Random();

    private final IslandNode[][] map;

    public Island() {
        this(100, 20);
    }

    public Island(int x, int y) {
        map = new IslandNode[x][y];
    }

    public void init() {
        int x = map.length;
        int y = map[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                var node = new IslandNode(i, j, this);
                var plant = new Plant();
                for (int k = 0; k < 100; k++) {
                    node.addPlant(plant);
                }
                map[i][j] = node;
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
            if (!addAnimalInRandomNode(animal)) {
                break;
            }
        }
    }

    public void initAnimals() {
        var nodes = getAllNodes();
        var animalTypes = Arrays.asList(AnimalType.values());
        for (var node : nodes) {
            animalTypes.forEach(e -> initAnimals(node, e));
        }
    }

    private void initAnimals(IslandNode node, AnimalType type) {
        int count = type.getMaxCount();
        node.addAllAnimals(AnimalFactory.getNewAnimals(type, count), type);
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

    public Map<AnimalType, List<Animal>> getAllAnimalsInMap() {
        Map<AnimalType, List<Animal>> animals = new EnumMap<>(AnimalType.class);
        int x = map.length;
        int y = map[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (var e : AnimalType.values()) {
                    if (null == animals.get(e)) {
                        animals.putIfAbsent(e, new ArrayList<>(map[i][j].getAnimalsByType(e)));
                    } else {
                        animals.get(e).addAll(map[i][j].getAnimalsByType(e));
                    }
                }
            }
        }
        return animals;
    }

    public List<Plant> getAllPlants() {
        List<Plant> plants = new ArrayList<>();
        int x = map.length;
        int y = map[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                plants.addAll(map[i][j].getAllPlants());
            }
        }
        return plants;
    }

    public List<IslandNode> getAllNodes() {
        List<IslandNode> nodes = new ArrayList<>();
        int x = map.length;
        int y = map[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (var e : AnimalType.values()) {
                    nodes.add(map[i][j]);
                }
            }
        }
        return nodes;
    }

    public void newTack() {
        getAllAnimals().stream().forEach(Animal::resetVariable);
    }
}