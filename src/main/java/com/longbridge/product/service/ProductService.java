package com.longbridge.product.service;

import com.longbridge.product.dto.Product;
import com.longbridge.product.exception.CurrenyNotValidException;
import com.longbridge.product.exception.OfferNotValidException;
import com.longbridge.product.repository.ProductRepository;
import com.longbridge.product.service.config.ProductConfiguration;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Slf4j  //log
@Service
public class ProductService {

    private ProductRepository productRepository;

    private ProductConfiguration productConfiguration;

    // Comment nd Use Lombok AllArgsConstructor instead
//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    List<Product> products = new ArrayList<>();
    public String addProduct(Product product) {
if(product.getPrice() == 0 && product.getDiscount() > 0) {
    throw new OfferNotValidException("No discount is allowed @ 0 price");
}

//INSTEAD OF HARD CODING THIS
        //WE CREATED A LIST IN APPLICATION>YAML FILE
        //AND A CONFIGURATION CLASS
//List<String> validCurriencies = new ArrayList<>();
//validCurriencies.add("INR");
//validCurriencies.add("USD");
//validCurriencies.add("EUR");
//validCurriencies.add("NG");

if(!productConfiguration.getCurrencies().contains(product.getCurrency().toUpperCase())){
    throw new CurrenyNotValidException("Invalid currency. Valid Currency here: " + productConfiguration.getCurrencies());
}

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

    public Product productById(String id) {
        return productRepository.findById(id).get();
        //when you return by id it returns the optional hence use .get()
    }

    public String updateProduct(Product product) {
                productRepository.save(product);
                return "product updated successful";
    }

    public String deleteProductById(String id) {
        productRepository.deleteById(id);
        return "product deleted.";
    }
}
