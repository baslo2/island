package island.task;

import java.util.List;

import island.Island;
import island.IslandNode;
import island.utils.IslandStatistic;

public class PlantLiveCycle implements Runnable {

    private final Island island;
    private final List<IslandNode> nodes;
    private boolean isFinish;

    public PlantLiveCycle(Island island) {
        this.island = island;
        this.nodes = island.getAllNodes();
    }

    @Override
    public void run() {
        isFinish = false;
        IslandStatistic.cashStartDayStat(island);
        nodes.forEach(IslandNode::reproducePlants);
        isFinish = true;
    }

    public boolean isFinish() {
        return isFinish;
    }

}
