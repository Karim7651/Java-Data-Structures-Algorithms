import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class WeightedGraphNode implements Comparable<WeightedGraphNode> {
    String name;
    int index;
    WeightedGraphNode parent;
    boolean isVisited = false;

    //least distance calculated in dijkstra
    int distance;
    ArrayList<WeightedGraphNode> neighbors = new ArrayList<>();
    HashMap<WeightedGraphNode,Integer> weightMap = new HashMap<>();
    //for disjoint set only
    public DisjointSet set;

    public WeightedGraphNode(String name, int index){
        this.name = name;
        this.index = index;
        this.distance = Integer.MAX_VALUE;

    }
    @Override
    public String toString(){
        return name;
    }
    @Override
    public int compareTo(WeightedGraphNode o){
        return this.distance - o.distance;
    }

}
