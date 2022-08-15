package app.controller;

import app.exception.PolygonNotFoundException;
import app.model.DataPoint;
import app.model.PolygonResponse;
import app.repository.DataPointRepository;
import app.repository.PolygonRepository;
import app.utils.Requests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class DataPointController {
    @Autowired
    PolygonRepository polygonRepository;
    @Autowired
    DataPointRepository dataPointRepository;
    @Autowired
    private Requests requests;

    private static final Logger log = LoggerFactory.getLogger(SpringBootApplication.class);

    @GetMapping("/{ticker}/timeseries")
    public ResponseEntity<List<DataPoint>> getAllDataPointsByTickerName(@PathVariable String ticker){

        log.info("reached0");
        if(!polygonRepository.existsPolygonResponseByTicker(ticker) ){
            ResponseEntity<PolygonResponse> res = requests.getPolygon(ticker);
            if(res.getStatusCode().is2xxSuccessful()) {
                res.getBody().getResults().forEach(dp -> dp.setPolygonResponse(res.getBody()));
                polygonRepository.save(res.getBody());
            } else {
                return new ResponseEntity<>(res.getStatusCode());
            }
        }

        log.info("reached4");
        PolygonResponse polygon = polygonRepository.findByTicker(ticker);
        if(polygon == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<DataPoint> datapoints = new ArrayList<>(polygon.getResults());
        log.info("reached5");
        return new ResponseEntity<>(datapoints, HttpStatus.OK);
    }
}
