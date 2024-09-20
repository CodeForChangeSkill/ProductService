package com.codeforchangeskill.ProductService.Service;

import com.codeforchangeskill.ProductService.Entity.Product;
import com.codeforchangeskill.ProductService.Model.ProductRequest;
import com.codeforchangeskill.ProductService.Repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product..");
      //create object from product entity using builder
        Product product
                    =Product.builder()
                    .productName(productRequest.getName())
                    .quantity(productRequest.getQuantity())
                    .price(productRequest.getPrice())
                    .build();
        //save button to pass this value to database
        productRepository.save(product);
        log.info("Product Created");
        return 0;

    }
}
