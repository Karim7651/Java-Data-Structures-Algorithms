import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphAdjacencyMatrix {
    //reference to all nodes in graph
    ArrayList<GraphNodeAdjacencyMatrix> nodeList;
    //adjacencyMatrix for the whole graph
    int[][] adjacencyMatrix;

    public GraphAdjacencyMatrix(ArrayList<GraphNodeAdjacencyMatrix> nodeList) {
        this.nodeList = nodeList;
        this.adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    //goes both ways
    public void addUndirectedEdge(int indexFrom, int indexTo) {
        adjacencyMatrix[indexFrom][indexTo] = 1;
        adjacencyMatrix[indexTo][indexFrom] = 1;
    }
    public void addDirectedEdge(int fromIndex , int toIndex){
        adjacencyMatrix[fromIndex][toIndex] = 1;
    }

    public ArrayList<GraphNodeAdjacencyMatrix> getNeighbors(GraphNodeAdjacencyMatrix node) {
        ArrayList<GraphNodeAdjacencyMatrix> neighbors = new ArrayList<>();
        int nodeIndex = node.index;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[nodeIndex][i] == 1) {
                neighbors.add(nodeList.get(i));
            }
        }
        return neighbors;
    }

    public void bfsVisit(GraphNodeAdjacencyMatrix node) {
        Queue<GraphNodeAdjacencyMatrix> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNodeAdjacencyMatrix currentNode = queue.remove();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNodeAdjacencyMatrix> neighbors = getNeighbors(currentNode);
            for (GraphNodeAdjacencyMatrix neighborNode : neighbors) {
                if (!neighborNode.isVisited) {
                    queue.add(neighborNode);
                    neighborNode.isVisited = true;
                }
            }
        }
    }

    public void bfs() {
        for (GraphNodeAdjacencyMatrix node : nodeList) {
            if (!node.isVisited) {
                bfsVisit(node);
            }
        }
    }

    public void dfsVisit(GraphNodeAdjacencyMatrix node) {
        Stack<GraphNodeAdjacencyMatrix> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            GraphNodeAdjacencyMatrix currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNodeAdjacencyMatrix> neighbors = getNeighbors(currentNode);
            for(GraphNodeAdjacencyMatrix neighbor : neighbors){
                if(!neighbor.isVisited){
                    neighbor.isVisited=true;
                    stack.push(neighbor);
                }
            }
        }
    }

    public void dfs() {
        for (GraphNodeAdjacencyMatrix node : nodeList) {
            if (!node.isVisited) {
                dfsVisit(node);
            }
        }
    }
    void topologicalVisit(GraphNodeAdjacencyMatrix node , Stack<GraphNodeAdjacencyMatrix> stack){
        ArrayList<GraphNodeAdjacencyMatrix> neighbors = getNeighbors(node);
        for(GraphNodeAdjacencyMatrix neighbor : neighbors){
            if(!neighbor.isVisited){
                topologicalVisit(neighbor,stack);
            }
            node.isVisited=true;
            stack.push(node);
        }
    }
    void topologicalSort(){
        Stack<GraphNodeAdjacencyMatrix> stack = new Stack<>();
        for(GraphNodeAdjacencyMatrix node : nodeList){
            topologicalVisit(node,stack);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop().name + " ");
        }
    }
    public static void printPath(GraphNodeAdjacencyMatrix node){
        if(node.parent != null){
            printPath(node.parent);
        }
        System.out.print(node.name + " ");
    }
    public void BFSForSSSP(GraphNodeAdjacencyMatrix node){
        Queue<GraphNodeAdjacencyMatrix> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNodeAdjacencyMatrix currentNode = queue.remove();
            currentNode.isVisited = true;
            System.out.print("Printing path for node" + currentNode.name + " ");
            printPath(currentNode);
            System.out.println();
            ArrayList<GraphNodeAdjacencyMatrix> neighbors = getNeighbors(currentNode);
            for(GraphNodeAdjacencyMatrix neighbor :  neighbors){
                if(!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                    neighbor.parent=currentNode;
                }
            }
        }
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
