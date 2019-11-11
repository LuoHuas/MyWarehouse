package com.shop.domain;

public class UserProductVo {
    private Product product;
    private User user;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserProductVo{" +
                "product=" + product +
                ", user=" + user +
                '}';
    }
}
