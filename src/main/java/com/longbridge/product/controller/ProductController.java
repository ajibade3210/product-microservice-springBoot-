package com.longbridge.product.controller;

import com.longbridge.product.dto.Product;
import com.longbridge.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/product")
public class ProductController {

    //Replace By Slf4j
   //private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

//    You can use the below code or Autowire above productservice declaration above
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/save")
    ResponseEntity<Product> addProduct(@RequestBody Product product) {
       String  status = productService.addProduct(product);
        log.info("Product addes status = {}", status);
        return  ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/list")
    List<Product> productList(){
        return productService.listAllProducts();
    }

    @GetMapping("{category}")
    List<Product> productCategoryList(@PathVariable("category") String category) {
        System.out.println(category);
    return productService.productCategoryList(category);
    }

    @GetMapping("id/{id}")
    Product productById(@PathVariable("id") Integer id) {
        System.out.println(id);
    return productService.productById(id);
    }

    @PutMapping("/update")
    String updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    String deleteProductById(@PathVariable Integer id){
        return  productService.deleteProductById(id);
    }
}
