package com.capibaras.bottomline.controllers;

import com.capibaras.bottomline.dtos.ProductDTO;
import com.capibaras.bottomline.models.Product;
import com.capibaras.bottomline.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAll")
    public List<Product> index() {
        return productService.listProducts();
    }

    @GetMapping("/getById/{id}")
    public Product findById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        return productOptional.orElse(null);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDto) {
        Product createdProduct = productService.createProduct(productDto);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDto) {
        Product updatedProduct = productService.updateProduct(id, productDto);
        return ResponseEntity.ok(updatedProduct);
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
