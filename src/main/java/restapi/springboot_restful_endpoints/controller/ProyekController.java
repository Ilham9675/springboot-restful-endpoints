package restapi.springboot_restful_endpoints.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restapi.springboot_restful_endpoints.entity.Proyek;
import restapi.springboot_restful_endpoints.service.ProyekService;

@RestController
@RequestMapping("/api/proyek")
public class ProyekController {
    @Autowired
    private ProyekService service;

    @GetMapping
    public List<Proyek> getAllProyek() {
        return service.getAllProyek();
    }

    @GetMapping("/{id}")
    public Proyek getProyekById(@PathVariable Integer id) {
        return service.getProyekById(id);
    }

    @PostMapping
    public Proyek createProyek(@RequestBody Proyek proyek) {
        return service.saveProyek(proyek);
    }

    @PutMapping("/{id}")
    public Proyek updateProyek(@PathVariable Integer id, @RequestBody Proyek proyek) {
        proyek.setId(id);
        return service.saveProyek(proyek);
    }

    @DeleteMapping("/{id}")
    public void deleteProyek(@PathVariable Integer id) {
        service.deleteProyek(id);
    }
}



