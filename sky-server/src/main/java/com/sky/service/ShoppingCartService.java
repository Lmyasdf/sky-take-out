package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ShoppingCartService {


    public void add(ShoppingCartDTO shoppingCartDTO);

    //查看购物车
    public List<ShoppingCart> list();

    //清空购物车
    public void clean();
}
