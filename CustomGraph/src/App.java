import java.util.LinkedList;

public class App {
    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge(0, 2);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(5, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 2);
        g.addEdge(4, 2);
        g.addEdge(5, 0);
        g.addEdge(4,6);
        g.addEdge(6,7);
        g.addEdge(7,8);
        g.addEdge(8,9);
        g.addEdge(9,6);

        BreadthFirstPaths bfp = new BreadthFirstPaths(g, 0);
        System.out.println("bfp.hasPathTo(5) " + bfp.hasPathTo(5));
        System.out.println("bfp.pathTo(3)= " + bfp.pathTo(3));
        System.out.println("bfp.pathTo(5)= " + bfp.pathTo(5));
        System.out.println("bfp.distTo(1)= " + bfp.distTo(1));
        System.out.println("bfp.distTo(2)= " + bfp.distTo(2));
        System.out.println("bfp.distTo(3)= " + bfp.distTo(3));
        System.out.println("bfp.distTo(4)= " + bfp.distTo(4));
        System.out.println("bfp.distTo(6)= " + bfp.distTo(6));
        System.out.println("bfp.distTo(5)= " + bfp.distTo(5));
        System.out.println("bfp.distTo(8)= " + bfp.distTo(8));
        System.out.println("bfp.distTo(9)= " + bfp.distTo(9));

        System.out.println("\nDepth search\n");
        DepthFirstPathsStack dfp = new DepthFirstPathsStack(g, 0);
        System.out.println("dfp.hasPathTo(5)= " + dfp.hasPathTo(5));
        System.out.println("dfp.hasPathTo(4)= " + dfp.hasPathTo(4));
        System.out.println("dfp.pathTo(3)= " + dfp.pathTo(3));
        System.out.println("dfp.pathTo(5)= " + dfp.pathTo(5));
        System.out.println("dfp.pathTo(4)= " + dfp.pathTo(4));
        System.out.println("dfp.hasPathTo(8)= " + dfp.hasPathTo(8));
        System.out.println("dfp.pathTo(8)= " + dfp.pathTo(8));
    }
}
