package app.model;

import app.model.DataPoint;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tickers")
@JsonIgnoreProperties(ignoreUnknown=true)
public class PolygonResponse {

    @Column(unique=true)
    private @Id @GeneratedValue Long id;

    @Column(unique=true)
    private String ticker;

    @Column(name="adjusted")
    private boolean adjusted;

    @Column(name="queryCount")
    private int queryCount;

    @OneToMany(mappedBy="polygonResponse", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DataPoint> results = new ArrayList<>();

    @Column(name="resultsCount")
    private int resultsCount;

    @Column(name="status")
    private String status;

    public void addDataPoint(DataPoint dataPoint){
        this.results.add(dataPoint);
        dataPoint.setPolygonResponse(this);
    }

    public PolygonResponse() {
    }

    public boolean isAdjusted() {
        return adjusted;
    }

    public void setAdjusted(boolean adjusted) {
        this.adjusted = adjusted;
    }

    public int getQueryCount() {
        return queryCount;
    }

    public void setQueryCount(int queryCount) {
        this.queryCount = queryCount;
    }

    public List<DataPoint> getResults() {
        return results;
    }

    public void setResults(List<DataPoint> results) {
        this.results = results;
    }

    public int getResultsCount() {
        return resultsCount;
    }

    public void setResultsCount(int resultsCount) {
        this.resultsCount = resultsCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    @Override
    public String toString() {
        return "PolygonResponse{" + "ticker: " + ticker + '}';
    }
}
