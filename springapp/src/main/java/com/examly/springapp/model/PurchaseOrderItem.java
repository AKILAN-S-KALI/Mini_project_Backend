package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class PurchaseOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseOrderItemId;
    
    private Integer quantity;
    private Double unitPrice;
    
    @ManyToOne
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    public PurchaseOrderItem() {}
    
    public PurchaseOrderItem(Integer quantity, Double unitPrice, PurchaseOrder purchaseOrder, Product product) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.purchaseOrder = purchaseOrder;
        this.product = product;
    }
    
    // Getters and Setters
    public Long getPurchaseOrderItemId() { return purchaseOrderItemId; }
    public void setPurchaseOrderItemId(Long purchaseOrderItemId) { this.purchaseOrderItemId = purchaseOrderItemId; }
    
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    
    public Double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(Double unitPrice) { this.unitPrice = unitPrice; }
    
    public PurchaseOrder getPurchaseOrder() { return purchaseOrder; }
    public void setPurchaseOrder(PurchaseOrder purchaseOrder) { this.purchaseOrder = purchaseOrder; }
    
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}
