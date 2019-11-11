package com.shop.web;

import com.shop.domain.Product;
import com.shop.domain.User;
import com.shop.domain.UserProductVo;
import com.shop.service.ProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/item")  //父级或者一级
public class ProductController {

    @Autowired  //自动装配注入业务逻辑层
    private ProductService productService;

    @RequestMapping(value = "/product")
    public ModelAndView getProduct() {
        List<Product> list = productService.getProductList();
        System.out.println("size:" + list.size());
        //要把list数据封装到ModeAndView对象中保存
        ModelAndView modelAndView = new ModelAndView();
        //封装数据
        modelAndView.addObject("productList", list);
        //封装逻辑视图名
        modelAndView.setViewName("productList");
        return modelAndView;
    }

    @RequestMapping(value = "/queryitem.action")  //二级
    public String query(UserProductVo vo) {
        System.out.println(vo.getProduct());
        System.out.println(vo.getUser());
        return null;
    }


    @RequestMapping(value = "/getProduct.action")
    public ModelAndView getProductById(Integer id) {
        Product product = productService.getProductById(id);
        ModelAndView modelAndView = new ModelAndView();
        //我们要把product保存在modelAndView对象中
        modelAndView.addObject("item", product);
        //转发到ProductItem.jsp页面
        modelAndView.setViewName("productItem");
        return modelAndView;
    }


    @RequestMapping(value = "/updateitem.action")
    public ModelAndView updateProduct(Product product) {
        //Date createtime = product.getCreatetime();
        //product.setCreatetime(new Date());
        //修改
        int iret = productService.updateProduct(product);
        /*try {
            if (iret > 0) {
                response.sendRedirect(request.getContextPath() + "/item/product");
            } else {
                response.sendRedirect(request.getContextPath() + "/item/getProduct.action?id=" + product.getId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return getProduct();
    }
}
