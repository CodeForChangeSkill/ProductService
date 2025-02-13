package com.codeforchangeskill.ProductService.Service;

import com.codeforchangeskill.ProductService.Entity.Product;
import com.codeforchangeskill.ProductService.Model.ProductRequest;
import com.codeforchangeskill.ProductService.Model.ProductResponse;
import com.codeforchangeskill.ProductService.Repository.ProductRepository;
import com.codeforchangeskill.ProductService.exception.ProductServiceCustomException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

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

    @Override
    public ProductResponse getProductById(long productId) {
        //add logger
        log.info("Get the productid: {}",productId);
        //Now define the Product with findbyId method
        Product product
                =productRepository.findById(productId)/*orElsethrow used here since it thows optional response*/
                //HERE now instead of RUntie we will be using our Customized exception
                //.orElseThrow(()-> new RuntimeException()"Product with given id not found");
                .orElseThrow(()-> new ProductServiceCustomException("Product with given id not found","PRODUCT_NOT_FOUND"));
  //Now suppose we got the product then we need to convert it into Product response format,
  // for that we can use builder pattern or bean util as well to create our object.
        ProductResponse productResponse = new ProductResponse();
        copyProperties(product, productResponse);

        return productResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity)
    {
        log.info("Reduce Quantity {} for id:{}",productId,quantity);
        Product product
                =productRepository.findById(productId)
                .orElseThrow(()-> new ProductServiceCustomException(
                "Product with given id not found",
                        "PRODUCT_NOT_FOUND"
                        ));

        if(product.getQuantity()<quantity) {
            throw new ProductServiceCustomException(
                    "Product does not have sufficient quantity",
                    "INNSUFFICENT_QUANITY");
        }
        product.setQuantity(product.getQuantity()-quantity);
        productRepository.save(product);
        log.info("Product quantity updated successfully");

    }
}
