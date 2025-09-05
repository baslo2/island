package island.task;

import java.util.List;

import island.Island;
import island.IslandNode;
import island.utils.IslandStatistic;

public class PlantLiveCycle implements Runnable {

    private final Island island;
    private final List<IslandNode> nodes;

    public PlantLiveCycle(Island island) {
        this.island = island;
        this.nodes = island.getAllNodes();
    }

    @Override
    public void run() {
        IslandStatistic.cashStartDayStat(island);
        nodes.forEach(IslandNode::reproducePlants);
    }

}
