package restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restapi.entity.Lokasi;

public interface LokasiRepository extends JpaRepository<Lokasi, Integer> {
}
