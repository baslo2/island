package island;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import island.task.AnimalLiveCycle;
import island.task.PlantLiveCycle;

public class Main {

    private static final int DAYS = 2;

    public static void main(String[] args) throws NoSuchMethodException {

        var island = new Island();
        island.init();
        island.initAnimals();

        var sheduler = Executors.newScheduledThreadPool(2);
        var plant = new PlantLiveCycle(island);
        var animal = new AnimalLiveCycle(island);
        for (int i = 0; i < DAYS; i++) {

            sheduler.submit(plant);
            sheduler.submit(animal);

            while (!plant.isFinish() || !animal.isFinish()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        sheduler.shutdown();
    }
}