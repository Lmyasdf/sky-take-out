package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface OrderMapper {
    //插入订单数据
    void insert(Orders orders);

    List<Orders> selectTimeoutOrders(Integer pendingPayment, LocalDateTime timeoutTime);

    //更新订单
    void update(Orders orders);

}
