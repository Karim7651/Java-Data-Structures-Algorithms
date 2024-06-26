import java.util.ArrayList;
import java.util.PriorityQueue;

//!
public class Prims {

    ArrayList<WeightedGraphNode> nodeList = new ArrayList<WeightedGraphNode>();

    public Prims(ArrayList<WeightedGraphNode> nodeList) {
        this.nodeList = nodeList;
    }


    void prims(WeightedGraphNode node) {
        for (int counter = 0; counter < nodeList.size(); counter++) {
            nodeList.get(counter).distance = Integer.MAX_VALUE;
        }
        node.distance = 0; // Setting '0' distance for Source Vertex


        PriorityQueue<WeightedGraphNode> queue = new PriorityQueue<>();

        queue.addAll(nodeList);
        while (!queue.isEmpty()) {
            WeightedGraphNode presentNode = queue.remove(); // Remove vertex which has minimum distance


            for (WeightedGraphNode neighbor : presentNode.neighbors) {
                //neighbor isn't processed yet
                if (queue.contains(neighbor)) {
                    if (neighbor.distance > presentNode.weightMap.get(neighbor)) {
                        neighbor.distance = presentNode.weightMap.get(neighbor);
                        neighbor.parent = presentNode;
                        //refresh queue by removing then inserting again
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        int cost = 0;
        for (WeightedGraphNode nodeToCheck : nodeList) {
            System.out.println("Node " + nodeToCheck + ", key: " + nodeToCheck.distance + ", Parent: " + nodeToCheck.parent);
            cost = cost + nodeToCheck.distance;
        }
        System.out.println("\nTotal cost of MST: " + cost);
    }

    public void addWeightedUndirectedEdge(int i, int j, int d) {
        WeightedGraphNode first = nodeList.get(i);
        WeightedGraphNode second = nodeList.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
        first.weightMap.put(second, d);
        second.weightMap.put(first, d);
    }
}
