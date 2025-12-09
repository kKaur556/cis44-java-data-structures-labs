public class ProjectTester {

    public static void main(String[] args) {
        BellmanFordOptimizer opt = new BellmanFordOptimizer();
        
        //test scenario 1: Logic Validation cheapest path found
        System.out.println("Logic Validation; Cheapest path found for Sunol:");
        Graph graph1 = new Graph();
        graph1.addEdge(new Edge("Sunol", "Newark", 10.0));
        graph1.addEdge(new Edge("Sunol", "Pleasanton", 3.0));
        graph1.addEdge(new Edge("Pleasanton", "Livermore", 1.0));
        
        /* expected behavior:
        cheapest is sunol-sunol: $0.00
        sunol- livermore: $4.00
        sunol- pleasanton: $3.00
        sunol- newark: $10.00
        
        */
        
        opt.findCheapestRoute(graph1, "Sunol");
        System.out.println();
        
        //test scenario 2: unreachable cities
        System.out.println("Logic Validation and Cities unreachable:");
        Graph graph2 = new Graph();
        graph2.addEdge(new Edge("Sacramento", "San Francisco", 15.0));
        graph2.addEdge(new Edge("San Francisco", "Roseville", 20.0));
        graph2.addEdge(new Edge("San Jose", "Santa Clara", 1.0));
        
        opt.findCheapestRoute(graph2, "Sacramento");
        System.out.println();
        
        
        //test scenario 3: Negative cylce detection
        System.out.println("Negative cycle detection:");
        Graph graph3 = new Graph();
        graph3.addEdge(new Edge("Patterson", "Tracy", 10.0));
        graph3.addEdge(new Edge("Tracy", "Davis", -8.0));
        graph3.addEdge(new Edge("Davis", "Patterson", -5.0));
        
        opt.findCheapestRoute(graph3, "Patterson");
        System.out.println();
    }
}
