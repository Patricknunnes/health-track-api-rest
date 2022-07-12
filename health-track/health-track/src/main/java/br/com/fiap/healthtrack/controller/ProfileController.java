package br.com.fiap.healthtrack.controller;

import br.com.fiap.healthtrack.controller.dto.ProfileDto;
import br.com.fiap.healthtrack.controller.form.ProfileForm;
import br.com.fiap.healthtrack.controller.form.UpdateProfileForm;
import br.com.fiap.healthtrack.model.Profile;
import br.com.fiap.healthtrack.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping
    public List<ProfileDto> profiles(String name){
        if (name != null) {
            List<Profile> profiles = profileRepository.findByName(name);
            return ProfileDto.conversor(profiles);
        } else {
            List<Profile> profiles = profileRepository.findAll();
            return ProfileDto.conversor(profiles);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProfileDto> createProfile(@RequestBody @Valid ProfileForm profileForm, UriComponentsBuilder uriComponentsBuilder){
        Profile profile = profileForm.conversor();
        profileRepository.save(profile);

        URI uri = uriComponentsBuilder.path("/profiles/{id}").buildAndExpand(profile.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProfileDto(profile));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDto> detailProfile(@PathVariable Long id){

        Optional<Profile> profile = profileRepository.findById(id);

        if (profile.isPresent()) {
            return ResponseEntity.ok(new ProfileDto(profile.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProfileDto> update(@PathVariable Long id, @RequestBody @Valid UpdateProfileForm updateProfileForm){
        Profile profile = updateProfileForm.update(id, profileRepository);

        return ResponseEntity.ok(new ProfileDto(profile));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity remove(@PathVariable Long id){

        profileRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}