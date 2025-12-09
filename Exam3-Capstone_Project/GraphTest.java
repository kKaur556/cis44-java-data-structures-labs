import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.mycompany.projecttester.Graph;
import com.mycompany.projecttester.Edge;

public class GraphTest {
    private Graph graph;

    // This method runs before every single test method below
    @BeforeEach
    public void setUp() {
        graph = new Graph();
    }

    //Boundary Tests

    @Test
    public void testEmptyGraphInitialization() {
        //Assertions provide the PASS/FAIL logic for the JUnit runner
        assertNotNull(graph.getEdgeList(), "Edge list should not be null");
        assertNotNull(graph.getCities(), "Cities set should not be null");
        assertTrue(graph.getEdgeList().isEmpty(), "Edge list should be empty initially");
        assertTrue(graph.getCities().isEmpty(), "Cities set should be empty initially");
        assertEquals(0, graph.getVertexCount(), "Vertex count should be 0 for an empty graph");
        assertEquals(0, graph.getEdgeCount(), "Edge count should be 0 for an empty graph");
    }

    //Logic Validation: Graph Methods

    @Test
    public void testAddSingleEdge() {
        Edge edge = new Edge("CityA", "CityB", 10.0);
        graph.addEdge(edge);

        assertEquals(1, graph.getEdgeCount(), "Should have exactly one edge after adding");
        assertEquals(2, graph.getVertexCount(), "Should have two unique cities after adding one edge");
        assertTrue(graph.getCities().contains("CityA"), "Source city must be in the set");
        assertTrue(graph.getCities().contains("CityB"), "Destination city must be in the set");
        assertTrue(graph.getEdgeList().contains(edge), "Edge list should contain the exact edge object added");
    }

    @Test
    public void testAddMultipleEdgesAndDuplicateCities() {
        graph.addEdge(new Edge("Newark", "Fremont", 1.0));
        graph.addEdge(new Edge("Fremont", "Milpitas", 2.0));
        graph.addEdge(new Edge("Newark", "Milpitas", 3.0));
        graph.addEdge(new Edge("Milpitas", "Fremont", 1.5)); // Add edge back

        assertEquals(4, graph.getEdgeCount(), "Total number of edges/routes should be 4");
        //Ensure cities are counted only once in the set
        assertEquals(3, graph.getVertexCount(), "Total number of unique cities/vertices should be 3");
        
        Set<String> expectedCities = new HashSet<>(Arrays.asList("Newark", "Fremont", "Milpitas"));
        assertEquals(expectedCities, graph.getCities(), "The set of cities must match expected unique city names");
    }

    //Logic Validation: Edge Class

    @Test
    public void testEdgeToString() {
        Edge edge = new Edge("NewYork", "Boston", 250.75);
        String expectedString = "NewYork --(250.75)--> Boston";
        assertEquals(expectedString, edge.toString(), "toString method output does not match expected format");
    }
}
