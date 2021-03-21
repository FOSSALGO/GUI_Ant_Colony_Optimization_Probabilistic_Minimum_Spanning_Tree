package util;

public class Parameters {

    private float Q;
    private float alpha;
    private float beta;
    private int m;
    private float rho;
    private float tho;
    private int ncMAX;

    public Parameters() {
        super();
    }

    public Parameters(float q, float alpha, float beta, int m, float rho, float tho, int ncMAX) {
        super();
        Q = q;
        this.alpha = alpha;
        this.beta = beta;
        this.m = m;
        this.rho = rho;
        this.tho = tho;
        this.ncMAX = ncMAX;
    }

    public float getQ() {
        return Q;
    }

    public float getAlpha() {
        return alpha;
    }

    public float getBeta() {
        return beta;
    }

    public int getM() {
        return m;
    }

    public float getRho() {
        return rho;
    }

    public float getTho() {
        return tho;
    }

    public int getNCMAX() {
        return ncMAX;
    }

    public void setQ(float q) {
        Q = q;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public void setBeta(float beta) {
        this.beta = beta;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setRho(float rho) {
        this.rho = rho;
    }

    public void setTho(float tho) {
        this.tho = tho;
    }

    public void setNCMAX(int ncMAX) {
        this.ncMAX = ncMAX;
    }

}
