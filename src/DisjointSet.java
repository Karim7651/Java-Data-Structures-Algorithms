import java.util.ArrayList;

public class DisjointSet {
    private ArrayList<WeightedGraphNode> nodeList = new ArrayList<>();

    public static void makeSet(ArrayList<WeightedGraphNode> nodeList){
        for(WeightedGraphNode node : nodeList){
            DisjointSet set = new DisjointSet();
            set.nodeList.add(node);
            node.set = set;
        }
    }
    //return the set where this node belongs
    public static DisjointSet findSet(WeightedGraphNode node){
        return node.set;
    }
    public static DisjointSet union(WeightedGraphNode node1, WeightedGraphNode node2){
        if(node1.set.equals(node2.set)){
            return null;
        }else{
           DisjointSet set1 = node1.set;
           DisjointSet set2 = node2.set;
           //if set 1 is bigger merge set 2 to set 1 (fewer operations)
           if(set1.nodeList.size() > set2.nodeList.size()){
               ArrayList<WeightedGraphNode> nodeSet2 = set2.nodeList;
               for(WeightedGraphNode node : set2.nodeList){
                   node.set = set1;
                   set1.nodeList.add(node);
               }
               return set1;
           }else{
               ArrayList<WeightedGraphNode> nodeSet2 = set1.nodeList;
               for(WeightedGraphNode node : set1.nodeList){
                   node.set = set2;
                   set1.nodeList.add(node);
               }
               return set2;
           }
        }
    }

    public void printAllNodes(){
        System.out.println("Printing all nodes of the set");
        for(WeightedGraphNode node : nodeList){
            System.out.print(node + " ");
        }
        System.out.println("Printing all nodes of the set");
    }
    //having cycle implies elements being in the same set

}
