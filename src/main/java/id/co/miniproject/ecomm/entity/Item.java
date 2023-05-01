package id.co.miniproject.ecomm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "[nama] cannot be blank")
    private String nama;

    @NotNull(message = "[harga] cannot be blank")
    private int harga;

    @NotNull(message = "[stok] cannot be blank")
    private int stok;
}
