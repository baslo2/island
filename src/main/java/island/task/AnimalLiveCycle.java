package island.task;

import java.util.List;

import island.Island;
import island.IslandNode;
import island.model.animals.Animal;
import island.utils.IslandStatistic;

public class AnimalLiveCycle implements Runnable {

    private final Island island;
    private final List<IslandNode> nodes;
    private boolean isFinish;

    public AnimalLiveCycle(Island island) {
        this.island = island;
        this.nodes = island.getAllNodes();

    }

    @Override
    public void run() {
        isFinish = false;
        var animals = island.getAllAnimals();
        animals.stream().forEach(Animal::eat);
        animals = island.getAllAnimals();
        animals.stream().forEach(Animal::move);
        nodes.parallelStream().forEach(IslandNode::reproduceAnimals);
        island.newTack();
        IslandStatistic.cashEndDayStat(island);
        IslandStatistic.printDayStat();
        isFinish = true;
    }

    public boolean isFinish() {
        return isFinish;
    }

}
