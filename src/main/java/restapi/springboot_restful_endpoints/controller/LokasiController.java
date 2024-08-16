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

import restapi.springboot_restful_endpoints.entity.Lokasi;
import restapi.springboot_restful_endpoints.service.LokasiService;


@RestController
@RequestMapping("/lokasi")
public class LokasiController {
    @Autowired
    private LokasiService lokasiService;
    
    @GetMapping
    public List<Lokasi> getAllLokasi() {
        return lokasiService.getAllLokasi();
    }
    
    @GetMapping("/{id}")
    public Lokasi getLokasiById(@PathVariable Long id) {
        return lokasiService.getLokasiById(id);
    }
    
    @PostMapping
    public Lokasi createLokasi(@RequestBody Lokasi lokasi) {
        return lokasiService.saveLokasi(lokasi);
    }
    
    @PutMapping("/{id}")
    public Lokasi updateLokasi(@PathVariable Long id, @RequestBody Lokasi lokasi) {
        lokasi.setId(id);
        return lokasiService.saveLokasi(lokasi);
    }
    
    @DeleteMapping("/{id}")
    public void deleteLokasi(@PathVariable Long id) {
        lokasiService.deleteLokasi(id);
    }
}

