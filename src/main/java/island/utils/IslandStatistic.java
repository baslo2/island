package island.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import island.Island;
import island.model.animals.Animal;
import island.model.animals.AnimalType;

public class IslandStatistic {

    private static final Map<AnimalType, Pair<Integer>> animalsStat = new HashMap<>();
    private static final Pair<Integer> plantsStat = new Pair<>();
    private static final String DELIMITR = "|________________";

    public static void cashStartDayStat(Island island) {
       plantsStat.setFirst(island.getAllPlants().size());
       Map<AnimalType, List<Animal>> allAnimals = island.getAllAnimalsInMap();
       for (var e : allAnimals.entrySet()) {
           var pair = new Pair<Integer>();
           pair.setFirst(e.getValue().size());
           animalsStat.put(e.getKey(), pair);
       }
    }

    public static void cashEndDayStat(Island island) {
        plantsStat.setSecond(island.getAllPlants().size());
        Map<AnimalType, List<Animal>> allAnimals = island.getAllAnimalsInMap();
        for (var e : allAnimals.entrySet()) {
            animalsStat.get(e.getKey()).setSecond(e.getValue().size());
        }
    }

    public static void printDayStat() {
        System.err.println(getDayStat());
    }

    public static String getDayStat() {
        StringBuilder sb = new StringBuilder("Object Type").append(DELIMITR).append("startDay/EndDay\n");
        for (var e : AnimalType.values()) {
            var value = animalsStat.get(e);
            sb.append(e).append(DELIMITR).append(value.getFirst()).append('/').append(value.getSecond()).append("\n");
        }
        sb.append("Plants").append(DELIMITR).append(plantsStat.getFirst()).append('/').append(plantsStat.getSecond());
        return sb.toString();
    }

}
