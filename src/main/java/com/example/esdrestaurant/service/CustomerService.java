package com.example.esdrestaurant.service;

import com.example.esdrestaurant.dto.CustomerRequest;
import com.example.esdrestaurant.dto.CustomerResponse;
import com.example.esdrestaurant.entity.Customer;
import com.example.esdrestaurant.mapper.CustomerMapper;
import com.example.esdrestaurant.repo.CustomerRepo;
import com.example.esdrestaurant.exception.CustomerNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;
    public String createCustomer(CustomerRequest request) {
        Customer customer = customerMapper.toCustomer(request);
        customerRepo.save(customer);
        return "Customer created Successfully";
    }
    public CustomerResponse retrieveCustomer(String email) {
        Customer customer = getCustomer(email);
        return customerMapper.toCustomerResponse(customer);
    }
    private Customer getCustomer(String email) {
        return customerRepo.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update Customer:: No customer found with the provided ID:: %s", email)
                ));
    }
}
