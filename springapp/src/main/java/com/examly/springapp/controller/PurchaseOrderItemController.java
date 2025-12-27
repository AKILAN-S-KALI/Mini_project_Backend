package com.examly.springapp.controller;

import com.examly.springapp.model.PurchaseOrderItem;
import com.examly.springapp.service.PurchaseOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-order-items")
public class PurchaseOrderItemController {

    @Autowired
    private PurchaseOrderItemService purchaseOrderItemService;

    @PostMapping
    public ResponseEntity<PurchaseOrderItem> createPurchaseOrderItem(@RequestBody PurchaseOrderItem purchaseOrderItem) {
        PurchaseOrderItem savedItem = purchaseOrderItemService.savePurchaseOrderItem(purchaseOrderItem);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<PurchaseOrderItem>> getPurchaseOrderItemsByOrderId(@PathVariable Long orderId) {
        List<PurchaseOrderItem> items = purchaseOrderItemService.getItemsByPurchaseOrderId(orderId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrderItem> getPurchaseOrderItemById(@PathVariable Long id) {
        PurchaseOrderItem item = purchaseOrderItemService.getPurchaseOrderItemById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrderItem> updatePurchaseOrderItem(@PathVariable Long id, @RequestBody PurchaseOrderItem purchaseOrderItem) {
        PurchaseOrderItem updatedItem = purchaseOrderItemService.updatePurchaseOrderItem(id, purchaseOrderItem);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseOrderItem(@PathVariable Long id) {
        purchaseOrderItemService.deletePurchaseOrderItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
