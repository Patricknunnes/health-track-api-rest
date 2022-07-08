package br.com.fiap.healthtrack.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String biograph;

    private String uriProfileImg;

    public Profile(String name, String biograph, String uriProfileImg) {
        this.name = name;
        this.biograph = biograph;
        this.uriProfileImg = uriProfileImg;
    }

    public Profile() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiograph() {
        return biograph;
    }

    public void setBiograph(String biograph) {
        this.biograph = biograph;
    }

    public String getUriProfileImg() {
        return uriProfileImg;
    }

    public void setUriProfileImg(String uriProfileImg) {
        this.uriProfileImg = uriProfileImg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
