package com.longbridge.product.service;

import com.longbridge.product.ProductRepository;
import com.longbridge.product.dto.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    List<Product> products = new ArrayList<>();
    public String addProduct(Product product) {
        log.info("adding product");
        productRepository.save(product);
        return "success";
    }

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> productCategoryList(String category) {
    return productRepository.findByCategory(category);
    }

    public Product productById(Integer id) {
        return productRepository.findById(id).get();
        //when you return by id it returns the optional hence use .get()
    }

    public String updateProduct(Product product) {
                productRepository.save(product);
                return "product updated successful";
    }

    public String deleteProductById(Integer id) {
        productRepository.deleteById(id);
        return "product deleted.";
    }
}
