package task2;

import lombok.Getter;

import java.util.*;

public class Graph {
    private int v;
    @Getter
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        if(v <= 0){
            throw new NullPointerException();
        }
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }


    public Result BFS(int s) {
        if(s >= v || s < 0){
            throw new IllegalArgumentException();
        }
        boolean visited[] = new boolean[v];
        int parent[] = new int[v];
        List<Integer> bfs = new ArrayList<>();

        for(int i = 0; i < v; i++){
            parent[i] = -1;
        }

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            int currentVertex = queue.poll();
            bfs.add(currentVertex);

            Iterator<Integer> i = adj[currentVertex].listIterator();
            while (i.hasNext()) {
                int adjacentVertex = i.next();

                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    queue.add(adjacentVertex);
                    parent[adjacentVertex] = currentVertex;
                }
            }
        }

        return new Result(visited, parent, bfs);
    }
}

