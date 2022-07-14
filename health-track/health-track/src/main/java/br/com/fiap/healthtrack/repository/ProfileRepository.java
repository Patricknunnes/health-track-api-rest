package br.com.fiap.healthtrack.repository;

import br.com.fiap.healthtrack.model.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Page<Profile> findByName(String name, Pageable pageable);
}