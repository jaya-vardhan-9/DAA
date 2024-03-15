import java.util.Arrays;
import java.util.Comparator;

class KruskalsAlgorithm {

    class Edge {
        int src, dest, weight;

        Edge() {
            src = dest = weight = 0;
        }
    }

    int V, E; 
    Edge[] edges; 

    KruskalsAlgorithm(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; ++i)
            edges[i] = new Edge();
    }
    int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    void kruskalMST() {
        Edge result[] = new Edge[V]; 
        int e = 0; 

        Arrays.sort(edges, Comparator.comparingInt(o -> o.weight));

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        while (e < V - 1 && e < E) {
            Edge next_edge = edges[e++];

            int x = find(parent, next_edge.src);
            int y = find(parent, next_edge.dest);

            if (x != y) {
                result[e - 1] = next_edge;
                union(parent, x, y);
            }
        }

        System.out.println("Edges in the Minimum Spanning Tree:");
        for (int i = 0; i < e - 1; ++i)
            System.out.println(result[i].src + " - " + result[i].dest + " : " + result[i].weight);
    }

    public static void main(String[] args) {
        int V = 4; 
        int E = 5; 

        KruskalsAlgorithm graph = new KruskalsAlgorithm(V, E);
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 10;
        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 6;
        graph.edges[2].src = 0;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 5;
        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 15;
        graph.edges[4].src = 2;
        graph.edges[4].dest = 3;
        graph.edges[4].weight = 4;
        graph.kruskalMST();
    }
}
