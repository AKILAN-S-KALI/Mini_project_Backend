package com.examly.springapp.service;

import java.util.List;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Supplier;
import com.examly.springapp.repository.SupplierRepo;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);

    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();

    }
    @Override
    public Supplier getSupplierById(long id) {
        return supplierRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Supplier not Found with Id " + id));
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier supplier) {
        Supplier existingSupplier = getSupplierById(id);
        existingSupplier.setSupplierName(supplier.getSupplierName());
        existingSupplier.setContactNumber(supplier.getContactNumber());
        existingSupplier.setEmail(supplier.getEmail());
        existingSupplier.setAddress(supplier.getAddress());
        return supplierRepo.save(existingSupplier);

    }

    @Override
    public void deleteSupplier(Long id) {
        Supplier supplier = getSupplierById(id);
        supplierRepo.delete(supplier);

    }

    
}
