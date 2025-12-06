public class Edge {
    public final String sourceCity;
    public final String destCity;
    public final double cost;
    
    //constructor- intializes instances
    public Edge(String sC, String dC, double c){
        sourceCity = sC;
        destCity = dC;
        cost = c;
    }
    
    @Override
    public String toString(){
        return sourceCity + " --(" + cost + ")--> "+ destCity;
    }
}
