package com.capibaras.bottomline.controllers;

import com.capibaras.bottomline.models.Product;
import com.capibaras.bottomline.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAll/index")
    public List<Product> index() {
        return productService.listProducts();
    }

    @GetMapping("/getById/{id}")
    public Product findById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        return productOptional.orElse(null);
    }

    @PostMapping("/create")
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> existingProductOptional = productService.findById(id);
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setSerial_number(product.getSerial_number());
            existingProduct.setPurchase_price(product.getPurchase_price());
            existingProduct.setSale_price(product.getSale_price());
            existingProduct.setQuantity_available(product.getQuantity_available());
            existingProduct.setProduct_thumbnail(product.getProduct_thumbnail());
            existingProduct.setProduct_state(product.getProduct_state());
            return productService.save(existingProduct);
        }
        return null;
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/count")
    public long count() {
        return productService.count();
    }

}
