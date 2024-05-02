package task2;

import lombok.Getter;

import java.util.List;

public class Result {
    @Getter
    private boolean visited[];
    @Getter
    private int parent[];
    @Getter
    private List<Integer> bfs;

    public Result(boolean[] visited, int[] parent, List<Integer> bfs) {
        this.visited = visited;
        this.parent = parent;
        this.bfs = bfs;
    }
}
