//used for kruskal algorithm
public class UndirectedEdge {
    public WeightedGraphNode first;
    public WeightedGraphNode second;
    public int weight;
   public UndirectedEdge(WeightedGraphNode first, WeightedGraphNode second , int weight){
       this.first = first;
       this.second = second;
       this.weight = weight;
   }

   @Override
    public String toString(){
       return "Edge (" + first + "," + second +"), weight =" + weight;
   }

}
