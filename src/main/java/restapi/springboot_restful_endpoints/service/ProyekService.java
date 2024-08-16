package restapi.springboot_restful_endpoints.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restapi.springboot_restful_endpoints.entity.Proyek;
import restapi.springboot_restful_endpoints.repository.ProyekRepository;


@Service
public class ProyekService {
    @Autowired
    private ProyekRepository repository;

    public List<Proyek> getAllProyek() {
        return repository.findAll();
    }

    public Proyek getProyekById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Proyek saveProyek(Proyek proyek) {
        return repository.save(proyek);
    }

    public void deleteProyek(Integer id) {
        repository.deleteById(id);
    }
}
   


