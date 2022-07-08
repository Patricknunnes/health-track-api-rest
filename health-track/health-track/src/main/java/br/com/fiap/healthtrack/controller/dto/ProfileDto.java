package br.com.fiap.healthtrack.controller.dto;

import br.com.fiap.healthtrack.model.Profile;

import java.util.List;
import java.util.stream.Collectors;

public class ProfileDto {

    private long id;

    private String name;

    private String uriProfileImg;

    public ProfileDto(Profile profile){
        this.id = profile.getId();
        this.name = profile.getName();
        this.uriProfileImg = profile.getUriProfileImg();
    }


    public static List<ProfileDto> conversor(List<Profile> profiles) {
        return profiles.stream().map(ProfileDto::new).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUriProfileImg() {
        return uriProfileImg;
    }
}
