package island;

public class Island {

    private final IslandNode[][] map = new IslandNode[5][5];

    public void init() {
        for (IslandNode[] node1 : map) {
            for (var node2 : node1) {
                node2 = new IslandNode();
            }
        }
    }
}