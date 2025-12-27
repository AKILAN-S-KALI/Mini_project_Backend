package com.examly.springapp.service;

import com.examly.springapp.model.PurchaseOrderItem;
import com.examly.springapp.repository.PurchaseOrderItemRepo;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderItemServiceImpl implements PurchaseOrderItemService {

    @Autowired
    private PurchaseOrderItemRepo purchaseOrderItemRepo;

    @Override
    public PurchaseOrderItem savePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) {
        return purchaseOrderItemRepo.save(purchaseOrderItem);
    }

    @Override
    public List<PurchaseOrderItem> getAllPurchaseOrderItems() {
        return purchaseOrderItemRepo.findAll();
    }

    @Override
    public PurchaseOrderItem getPurchaseOrderItemById(Long id) {
        return purchaseOrderItemRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PurchaseOrderItem not found with id: " + id));
    }

    @Override
    public PurchaseOrderItem updatePurchaseOrderItem(Long id, PurchaseOrderItem purchaseOrderItem) {
        PurchaseOrderItem existingItem = getPurchaseOrderItemById(id);
        existingItem.setQuantity(purchaseOrderItem.getQuantity());
        existingItem.setUnitPrice(purchaseOrderItem.getUnitPrice());
        existingItem.setPurchaseOrder(purchaseOrderItem.getPurchaseOrder());
        existingItem.setProduct(purchaseOrderItem.getProduct());
        return purchaseOrderItemRepo.save(existingItem);
    }

    @Override
    public void deletePurchaseOrderItem(Long id) {
        PurchaseOrderItem item = getPurchaseOrderItemById(id);
        purchaseOrderItemRepo.delete(item);
    }

    @Override
    public List<PurchaseOrderItem> getItemsByPurchaseOrderId(Long purchaseOrderId) {
        return purchaseOrderItemRepo.findByPurchaseOrderId(purchaseOrderId);
    }
}
