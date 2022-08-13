package app.controller;

import app.TraderDTO;
import app.TraderModelAssembler;
import app.TraderNotFoundException;
import app.model.Trader;
import app.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraderController{

    @Autowired
    private final TraderRepository traderRepository;
    private final TraderModelAssembler assembler;

    TraderController(TraderRepository traderRepository, TraderModelAssembler traderModelAssembler){
        this.traderRepository = traderRepository;
        this.assembler = traderModelAssembler;
    }

    @GetMapping("/traders/{id}")
    TraderDTO getById(@PathVariable Long id){
        Trader trader = traderRepository.findById(id)
                .orElseThrow(() -> new TraderNotFoundException(id));

        return new TraderDTO(trader);
    }
}