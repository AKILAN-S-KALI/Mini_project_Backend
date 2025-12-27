package com.examly.springapp.service;

import java.util.List;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.CustomerReturn;
import com.examly.springapp.repository.CustomerReturnRepo;

@Service
public class CustomerReturnServiceImpl implements CustomerReturnService {

    @Autowired
    private CustomerReturnRepo customerReturnRepo;

    @Override
    public CustomerReturn saveCustomerReturn(CustomerReturn customerReturn) {
        return customerReturnRepo.save(customerReturn);        

    }

    @Override
    public List<CustomerReturn> getAllCustomerReturns() {
        return customerReturnRepo.findAll();

    }

    @Override
    public CustomerReturn getCustomerReturnById(Long id) {
        return customerReturnRepo.findById(id)
                                    .orElseThrow(() -> new ResourceNotFoundException("CustomerReturn not found with id " + id));

    }

    @Override
    public CustomerReturn updateCustomerReturn(Long id, CustomerReturn customerReturn) {

        CustomerReturn existingReturn = getCustomerReturnById(id);
        existingReturn.setReturnDate(customerReturn.getReturnDate());
        existingReturn.setQuantity(customerReturn.getQuantity());
        existingReturn.setReason(customerReturn.getReason());
        existingReturn.setProduct(customerReturn.getProduct());
        return customerReturnRepo.save(existingReturn);
    }

    @Override
    public void deleteCutomerReturn(Long id) {
        CustomerReturn customerReturn = getCustomerReturnById(id);
        customerReturnRepo.delete(customerReturn);

    }
    
}
