package com.capibaras.bottomline.controllers;

import com.capibaras.bottomline.models.Product;
import com.capibaras.bottomline.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class ProductControllerTest {

    private ProductController productController;
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productService = mock(ProductService.class);
        productController = new ProductController();
        productController.productService = productService;
    }

    @Test
    public void testIndex() {
        // Arrange
        List<Product> expectedProducts = Arrays.asList(new Product(), new Product());
        when(productService.listProducts()).thenReturn(expectedProducts);

        // Act
        List<Product> actualProducts = productController.index();

        // Assert
        assertEquals(expectedProducts.size(), actualProducts.size());
    }

    @Test
    public void testFindById() {
        // Arrange
        Long id = 1L;
        Product expectedProduct = new Product();
        when(productService.findById(id)).thenReturn(Optional.of(expectedProduct));

        // Act
        Product actualProduct = productController.findById(id);

        // Assert
        assertNotNull(actualProduct);
    }

    @Test
    public void testFindById_NotFound() {
        // Arrange
        Long id = 1L;
        when(productService.findById(id)).thenReturn(Optional.empty());

        // Act
        Product actualProduct = productController.findById(id);

        // Assert
        assertNull(actualProduct);
    }

    @Test
    public void testCreateProduct() {
        // Arrange
        Product productToSave = new Product();
        productToSave.setName("New Product");
        when(productService.save(productToSave)).thenReturn(productToSave);

        // Act
        Product savedProduct = productController.create(productToSave);

        // Assert
        assertNotNull(savedProduct);
        assertEquals("New Product", savedProduct.getName());
    }

    @Test
    public void testUpdateProduct_Success() {
        // Arrange
        Long productId = 1L;
        Product existingProduct = new Product();
        existingProduct.setId(Math.toIntExact(productId));
        existingProduct.setName("Old Name");

        Product updatedInfo = new Product();
        updatedInfo.setName("Updated Name");

        when(productService.findById(productId)).thenReturn(Optional.of(existingProduct));
        when(productService.save(existingProduct)).thenReturn(existingProduct);

        // Act
        Product updatedProduct = productController.update(productId, updatedInfo);

        // Assert
        assertNotNull(updatedProduct);
        assertEquals("Updated Name", updatedProduct.getName());
    }

    @Test
    public void testUpdateProduct_NotFound() {
        // Arrange
        Long productId = 1L;
        Product updatedInfo = new Product();
        updatedInfo.setName("Updated Name");

        when(productService.findById(productId)).thenReturn(Optional.empty());

        // Act
        Product updatedProduct = productController.update(productId, updatedInfo);

        // Assert
        assertNull(updatedProduct);
    }

    @Test
    public void testDeleteProduct() {
        // Arrange
        Long productId = 1L;
        doNothing().when(productService).deleteById(productId);

        // Act and Assert
        assertDoesNotThrow(() -> productController.delete(productId));
        verify(productService, times(1)).deleteById(productId);
    }

    @Test
    public void testCountProducts() {
        // Arrange
        long expectedCount = 10L;
        when(productService.count()).thenReturn(expectedCount);

        // Act
        long actualCount = productController.count();

        // Assert
        assertEquals(expectedCount, actualCount);
    }
}
