package app.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.security.SecureRandom;

@Entity
public class Trader {
    private @Id @GeneratedValue Long id;
    private String username;
    private String name;
    private String password_hash;

    Trader(){}

    public Trader(String name, String username, String password){
        this.name = name;
        this.username = username;

        int strength = 10;
        this.password_hash = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }
}