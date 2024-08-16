package restapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreateLokasi {
    
    private String namaLokasi;
    private String negara;
    private String provinsi;
    private String kota;
    private String createdAt;

    

}
