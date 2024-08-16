package restapi.springboot_restful_endpoints.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restapi.springboot_restful_endpoints.entity.Proyek;
@Repository
public interface ProyekRepository extends JpaRepository<Proyek, Integer> {
}

