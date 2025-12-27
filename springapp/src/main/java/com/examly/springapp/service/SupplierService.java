package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Supplier;

public interface SupplierService {
    Supplier saveSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();
    Supplier getSupplierById(long id);
    Supplier updateSupplier(Long id,Supplier supplier);
    void deleteSupplier(Long id);

}
