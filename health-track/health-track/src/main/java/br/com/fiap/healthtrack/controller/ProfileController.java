package br.com.fiap.healthtrack.controller;

import br.com.fiap.healthtrack.controller.dto.ProfileDto;
import br.com.fiap.healthtrack.model.Picture;
import br.com.fiap.healthtrack.model.Profile;
import br.com.fiap.healthtrack.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProfileController {

    @RequestMapping("/profiles")
    public List<ProfileDto> profiles(){
        Profile profile = new Profile("Patrick", "19y", "" );


        return ProfileDto.conversor(Arrays.asList(profile, profile, profile));
    }
}
