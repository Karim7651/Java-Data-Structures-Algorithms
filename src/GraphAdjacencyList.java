import java.util.ArrayList;

public class GraphAdjacencyList {

    ArrayList<GraphNodeAdjacencyList> nodeList = new ArrayList<>();

    public GraphAdjacencyList(ArrayList<GraphNodeAdjacencyList> nodeList){
        this.nodeList = nodeList;
    }
    public void addUndirectedEdge(int fromIndex,int toIndex){
        GraphNodeAdjacencyList first = nodeList.get(fromIndex);
        GraphNodeAdjacencyList second = nodeList.get(toIndex);
        first.neighbors.add(second);
        second.neighbors.add(first) ;
    }




    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j =0; j < nodeList.get(i).neighbors.size(); j++) {
                if (j == nodeList.get(i).neighbors.size()-1 ) {
                    s.append((nodeList.get(i).neighbors.get(j).name) );
                } else {
                    s.append((nodeList.get(i).neighbors.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
}
