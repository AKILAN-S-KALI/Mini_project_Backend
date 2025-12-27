package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.CustomerReturn;

public interface CustomerReturnService {
    CustomerReturn saveCustomerReturn(CustomerReturn customerReturn);
    List<CustomerReturn> getAllCustomerReturns();
    CustomerReturn getCustomerReturnById(Long id);
    CustomerReturn updateCustomerReturn(Long id,CustomerReturn customerReturn);
    void deleteCutomerReturn(Long id);    
}
