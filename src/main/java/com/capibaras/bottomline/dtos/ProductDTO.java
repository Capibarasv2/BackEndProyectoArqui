package com.capibaras.bottomline.dtos;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private String category;
    private String serial_number;
    private double purchase_price;
    private double sale_price;
    private int quantity_available;
    private String product_thumbnail;
    private String product_state;
    private Long supplier_id;

}
