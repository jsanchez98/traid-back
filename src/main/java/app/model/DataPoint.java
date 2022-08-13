package app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="datapoints")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataPoint {

    private int c;
    private int h;
    private int l;
    private int n;
    private int o;
    @Id
    private Long t;
    private Long v;
    private int vw;

    public DataPoint(){}

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getO() {
        return o;
    }

    public void setO(int o) {
        this.o = o;
    }

    public Long getT() {
        return t;
    }

    public void setT(Long t) {
        this.t = t;
    }

    public Long getV() {
        return v;
    }

    public void setV(Long v) {
        this.v = v;
    }

    public int getVw() {
        return vw;
    }

    public void setVw(int vw) {
        this.vw = vw;
    }
}
