package restapi.springboot_restful_endpoints.controller;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import restapi.springboot_restful_endpoints.entity.Lokasi;
import restapi.springboot_restful_endpoints.service.LokasiService;

@WebMvcTest(LokasiController.class)
@ExtendWith(MockitoExtension.class)
public class LokasiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LokasiService lokasiService;

    @InjectMocks
    private LokasiController lokasiController;

    private Lokasi lokasi;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(lokasiController).build();
        lokasi = new Lokasi();
        lokasi.setId(1L);
        lokasi.setNamaLokasi("Lokasi A");
        lokasi.setNegara("Indonesia");
        lokasi.setProvinsi("Jawa Barat");
        lokasi.setKota("Bandung");
    }

    @Test
    public void testGetAllLokasi() throws Exception {
        when(lokasiService.getAllLokasi()).thenReturn(Arrays.asList(lokasi));

        mockMvc.perform(get("/lokasi")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].namaLokasi", is(lokasi.getNamaLokasi())));
    }

    @Test
    public void testGetLokasiById() throws Exception {
        when(lokasiService.getLokasiById(1L)).thenReturn(lokasi);

        mockMvc.perform(get("/lokasi/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(lokasi.getId().intValue())))
                .andExpect(jsonPath("$.namaLokasi", is(lokasi.getNamaLokasi())));
    }

    @Test
    public void testCreateLokasi() throws Exception {
        when(lokasiService.saveLokasi(any(Lokasi.class))).thenReturn(lokasi);

        mockMvc.perform(post("/lokasi")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(lokasi)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.namaLokasi", is(lokasi.getNamaLokasi())));
    }

    @Test
    public void testUpdateLokasi() throws Exception {
        when(lokasiService.saveLokasi(any(Lokasi.class))).thenReturn(lokasi);

        mockMvc.perform(put("/lokasi/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(lokasi)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.namaLokasi", is(lokasi.getNamaLokasi())));
    }

    @Test
    public void testDeleteLokasi() throws Exception {
        doNothing().when(lokasiService).deleteLokasi(1L);

        mockMvc.perform(delete("/lokasi/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(lokasiService, times(1)).deleteLokasi(1L);
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
