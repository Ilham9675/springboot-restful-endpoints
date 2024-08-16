package restapi.springboot_restful_endpoints.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restapi.springboot_restful_endpoints.entity.Lokasi;
import restapi.springboot_restful_endpoints.repository.LokasiRepository;

@Service
public class LokasiService {
    @Autowired
    private LokasiRepository lokasiRepository;
    
    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }
    
    public Lokasi getLokasiById(Long id) {
        return lokasiRepository.findById(id).orElse(null);
    }
    
    public Lokasi saveLokasi(Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }
    
    public void deleteLokasi(Long id) {
        lokasiRepository.deleteById(id);
    }
}

