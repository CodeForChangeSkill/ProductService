package com.codeforchangeskill.ProductService.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;

   @Column(name ="Product_Name")
     private String productName;
    @Column(name ="Price")
    private long price;
    @Column(name ="Quantity")
    private long quantity;
}
