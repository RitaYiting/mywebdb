package com.lulu.mywebdb.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DBService {
    @Autowired
    JdbcTemplate jdbcTemplate;   //等同Statement
    public String getOrdersAll(){
        String sql = "select customers.customerName from customers where customerNumber=129";
        //queryForOject 要確定sql 只會回傳一個欄位 哪一種類型 請在第二個參數告知
        String name = jdbcTemplate.queryForObject(sql, String.class);
        return name;
    }
    public Long countByCountry(String cname){
        //String sql = "select count(*) from customers where country = 'USA' ";
        //Long USA = jdbcTemplate.queryForObject(sql, Long.class);
        //return USA;

        // queryForObject 要確定 sql 只會回傳一個欄位  哪一種類型 請在地二個參數告知

        String sql = "select count(*) from customers where country='" + cname +"'";
        Long cnt = jdbcTemplate.queryForObject(sql,Long.class);
        return cnt;
    }
}
