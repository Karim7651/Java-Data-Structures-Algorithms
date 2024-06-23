import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphAdjacencyList {

    ArrayList<GraphNodeAdjacencyList> nodeList = new ArrayList<>();

    public GraphAdjacencyList(ArrayList<GraphNodeAdjacencyList> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int fromIndex, int toIndex) {
        GraphNodeAdjacencyList first = nodeList.get(fromIndex);
        GraphNodeAdjacencyList second = nodeList.get(toIndex);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    public void bfsVisit(GraphNodeAdjacencyList node) {
        Queue<GraphNodeAdjacencyList> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNodeAdjacencyList currentNode = queue.remove();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for (int i = 0; i < currentNode.neighbors.size(); i++) {
                GraphNodeAdjacencyList currentNeighbor = currentNode.neighbors.get(i);
                if (!currentNeighbor.isVisited) {
                    queue.add(currentNeighbor);
                    currentNeighbor.isVisited = true;
                }

            }

        }

    }

    // bfs on every node since there might be disconnected node(s)
    public void bfs() {
        for (GraphNodeAdjacencyList node : nodeList) {
            if (!node.isVisited) {
                bfsVisit(node);
            }
        }
    }
    public void dfsVisit(GraphNodeAdjacencyList node){
        Stack<GraphNodeAdjacencyList> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            GraphNodeAdjacencyList currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for(GraphNodeAdjacencyList neighbor : currentNode.neighbors){
                if(!neighbor.isVisited){
                    neighbor.isVisited = true;
                    stack.push(neighbor);
                }
            }
        }

    }
    public void dfs(){
        for(GraphNodeAdjacencyList node : nodeList){
            if(!node.isVisited){
                dfsVisit(node);
            }
        }
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j = 0; j < nodeList.get(i).neighbors.size(); j++) {
                if (j == nodeList.get(i).neighbors.size() - 1) {
                    s.append((nodeList.get(i).neighbors.get(j).name));
                } else {
                    s.append((nodeList.get(i).neighbors.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
}
