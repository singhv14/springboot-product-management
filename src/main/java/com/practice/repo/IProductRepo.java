package com.practice.repo;

import com.practice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface IProductRepo extends CrudRepository<Product, Integer> {
//
//}
public interface IProductRepo extends JpaRepository<Product, Integer> {

}
