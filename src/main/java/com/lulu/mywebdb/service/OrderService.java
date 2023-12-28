package com.lulu.mywebdb.service;

import com.lulu.mywebdb.mapper.CustomerMapper;
import com.lulu.mywebdb.model.Customer;
import com.lulu.mywebdb.model.Orders_List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Orders_List> getOrderListAll(){
        return jdbcTemplate.query("select * from orders", new OrderMapper());

    }
}
