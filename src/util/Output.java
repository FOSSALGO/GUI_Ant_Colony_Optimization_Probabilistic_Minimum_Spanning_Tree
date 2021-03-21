package util;

import java.awt.Point;

public class Output {

    /*ACO Result*/
    private float[][] ACOsolution = null;
    private float ACOcost = -1;

    /*ACO Parameters*/
    Parameters parameters = null;

    /*graph*/
    Graph graph = null;

    public Output() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Output(float[][] aCOsolution, float aCOcost, Parameters parameters, Graph graph) {
        super();
        ACOsolution = aCOsolution;
        ACOcost = aCOcost;
        this.parameters = parameters;
        this.graph = graph;
    }

    public float[][] getACOsolution() {
        return ACOsolution;
    }

    public void setACOsolution(float[][] aCOsolution) {
        ACOsolution = aCOsolution;
    }

    public float getACOcost() {
        return ACOcost;
    }

    public void setACOcost(float aCOcost) {
        ACOcost = aCOcost;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
