package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.CustomerReturn;
import com.examly.springapp.service.CustomerReturnService;

@RestController
@RequestMapping("/api/customer-returns")
public class CustomerReturnController {

    @Autowired
    private CustomerReturnService customerReturnService;

    @PostMapping
    public ResponseEntity<CustomerReturn> createCustomerReturn(@RequestBody CustomerReturn customerReturn)
    {
        CustomerReturn saveCustomerReturn = customerReturnService.saveCustomerReturn(customerReturn);
        return new ResponseEntity<>(saveCustomerReturn,HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CustomerReturn>> getAllCustomerReturns()
    {  
        List<CustomerReturn> customerReturns = customerReturnService.getAllCustomerReturns();
        return new ResponseEntity<>(customerReturns,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerReturn> getCustomerReturnById(@PathVariable Long id)
    {
        CustomerReturn customerReturn = customerReturnService.getCustomerReturnById(id);
        return new ResponseEntity<>(customerReturn,HttpStatus.OK);

    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CustomerReturn> updateCustomerReturn(@PathVariable Long id,@RequestBody CustomerReturn customerReturn)
    {
        CustomerReturn updateCustomerReturn = customerReturnService.updateCustomerReturn(id, customerReturn);
        return  new ResponseEntity<>(updateCustomerReturn,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerReturn(@PathVariable Long id)
    {
        customerReturnService.deleteCutomerReturn(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    } 

    
}
