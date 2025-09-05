package island;

import java.util.concurrent.Executors;

import island.task.AnimalLiveCycle;
import island.task.PlantLiveCycle;

public class Main {

    private static final int DAYS = 2;

    public static void main(String[] args) throws NoSuchMethodException {

        var island = new Island();
        island.init();
        island.initAnimals();

        var sheldue = Executors.newScheduledThreadPool(2);
        var plant = new PlantLiveCycle(island);
        var animal = new AnimalLiveCycle(island);
        for (int i = 0; i < DAYS; i++) {

            sheldue.execute(plant);
            sheldue.execute(animal);

            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sheldue.shutdown();
    }
}