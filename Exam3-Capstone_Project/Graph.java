import java.util.*;
public class Graph {
    private final List<Edge> edgeList;
    private final Set<String> cities;
    
    //constructor- intializes instances
    public Graph()
    {
        this.edgeList = new ArrayList<>();
        this.cities = new HashSet<>();
    }
    
    //gets edgeList
    public List<Edge> getEdgeList(){ return edgeList; }
    
    //gets cities list
    public Set<String> getCities(){ return cities; }
    
    //gets count of cities(Vertices)
    public int getVertexCount(){ return cities.size(); }
    
    //gets count of routes(Edges)
    public int getEdgeCount(){ return edgeList.size(); }
    
    
    //add new route(edge)
    public void addEdge(Edge edge){
        edgeList.add(edge);
        cities.add(edge.sourceCity);
        cities.add(edge.destCity);
    }
}
