package com.example.billingservice.ProductItem;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ProductItemRepository extends MongoRepository<ProductItem, Long> {
    public Collection<ProductItem> findByBillId(Long id);
}
