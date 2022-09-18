package com.example.billingservice.ProductItem;

import lombok.Data;

import java.util.Collection;

@Data
public class ProductItems {
    private Collection<ProductItem> productItemCollection;
}
