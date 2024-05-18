package com.myorg.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myorg.rest.webservices.restfulwebservices.post.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "user_details")
public class User {

    protected User(){

    }

    @Id
    @GeneratedValue
    private Integer id;
    @Size(min=2, message = "Name should have at least 2 characters. ")
    private String name;

    @Past(message = "Birthdate should be in the past")
    private LocalDateTime birthDate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;


    public User(Integer id, String name, LocalDateTime birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
