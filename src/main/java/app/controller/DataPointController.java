package app.controller;

import app.exception.PolygonNotFoundException;
import app.model.DataPoint;
import app.model.PolygonResponse;
import app.repository.DataPointRepository;
import app.repository.PolygonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DataPointController {
    @Autowired
    PolygonRepository polygonRepository;
    @Autowired
    DataPointRepository dataPointRepository;

    @GetMapping("/{ticker}/timeseries")
    public ResponseEntity<List<DataPoint>> getAllDataPointsByTickerName(@PathVariable String ticker){

        PolygonResponse polygon = polygonRepository.findByTicker(ticker);
        if(polygon == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<DataPoint> datapoints = new ArrayList<>(polygon.getResults());

        return new ResponseEntity<>(datapoints, HttpStatus.OK);
    }
}
