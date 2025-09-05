package island.model.animals;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import island.model.animals.herbivores.Boar;
import island.model.animals.herbivores.Buffalo;
import island.model.animals.herbivores.Caterpillar;
import island.model.animals.herbivores.Deer;
import island.model.animals.herbivores.Duck;
import island.model.animals.herbivores.Goat;
import island.model.animals.herbivores.Horse;
import island.model.animals.herbivores.Mouse;
import island.model.animals.herbivores.Rabbit;
import island.model.animals.herbivores.Sheep;
import island.model.animals.predators.Anaconda;
import island.model.animals.predators.Bear;
import island.model.animals.predators.Eagle;
import island.model.animals.predators.Fox;
import island.model.animals.predators.Wolf;
import island.utils.FixedSizeList;

public class AnimalFactory {

    public static Animal getNewAnimal(AnimalType type) {
        return getNewAnimals(type, 1).get(0);
    }

    public static FixedSizeList<Animal> getNewAnimals(AnimalType type, int animalValue) {
        return switch (type) {
            case WOLF -> getAnimals(Wolf.class, animalValue, type);
            case ANACONDA -> getAnimals(Anaconda.class, animalValue, type);
            case BEAR -> getAnimals(Bear.class, animalValue, type);
            case EAGLE -> getAnimals(Eagle.class, animalValue, type);
            case FOX -> getAnimals(Fox.class, animalValue, type);
            case BOAR -> getAnimals(Boar.class, animalValue, type);
            case BUFFALO -> getAnimals(Buffalo.class, animalValue, type);
            case CATERPILLAR -> getAnimals(Caterpillar.class, animalValue, type);
            case DEER -> getAnimals(Deer.class, animalValue, type);
            case DUCK -> getAnimals(Duck.class, animalValue, type);
            case GOAT -> getAnimals(Goat.class, animalValue, type);
            case HORSE -> getAnimals(Horse.class, animalValue, type);
            case MOUSE -> getAnimals(Mouse.class, animalValue, type);
            case RABBIT -> getAnimals(Rabbit.class, animalValue, type);
            case SHEEP -> getAnimals(Sheep.class, animalValue, type);
            default -> throw new IllegalArgumentException("Unexpected value: " + type);
        };
    }

    // TODO refactor me please
    private static FixedSizeList<Animal> getAnimals(Class<?> clazz, int animalValue, AnimalType type) {
        Constructor<Animal> constructor = null;
        try {
            constructor = (Constructor<Animal>) clazz.getDeclaredConstructor();
        } catch (NoSuchMethodException | SecurityException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        if (null == constructor) {
            return new FixedSizeList<>(0);
        }
        constructor.setAccessible(true);
        FixedSizeList<Animal> l = new FixedSizeList<>(type.getMaxCount());
        for (int j = 0; j < animalValue; j++) {
            try {
                l.add(constructor.newInstance());
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                e.printStackTrace();
                return new FixedSizeList<>(0);
            }
        }
        return l;
    }

    private AnimalFactory() {

    }
}
