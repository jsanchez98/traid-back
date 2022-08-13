package app;

import app.model.Trader;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class TraderModelAssembler implements RepresentationModelAssembler<Trader, EntityModel<Trader>> {
    @Override
    public EntityModel<Trader> toModel(Trader trader){
        return EntityModel.of(trader);
    }
}
