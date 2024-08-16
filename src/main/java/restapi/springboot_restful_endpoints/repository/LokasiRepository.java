package restapi.springboot_restful_endpoints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restapi.springboot_restful_endpoints.entity.Lokasi;

@Repository
public interface LokasiRepository extends JpaRepository<Lokasi, Long> {
}

