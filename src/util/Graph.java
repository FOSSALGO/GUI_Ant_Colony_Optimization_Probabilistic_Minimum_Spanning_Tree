package util;

import java.awt.Point;

public class Graph {

    private Point[] position = null;
    private float[] probabilitasVertex = null;
    private int[][] adjacency = null;

    public int length = 0;

    private int gridSize;
    private int numGridX;
    private int numGridY;

    public Graph() {
        super();
    }

    public Graph(Point[] position, float[] probabilitasVertex, int[][] adjacency, int gridSize, int numGridX, int numGridY) {
        super();
        this.position = position;
        this.probabilitasVertex = probabilitasVertex;
        this.adjacency = adjacency;
        this.gridSize = gridSize;
        this.numGridX = numGridX;
        this.numGridY = numGridY;
    }

    public Point[] getPosition() {
        return position;
    }

    public void setPosition(Point[] position) {
        this.position = position;
    }

    public float[] getProbabilitasVertex() {
        return probabilitasVertex;
    }

    public void setProbabilitasVertex(float[] probabilitasVertex) {
        this.probabilitasVertex = probabilitasVertex;
    }

    public int[][] getAdjacency() {
        return adjacency;
    }

    public void setAdjacency(int[][] adjacency) {
        this.adjacency = adjacency;
    }

    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

    public int getNumGridX() {
        return numGridX;
    }

    public void setNumGridX(int numGridX) {
        this.numGridX = numGridX;
    }

    public int getNumGridY() {
        return numGridY;
    }

    public void setNumGridY(int numGridY) {
        this.numGridY = numGridY;
    }
}
