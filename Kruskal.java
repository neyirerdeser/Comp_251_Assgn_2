import java.util.*;

public class Kruskal{

    public static WGraph kruskal(WGraph g){
        int nodes = g.getNbNodes();
        WGraph MST = new WGraph();
        ArrayList<Edge> sorted = g.listOfEdgesSorted();

        DisjointSets subset = new DisjointSets(nodes);

        int i = 0; // counter for sorted
        int e = 0; // counter for MST
        while(e < nodes - 1) {
            Edge next_edge = sorted.get(i++);

            if (IsSafe(subset, next_edge)) {
                MST.addEdge(next_edge);
                e++;
                subset.union(subset.find(next_edge.nodes[0]), subset.find(next_edge.nodes[1]));
            }
        }
        return MST;
    }

    public static Boolean IsSafe(DisjointSets p, Edge e){
        int node1 = e.nodes[0];
        int node2 = e.nodes[1];
        int rep1 = p.find(node1);
        int rep2 = p.find(node2);

        return rep1 != rep2;
    
    }

    public static void main(String[] args){

        String file = args[0];
        WGraph g = new WGraph(file);
        WGraph t = kruskal(g);
        System.out.println(t);

   } 
}
