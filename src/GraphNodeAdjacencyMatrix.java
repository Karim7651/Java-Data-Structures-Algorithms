public class GraphNodeAdjacencyMatrix {
    String name;
    int index;
    boolean isVisited = false;
    GraphNodeAdjacencyMatrix parent;

    public GraphNodeAdjacencyMatrix(String name, int index){
        this.name = name;
        this.index = index ;
    }
}
