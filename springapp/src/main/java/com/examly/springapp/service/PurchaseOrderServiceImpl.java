package com.examly.springapp.service;

import java.util.List;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.PurchaseOrder;
import com.examly.springapp.repository.PurchaseOrderRepo;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepo purchaseOrderRepo;

    @Override
    public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepo.save(purchaseOrder);

    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepo.findAll();

    }

    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
        return purchaseOrderRepo.findById(id)
                            .orElseThrow(()-> new ResourceNotFoundException("PurchaseOder not found with id: " + id));
    }

    @Override
    public PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder purchaseOrder) {
        PurchaseOrder existingOrder = getPurchaseOrderById(id);
        existingOrder.setOrderNumber(purchaseOrder.getOrderNumber());
        existingOrder.setOrderDate(purchaseOrder.getOrderDate());
        existingOrder.setStatus(purchaseOrder.getStatus());
        existingOrder.setSupplier(purchaseOrder.getSupplier());

        return purchaseOrderRepo.save(existingOrder);

    }

    @Override
    public void deletePurchaseOrder(Long id) {
        PurchaseOrder purchaseOrder = getPurchaseOrderById(id);
        purchaseOrderRepo.delete(purchaseOrder);

        

    }
    
}
