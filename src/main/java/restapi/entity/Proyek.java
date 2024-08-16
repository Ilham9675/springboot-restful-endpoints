package restapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proyek")

public class Proyek {

    private int id;
    
    private String nama_proyek;

    private String client;

    private String tgl_mulai;

    private String tgl_selesai;

    private String pimpinan_proyek;

    private String keterangan;

    private String creatad_at;

    private String update_at;

}
