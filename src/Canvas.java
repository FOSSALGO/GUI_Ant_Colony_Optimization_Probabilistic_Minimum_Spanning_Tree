
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import algorithm.GraphACO;

import util.*;

public class Canvas extends JPanel {

    private double translateX;
    private double translateY;
    private double scale;

    private int xPos = -1, yPos = -1;

    private Graph graph = null;
    private Parameters parameters = null;
    private int[][] grid = null;

    private Point[] tempPosition = null;
    private float[] tempProbability = null;
    private int[][] tempAdjacency = null;

    private int iVo = -1;

    private CanvasState cs = CanvasState.TRANSFORM;

    /*property info*/
    boolean infoVertex = false;
    boolean infoProbability = false;
    boolean infoDegree = false;
    boolean hideEdge = false;

    private int[] degree = null;
    private int[] degreeSolution = null;

    /*output*/
    private float[][] ACOsolution = null;
    private float ACOcost = -1;
    private Output output = null;

    public Canvas() {
        super();
        this.initialize();
    }

    private void initialize() {
        translateX = 0;
        translateY = 0;
        scale = 1;
        //this.setOpaque(false);
        this.setOpaque(true);
        this.setDoubleBuffered(true);

        Handler handler = new Handler();
        this.addMouseListener(handler);
        this.addMouseMotionListener(handler);
        this.addMouseWheelListener(handler);

        this.initializeDefaultProperties();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        draw(g2d);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        draw(g2d);
    }

