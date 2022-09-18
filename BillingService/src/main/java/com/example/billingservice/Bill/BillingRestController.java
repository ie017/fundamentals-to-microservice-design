package com.example.billingservice.Bill;

import com.example.billingservice.Customer.CustomerRestClient;
import com.example.billingservice.Product.ProductItemRestClient;
import com.example.billingservice.ProductItem.ProductItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BillingRestController {
    private ProductItemRepository productItemRepository;
    private ProductItemRestClient productItemRestClient;
    private BillRepository billRepository;
    private CustomerRestClient customerRestClient;
    @GetMapping(path = "/bills/{id}")
    public Bill getBill(@PathVariable(name = "id") String id){
        return billRepository.findById(id).get();
    }

}
