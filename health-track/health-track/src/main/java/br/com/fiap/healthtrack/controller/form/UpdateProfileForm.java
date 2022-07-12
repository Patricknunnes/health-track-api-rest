package br.com.fiap.healthtrack.controller.form;

import br.com.fiap.healthtrack.model.Profile;
import br.com.fiap.healthtrack.repository.ProfileRepository;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;

public class UpdateProfileForm {

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


    public Profile update(Long id, ProfileRepository profileRepository) {
        Profile profile = profileRepository.getReferenceById(id);
        profile.setName(this.name);
        profile.setBiograph(this.biograph);
        profile.setUriProfileImg(this.uriProfileImg);

        return profile;
    }
}
