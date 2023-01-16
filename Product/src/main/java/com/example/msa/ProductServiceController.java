package com.example.msa;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@SpringBootApplication
@RequestMapping("/msa")
public class ProductServiceController {

	private static Map<String, Product> productDatabase = new HashMap();
	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productDatabase.put(honey.getId(), honey);
		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		productDatabase.put(almond.getId(), almond);
	}

	public Object delete(String id) {
		productDatabase.remove(id);
		return "Product is deleted successsfully";
	}

	public Object updateProduct(String id, Product product) {
		productDatabase.remove(id);
		product.setId(id);
		productDatabase.put(id, product);
		return "Product is updated successsfully";
	}

	public Object createProduct(Product product) {
		productDatabase.put(product.getId(), product);
		return "Product is created successfully";
	}

	@RequestMapping(value = "/products/{id}", method=RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable("id") String id) {
		Product product=productDatabase.get(id);
		ResponseEntity<Product> returnValues=new ResponseEntity<Product>(product,HttpStatus.OK);
		//return productDatabase.get(id);
		return returnValues;
	}

	public Object getProduct() {
		return productDatabase.values();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceController.class, args);
	}

}
