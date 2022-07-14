package br.com.fiap.healthtrack.controller;

import br.com.fiap.healthtrack.controller.dto.ProfileDto;
import br.com.fiap.healthtrack.controller.form.ProfileForm;
import br.com.fiap.healthtrack.controller.form.UpdateProfileForm;
import br.com.fiap.healthtrack.model.Profile;
import br.com.fiap.healthtrack.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    @Cacheable(value = "profilesList")
    public Page<ProfileDto> profiles(@RequestParam(required = false) String name,
                                     @PageableDefault(page = 0, size = 10,
                                             sort = "id", direction = Sort.Direction.ASC) Pageable pageable){

        if (name != null) {
            Page<Profile> profiles = profileRepository.findByName(name, pageable);
            return ProfileDto.conversor(profiles);
        } else {
            Page<Profile> profiles = profileRepository.findAll(pageable);
            return ProfileDto.conversor(profiles);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProfileDto> createProfile(@RequestBody @Valid ProfileForm profileForm,
                                                    UriComponentsBuilder uriComponentsBuilder){
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
    public ResponseEntity<ProfileDto> update(@PathVariable Long id,
                                             @RequestBody @Valid UpdateProfileForm updateProfileForm){

        Optional<Profile> optionalProfile = profileRepository.findById(id);

        if (optionalProfile.isPresent()){
            Profile profile = updateProfileForm.update(id, profileRepository);
            return ResponseEntity.ok(new ProfileDto(profile));
        } else {
            return ResponseEntity.notFound().build();
        }


    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity remove(@PathVariable Long id){

        Optional<Profile> profile = profileRepository.findById(id);

        if (profile.isPresent()) {
            profileRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}