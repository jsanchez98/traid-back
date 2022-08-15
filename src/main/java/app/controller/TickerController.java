package app.controller;

import app.model.Ticker;
import app.repository.TickerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class TickerController {
    @Autowired
    TickerRepository tickerRepository;

    @GetMapping("/getAll")
    public ResponseEntity<List<Ticker>> getAllTickers(){

        Iterable<Ticker> tickerIterable = tickerRepository.findAll();
        List<Ticker> all = iterableToList(tickerIterable);

        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/getTickerByMarket/{market}")
    public ResponseEntity<List<Ticker>> getTickerByMarket(@PathVariable String market){

        if(!checkMarketList(market)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Iterable<Ticker> tickerIterableByMarket = tickerRepository.findByMarket(market);
        List<Ticker> allByMarket = iterableToList(tickerIterableByMarket);

        if (allByMarket.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(allByMarket, HttpStatus.OK);
    }

    private <T> List<T> iterableToList(Iterable<T> iterable){
        return StreamSupport
                .stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    /**
     * Validate user's query for security
     * @param market
     * @return
     */
    private boolean checkMarketList(String market){
        return market.equals("stocks") || market.equals("crypto") ||
                market.equals("fx") || market.equals("otc");
    }

}
