package application;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import geography.GeographicPoint;
import util.GraphLoader;

/** A class which represents a graph of geographic locations**/
public class DataSet {
	String filePath;
	roadgraph.MapGraph graph;
	Set<GeographicPoint> intersections;
    private HashMap<geography.GeographicPoint,HashSet<geography.RoadSegment>>  roads;
	boolean currentlyDisplayed;

	public DataSet (String path) {
        this.filePath = path;
        graph = null;
        roads = null;
        currentlyDisplayed = false;
	}

    public void setGraph(roadgraph.MapGraph graph) {
    	this.graph = graph;
    }

    public void setRoads(HashMap<geography.GeographicPoint,HashSet<geography.RoadSegment>>  roads) { this.roads = roads; }
    public roadgraph.MapGraph getGraph(){ return graph; }
    
    
    public Set<GeographicPoint> getIntersections() {
    	Set<GeographicPoint> intersectionsFromGraph = graph.getVertices();
    	if (intersectionsFromGraph == null) {
    		return intersections;
    	}
    	else {
    		return intersectionsFromGraph;
    	}
    }
    
    public HashMap<geography.GeographicPoint,HashSet<geography.RoadSegment>>  getRoads() { return this.roads; }

    public void initializeGraph() {
        graph = new roadgraph.MapGraph();
        roads = new HashMap<geography.GeographicPoint, HashSet<geography.RoadSegment>>();
        intersections = new HashSet<GeographicPoint>();
        //TODO: change to use intersections for points in graph.
    	GraphLoader.loadRoadMap(filePath, graph, roads, intersections);
    }

	public String getFilePath() {
		return this.filePath;
	}


    public Object[] getPoints() {
    	Set<geography.GeographicPoint> pointSet = roads.keySet();
    	return pointSet.toArray();
    }

    public boolean isDisplayed() {
    	return this.currentlyDisplayed;
    }

    public void setDisplayed(boolean value) {
    	this.currentlyDisplayed = value;
    }

}