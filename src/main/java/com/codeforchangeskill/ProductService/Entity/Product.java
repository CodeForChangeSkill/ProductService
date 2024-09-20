package com.codeforchangeskill.ProductService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ProductId;

   @Column(name ="Product_Name")
    private String productName;
    @Column(name ="Price")
   private long price;
    @Column(name ="Quantity")
    private long quantity;
}
