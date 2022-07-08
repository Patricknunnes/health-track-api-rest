package br.com.fiap.healthtrack.repository;

import br.com.fiap.healthtrack.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}