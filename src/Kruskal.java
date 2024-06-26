import java.util.*;
public class Kruskal {
    ArrayList<WeightedGraphNode> nodeList= new ArrayList<>();
    ArrayList<UndirectedEdge> edgeList = new ArrayList<>();

    public Kruskal(ArrayList<WeightedGraphNode> nodeList){
        this.nodeList = nodeList;
    }
    public void addWeightedUndirectedEdge(int firstIndex, int secondIndex,int weight){
        UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex),nodeList.get(secondIndex),weight);
        nodeList.get(firstIndex).neighbors.add(nodeList.get(secondIndex));
        nodeList.get(secondIndex).neighbors.add(nodeList.get(secondIndex));
        nodeList.get(firstIndex).weightMap.put(nodeList.get(secondIndex),weight);
        nodeList.get(secondIndex).weightMap.put(nodeList.get(firstIndex),weight);
        edgeList.add(edge);
    }
    public void kruskal(){
        //make set
        DisjointSet.makeSet(nodeList);
        //sort edges ascendingly
        Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>(){
            @Override
            public int compare(UndirectedEdge o1,UndirectedEdge o2){
                return o1.weight - o2.weight;
            }
        };
        Collections.sort(edgeList,comparator);
        int cost = 0;
        for(UndirectedEdge edge : edgeList){
            WeightedGraphNode first = edge.first;
            WeightedGraphNode second = edge.second;
            if(!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))){
                DisjointSet.union(first,second);
                cost += edge.weight;
                System.out.println("Taken" + edge);
            }
        }
        System.out.println("total cost of MST " + cost);
    }
}
