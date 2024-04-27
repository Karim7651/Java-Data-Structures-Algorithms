import java.util.ArrayList;

public class GraphNodeAdjacencyList {
    String name;
    int index;
    ArrayList<GraphNodeAdjacencyList> neighbors = new ArrayList<>();
    public GraphNodeAdjacencyList(String name,int index){
        this.name = name;
        this.index = index;
    }
}
