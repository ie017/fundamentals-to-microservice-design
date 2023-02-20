package com.example.billingservice;

import com.example.billingservice.Bill.Bill;
import com.example.billingservice.Bill.BillRepository;
import com.example.billingservice.Customer.Customer;
import com.example.billingservice.Customer.CustomerRestClient;
import com.example.billingservice.Product.Product;
import com.example.billingservice.Product.ProductItemRestClient;
import com.example.billingservice.ProductItem.ProductItem;
import com.example.billingservice.ProductItem.ProductItemRepository;
import com.example.billingservice.ProductItem.ProductItems;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients /* Il est très important d'activer OpenFeign pour spring détecter les deux
interfaces qui on a */
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner doIt(BillRepository billRepository, ProductItemRepository productItemRepository,
                           CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient){
        return args -> {
            for (int page = 1; page < 10; page++){
                Customer customer = customerRestClient.getCustomerById(Integer.toUnsignedLong(page));
                Bill bill = new Bill(new Date(),null,customer.getId(),null);
                PagedModel<Product> pagedModel = productItemRestClient.pageProducts(page-1, 6);
                ProductItems productItems = new ProductItems(new ArrayList<>());
                pagedModel.forEach(product->{
                    ProductItem productItem = new ProductItem();
                    productItem.setId(product.getId());
                    productItem.setName(product.getName());
                    productItem.setBill(bill);
                    productItem.setPrice(product.getPrice());
                    productItem.setQuantity(product.getQuantity());
                    productItemRepository.save(productItem);
                    productItems.getProductItemCollection().add(productItem);
                });
                bill.setProductItems(productItems.getProductItemCollection());
                billRepository.save(bill);
            }
        };
    }
}
