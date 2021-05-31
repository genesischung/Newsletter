package myzhong.com.newsletter.models;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="suscriber")
public class Subscriber {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String email;
    private String name;

    public Subscriber(String email, String name){
        this.email = email;
        this.name = name;
    }

    public Subscriber() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
