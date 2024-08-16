package restapi.springboot_restful_endpoints.service;



import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import restapi.springboot_restful_endpoints.service.ProyekService;

class ProyekServiceTest {

    @Mock
    private restapi.springboot_restful_endpoints.repository.ProyekRepository repository;

    @InjectMocks
    private ProyekService service;

    private restapi.springboot_restful_endpoints.entity.Proyek proyek;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        proyek = new restapi.springboot_restful_endpoints.entity.Proyek();
        proyek.setId(1);
        proyek.setNamaProyek("Proyek A");
        proyek.setClient("Client A");
        proyek.setTglMulai(LocalDateTime.now());
        proyek.setTglSelesai(LocalDateTime.now().plusDays(10));
        proyek.setPimpinanProyek("Pimpinan A");
        proyek.setKeterangan("Keterangan A");
    }

    @Test
    void testGetAllProyek() {
        when(repository.findAll()).thenReturn(Arrays.asList(proyek));
        List<restapi.springboot_restful_endpoints.entity.Proyek> proyekList = service.getAllProyek();
        assertEquals(1, proyekList.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetProyekById() {
        when(repository.findById(1)).thenReturn(Optional.of(proyek));
        restapi.springboot_restful_endpoints.entity.Proyek foundProyek = service.getProyekById(1);
        assertNotNull(foundProyek);
        assertEquals(proyek.getNamaProyek(), foundProyek.getNamaProyek());
        verify(repository, times(1)).findById(1);
    }

    @Test
    void testSaveProyek() {
        when(repository.save(proyek)).thenReturn(proyek);
        restapi.springboot_restful_endpoints.entity.Proyek savedProyek = service.saveProyek(proyek);
        assertNotNull(savedProyek);
        assertEquals(proyek.getNamaProyek(), savedProyek.getNamaProyek());
        verify(repository, times(1)).save(proyek);
    }

    @Test
    void testDeleteProyek() {
        doNothing().when(repository).deleteById(1);
        service.deleteProyek(1);
        verify(repository, times(1)).deleteById(1);
    }
}