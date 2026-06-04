package com.practice.service.implementation;

import com.practice.entity.Product;
import com.practice.repo.IProductRepo;
import com.practice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements IProductService {

    private final IProductRepo repo;

    public ProductServiceImplementation(IProductRepo repo) {
        this.repo = repo;
    }

    @Override
    public String saveProduct(Product product) {
        Product save = repo.save(product);
        if (save != null) {
            return "Product saved successfully";
        }
        return "Product not saved";
    }

    @Override
    public Iterable<Product> saveMultipleProducts(Iterable<Product> products) {
        return repo.saveAll(products);
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public Iterable<Product> getAllProductsByIds(List<Integer> ids) {
        return repo.findAllById(ids);
    }

    @Override
    public Product getProductById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Boolean isProductAvailable(Integer id) {
        return repo.existsById(id);
    }

    @Override
    public Long getTotalProductsCount() {
        return repo.count();
    }

    @Override
    public String deleteProductById(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Product deleted successfully";
        }
        return "Product not found";
    }

    @Override
    public String deleteProductsByIds(List<Integer> ids) {
        Iterable<Product> found = repo.findAllById(ids);
        if (found.iterator().hasNext()) {
            repo.deleteAllById(ids);
            return "Products deleted successfully";
        }
        return "No products found";
    }

    @Override
    public Product searchProductById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Product> searchProductsByIds(Iterable<Integer> ids) {
        return repo.findAllById(ids);
    }

    @Override
    public List<Product> searchProductsByProduct(Product product) {

        Example<Product> example = Example.of(product);
        return repo.findAll(example);
    }

    @Override
    public String deleteProductsByIdsCrud(List<Integer> ids) {
        List<Product> found = repo.findAllById(ids);
        if (!found.isEmpty()) {
            repo.deleteAllById(ids);
            return "Products deleted successfully";
        }
        return "No products found";
    }

    @Override
    public String deleteProductsByIdsBatch(List<Integer> ids) {
        List<Product> found = repo.findAllById(ids);
        if (!found.isEmpty()) {
            repo.deleteAllByIdInBatch(ids); // ← this is the key difference!
            return "Products deleted in batch successfully";
        }
        return "No products found";
    }
}
