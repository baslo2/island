package island;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import island.model.animals.Animal;
import island.model.animals.AnimalType;
import island.model.animals.Plant;
import island.utils.FixedSizeList;

public class IslandNode {

    private final Map<AnimalType, List<Animal>> animals = new EnumMap<>(AnimalType.class);
    private final List<Plant> plants = new FixedSizeList<>(200);
    private final int x;
    private final int y;
    private final Island island;

    public IslandNode(int x, int y, Island island) {
        this.x = x;
        this.y = y;
        this.island = island;
        for (var type : AnimalType.values()) {
            animals.put(type, new FixedSizeList<>(type.getMaxCount()));
        }
    }

    public IslandNode() {
        this(0, 0, null);
    }

    public boolean addAnimal(Animal animal) {
        if (!animals.get(animal.getType()).add(animal)) {
            return false;
        }
        if (animal.getLocation() != null) {
            animal.getLocation().removeAnimal(animal);
        }
        animal.setLocation(this);
        return true;
    }

    public boolean removeAnimal(Animal animal) {
        return animals.get(animal.getType()).remove(animal);
    }

    public Island getIsland() {
        return island;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Animal> getAllAnimals() {
        return animals.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<Animal> getAnimalsByType(AnimalType type) {
        return Collections.unmodifiableList(animals.get(type));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IslandNode that = (IslandNode) o;
        return getX() == that.getX() && getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
