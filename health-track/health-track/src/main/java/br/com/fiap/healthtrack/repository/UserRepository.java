package br.com.fiap.healthtrack.repository;

import br.com.fiap.healthtrack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}