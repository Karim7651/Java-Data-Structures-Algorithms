import java.util.*;
public class WeightedGraph {
    ArrayList<WeightedGraphNode> nodeList = new ArrayList<>();
    public WeightedGraph(ArrayList<WeightedGraphNode> nodeList){
        this.nodeList = nodeList;
    }
    public void printPath(WeightedGraphNode node){
        if(node.parent != null){
            printPath(node.parent);
        }
        System.out.print(node.name + " ");
    }
    public void addWeightedDirectedEdge(int i, int j , int d){
        WeightedGraphNode n1 = nodeList.get(i);
        WeightedGraphNode n2 = nodeList.get(j);
        n1.neighbors.add(n2);
        n1.weightMap.put(n2,d);
    }
    void dijkstra(WeightedGraphNode node){
        PriorityQueue<WeightedGraphNode> priorityQueue = new PriorityQueue<>();
        //make sure we start from this node(source)
        node.distance = 0;
        priorityQueue.addAll(nodeList);
        while(!priorityQueue.isEmpty()){
            WeightedGraphNode currentNode = priorityQueue.remove();
            for(WeightedGraphNode neighbor : currentNode.neighbors){
                //if this node is unvisited
                if(priorityQueue.contains(neighbor)){
                    if(neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)){
                        neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
                        neighbor.parent = currentNode;
                        //refresh priorityQueue by adding this neighbor and adding it again
                        priorityQueue.remove(neighbor);
                        priorityQueue.add(neighbor);
                    }
                }
            }
        }
        for(WeightedGraphNode nodeToCheck : nodeList){
            System.out.print("Node " + nodeToCheck+ ", distance: " + nodeToCheck.distance + ", Path: ");
            printPath(nodeToCheck);
            System.out.println();
        }

    }
}
