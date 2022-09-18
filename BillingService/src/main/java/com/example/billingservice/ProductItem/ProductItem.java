package com.example.billingservice.ProductItem;

import com.example.billingservice.Bill.Bill;
import com.example.billingservice.Product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class ProductItem {
    @Id
    private String id;
    private double quantity;
    private double price;
    private Long productId;
    private Bill bill;
    @JsonIgnore
    private Product product;
}
