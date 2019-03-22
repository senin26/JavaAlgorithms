import java.util.LinkedList;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DepthFirstPaths(Graph g, int source) {
        if (source < 0) {
            throw new IllegalArgumentException();
        }
        if (source >= g.vertexCount()) {
            throw new IndexOutOfBoundsException();
        }
        this.source = source;
        edgeTo = new int[g.vertexCount()];
        marked = new boolean[g.vertexCount()];
        dfs(g, source);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w:
             g.adjList(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    public boolean hasPathTo(int dest) {
        if (dest < 0) {
            throw new IllegalArgumentException();
        }
        if (dest >= marked.length) {
            throw new IndexOutOfBoundsException();
        }
        return marked[dest];
    }

    public LinkedList pathTo(int dest) {
        if (!hasPathTo(dest)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();

        int vertex = dest;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
