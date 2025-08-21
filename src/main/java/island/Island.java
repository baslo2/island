package island;

import java.util.ArrayList;
import java.util.List;

import island.model.animals.Animal;

public class Island {

    private final IslandNode[][] map = new IslandNode[100][20];

    public void init() {
        int x = map.length;
        int y = map[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                map[i][j] = new IslandNode(i, j, this);
            }
        }
    }

    public IslandNode getIslandNode(int x, int y) {
        return map[x][y];
    }

    public int getXLength() {
        return map.length - 1;
    }

    public int getYLength() {
        return map[0].length - 1;
    }

    public List<Animal> getAllAnimals() {
        List<Animal> animals = new ArrayList<>();
        int x = map.length;
        int y = map[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                animals.addAll(map[i][j].getAllAnimals());
            }
        }
        return animals;
    }
}