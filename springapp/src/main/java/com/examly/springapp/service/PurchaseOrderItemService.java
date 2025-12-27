package com.examly.springapp.service;

import com.examly.springapp.model.PurchaseOrderItem;
import java.util.List;

public interface PurchaseOrderItemService {
    PurchaseOrderItem savePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem);
    List<PurchaseOrderItem> getAllPurchaseOrderItems();
    PurchaseOrderItem getPurchaseOrderItemById(Long id);
    PurchaseOrderItem updatePurchaseOrderItem(Long id, PurchaseOrderItem purchaseOrderItem);
    void deletePurchaseOrderItem(Long id);
    List<PurchaseOrderItem> getItemsByPurchaseOrderId(Long purchaseOrderId);
}
