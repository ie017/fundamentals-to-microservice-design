package com.example.billingservice.Bill;

import com.example.billingservice.Customer.Customer;
import com.example.billingservice.ProductItem.ProductItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Date;
@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class Bill {
    @Id
    private String id;
    private Date billingDate;
    @JsonIgnore /* Pour éviter le bouclage il faut ajouter cette annotation */
    private Collection<ProductItem> productItems;
    private Long customerId;
    @JsonIgnore
    private Customer customer;

    public Bill(Date billingDate, Collection<ProductItem> productItems, Long customerId, Customer customer) {
        this.billingDate = billingDate;
        this.productItems = productItems;
        this.customerId = customerId;
        this.customer = customer;
    }
}
