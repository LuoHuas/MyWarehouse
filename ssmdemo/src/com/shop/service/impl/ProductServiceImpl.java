package com.shop.service.impl;

import com.shop.dao.ProductMapper;
import com.shop.domain.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  //表示业务逻辑层
public class ProductServiceImpl implements ProductService {

    @Autowired  //自动装配按类型
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductList() {
        //List<Product> products = productMapper.selectByExample(null);
        List<Product> products = productMapper.selectByExampleWithBLOBs(null);
        return products;
    }

    @Override
    public Product getProductById(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateProduct(Product product) {
        int iret = productMapper.updateByPrimaryKeyWithBLOBs(product);
        return iret;
    }
}
