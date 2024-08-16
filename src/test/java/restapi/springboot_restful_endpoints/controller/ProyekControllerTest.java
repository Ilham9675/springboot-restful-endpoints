package restapi.springboot_restful_endpoints.controller;


import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import restapi.springboot_restful_endpoints.entity.Proyek;
import restapi.springboot_restful_endpoints.service.ProyekService;

class ProyekControllerTest {

    @Mock
    private ProyekService service;

    @InjectMocks
    private ProyekController controller;

    private MockMvc mockMvc;
    private Proyek proyek;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        proyek = new Proyek();
        proyek.setId(1);
        proyek.setNamaProyek("Proyek A");
        proyek.setClient("Client A");
        proyek.setTglMulai(LocalDateTime.now());
        proyek.setTglSelesai(LocalDateTime.now().plusDays(10));
        proyek.setPimpinanProyek("Pimpinan A");
        proyek.setKeterangan("Keterangan A");
    }

    @Test
    void testGetAllProyek() throws Exception {
        when(service.getAllProyek()).thenReturn(Arrays.asList(proyek));
        mockMvc.perform(get("/proyek"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].namaProyek").value("Proyek A"));
        verify(service, times(1)).getAllProyek();
    }

    @Test
    void testGetProyekById() throws Exception {
        when(service.getProyekById(1)).thenReturn(proyek);
        mockMvc.perform(get("/proyek/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.namaProyek").value("Proyek A"));
        verify(service, times(1)).getProyekById(1);
    }

    @Test
    void testCreateProyek() throws Exception {
        when(service.saveProyek(any(Proyek.class))).thenReturn(proyek);
        mockMvc.perform(post("/proyek")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"namaProyek\":\"Proyek A\",\"client\":\"Client A\",\"tglMulai\":\"2024-08-16T14:05:50\",\"tglSelesai\":\"2024-08-26T14:05:50\",\"pimpinanProyek\":\"Pimpinan A\",\"keterangan\":\"Keterangan A\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.namaProyek").value("Proyek A"));
        verify(service, times(1)).saveProyek(any(Proyek.class));
    }

    @Test
    void testDeleteProyek() throws Exception {
        doNothing().when(service).deleteProyek(1);
        mockMvc.perform(delete("/proyek/1"))
                .andExpect(status().isOk());
        verify(service, times(1)).deleteProyek(1);
    }
}
