package br.com.fiap.healthtrack.controller.form;

import br.com.fiap.healthtrack.model.Profile;
import br.com.fiap.healthtrack.model.User;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class ProfileForm {

    @NotNull @NotEmpty
    private String name;

    @NotNull @NotEmpty
    private String biograph;

    @NotNull @NotEmpty
    private String uriProfileImg;

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

    public Profile conversor() {
        return new Profile(name, biograph, uriProfileImg);
    }
}
