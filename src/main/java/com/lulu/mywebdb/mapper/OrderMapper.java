package com.lulu.mywebdb.mapper;

import com.lulu.mywebdb.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setOrderNumber( rs.getInt("orderNumber"));
        order.setOrderDate(rs.getDate("orderDate"));
        order.setRequiredDate(rs.getDate("requiredDate"));
        order.setShippedDate(rs.getDate("shippedDate"));
        order.setComments(rs.getString("comments"));
        order.setCustomerNumber(rs.getInt("customerNumber"));
        order.setStatus(rs.getString("status"));
        return  order;
    }
}
