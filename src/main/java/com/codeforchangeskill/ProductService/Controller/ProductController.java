package com.codeforchangeskill.ProductService.Controller;

import com.codeforchangeskill.ProductService.Model.ProductRequest;
import com.codeforchangeskill.ProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Handles the HTTP POST request to add a new product.
     *
     * @param productRequest the request containing product details such as name, price, and quantity
     * @return a ResponseEntity containing the unique ID of the newly created product, along with an HTTP status code of CREATED
     */
    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {

        long productId = productService.addProduct(productRequest);
        //send the data pack to client request
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }



}
