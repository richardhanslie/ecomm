package id.co.miniproject.ecomm.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private int id;
    private String nama;
    private int harga;
    private int stok;
}
