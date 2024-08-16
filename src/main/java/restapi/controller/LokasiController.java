package restapi.controller;

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

import restapi.entity.Lokasi;
import restapi.repository.LokasiRepository;



@RestController
@RequestMapping("/api/lokasi")
public class LokasiController {

    @Autowired
    private LokasiRepository lokasiRepository;

    @GetMapping
    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }

    @PostMapping
    public Lokasi createLokasi(@RequestBody Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    @GetMapping("/{id}")
    public Lokasi getLokasiById(@PathVariable int id) {
        return lokasiRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Lokasi updateLokasi(@PathVariable int id, @RequestBody Lokasi lokasiDetails) {
        Lokasi lokasi = lokasiRepository.findById(id).orElse(null);
        if (lokasi != null) {
            lokasi.setNamaLokasi(lokasiDetails.getNamaLokasi());
            lokasi.setNegara(lokasiDetails.getNegara());
            lokasi.setProvinsi(lokasiDetails.getProvinsi());
            lokasi.setKota(lokasiDetails.getKota());
            lokasi.setCreatedAt(lokasiDetails.getCreatedAt());
            lokasi.setUpdateAt(lokasiDetails.getUpdateAt());
            return lokasiRepository.save(lokasi);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteLokasi(@PathVariable int id) {
        lokasiRepository.deleteById(id);
    }
}
