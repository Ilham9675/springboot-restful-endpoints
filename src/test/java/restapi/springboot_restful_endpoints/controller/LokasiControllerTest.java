package restapi.springboot_restful_endpoints.controller;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;


import restapi.springboot_restful_endpoints.entity.Lokasi;
import restapi.springboot_restful_endpoints.service.LokasiService;

@ExtendWith(MockitoExtension.class)
public class LokasiControllerTest {

    @Mock
    private LokasiService lokasiService;

    @InjectMocks
    private LokasiController lokasiController;

    @Test
    public void testGetAllLokasi() {
        List<Lokasi> lokasiList = new ArrayList<>();
        lokasiList.add(new Lokasi());
        lokasiList.add(new Lokasi());

        when(lokasiService.getAllLokasi()).thenReturn(lokasiList);

        List<Lokasi> result = lokasiController.getAllLokasi();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetLokasiById() {
        Lokasi lokasi = new Lokasi();
        lokasi.setId(1L);

        when(lokasiService.getLokasiById(1L)).thenReturn(lokasi);

        Lokasi result = lokasiController.getLokasiById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId().longValue());
    }

    @Test
    public void testCreateLokasi() {
        Lokasi lokasi = new Lokasi();
        lokasi.setNamaLokasi("Lokasi A");

        when(lokasiService.saveLokasi(lokasi)).thenReturn(lokasi);

        Lokasi result = lokasiController.createLokasi(lokasi);
        assertNotNull(result);
        assertEquals("Lokasi A", result.getNamaLokasi());
    }

    @Test
    public void testUpdateLokasi() {
        Lokasi lokasi = new Lokasi();
        lokasi.setId(1L);
        lokasi.setNamaLokasi("Lokasi B");

        when(lokasiService.saveLokasi(lokasi)).thenReturn(lokasi);

        Lokasi result = lokasiController.updateLokasi(1L, lokasi);
        assertNotNull(result);
        assertEquals("Lokasi B", result.getNamaLokasi());
    }

    @Test
    public void testDeleteLokasi() {
        Long id = 1L;
        lokasiController.deleteLokasi(id);
        verify(lokasiService, times(1)).deleteLokasi(id);
    }
}


