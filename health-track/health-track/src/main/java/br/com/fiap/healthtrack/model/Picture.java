package br.com.fiap.healthtrack.model;

import javax.persistence.*;

@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String uriPicture;


    public Picture(String uriPicture) {
        this.uriPicture = uriPicture;
    }

    public Picture() {
    }

    public String getUriPicture() {
        return uriPicture;
    }

    public void setUriPicture(String uriPicture) {
        this.uriPicture = uriPicture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
