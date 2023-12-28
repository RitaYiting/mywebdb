package com.lulu.mywebdb.service;

import com.lulu.mywebdb.mapper.OrderMapper;
import com.lulu.mywebdb.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Order> getAll() {
        return jdbcTemplate.query("select * from orders", new OrderMapper());

    }
    public List<Order> getOrderById(int ono) {
        return jdbcTemplate.query("select * from orders where orderNumber=" + ono, new OrderMapper());
    }
    public List<Order> getOrderByCustomerNumber(int cno) {
        return jdbcTemplate.query("select * from orders where customerNumber=" + cno, new OrderMapper());
    }
}
