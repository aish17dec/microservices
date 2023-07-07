package com.example.customerservice.controller;

import com.example.customerservice.entity.Customer;
import com.example.customerservice.entity.Order;
import com.example.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path ="/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<Customer> getCustomerDetails(@RequestParam Integer customerId){
        Customer c = customerService.getCustomerDetails(customerId);

        HashMap<String, Integer> params = new HashMap<>();
        params.put("id",customerId);
        List<Order> orders = restTemplate.getForEntity("http://OrderService/orders?id={id}",List.class,params).getBody();
        c.setOrders(orders);

        return new ResponseEntity<>(c, HttpStatus.OK);
    }
}
