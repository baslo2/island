package island;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

import island.model.animals.Animal;
import island.model.animals.AnimalFactory;
import island.model.animals.AnimalType;
import island.model.animals.Plant;
import island.utils.FixedSizeList;

public class IslandNode {

    private static final Random R = new Random();

    private final Map<AnimalType, FixedSizeList<Animal>> animals = new EnumMap<>(AnimalType.class);
    private final FixedSizeList<Plant> plants = new FixedSizeList<>(200);
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

    public boolean addPlant(Plant plant) {
        return plants.add(plant);
    }

    public Plant removePlant() {
        return plants.remove(0);
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

    public void reproduceAnimals(boolean needRandom) {
        for (List<Animal> animalsByTypes : animals.values()) {
            reproduceAnimals(animalsByTypes, needRandom);
        }
    }

    public List<Plant> getAllPlants() {
        return Collections.unmodifiableList(plants);
    }

    public void reproduceAnimals() {
        for (List<Animal> animalsByTypes : animals.values()) {
            reproduceAnimals(animalsByTypes, true);
        }
    }

    private void reproduceAnimals(List<Animal> animalsByTypes, boolean needRandom) {
        int size = animalsByTypes.size();
        Animal firstAnimal;
        Animal secondAnimal;
        int indexForSecondAnimal;
        AnimalType type = null;
        for (int i = 0; i<size; i++) {
            firstAnimal = animalsByTypes.get(i);
            if (null == type) {
                type = firstAnimal.getType();
            }
            if (animals.get(type).isFull()) {
                return;
            }
            indexForSecondAnimal = needRandom ? R.nextInt(0, size+1) : i + 1;
            if (indexForSecondAnimal >= size) {
                continue;
            }
            secondAnimal = animalsByTypes.get(indexForSecondAnimal);
            if (firstAnimal.isReproduced() || secondAnimal.isReproduced()) {
                continue;
            }
            firstAnimal.setReproduced(true);
            secondAnimal.setReproduced(true);
            var newAnimal = AnimalFactory.getNewAnimal(type);
            newAnimal.setReproduced(true);
            addAnimal(newAnimal);
        }
    }

    public void reproducePlants() {
        if (plants.isFull()) {
            return;
        }
        int startSize = plants.size();
        for (int i=0; i<startSize;i++) {
           if(!plants.add(new Plant())) {
               return;
           }
        }
    }

    public Animal getPreyByType(AnimalType type) {
        List<Animal> preys = animals.get(type);
        if(preys.isEmpty()) {
            return null;
        }
        return preys.get(R.nextInt(0, preys.size()));
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
