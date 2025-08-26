package island.model.animals;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

public class AnimalFactory {

    public static Animal getNewAnimal(AnimalType type) {
        return getNewAnimals(type, 1).get(0);
    }

    public static List<Animal> getNewAnimals(AnimalType type, int animalValue) {
        return switch (type) {
            case WOLF -> getAnimals(Wolf.class, animalValue);
            case ANACONDA -> getAnimals(Anaconda.class, animalValue);
            case BEAR -> getAnimals(Bear.class, animalValue);
            case EAGLE -> getAnimals(Eagle.class, animalValue);
            case FOX -> getAnimals(Fox.class, animalValue);
            case BOAR -> getAnimals(Boar.class, animalValue);
            case BUFFALO -> getAnimals(Buffalo.class, animalValue);
            case CATERPILLAR -> getAnimals(Caterpillar.class, animalValue);
            case DEER -> getAnimals(Deer.class, animalValue);
            case DUCK -> getAnimals(Duck.class, animalValue);
            case GOAT -> getAnimals(Goat.class, animalValue);
            case HORSE -> getAnimals(Horse.class, animalValue);
            case MOUSE -> getAnimals(Mouse.class, animalValue);
            case RABBIT -> getAnimals(Rabbit.class, animalValue);
            case SHEEP -> getAnimals(Sheep.class, animalValue);
            default -> throw new IllegalArgumentException("Unexpected value: " + type);
        };
    }

    // TODO refactor me please
    private static List<Animal> getAnimals(Class<?> clazz, int animalValue) {
        Constructor<Animal> constructor = null;
        try {
            constructor = (Constructor<Animal>) clazz.getDeclaredConstructor();
        } catch (NoSuchMethodException | SecurityException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        if (null == constructor) {
            return Collections.EMPTY_LIST;
        }
        constructor.setAccessible(true);
        List<Animal> l = new ArrayList<>();
        for (int j = 0; j < animalValue; j++) {
            try {
                l.add(constructor.newInstance());
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                e.printStackTrace();
                return Collections.EMPTY_LIST;
            }
        }
        return l;
    }

    private AnimalFactory() {

    }
}
