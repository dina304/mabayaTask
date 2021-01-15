package com.mabaya.task;

import com.mabaya.task.dto.Product;
import com.mabaya.task.model.Category;
import com.mabaya.task.model.DataConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {

		populateData();
		SpringApplication.run(TaskApplication.class, args);
	}

	private static void populateData() {
		Product products[]= {new Product("p1", Category.SHOES.getId(),12.1),
		new Product("p2", Category.SMARTPHONE.getId(),100.3),
		new Product("p3", Category.TSHIRTS.getId(),10.1),
		new Product("p4", Category.SMARTPHONE.getId(),800.1),
		new Product("p5", Category.SHOES.getId(),25.5)};
		for (Product p :products){
			DataConnector.products.put(p.getId(),p);
		}
	}

}
