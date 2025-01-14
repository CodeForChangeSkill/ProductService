package com.codeforchangeskill.ProductService.Model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private String productName;
    private Long productId;
    private long quantity;
    private long price;
}
