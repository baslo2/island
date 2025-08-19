package island;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import island.model.animals.Animal;
import island.model.animals.AnimalType;
import island.model.animals.Plant;
import island.utils.FixedSizeList;

public class IslandNode {

    private final Map<AnimalType, List<Animal>> animals = new EnumMap<>(AnimalType.class);
    private final List<Plant> plants = new FixedSizeList<>(200);
    private final int x;
    private final int y;

    public IslandNode(int x, int y) {
        this.x = x;
        this.y = y;
        for (var type : AnimalType.values()) {
            animals.put(type, new FixedSizeList<>(type.getMaxCount()));
        }
    }

    public IslandNode() {
        this(0, 0);
    }

    public boolean addAnimal(Animal animal) {

        return animals.get(animal.getType()).add(animal);
    }

    public boolean removeAnimal(Animal animal) {
        animal.setStartLocation(x, y);
        return animals.get(animal.getType()).remove(animal);
    }

    public List<Animal> getAnimalsByAnimal(Animal animal) {
        return getAnimalsByType(animal.getType());
    }

    public List<Animal> getAnimalsByType(AnimalType type) {
        return Collections.unmodifiableList(animals.get(type));
    }
}
