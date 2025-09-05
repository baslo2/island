package island;

import java.util.concurrent.Executors;

import island.task.AnimalLiveCycle;
import island.task.PlantLiveCycle;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException {

        System.err.println("start");
        var island = new Island();
        island.init();
        island.initAnimals();

        var sheldue = Executors.newScheduledThreadPool(2);

        var plant = new PlantLiveCycle(island);
        var animal = new AnimalLiveCycle(island);
        sheldue.execute(plant);
        sheldue.execute(animal);
        sheldue.shutdown();
        System.err.println("finish");
    }
}