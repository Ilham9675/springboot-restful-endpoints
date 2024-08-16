package restapi.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restapi.entity.Lokasi;
import restapi.model.CreateLokasi;
import restapi.model.LokasiResponse;
import restapi.repository.LokasiRepository;

@Service
public class LokasiService {

    @Autowired
    private LokasiRepository lokasiRepository;

    public LokasiResponse create(CreateLokasi request) {
        Lokasi lokasi = new Lokasi();
        lokasi.setNamaLokasi(request.getNamaLokasi());
        lokasi.setNegara(request.getNegara());
        lokasi.setProvinsi(request.getProvinsi());
        lokasi.setKota(request.getKota());
        lokasi.setCreatedAt(Timestamp.valueOf(request.getCreatedAt()));
        lokasi.setUpdateAt(Timestamp.valueOf(request.getCreatedAt()));  // Assuming same timestamp for creation and update

        Lokasi savedLokasi = lokasiRepository.save(lokasi);

        LokasiResponse response = new LokasiResponse();
        response.setId(savedLokasi.getId());
        response.setNamaLokasi(savedLokasi.getNamaLokasi());
        response.setNegara(savedLokasi.getNegara());
        response.setProvinsi(savedLokasi.getProvinsi());
        response.setKota(savedLokasi.getKota());
        response.setCreatedAt(savedLokasi.getCreatedAt().toString());

        return response;
    }
}
