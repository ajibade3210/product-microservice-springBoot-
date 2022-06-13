package com.longbridge.product;


import com.longbridge.product.dto.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

    //Custom queries can esily be created using respository.
    //Using the @Query to create implementation at run time.
    //Query from Category.name and return list of Products
    @Query("{'Category.name':?0}")
    List<Product> findByCategory(String category);
}
