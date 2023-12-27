package com.lulu.mywebdb.controller;

import com.lulu.mywebdb.data.DBProvider;
import com.lulu.mywebdb.model.Orders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class ReportController {
    DBProvider dbProvider = new DBProvider();

    @GetMapping("/orders")
    public  String getOrderList(){
        //提供一個訂單總覽 點選其中一個 在顯示 訂單明細
        ResultSet rs = null;
        ArrayList<Orders> o = new ArrayList<>();
        String sql = """
                SELECT
                    orders.orderNumber,
                    orders.orderDate,
                    orders.requiredDate,
                    orders.comments,
                    customers.customerName
                FROM
                    orders
                JOIN
                    customers
                ON
                    customers.customerNumber=orders.customerNumber
                                
                """;
        rs = dbProvider.getData(sql);
        //打包資料 放入model
        try{
            while(rs.next()){
                Orders o = new Orders();
                o.setOrderNumber(rs.getInt("orderNumber"));
                o.setOrderDate(rs.getDate("orderDate"));
                o.setRequiredDate(rs.getDate("requiredDate"));
                o.setComments(rs.getString("comments"));
                o.setCoustomerName(rs.getString("customerNumber"));
                orders.add(o);
            }
            model.// Model還沒加
        } catch (SQLException e) {
            System.out.println("ReportController 處理資料發生異常");
        }
        return "orders_list";
    }
    public String getOrderDetails(){
        //提供一個訂單總覽 點選其中一個 在顯示訂單明細
        return "orderDetail";
    }
}
