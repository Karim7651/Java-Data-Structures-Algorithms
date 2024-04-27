import java.util.ArrayList;

public class GraphAdjacencyMatrix {
    ArrayList<GraphNodeAdjacencyMatrix> nodeList ;
    int[][] adjacencyMatrix;

    public GraphAdjacencyMatrix(ArrayList<GraphNodeAdjacencyMatrix> nodeList){
        this.nodeList = nodeList;
        this.adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    //goes both ways
    public void addUndirectedEdge(int indexFrom, int indexTo){
        adjacencyMatrix[indexFrom][indexTo] = 1;
        adjacencyMatrix[indexTo][indexFrom] = 1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j : adjacencyMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }



}
