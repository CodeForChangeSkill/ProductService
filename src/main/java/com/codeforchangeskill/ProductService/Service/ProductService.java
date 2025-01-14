package com.codeforchangeskill.ProductService.Service;

import com.codeforchangeskill.ProductService.Model.ProductRequest;
import com.codeforchangeskill.ProductService.Model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);
}
