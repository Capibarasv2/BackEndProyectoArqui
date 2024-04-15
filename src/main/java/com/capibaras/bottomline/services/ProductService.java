package com.capibaras.bottomline.services;

import com.capibaras.bottomline.models.Product;
import com.capibaras.bottomline.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById( id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public long count() {
        return productRepository.count();
    }

}
