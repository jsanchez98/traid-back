package app.controller;

import app.TraderDTO;
import app.TraderNotFoundException;
import app.model.Greeting;
import app.model.Message;
import app.model.Trader;
import app.repository.TraderRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    private static TraderRepository traderRepository;

    GreetingController(TraderRepository traderRepository){
        this.traderRepository = traderRepository;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) throws Exception {
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()));
    }

    @MessageMapping("/traders")
    @SendTo("/topic/traders")
    public TraderDTO returnTrader(Message message) throws Exception {
        Long id = Long.valueOf(1);

        Trader trader = traderRepository.findById(id)
                .orElseThrow(() -> new TraderNotFoundException(id));

        return new TraderDTO(trader);
    }
}
