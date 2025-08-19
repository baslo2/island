package island;

public class Island {

    private final IslandNode[][] map = new IslandNode[5][5];

    public void init() {
        int x = map.length;
        int y = map[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; i++) {
                map[i][j] = new IslandNode(i, j);
            }
        }
    }
}