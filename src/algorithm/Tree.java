package algorithm;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    /*parameter input*/
    private float[][] edges = null;/*pasangan vertex dan bobotnya: [vi|vj|weight]*/
    private float[] pVertices = null;/*peluang vertex*/

 /*output*/
    float cost = Float.MAX_VALUE;/*biaya*/
    float Lk = Float.MAX_VALUE;// length of ant tour

    public Tree(float[][] edges, float[] pVertices) {
        super();
        /*validasi input*/
        if (edges.length == pVertices.length - 1 && edges[0].length == 3) {
            this.pVertices = pVertices;
            this.edges = edges;
        } else {
            System.out.println("Input tidak valid");
        }
        if (edges != null && pVertices != null) {
            this.cost = this.evaluateCost();
        }
    }

    public float evaluateCost() {
        float cost = 0;
        try {
            if (this.pVertices != null && this.edges != null) {
                float sum_ce = 0;
                for (int i = 0; i < edges.length; i++) {
                    int v0 = (int) edges[i][0];
                    int v1 = (int) edges[i][1];
                    float weight = edges[i][2];
                    float ce = weight;
                    boolean[] isClosed = new boolean[this.edges.length];/*initial value of isClosed[i]=false untuk semua i=0,1,2,3,....*/
                    Queue<Point> vertexQueue = new LinkedList<Point>();
                    Point left = new Point(v0, 0);
                    Point right = new Point(v1, 1);
                    vertexQueue.offer(left);
                    vertexQueue.offer(right);
                    float pKe = 1.0f - pVertices[v0];
                    float pV_Ke = 1.0f - pVertices[v1];
                    int nEdge = 1;
                    isClosed[i] = true;
                    while (nEdge < edges.length && !vertexQueue.isEmpty()) {
                        Point parent = vertexQueue.poll();
                        for (int j = 0; j < edges.length; j++) {
                            if (!isClosed[j]) {
                                int v2 = (int) edges[j][0];
                                int v3 = (int) edges[j][1];
                                if (parent.x == v2) {
                                    if (parent.y == 0) {
                                        pKe *= (1.0f - pVertices[v3]);
                                    } else if (parent.y == 1) {
                                        pV_Ke *= (1.0f - pVertices[v3]);
                                    }
                                    Point child = new Point(v3, parent.y);
                                    vertexQueue.offer(child);
                                    isClosed[j] = true;
                                    nEdge++;
                                } else if (parent.x == v3) {
                                    if (parent.y == 0) {
                                        pKe *= (1.0f - pVertices[v2]);
                                    } else if (parent.y == 1) {
                                        pV_Ke *= (1.0f - pVertices[v2]);
                                    }
                                    Point child = new Point(v2, parent.y);
                                    vertexQueue.offer(child);
                                    isClosed[j] = true;
                                    nEdge++;
                                }

                            }
                        }
                    }
                    pKe = (1.0f - pKe);
                    pV_Ke = (1.0f - pV_Ke);

                    sum_ce += (weight * pKe * pV_Ke);
                    this.Lk += weight;
                    /*System.out.println("w: "+(weight)+", Ke: "+(pKe)+", V-Ke: "+(pV_Ke));*/

                }/*end of for i*/
                cost = sum_ce;
            } else {
                System.out.println("Kesalahan pada parameter input");
            }
        } catch (Exception e) {
            System.out.println("GAGAL melakukan evaluasi biaya...");
            e.printStackTrace();
        }
        return cost;
    }

}
