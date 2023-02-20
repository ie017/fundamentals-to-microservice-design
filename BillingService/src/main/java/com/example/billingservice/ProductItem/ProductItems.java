package com.example.billingservice.ProductItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductItems {
    private Collection<ProductItem> productItemCollection;
}
