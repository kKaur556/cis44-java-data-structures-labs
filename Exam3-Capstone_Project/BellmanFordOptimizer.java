import java.util.*;
public class BellmanFordOptimizer {
    
    public void findCheapestRoute(Graph graph, String startCity){
        int vertices = graph.getVertexCount();
        List<Edge> edges = graph.getEdgeList();
        
        //initalize distances to all cities
        Map<String, Double> distances = new HashMap<>();
        for(String city: graph.getCities())
        {
            distances.put(city, Double.POSITIVE_INFINITY);
        }
        
        distances.put(startCity, 0.0);
        
        
        //Relax all edges V-1 times-find shorter path
        for(int i = 0; i < vertices - 1; i++){
            for(Edge edge: edges){
                //check if a cheaper path is found
                if((distances.get(edge.sourceCity)) != Double.POSITIVE_INFINITY && (distances.get(edge.sourceCity)) + edge.cost < (distances.get(edge.destCity)))
                    distances.put(edge.destCity, distances.get(edge.sourceCity) + edge.cost);
            }
        }
        
        
        //check for negative-weight cycles
        for(Edge edge: edges){
            if((distances.get(edge.sourceCity)) != Double.POSITIVE_INFINITY && (distances.get(edge.sourceCity)) + edge.cost < (distances.get(edge.destCity)))
            {
                System.out.println("Graph contains a negative cost cycle! Incosistent pricing.");
                return; //cannot find valid shortest path
            }
        }
        
        
        printSolution(distances, startCity); //no negative cyle, result printed
    }
    
    //helper print method
    private void printSolution(Map<String, Double> dist, String sC)
    {
        System.out.println("Cheapest routes from " + sC + ":");
        
        for(Map.Entry<String, Double> entry : dist.entrySet())
        {
            String city = entry.getKey();
            Double cost = entry.getValue();
            
            //checks if cost as the special infinite value, if not number is fixed to 2 decimal places
            String costString = (cost == Double.POSITIVE_INFINITY) ? "Infinity" : String.format("$%.2f", cost);
            
            System.out.println(city + ": " + costString);
        }
    }
}
