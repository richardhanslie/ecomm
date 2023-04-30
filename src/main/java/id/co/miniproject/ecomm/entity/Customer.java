package id.co.miniproject.ecomm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "[name] cannot be blank")
    private String nama;
    @NotBlank(message = "[name] cannot be blank")
    private String username;
    @NotBlank(message = "[name] cannot be blank")
    @Size(min = 6, max = 12)
    private String password;
    @NotBlank(message = "[name] cannot be blank")
    @Size(min = 16)
    private String nomor_ktp;
    @NotBlank(message = "[name] cannot be blank")
    private String alamat;
}
