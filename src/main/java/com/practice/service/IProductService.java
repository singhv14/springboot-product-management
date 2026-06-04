package com.practice.service;

import com.practice.entity.Product;

import java.util.List;

public interface IProductService {

    String saveProduct(Product product);

    Iterable<Product> saveMultipleProducts(Iterable<Product> products);

    Iterable<Product> getAllProducts();

    Iterable<Product> getAllProductsByIds(List<Integer> ids);

    Product getProductById(Integer id);

    Boolean isProductAvailable(Integer id);

    Long getTotalProductsCount();

    String deleteProductById(Integer id);

    String deleteProductsByIds(List<Integer> ids);

    // 1. Search by id using getReferenceById (faster than findById)
    Product searchProductById(Integer id);

    // 2. Search multiple by ids - returns List not Iterable this time
    List<Product> searchProductsByIds(Iterable<Integer> ids);

    // 3. Search by example object
    List<Product> searchProductsByProduct(Product product);

    // 4. Delete using normal deleteAllById (one query per id)
    String deleteProductsByIdsCrud(List<Integer> ids);

    // 5. Delete using batch (ONE query for all ids - faster!)
    String deleteProductsByIdsBatch(List<Integer> ids);
}
