package br.com.fiap.healthtrack.controller;

import br.com.fiap.healthtrack.controller.dto.ProfileDto;
import br.com.fiap.healthtrack.model.Profile;
import br.com.fiap.healthtrack.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @RequestMapping("/profiles")
    public List<ProfileDto> profiles(){
        List<Profile> profiles = profileRepository.findAll();

        return ProfileDto.conversor(profiles);
    }
}