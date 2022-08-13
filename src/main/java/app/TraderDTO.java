package app;

import app.model.Trader;
import org.springframework.hateoas.RepresentationModel;

public class TraderDTO extends RepresentationModel<TraderDTO> {
    private long id;
    private String username;
    private String name;

    public TraderDTO(Trader trader){
        this.id = trader.getId();
        this.username = trader.getUsername();
        this.name = trader.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\''
                + ", username='" + this.username
                + '\'' + '}';
    }
}