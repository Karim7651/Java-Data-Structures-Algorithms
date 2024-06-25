import java.util.ArrayList;

public class GraphNodeAdjacencyList {
    String name;
    int index;
    boolean isVisited = false;
    //parent is for single shortest path algorithm
    GraphNodeAdjacencyList parent;
    ArrayList<GraphNodeAdjacencyList> neighbors = new ArrayList<>();
    public GraphNodeAdjacencyList(String name,int index){
        this.name = name;
        this.index = index ;
    }
}
