package restapi.controller;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import restapi.entity.Lokasi;
import restapi.repository.LokasiRepository;
import restapi.springboot_restful_endpoints.SpringbootRestfulEndpointsApplication;

@SpringBootTest(classes = SpringbootRestfulEndpointsApplication.class)
@AutoConfigureMockMvc
public class LokasiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LokasiRepository lokasiRepository;

    @InjectMocks
    private LokasiController lokasiController;

    private Lokasi lokasi;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(lokasiController).build();
        lokasi = new Lokasi();
        lokasi.setId(1);
        lokasi.setNamaLokasi("Bandung");
        lokasi.setNegara("Indonesia");
        lokasi.setProvinsi("Jawa Barat");
        lokasi.setKota("Bandung");
    }

    @Test
    public void testGetAllLokasi() throws Exception {
        when(lokasiRepository.findAll()).thenReturn(Arrays.asList(lokasi));

        mockMvc.perform(get("/api/lokasi"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].namaLokasi").value("Bandung"));
    }

    @Test
    public void testGetLokasiById() throws Exception {
        when(lokasiRepository.findById(1)).thenReturn(Optional.of(lokasi));

        mockMvc.perform(get("/api/lokasi/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.namaLokasi").value("Bandung"));
    }

    @Test
    public void testCreateLokasi() throws Exception {
        when(lokasiRepository.save(any(Lokasi.class))).thenReturn(lokasi);

        mockMvc.perform(post("/api/lokasi")
                .contentType("application/json")
                .content("{\"namaLokasi\": \"Bandung\", \"negara\": \"Indonesia\", \"provinsi\": \"Jawa Barat\", \"kota\": \"Bandung\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.namaLokasi").value("Bandung"));
    }

    @Test
    public void testUpdateLokasi() throws Exception {
        when(lokasiRepository.findById(1)).thenReturn(Optional.of(lokasi));
        when(lokasiRepository.save(any(Lokasi.class))).thenReturn(lokasi);

        mockMvc.perform(put("/api/lokasi/1")
                .contentType("application/json")
                .content("{\"namaLokasi\": \"Jakarta\", \"negara\": \"Indonesia\", \"provinsi\": \"DKI Jakarta\", \"kota\": \"Jakarta\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.namaLokasi").value("Jakarta"));
    }

    @Test
    public void testDeleteLokasi() throws Exception {
        doNothing().when(lokasiRepository).deleteById(1);

        mockMvc.perform(delete("/api/lokasi/1"))
                .andExpect(status().isOk());
    }
}

