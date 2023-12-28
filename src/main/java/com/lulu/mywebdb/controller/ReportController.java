package com.lulu.mywebdb.controller;

import com.lulu.mywebdb.data.DBProvider;
import com.lulu.mywebdb.model.Orders;
import com.lulu.mywebdb.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.ResultSet;
import java.util.List;

@Controller
public class ReportController {
    //不用再自己new一個DBProvider
    //正確 要做託管 應該是交由springboot管理
    DBProvider dbProvider = new DBProvider();

    //託管版本
    @Autowired
    DBService dbService;
    @GetMapping("test123")
    public String sayHello(Model model){
        //注意重點:dbService並無 new DBService() 的過程 僅單純宣告
        String name = dbService.getOrdersAll();
        //Long USA = dbService.countByCountry();
        //model.addAttribute("USA",USA);

        Long cusa = dbService.countByCountry("USA");
        Long cfr = dbService.countByCountry("france");
        model.addAttribute("name", name);
        model.addAttribute("USA", cusa);
        model.addAttribute("France", cfr);
        return "hello";

    }

    @GetMapping("/orders")
    public String getOrderList(Model model){
        //提供一個訂單總覽 點選其中一個 在顯示 訂單明細
        ResultSet rs = null;
        List<Orders> orders;
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
        orders = dbProvider.getOrderData(sql);
        //接收資料 放入model
        model.addAttribute("orders",orders);
        return "orders_list";
    }
    public String getOrderDetails(){
        //提供一個訂單總覽 點選其中一個 在顯示訂單明細
        return "orderDetail";
    }
}
