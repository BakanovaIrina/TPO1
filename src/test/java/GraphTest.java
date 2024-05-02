import org.junit.jupiter.api.Test;
import task2.Graph;
import task2.Result;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    @Test
    void addEdgeTest(){
        Graph graph = new Graph(2);
        graph.addEdge(0, 1);

        LinkedList<Integer> adj[] = graph.getAdj();
        assertEquals(adj[0].get(0), 1);
        assertEquals(adj[1].get(0), 0);
    }

    @Test
    void checkRoundGraph(){
        Graph graph = new Graph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        Result result = graph.BFS(0);

        boolean[] visited = {true, true, true};
        int[] parent = {-1, 0, 0};
        ArrayList<Integer> bfs = new ArrayList<>();
        bfs.add(0);
        bfs.add(1);
        bfs.add(2);

        assertEquals(result.getBfs(), bfs);
        assertArrayEquals(result.getVisited(), visited);
        assertArrayEquals(result.getParent(), parent);
    }

    @Test
    void checkNoEdge(){
        Graph graph = new Graph(2);
        Result result = graph.BFS(0);

        boolean[] visited = {true, false};
        int[] parent = {-1, -1};
        ArrayList<Integer> bfs = new ArrayList<>();
        bfs.add(0);

        assertEquals(result.getBfs(), bfs);
        assertArrayEquals(result.getVisited(), visited);
        assertArrayEquals(result.getParent(), parent);
    }

    @Test
    void checkZeroV(){
        assertThrows(NullPointerException.class, () -> new Graph(0));
    }

    @Test
    void checkNegativeV(){
        assertThrows(NullPointerException.class, () -> new Graph(-1));
    }

    @Test
    void checkNegativeS(){
        Graph graph = new Graph(2);
        assertThrows(IllegalArgumentException.class, () -> graph.BFS(-5));
    }

    @Test
    void checkBigS(){
        Graph graph = new Graph(2);
        assertThrows(IllegalArgumentException.class, () -> graph.BFS(5));
    }

    @Test
    void checkSEqualV(){
        Graph graph = new Graph(2);
        assertThrows(IllegalArgumentException.class, () -> graph.BFS(2));
    }
}
