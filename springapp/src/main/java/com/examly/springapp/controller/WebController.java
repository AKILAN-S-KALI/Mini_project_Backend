package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examly.springapp.model.Product;
import com.examly.springapp.model.Supplier;
import com.examly.springapp.model.PurchaseOrder;
import com.examly.springapp.model.CustomerReturn;
import com.examly.springapp.service.ProductService;
import com.examly.springapp.service.SupplierService;
import com.examly.springapp.service.PurchaseOrderService;
import com.examly.springapp.service.CustomerReturnService;

import java.time.LocalDateTime;

@Controller
public class WebController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private SupplierService supplierService;
    
    @Autowired
    private PurchaseOrderService purchaseOrderService;
    
    @Autowired
    private CustomerReturnService customerReturnService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Product CRUD
    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getallProducts());
        return "products/list";
    }

    @GetMapping("/products/new")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "products/form";
    }

    @GetMapping("/products/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "products/form";
    }

    @PostMapping("/products/save")
    public String saveProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        if (product.getProductId() == 0) {
            productService.saveProduct(product);
            redirectAttributes.addFlashAttribute("message", "Product created successfully!");
        } else {
            productService.updateProduct(product.getProductId(), product);
            redirectAttributes.addFlashAttribute("message", "Product updated successfully!");
        }
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("message", "Product deleted successfully!");
        return "redirect:/products";
    }

    // Supplier CRUD
    @GetMapping("/suppliers")
    public String listSuppliers(Model model) {
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "suppliers/list";
    }

    @GetMapping("/suppliers/new")
    public String newSupplierForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "suppliers/form";
    }

    @GetMapping("/suppliers/edit/{id}")
    public String editSupplierForm(@PathVariable Long id, Model model) {
        model.addAttribute("supplier", supplierService.getSupplierById(id));
        return "suppliers/form";
    }

    @PostMapping("/suppliers/save")
    public String saveSupplier(@ModelAttribute Supplier supplier, RedirectAttributes redirectAttributes) {
        if (supplier.getId() == 0) {
            supplierService.saveSupplier(supplier);
            redirectAttributes.addFlashAttribute("message", "Supplier created successfully!");
        } else {
            supplierService.updateSupplier(supplier.getId(), supplier);
            redirectAttributes.addFlashAttribute("message", "Supplier updated successfully!");
        }
        return "redirect:/suppliers";
    }

    @GetMapping("/suppliers/delete/{id}")
    public String deleteSupplier(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        supplierService.deleteSupplier(id);
        redirectAttributes.addFlashAttribute("message", "Supplier deleted successfully!");
        return "redirect:/suppliers";
    }

    // Purchase Order CRUD
    @GetMapping("/purchase-orders")
    public String listOrders(Model model) {
        model.addAttribute("orders", purchaseOrderService.getAllPurchaseOrders());
        return "orders/list";
    }

    @GetMapping("/purchase-orders/new")
    public String newOrderForm(Model model) {
        model.addAttribute("order", new PurchaseOrder());
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "orders/form";
    }

    @GetMapping("/purchase-orders/edit/{id}")
    public String editOrderForm(@PathVariable Long id, Model model) {
        model.addAttribute("order", purchaseOrderService.getPurchaseOrderById(id));
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "orders/form";
    }

    @PostMapping("/purchase-orders/save")
    public String saveOrder(@ModelAttribute PurchaseOrder order, @RequestParam Long supplierId, RedirectAttributes redirectAttributes) {
        order.setSupplier(supplierService.getSupplierById(supplierId));
        if (order.getOrderDate() == null) {
            order.setOrderDate(LocalDateTime.now());
        }
        if (order.getId() == 0) {
            purchaseOrderService.savePurchaseOrder(order);
            redirectAttributes.addFlashAttribute("message", "Order created successfully!");
        } else {
            purchaseOrderService.updatePurchaseOrder(order.getId(), order);
            redirectAttributes.addFlashAttribute("message", "Order updated successfully!");
        }
        return "redirect:/purchase-orders";
    }

    @GetMapping("/purchase-orders/delete/{id}")
    public String deleteOrder(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        purchaseOrderService.deletePurchaseOrder(id);
        redirectAttributes.addFlashAttribute("message", "Order deleted successfully!");
        return "redirect:/purchase-orders";
    }

    // Customer Return CRUD
    @GetMapping("/returns")
    public String listReturns(Model model) {
        model.addAttribute("returns", customerReturnService.getAllCustomerReturns());
        return "returns/list";
    }

    @GetMapping("/returns/new")
    public String newReturnForm(Model model) {
        model.addAttribute("customerReturn", new CustomerReturn());
        model.addAttribute("products", productService.getallProducts());
        return "returns/form";
    }

    @GetMapping("/returns/edit/{id}")
    public String editReturnForm(@PathVariable Long id, Model model) {
        model.addAttribute("customerReturn", customerReturnService.getCustomerReturnById(id));
        model.addAttribute("products", productService.getallProducts());
        return "returns/form";
    }

    @PostMapping("/returns/save")
    public String saveReturn(@ModelAttribute CustomerReturn customerReturn, @RequestParam Long productId, RedirectAttributes redirectAttributes) {
        customerReturn.setProduct(productService.getProductById(productId));
        if (customerReturn.getReturnDate() == null) {
            customerReturn.setReturnDate(LocalDateTime.now());
        }
        if (customerReturn.getCustomerReturnId() == 0) {
            customerReturnService.saveCustomerReturn(customerReturn);
            redirectAttributes.addFlashAttribute("message", "Return created successfully!");
        } else {
            customerReturnService.updateCustomerReturn(customerReturn.getCustomerReturnId(), customerReturn);
            redirectAttributes.addFlashAttribute("message", "Return updated successfully!");
        }
        return "redirect:/returns";
    }

    @GetMapping("/returns/delete/{id}")
    public String deleteReturn(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        customerReturnService.deleteCutomerReturn(id);
        redirectAttributes.addFlashAttribute("message", "Return deleted successfully!");
        return "redirect:/returns";
    }
}