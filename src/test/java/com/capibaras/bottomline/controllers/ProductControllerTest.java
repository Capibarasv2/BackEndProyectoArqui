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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    // Tests for other methods (create, update, delete, count) can be similarly implemented

}
