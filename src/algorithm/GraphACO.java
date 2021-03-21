package algorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GraphACO {

    /*Graph attributes*/
    Point[] position = null;/*cx cy*/
    float[] probabilitasVertex = null;
    int[][] adajacency = null;
    float[][] distance = null;
    float[][] eta = null;/*eta	=invers jarak atau visibilitas antar vertex*/

 /*Parameter-parameter Algoritma*/
    int n;
    /*n		=banyaknya vertex*/
    float Q;
    /*Q		=konstanta siklus semut*/
    float alpha;
    /*alpha	=konstanta pengendali intensitas jejak semut*/
    float beta;
    /*beta	=konstanta pengendali visibilitas*/
    int m;
    /*m		=banyaknya semut*/
    float rho;
    /*rho	=tetapan penguapan jejak semut*/
    int NCmax;
    /*NCmax	=jumlah siklus semut*/
    float[][] tho;
    /*tou	=intensitas jejak kaki semut*/

 /*Output*/
    public static float[][] ACOsolution = null;
    public static float ACOcost = Float.MAX_VALUE;

    boolean isInitialized = false;
    private float eL;
    public double deltaTime = Double.MAX_VALUE;

    public GraphACO(Point[] position, float[] probabilitasVertex, int[][] adajacency, float Q, float alpha, float beta, int m, float rho, float tho, int NCmax) {
        super();
        try {
            this.initializeGraph(position, probabilitasVertex, adajacency);
            this.initializeACO(position.length, Q, alpha, beta, m, rho, tho, NCmax);
            isInitialized = true;
            solve();
        } catch (Exception e) {
            System.out.println("GAGAL Melakukan Inisialisasi");
            e.printStackTrace();
        }
    }

    public GraphACO(Point[] position, float[] probabilitasVertex, int[][] adajacency, int n, float Q, float alpha, float beta, int m, float rho, float tho, int NCmax) {
        super();
        try {
            this.initializeGraph(position, probabilitasVertex, adajacency);
            this.initializeACO(n, Q, alpha, beta, m, rho, tho, NCmax);
            isInitialized = true;
            solve();
        } catch (Exception e) {
            System.out.println("GAGAL Melakukan Inisialisasi");
            e.printStackTrace();
        }
    }

    void initializeGraph(Point[] position, float[] probabilitasVertex, int[][] adajacency) {
        /*validasi input*/
        if (position != null
                && probabilitasVertex != null
                && adajacency != null
                && position.length == probabilitasVertex.length
                && position.length == adajacency.length
                && position.length == adajacency[0].length) {
            this.position = position;
            this.probabilitasVertex = probabilitasVertex;
            this.adajacency = adajacency;
            /*inisialisasi jarak/distance dan eta*/
            this.n = position.length;
            this.distance = new float[n][n];
            this.eta = new float[n][n];
            for (int i = 0; i < n; i++) {
                int x1 = position[i].x;
                int y1 = position[i].y;
                for (int j = (1 + i); j < n; j++) {
                    int x2 = position[j].x;
                    int y2 = position[j].y;
                    if (adajacency[i][j] == 1 || adajacency[j][i] == 1) {
                        /*hitung euklidean distance*/
                        float d = (float) Math.sqrt((float) ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));
                        this.distance[i][j] = d;
                        this.distance[j][i] = d;
                        this.eta[i][j] = 1.0f / d;
                        this.eta[j][i] = 1.0f / d;
                    }

                }
            }
        }/*end of validasi input*/
    }/*initialize Graph*/

    void initializeACO(int n, float Q, float alpha, float beta, int m, float rho, float tho, int NCmax) {
        this.n = n;
        this.Q = Q;
        this.alpha = alpha;
        this.beta = beta;
        this.m = m;
        this.rho = rho;
        this.NCmax = NCmax;
        initializeTho(tho, n);
    }

    void initializeTho(float tho, int n) {
        this.tho = new float[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.tho[i][j] = tho;
            }
        }
    }

    static int rndInt(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }

    static float rndFloat(float min, float max) {
        return (float) (min + (max - min) * Math.random());
    }

    void solve() {
        try {
            long t0 = System.currentTimeMillis();
            if (isInitialized) {
                this.ACOsolution = new float[-1 + n][3];
                this.ACOcost = Float.MAX_VALUE;
                for (int nc = 0; nc < this.NCmax; nc++) {/*looping nc*/
                    float[][] semutTerbaik = new float[-1 + n][3];
                    float costSemutTerbaik = Float.MAX_VALUE;
                    float[][] deltaTho = new float[this.n][this.n];
                    for (int iSemut = 0; iSemut < m; iSemut++) {/*looping semut*/
                        float[][] solusi_iSemut = new float[-1 + n][3];
                        float cost_iSemut = Float.MAX_VALUE;
                        int firstOriginalVertex = rndInt(0, (-1 + n));
                        boolean[] isActive = new boolean[n];/*jika isActive bernilai true berarti vertex-i telah berada di dalam tree*/
                        isActive[firstOriginalVertex] = true;
                        /*CONSTRUCT COMPLETE SOLUTION BY ANT*/
                        int numEdge = 0;
                        final int MAX_NUM_EDGE = -1 + n;
                        while (numEdge < MAX_NUM_EDGE) {
                            int numCandidate = (MAX_NUM_EDGE) * (MAX_NUM_EDGE - numEdge);
                            float[][] candidate = new float[numCandidate][4];
                            int k = 0;
                            for (int i = 0; i < n; i++) {
                                if (isActive[i]) {
                                    for (int j = 0; j < n; j++) {
                                        if (!isActive[j] && k < candidate.length && this.adajacency[i][j] > 0) {
                                            candidate[k][0] = i;
                                            candidate[k][1] = j;
                                            candidate[k][2] = this.tho[i][j];
                                            candidate[k][3] = this.eta[i][j];
                                            k++;
                                        }
                                    }
                                }
                            }
                            Point newEdge = setNewEdge(candidate);
                            if (newEdge != null) {
                                int originalVertex = (int) newEdge.x;
                                int destinationVertex = (int) newEdge.y;
                                float[] solusi = {(float) originalVertex, (float) destinationVertex, this.distance[originalVertex][destinationVertex]};
                                solusi_iSemut[numEdge] = solusi.clone();
                                isActive[destinationVertex] = true;
                                numEdge++;
                                /*System.out.print(".");*/
                            }
                        }
                        /*END OF CONSTRUCT COMPLETE SOLUTION BY ANT*/
 /*evaluasi solusi_iSemut*/
                        Tree tree = new Tree(solusi_iSemut, this.probabilitasVertex);
                        cost_iSemut = tree.cost;
                        float Lk = tree.Lk;
                        //System.out.print(" TRACE: Lk: "+(Lk));

                        /*update costSemutTerbaik*/
                        if (cost_iSemut < costSemutTerbaik && cost_iSemut > 0) {
                            semutTerbaik = solusi_iSemut.clone();
                            costSemutTerbaik = cost_iSemut;
                            this.eL = Lk;
                        }

                        /*update delta_tho*/
                        for (int i = 0; i < solusi_iSemut.length; i++) {
                            int original = (int) solusi_iSemut[i][0];
                            int destination = (int) solusi_iSemut[i][1];
                            deltaTho[original][destination] += (this.Q / cost_iSemut);//(this.Q/Lk);
                            deltaTho[destination][original] = deltaTho[original][destination];
                        }
                    }/*end of looping semut*/

 /*update solusi global*/
                    if (costSemutTerbaik < ACOcost && costSemutTerbaik > 0) {
                        ACOcost = costSemutTerbaik;
                        ACOsolution = semutTerbaik.clone();
                    }

                    /*update tho (pheromon global)*/
                    for (int i = 0; i < this.tho.length; i++) {
                        for (int j = 1 + i; j < this.tho[i].length; j++) {
                            if (deltaTho[i][j] > 0) {
                                this.tho[i][j] = (1.0f - this.rho) * this.tho[i][j] + deltaTho[i][j];
                                this.tho[j][i] = this.tho[i][j];
                            }
                        }
                    }
                    /*System.out.println();*/
                    //System.out.println("TRACE - nc: "+(nc)+" , cost: "+(ACOcost));				
                    /*System.out.println("TRACE - nc: "+(nc)+" El: "+eL+" , cost: "+(ACOcost));	*/
                }/*end of looping nc*/
            }/*end of if(isInitialized)*/
            long t1 = System.currentTimeMillis();
            //long t2		= t1-t0;
            double deltaT = t1 - t0;
            this.deltaTime = deltaT / 1000.0;
            //System.out.println("Waktu Komputasi: "+ DecimalFormat.getInstance().format(deltaT / 1000.0f)+ " seconds.");
        } catch (Exception e) {
            System.out.println("GAGAL Memanggil Method solve()");
            e.printStackTrace();
        }
    }

    public Point setNewEdge(float[][] candidate) {
        Point newEdge = null;
        try {
            float[] thoalpha_etabeta = new float[candidate.length];
            float sigma_thoalpha_etabeta = 0;
            for (int i = 0; i < candidate.length; i++) {
                float tho = candidate[i][2];
                float eta = candidate[i][3];
                float thoalpha = (float) Math.pow(tho, this.alpha);
                float etabeta = (float) Math.pow(eta, this.beta);
                float value = thoalpha * etabeta;
                thoalpha_etabeta[i] = value;
                sigma_thoalpha_etabeta += value;
            }

            float[] probabilitas = new float[candidate.length];
            float[] probabilitasKomulatif = new float[candidate.length];
            float sigmaProbabilitasKomulatif = 0;
            for (int i = 0; i < candidate.length; i++) {
                float value = thoalpha_etabeta[i] / sigma_thoalpha_etabeta;
                probabilitas[i] = value;
                sigmaProbabilitasKomulatif += value;
                probabilitasKomulatif[i] = sigmaProbabilitasKomulatif;
            }

            float randomProbabilitas = rndFloat(0.0f, sigmaProbabilitasKomulatif);

            for (int i = 0; i < candidate.length; i++) {
                if (randomProbabilitas <= probabilitasKomulatif[i]) {
                    int originalVertex = (int) candidate[i][0];
                    int destinationVertex = (int) candidate[i][1];
                    newEdge = new Point(originalVertex, destinationVertex);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newEdge;
    }

}