    private void draw(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        AffineTransform tx = new AffineTransform();
        tx.translate(translateX, translateY);
        tx.scale(scale, scale);
        g2d.setTransform(tx);
        /*==================================================================*/
        int gridSize = this.graph.getGridSize();
        int numGridX = this.graph.getNumGridX();
        int numGridY = this.graph.getNumGridY();
        int wGrid = gridSize * numGridX;
        int hGrid = gridSize * numGridY;
        int r = 0;
        int c = 0;
        if (gridSize > 0) {
            r = gridSize / 6;
            c = gridSize / 2;
        }

        //gambar edgenya
        if (!hideEdge && this.tempPosition != null && this.tempAdjacency != null && this.tempAdjacency.length == this.tempPosition.length && this.tempAdjacency[0].length == this.tempPosition.length) {
            for (int i = 0; i < this.tempAdjacency.length; i++) {
                for (int j = 1 + i; j < this.tempAdjacency[i].length; j++) {
                    if (this.tempAdjacency[i][j] == 1 || this.tempAdjacency[j][i] == 1) {
                        int x0 = this.tempPosition[i].x * gridSize + c;
                        int y0 = this.tempPosition[i].y * gridSize + c;
                        int x1 = this.tempPosition[j].x * gridSize + c;
                        int y1 = this.tempPosition[j].y * gridSize + c;
                        g2d.setColor(FlatUIColor.GREEN_SEA);
                        g2d.setComposite(AlphaComposite.SrcOver.derive(0.3f));
                        g2d.setStroke(new BasicStroke(2));
                        g2d.drawLine(x0, y0, x1, y1);
                        g2d.setStroke(new BasicStroke(1));
                        g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
                        /*System.out.println("TRACE ("+(x0)+", "+(y0)+"); ("+(x1)+", "+(y1)+") ");*/
                    }
                }
            }
        }

        /*visualisasi degree of vertex*/
        if (this.infoDegree && this.tempPosition != null && this.degree != null && this.tempPosition.length == this.degree.length) {
            for (int i = 0; i < this.degree.length; i++) {
                int cx = this.tempPosition[i].x * gridSize + c;
                int cy = this.tempPosition[i].y * gridSize + c;
                if (this.ACOsolution != null && this.degreeSolution != null) {
                    int J = this.degreeSolution[i];
                    float alpha = 0.6f / (float) J;
                    for (int j = J; j > 0; j--) {
                        g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));
                        Cycle.fill(g2d, cx, cy, j * r, FlatUIColor.ALIZARIN);
                        g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
                        Cycle.draw(g2d, cx, cy, j * r, FlatUIColor.CLOUDS);
                        g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
                    }
                } else {
                    int J = this.degree[i];
                    float alpha = 0.4f / (float) J;
                    for (int j = J; j > 0; j--) {
                        g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));
                        Cycle.fill(g2d, cx, cy, j * r, FlatUIColor.CARROT);
                        g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
                        Cycle.draw(g2d, cx, cy, j * r, FlatUIColor.CLOUDS);
                        g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
                    }
                }
            }
        }

        /*grid*/
        if (gridSize > 0 && numGridX > 0 && numGridY > 0) {
            g2d.setColor(FlatUIColor.WET_ASPHALT);
            g2d.setComposite(AlphaComposite.SrcOver.derive(0.2f));
            float[] dash1 = {4f, 4f, 1f};
            BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
            g2d.setStroke(bs1);
            for (int i = 0; i <= numGridX; i++) {
                g2d.drawLine(i * gridSize, 0, i * gridSize, hGrid);
            }
            for (int j = 0; j <= numGridY; j++) {
                g2d.drawLine(0, j * gridSize, wGrid, j * gridSize);
            }
            g2d.setStroke(new BasicStroke(1));
            g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
        }

        /*gambar solusi ACO*/
        Point[] ACOposition = this.graph.getPosition();
        if (this.ACOsolution != null && ACOposition != null && this.ACOsolution.length == (-1 + ACOposition.length)) {
            for (int i = 0; i < this.ACOsolution.length; i++) {
                int is0 = (int) this.ACOsolution[i][0];
                int is1 = (int) this.ACOsolution[i][1];
                Point p0 = ACOposition[is0];
                Point p1 = ACOposition[is1];
                int x0 = p0.x * gridSize + c;;
                int y0 = p0.y * gridSize + c;;
                int x1 = p1.x * gridSize + c;;
                int y1 = p1.y * gridSize + c;;
                g2d.setColor(FlatUIColor.CLOUDS);
                g2d.setComposite(AlphaComposite.SrcOver.derive(0.8f));
                g2d.setStroke(new BasicStroke(6));
                g2d.drawLine(x0, y0, x1, y1);
                g2d.setColor(FlatUIColor.ALIZARIN);
                g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
                g2d.setStroke(new BasicStroke(2));
                g2d.drawLine(x0, y0, x1, y1);
                g2d.setStroke(new BasicStroke(1));
                g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
            }
        }

        //gambar vertexnya
        if (this.grid != null) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        int x0 = i * gridSize;
                        int y0 = j * gridSize;
                        int cx = x0 + c;
                        int cy = y0 + c;
                        g2d.setComposite(AlphaComposite.SrcOver.derive(0.9f));
                        Cycle.fill(g2d, cx, cy, r, FlatUIColor.ALIZARIN);
                        g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
                    }
                }
            }
        }

        //gambar label vertex
        if (this.tempPosition != null && this.tempProbability != null && this.tempPosition.length == this.tempProbability.length) {
            for (int k = 0; k < this.tempPosition.length; k++) {
                int i = this.tempPosition[k].x;
                int j = this.tempPosition[k].y;
                float p = this.tempProbability[k];
                int x0 = i * gridSize;
                int y0 = j * gridSize;
                int cx = x0 + c;
                int cy = y0 + c;
                g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
                g2d.setColor(FlatUIColor.PETER_RIVER);
                if (this.infoProbability) {
                    g2d.drawString("  {p: " + (new DecimalFormat("###.##").format(p)) + "}", cx, cy - r + 12);
                }
                g2d.setColor(FlatUIColor.MIDNIGHT_BLUE);
                if (this.infoVertex) {
                    g2d.drawString("V" + (k) + "(" + (i) + "," + (j) + ")", cx, cy - r);
                } else {
                    g2d.drawString("V" + (k), cx, cy - r);
                }
                g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
            }
        }

        /*gambar watermark*//*
		if(this.grid!=null){
			for(int i=0;i<grid.length;i++){
				for(int j=0;j<grid[i].length;j++){
					if(grid[i][j]==1){
						
						int x0	= i*gridSize;
						int y0	= j*gridSize;						
						int cx	= x0+c;
						int cy	= y0+c;
						g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
						g2d.setColor(FlatUIColor.MIDNIGHT_BLUE);
						g2d.drawString("Watermark ACO_PMST", cx, cy);
						g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
						
					}
					int x0	= i*gridSize;
					int y0	= j*gridSize;						
					int cx	= x0+c;
					int cy	= y0+c;
					g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
					g2d.setColor(FlatUIColor.ASBESTOS);
					g2d.drawString("OCA", cx, cy);
					g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
				}
			}
		}	*/
 /*==================================================================*/

        if (this.xPos != -1 && this.yPos != -1) {
            int x0 = xPos;
            int y0 = yPos;
            int x1 = (int) Math.round((x0 - translateX) / scale);
            int y1 = (int) Math.round((y0 - translateY) / scale);
            g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
            g2d.setColor(FlatUIColor.MIDNIGHT_BLUE);
            g2d.drawString("(" + ((int) Math.floor(x1 / gridSize)) + "," + ((int) Math.floor(y1 / gridSize)) + ")", x1, y1);
            g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
        }
        g2d.dispose();
    }

    public double getTranslateX() {
        return translateX;
    }

    public void setTranslateX(double translateX) {
        this.translateX = translateX;
    }

    public double getTranslateY() {
        return translateY;
    }

    public void setTranslateY(double translateY) {
        this.translateY = translateY;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public void initializeDefaultProperties() {
        this.graph = new Graph();
        this.parameters = new Parameters();
        this.graph.setGridSize(40);
        this.graph.setNumGridX(20);
        this.graph.setNumGridY(20);
        this.grid = new int[this.graph.getNumGridX()][this.graph.getNumGridY()];
        this.parameters.setQ(1.0f);
        this.parameters.setAlpha(1.0f);
        this.parameters.setBeta(1.0f);
        this.parameters.setRho(1.0f);
        this.parameters.setTho(1.0f);
        this.parameters.setM(10);
        this.parameters.setNCMAX(10);
    }

    public void resetDefaultGrid() {
        if (this.graph == null) {
            this.graph = new Graph();
        }
        this.graph.setGridSize(40);
        this.graph.setNumGridX(20);
        this.graph.setNumGridY(20);
        this.grid = new int[this.graph.getNumGridX()][this.graph.getNumGridY()];
    }

    public void resetDefaultParameters() {
        if (this.parameters == null) {
            this.parameters = new Parameters();
        }
        this.parameters.setQ(1.0f);
        this.parameters.setAlpha(1.0f);
        this.parameters.setBeta(1.0f);
        this.parameters.setRho(1.0f);
        this.parameters.setTho(1.0f);
        this.parameters.setM(10);
        this.parameters.setNCMAX(10);
    }

    public void setParametes(Parameters p) {
        this.parameters = p;
    }

    public void setParameters(float Q, float alpha, float beta, int m, float rho, float tho, int ncMAX) {
        this.parameters = new Parameters(Q, alpha, beta, m, rho, tho, ncMAX);
    }

    public void setGrid(int numGridX, int numGridY, int gridSize) {
        if (this.graph == null) {
            this.graph = new Graph();
        }
        if (numGridX > 0 && numGridY > 0 && gridSize > 0) {
            this.graph.setGridSize(gridSize);
            this.graph.setNumGridX(numGridX);
            this.graph.setNumGridY(numGridY);
            this.grid = new int[this.graph.getNumGridX()][this.graph.getNumGridY()];
        }
    }

    public void setCS(CanvasState cs) {
        this.cs = cs;
    }

    public boolean createVertices() {
        boolean result = false;
        int numGridX = this.graph.getNumGridX();
        int numGridY = this.graph.getNumGridY();
        if (numGridX > 0 && numGridY > 0) {
            this.grid = new int[numGridX][numGridY];
            this.cs = CanvasState.CREATE_VERTEX;
            result = true;
            repaint();
        }
        return result;
    }

    public boolean generateRandomVertices(int numVertices) {
        boolean result = false;
        try {
            int numGridX = this.graph.getNumGridX();
            int numGridY = this.graph.getNumGridY();
            if (0 < numVertices && numVertices <= (numGridX * numGridY)) {
                this.grid = new int[numGridX][numGridY];
                int i = 0;
                while (i < numVertices) {
                    int x = RandomGenerator.randomBetweenInt(0, -1 + numGridX);
                    int y = RandomGenerator.randomBetweenInt(0, -1 + numGridY);
                    if (this.grid[x][y] == 0) {
                        this.grid[x][y] = 1;
                        i++;
                    }
                }
                result = true;
                repaint();
            }
        } catch (Exception e) {
            System.out.println("GAGAL meng-Generate random vertices");
            JOptionPane.showMessageDialog(null, "GAGAL meng-Generate random vertices");
            e.printStackTrace();
        }
        return result;
    }

    private Point[] getPosition() {
        Point[] position = null;
        if (this.grid != null) {
            List<Point> pos = new ArrayList<Point>();
            for (int i = 0; i < this.grid.length; i++) {
                for (int j = 0; j < this.grid[i].length; j++) {
                    if (this.grid[i][j] == 1) {
                        pos.add(new Point(i, j));
                    }
                }
            }
            if (!pos.isEmpty()) {
                position = new Point[pos.size()];
                for (int i = 0; i < pos.size(); i++) {
                    position[i] = pos.get(i);
                }
            }
        }
        return position;
    }

    public void preparingSetVerticesProbabilities() {
        Point[] position = this.getPosition();
        if (position != null) {
            this.tempPosition = position;
            this.tempProbability = new float[position.length];
            this.degree = new int[position.length];
            this.tempAdjacency = new int[position.length][position.length];
            for (int i = 0; i < position.length; i++) {
                this.tempProbability[i] = 1.0f;
            }
        }
    }

    public boolean setVertexPobability() {
        boolean result = false;
        preparingSetVerticesProbabilities();
        if (this.tempProbability != null) {
            this.cs = CanvasState.SET_PROBABILITY;
            result = true;
        }
        return result;
    }

    public boolean setRandomVerticesProbabilities() {
        boolean result = false;
        preparingSetVerticesProbabilities();
        if (this.tempProbability != null) {
            for (int i = 0; i < this.tempProbability.length; i++) {
                this.tempProbability[i] = RandomGenerator.randomBetweenFloat(0.0f, 1.0f);
            }
            this.cs = CanvasState.TRANSFORM;
            result = true;
        }
        return result;
    }

    public boolean setFixedVerticesProbabilities(float value) {
        boolean result = false;
        preparingSetVerticesProbabilities();
        if (this.tempProbability != null && value >= 0.0f && value <= 1.0f) {
            for (int i = 0; i < this.tempProbability.length; i++) {
                this.tempProbability[i] = value;
            }
            this.cs = CanvasState.TRANSFORM;
            result = true;
        }
        return result;
    }

    public boolean createEdge() {
        boolean result = false;
        try {
            if (this.grid != null && this.tempPosition != null && this.tempAdjacency != null && this.tempAdjacency.length == this.tempPosition.length && this.tempAdjacency[0].length == this.tempPosition.length) {
                this.cs = CanvasState.CREATE_EDGE;
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean generateRandomEdges() {
        boolean result = false;
        try {
            if (this.tempPosition != null && this.tempAdjacency != null && this.tempAdjacency.length == this.tempPosition.length && this.tempAdjacency[0].length == this.tempPosition.length) {
                for (int i = 0; i < -1 + this.tempAdjacency.length; i++) {
                    int numEdge = 0;
                    while (numEdge <= 0) {
                        for (int j = 1 + i; j < this.tempAdjacency[i].length; j++) {
                            boolean isConnected = RandomGenerator.randomBoolean();
                            /*System.out.println("TRACE : "+(isConnected));*/
                            if (isConnected && this.tempAdjacency[i][j] == 0 && this.tempAdjacency[j][i] == 0) {
                                this.tempAdjacency[i][j] = 1;
                                this.tempAdjacency[j][i] = 1;
                                this.degree[i]++;
                                this.degree[j]++;
                                numEdge++;
                            }

                        }
                    }
                }
                repaint();
                this.cs = CanvasState.CREATE_EDGE;
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean generateCompleteGraph() {
        boolean result = false;
        try {
            if (this.tempPosition != null && this.tempAdjacency != null && this.tempAdjacency.length == this.tempPosition.length && this.tempAdjacency[0].length == this.tempPosition.length) {
                //generate complete adjacency
                for (int i = 0; i < -1 + this.tempAdjacency.length; i++) {
                    for (int j = 1 + i; j < this.tempAdjacency[i].length; j++) {
                        this.tempAdjacency[i][j] = 1;
                        this.tempAdjacency[j][i] = 1;
                        this.degree[i]++;
                        this.degree[j]++;
                    }
                }
                repaint();
                this.cs = CanvasState.CREATE_EDGE;
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean setGraph() {
        boolean result = false;
        if (this.graph != null
                && this.tempPosition != null
                && this.tempProbability != null
                && this.tempAdjacency != null
                && this.tempProbability.length == this.tempPosition.length
                && this.tempAdjacency.length == this.tempPosition.length
                && this.tempAdjacency[0].length == this.tempPosition.length) {
            this.graph.setPosition(tempPosition.clone());
            this.graph.setProbabilitasVertex(tempProbability.clone());
            this.graph.setAdjacency(tempAdjacency.clone());
            this.cs = CanvasState.TRANSFORM;
            result = true;
        }
        return result;
    }

    public boolean resetGraph() {
        boolean result = false;
        if (this.graph != null) {
            this.tempPosition = null;
            this.tempProbability = null;
            this.tempAdjacency = null;
            this.degree = null;
            this.ACOsolution = null;
            this.ACOcost = -1;
            this.output = null;
            this.grid = new int[this.graph.getNumGridX()][this.graph.getNumGridY()];
            this.cs = CanvasState.TRANSFORM;
            repaint();
            result = true;
        }
        return result;
    }

    public boolean saveGraph(File file) {
        boolean result = false;
        if (this.graph != null && file != null) {
            result = ReadWriteGraph.writeToFile(file, this.graph);
        }
        return result;
    }

    public boolean openGraph(File file) {
        boolean result = false;
        Graph graph = ReadWriteGraph.readFromFile(file);
        if (graph != null) {
            this.graph = graph;
            this.grid = new int[this.graph.getNumGridX()][this.graph.getNumGridY()];
            this.tempPosition = graph.getPosition();
            this.tempProbability = graph.getProbabilitasVertex();
            this.tempAdjacency = graph.getAdjacency();
            for (int i = 0; i < this.tempPosition.length; i++) {
                int x = this.tempPosition[i].x;
                int y = this.tempPosition[i].y;
                this.grid[x][y] = 1;
            }
            this.degree = new int[this.tempPosition.length];
            for (int i = 0; i < -1 + this.tempAdjacency.length; i++) {
                for (int j = 1 + i; j < this.tempAdjacency[i].length; j++) {
                    if (this.tempAdjacency[i][j] == 1 || this.tempAdjacency[j][i] == 1) {
                        this.degree[i]++;
                        this.degree[j]++;
                    }
                }
            }
            repaint();
            result = true;
        }
        return result;
    }

    public boolean method() {
        boolean result = false;

        return result;
    }

    private CanvasState originalState = CanvasState.TRANSFORM;

    public String switchCanvasState() {
        String result = "free transform";
        if (this.cs != CanvasState.TRANSFORM) {
            this.originalState = this.cs;
            this.cs = CanvasState.TRANSFORM;
        } else {
            this.cs = this.originalState;
            this.originalState = CanvasState.TRANSFORM;
        }
        if (this.originalState == CanvasState.TRANSFORM) {
            result = "free transform";
        } else if (this.originalState == CanvasState.CREATE_EDGE) {
            result = "create edge";
        } else if (this.originalState == CanvasState.CREATE_VERTEX) {
            result = "create vertex";
        } else if (this.originalState == CanvasState.SET_PROBABILITY) {
            result = "set probability";
        }
        return result;
    }

    public void setView(boolean vVertex, boolean vProbability, boolean vDegree, boolean hideEdge) {
        this.infoVertex = vVertex;
        this.infoProbability = vProbability;
        this.infoDegree = vDegree;
        this.hideEdge = hideEdge;
    }

    public boolean runACO() {
        boolean status = false;
        if (graph != null && parameters != null) {
            try {
                Point[] position = graph.getPosition();
                float[] probabilitasVertex = graph.getProbabilitasVertex();
                int[][] adjacency = graph.getAdjacency();
                float Q = parameters.getQ();
                float alpha = parameters.getAlpha();
                float beta = parameters.getBeta();
                int m = parameters.getM();
                float rho = parameters.getRho();
                float tho = parameters.getTho();
                int NCmax = parameters.getNCMAX();
                GraphACO graphACO = new GraphACO(position, probabilitasVertex, adjacency, Q, alpha, beta, m, rho, tho, NCmax);
                this.ACOsolution = graphACO.ACOsolution;
                this.ACOcost = graphACO.ACOcost;
                this.output = new Output(this.ACOsolution, this.ACOcost, this.parameters, this.graph);
                this.degreeSolution = new int[position.length];
                for (int k = 0; k < this.ACOsolution.length; k++) {
                    int i = (int) this.ACOsolution[k][0];
                    int j = (int) this.ACOsolution[k][1];
                    this.degreeSolution[i]++;
                    this.degreeSolution[j]++;
                }
                JOptionPane.showMessageDialog(null, "Active cost: " + (this.ACOcost));
                repaint();
                status = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return status;
    }

    public String resultToString() {
        StringBuffer sb = new StringBuffer();
        if (this.output != null) {
            Graph graph = this.output.getGraph();
            Parameters parameters = this.output.getParameters();
            Point[] position = graph.getPosition();
            float[] probabilitasVertex = graph.getProbabilitasVertex();
            int[][] adjacency = graph.getAdjacency();
            float Q = parameters.getQ();
            float alpha = parameters.getAlpha();
            float beta = parameters.getBeta();
            int m = parameters.getM();
            float rho = parameters.getRho();
            float tho = parameters.getTho();
            int NCmax = parameters.getNCMAX();
            float[][] ACOsolution = this.output.getACOsolution();
            float ACOcost = this.output.getACOcost();
            /*write result*/
            sb.append("R E S U L T\n");
            if (ACOcost >= 0) {
                sb.append("Active cost: " + (ACOcost) + "\n\n");
            }
            sb.append("Probabilistic Minimum Spanning Tree\n");
            if (ACOsolution != null) {
                for (int i = 0; i < ACOsolution.length; i++) {
                    sb.append("edge: " + ((int) ACOsolution[i][0]) + "-" + ((int) ACOsolution[i][1]) + " weight: " + (ACOsolution[i][2]) + "\n");
                }
            }
            sb.append("\n\nP A R A M E T E R S\n");
            sb.append("Q     : " + (Q) + "\n");
            sb.append("alpha : " + (alpha) + "\n");
            sb.append("beta  : " + (beta) + "\n");
            sb.append("m     : " + (m) + "\n");
            sb.append("rho   : " + (rho) + "\n");
            sb.append("tho   : " + (tho) + "\n");
            sb.append("ncMAX : " + (NCmax) + "\n");

            sb.append("\n\nG R A P H\n");
            sb.append("Position\n");
            if (position != null && probabilitasVertex != null) {
                for (int i = 0; i < position.length; i++) {
                    sb.append("vertex-" + (i) + "(" + (position[i].x) + "," + (position[i].y) + ") probability: " + (probabilitasVertex[i]) + "\n");
                }
            }
            sb.append("\nadjacency\n");
            if (adjacency != null) {
                for (int i = 0; i < adjacency.length; i++) {
                    for (int j = 0; j < adjacency[i].length; j++) {
                        if (j > 0) {
                            sb.append(" ");
                        }
                        sb.append(adjacency[i][j]);
                    }
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    public String infoToString() {
        StringBuffer sb = new StringBuffer();
        if (this.tempPosition == null && this.tempProbability == null && this.tempAdjacency == null) {
            sb.append("Belum ada info graph");
        } else {
            if (this.tempPosition != null && this.tempProbability != null) {
                sb.append("VERTEX\n");
                for (int i = 0; i < this.tempPosition.length; i++) {
                    sb.append("V" + (i) + "(" + ((int) this.tempPosition[i].x) + "," + ((int) this.tempPosition[i].y) + ") probability: " + (this.tempProbability[i]) + "\n");
                }
            }
            if (this.tempPosition != null && this.tempAdjacency != null) {
                sb.append("\nEDGE\n");
                for (int i = 0; i < -1 + this.tempAdjacency.length; i++) {
                    for (int j = 1 + i; j < this.tempAdjacency[i].length; j++) {
                        if (this.tempAdjacency[i][j] == 1 || this.tempAdjacency[j][i] == 1) {
                            int x1 = this.tempPosition[i].x;
                            int y1 = this.tempPosition[i].y;
                            int x2 = this.tempPosition[j].x;
                            int y2 = this.tempPosition[j].y;
                            float w = (float) Math.sqrt(Math.pow(((double) (x1 - x2)), 2) + (Math.pow(((double) (y1 - y2)), 2)));
                            sb.append("edge: V" + (i) + "-V" + (j) + " weight: " + (w) + "\n");
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    private class Handler implements MouseListener, MouseMotionListener, MouseWheelListener {

        private int lastOffsetX;
        private int lastOffsetY;

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            if (cs == CanvasState.TRANSFORM) {
                if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
                    scale -= (0.1 * e.getWheelRotation());
                    scale = Math.max(0.00001, scale);
                    repaint();
                }
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (cs == CanvasState.TRANSFORM) {
                // new x and y are defined by current mouse location subtracted
                // by previously processed mouse location
                int newX = e.getX() - lastOffsetX;
                int newY = e.getY() - lastOffsetY;

                // increment last offset to last processed by drag event.
                lastOffsetX += newX;
                lastOffsetY += newY;

                // update the canvas locations
                translateX += newX;
                translateY += newY;

                // schedule a repaint.
                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            //xPos	= -1;
            //yPos	= -1;
            xPos = e.getX();
            yPos = e.getY();
            repaint();

        }

        @Override
        public void mouseClicked(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            xPos = e.getX();
            yPos = e.getY();
            repaint();

        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (cs == CanvasState.TRANSFORM) {
                // capture starting point
                lastOffsetX = e.getX();
                lastOffsetY = e.getY();
            } else if (cs == CanvasState.CREATE_VERTEX) {
                if (grid != null) {
                    int x0 = e.getX();
                    int y0 = e.getY();
                    double translateX0 = translateX;
                    double translateY0 = translateY;
                    double scale0 = scale;
                    int gridSize = graph.getGridSize();
                    int x1 = (int) Math.round((x0 - translateX0) / scale0);
                    int y1 = (int) Math.round((y0 - translateY0) / scale0);
                    for (int i = 0; i < grid.length; i++) {
                        if (((gridSize * i) <= x1) && (x1 <= (gridSize * (1 + i)))) {
                            for (int j = 0; j < grid[i].length; j++) {
                                if (((gridSize * j) <= y1) && (y1 <= (gridSize * (1 + j)))) {
                                    if (grid[i][j] == 0) {
                                        grid[i][j] = 1;
                                    } else if (grid[i][j] == 1) {
                                        grid[i][j] = 0;
                                    }
                                    //generateCompleteGraph();
                                    break;
                                }
                            }
                            repaint();
                            break;
                        }
                    }
                }
            } else if (cs == CanvasState.SET_PROBABILITY) {
                if (tempPosition != null && tempProbability != null && grid != null && tempPosition.length == tempProbability.length) {
                    int x0 = e.getX();
                    int y0 = e.getY();
                    int gridSize = graph.getGridSize();
                    double translateX0 = translateX;
                    double translateY0 = translateY;
                    double scale0 = scale;
                    int x1 = (int) Math.round((x0 - translateX0) / scale0);
                    int y1 = (int) Math.round((y0 - translateY0) / scale0);
                    for (int i = 0; i < grid.length; i++) {
                        if (((gridSize * i) <= x1) && (x1 <= (gridSize * (1 + i)))) {
                            for (int j = 0; j < grid[i].length; j++) {
                                if (((gridSize * j) <= y1) && (y1 <= (gridSize * (1 + j)))) {
                                    int x = i;
                                    int y = j;
                                    for (int k = 0; k < tempPosition.length; k++) {
                                        if (tempPosition[k].x == x && tempPosition[k].y == y) {
                                            //Object result = JOptionPane.showInputDialog(null, "0.1");
                                            String result = JOptionPane.showInputDialog(null, "masukkan nilai probabilitas vetex_" + k + "", "input probability", JOptionPane.WARNING_MESSAGE);
                                            try {
                                                float value = Float.parseFloat(result.trim());
                                                if (0.0f <= value && value <= 1.0f) {
                                                    tempProbability[k] = value;
                                                }
                                            } catch (Exception e1) {
                                                e1.printStackTrace();
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            } else if (cs == CanvasState.CREATE_EDGE) {
                /*periksa apakah (x,y) merupakan koordinat dari salah satu vertex dalam graph*/
                if (tempPosition != null && grid != null) {
                    int x0 = e.getX();
                    int y0 = e.getY();
                    int gridSize = graph.getGridSize();
                    double translateX0 = translateX;
                    double translateY0 = translateY;
                    double scale0 = scale;
                    int x1 = (int) Math.round((x0 - translateX0) / scale0);
                    int y1 = (int) Math.round((y0 - translateY0) / scale0);
                    for (int i = 0; i < grid.length; i++) {
                        if (((gridSize * i) <= x1) && (x1 <= (gridSize * (1 + i)))) {
                            for (int j = 0; j < grid[i].length; j++) {
                                if (((gridSize * j) <= y1) && (y1 <= (gridSize * (1 + j)))) {
                                    int x = i;
                                    int y = j;
                                    Point p1 = new Point(x, y);
                                    for (int k = 0; k < tempPosition.length; k++) {
                                        if (tempPosition[k].x == p1.x && tempPosition[k].y == p1.y) {
                                            if (iVo == -1) {
                                                iVo = k;
                                            } else if (iVo == k) {
                                                iVo = -1;
                                            } else {
                                                if (tempAdjacency[iVo][k] == 1 || tempAdjacency[k][iVo] == 1) {
                                                    tempAdjacency[iVo][k] = 0;
                                                    tempAdjacency[k][iVo] = 0;
                                                    degree[iVo]--;
                                                    degree[k]--;
                                                    iVo = -1;
                                                } else {
                                                    tempAdjacency[iVo][k] = 1;
                                                    tempAdjacency[k][iVo] = 1;
                                                    degree[iVo]++;
                                                    degree[k]++;
                                                    iVo = -1;
                                                }
                                                repaint();
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            /**/
        }

    }

}
