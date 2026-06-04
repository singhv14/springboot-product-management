package com.practice;

import com.practice.entity.Product;
import com.practice.service.IProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ProductappApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext container = SpringApplication.run(ProductappApplication.class, args);
		IProductService service = container.getBean(IProductService.class);

		Product product = new Product(101,"Laptop", 175000.0, 10);
		Product product1 = new Product(52,"Mobile", 82500.0, 5);
		Product product2 = new Product(214,"Watch", 12300.5, 8);
		Product product3 = new Product(12,"CPU", 125000.0, 12);
		Product product4 = new Product(10,"Monitor", 23235.5, 12);

		service.saveProduct(product);

		List<Product> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);

		service.saveMultipleProducts(products).forEach(System.out::println);

//		service.getAllProducts().forEach(System.out::println);
//
//		List<Integer> ids = Arrays.asList(52, 101);
//		service.getAllProductsByIds(ids).forEach(System.out::println);
//
//		System.out.println(service.getProductById(101));
//
//		System.out.println(service.isProductAvailable(101));  // true
//		System.out.println(service.isProductAvailable(999));  // false
//
//		System.out.println("Total: " + service.getTotalProductsCount());
//
//		System.out.println(service.deleteProductById(52));
//
//		List<Integer> deleteIds = Arrays.asList(101, 214);
//		System.out.println(service.deleteProductsByIds(deleteIds));




// 1. getReferenceById
		System.out.println("-- getReferenceById --");
		System.out.println(service.searchProductById(52));

// 2. findAllById returns List
		System.out.println("-- searchByIds --");
		List<Integer> searchIds = Arrays.asList(52, 101);
		service.searchProductsByIds(searchIds)
				.forEach(System.out::println);

// 3. Search by Example
		System.out.println("-- searchByExample --");
		Product sample = new Product(null, "Electronics", null, null);
		service.searchProductsByProduct(sample)
				.forEach(System.out::println);
// finds ALL products where category = Electronics!

// 4. Delete using normal deleteAllById
		System.out.println("-- deleteByIdsCrud --");
		List<Integer> crudDeleteIds = Arrays.asList(12);
		System.out.println(service.deleteProductsByIdsCrud(crudDeleteIds));

// 5. Delete using batch
		System.out.println("-- deleteByIdsBatch --");
		List<Integer> batchDeleteIds = Arrays.asList(52, 214);
		System.out.println(service.deleteProductsByIdsBatch(batchDeleteIds));

// verify remaining
		System.out.println("-- remaining products --");
		service.getAllProducts().forEach(System.out::println);


	}

}
