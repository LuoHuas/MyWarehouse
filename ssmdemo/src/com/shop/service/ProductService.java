package com.shop.service;

import java.util.List;

import com.shop.domain.Product;

public interface ProductService {
    public List<Product> getProductList();

    Product getProductById(Integer id);

    int updateProduct(Product product);
}
