package com.capibaras.bottomline.services;

import com.capibaras.bottomline.dtos.ProductDTO;
import com.capibaras.bottomline.models.Product;
import com.capibaras.bottomline.models.Supplier;
import com.capibaras.bottomline.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private SupplierService supplierService;

    @Autowired
    public ProductService(ProductRepository productRepository, SupplierService supplierService) {
        this.productRepository = productRepository;
        this.supplierService = supplierService;

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

    public Product createProduct(ProductDTO productDto) {
        Product product = new Product();
        return getProduct(productDto, product);
    }

    public Product updateProduct(Long id, ProductDTO productDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        return getProduct(productDto, product);
    }

    private Product getProduct(ProductDTO productDto, Product product) {
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategory(productDto.getCategory());
        product.setSerial_number(productDto.getSerial_number());
        product.setPurchase_price(productDto.getPurchase_price());
        product.setSale_price(productDto.getSale_price());
        product.setQuantity_available(productDto.getQuantity_available());
        product.setProduct_thumbnail(productDto.getProduct_thumbnail());
        product.setProduct_state(productDto.getProduct_state());

        Supplier supplier = supplierService.getSupplierById(productDto.getSupplier_id())
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + productDto.getSupplier_id()));
        product.setSupplier(supplier);

        return productRepository.save(product);
    }

}
