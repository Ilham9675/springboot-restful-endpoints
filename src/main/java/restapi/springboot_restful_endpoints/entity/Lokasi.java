package restapi.springboot_restful_endpoints.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "lokasi")
public class Lokasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nama_lokasi")
    private String namaLokasi;
    
    @Column(name = "negara")
    private String negara;
    
    @Column(name = "provinsi")
    private String provinsi;
    
    @Column(name = "kota")
    private String kota;
    
    @Column(name = "created_at")
    private Timestamp createdAt;
    
    @Column(name = "update_at")
    private Timestamp updateAt;
    
    
}
