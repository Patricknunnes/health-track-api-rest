package br.com.fiap.healthtrack.repository;

import br.com.fiap.healthtrack.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}